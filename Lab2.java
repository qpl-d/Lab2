import java.util.Scanner;
import java.io.PrintStream;
public class Lab2 {
    public static PrintStream out = System.out;
    public static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {

        // считывание числа n и заполнение массива
        int n = in.nextInt();
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = in.nextInt();
        }

        // перемещение простых чисел в начало массива
        int primeCount = 0;
        for (int i = 0; i < array.length; i++) {

            // проверка на простоту числа
            boolean isPrime = true;
            if (array[i] <= 1) {
                isPrime = false;
            } else {
                for (int j = 2; j < array[i]; j++) {
                    if (array[i] % j == 0) {
                        isPrime = false;
                        break;
                    }
                }
            }

            // если число простое, оно перемещается в начало массива
            if (isPrime) {
                int temp = array[primeCount];
                array[primeCount] = array[i];
                array[i] = temp;
                primeCount++;
            }
        }

        // сортировка простых чисел по возрастанию
        for (int i = 0; i < primeCount - 1; i++) {
            for (int j = 0; j < primeCount - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }

        // сортировка составных чисел по убыванию
        for (int i = primeCount; i < array.length - 1; i++) {
            for (int j = primeCount; j < array.length - 1; j++) {
                if (array[j] < array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }

        out.println(primeCount);

        for (int i = 0; i < array.length; i++) {
            boolean isPrime = true;
            if (array[i] <= 1) {
                isPrime = false;
            } else {
                for (int j = 2; j < array[i]; j++) {
                    if (array[i] % j == 0) {
                        isPrime = false;
                        break;
                    }
                }
            }

            // вывод элементов массива
            if (isPrime) {
                out.print("Простое ");
            } else {
                out.print("Составное ");
            }
        }
        out.println(" ");

        // замена чисел в массиве на сумму их цифр
        for (int i = 0; i < array.length; i++) {
            int sum = 0;

            while (array[i] > 0) {
                sum += array[i] % 10;
                array[i] /= 10;
            }
            array[i] = sum;
        }

        // вывод массива с замененными числами на суммы их цифр
        for (int i = 0; i < array.length; i++) {
            out.print(array[i] + " ");
        }
    }
}
