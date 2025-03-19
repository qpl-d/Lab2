import java.util.Scanner;
import java.io.PrintStream;
public class Main {
    public static PrintStream out = System.out;
    public static Scanner in = new Scanner(System.in);
    public static void main(String[] args) {
        
        // считывание числа n и заполнение массива
        int n = in.nextInt();
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = in.nextInt();
        }

        // разделение чисел на простые и составные
        int[] prim = new int[n];
        int[] comp = new int[n];
        int primCount = 0;
        int compCount = 0;

        for (int num = 0; num < array.length; num++) {
            boolean isPrime = true;
            if (array[num] < 2) {
                isPrime = false;
            } else {
                for (int i = 2; i < array[num]; i++) {
                    if (array[num] % i == 0) {
                        isPrime = false;
                        break;
                    }
                }
            }

            if (isPrime) {
                prim[primCount] = array[num];
                primCount++;
            } else {
                comp[compCount] = array[num];
                compCount++;
            }
        }

        // сортировка простых чисел по возрастанию
        for (int i = 0; i < primCount - 1; i++) {
            for (int j = i + 1; j < primCount; j++) {
                if (prim[i] > prim[j]) {
                    int temp = prim[i];
                    prim[i] = prim[j];
                    prim[j] = temp;
                }
            }
        }

        // сортировка составных чисел по убыванию
        for (int i = 0; i < compCount - 1; i++) {
            for (int j = i + 1; j < compCount; j++) {
                if (comp[i] < comp[j]) {
                    int temp = comp[i];
                    comp[i] = comp[j];
                    comp[j] = temp;
                }
            }
        }

        // объединение массивов
        int[] sortedArray = new int[n];
        int index = 0;

        for (int i = 0; i < primCount; i++) {
            sortedArray[index] = prim[i];
            index++;
        }
        for (int i = 0; i < compCount; i++) {
            sortedArray[index] = comp[i];
            index++;
        }

        // вывод количества простых чисел
        out.println(primCount);

        // вывод массива с заменой на слова
        for (int num = 0; num < sortedArray.length; num++) {
            boolean isPrime = true;
            if (sortedArray[num] < 2) {
                isPrime = false;
            } else {
                for (int i = 2; i < sortedArray[num]; i++) {
                    if (sortedArray[num] % i == 0) {
                        isPrime = false;
                        break;
                    }
                }
            }
            if (isPrime) {
                out.print("Простое ");
            } else {
                out.print("Составное ");
            }
        }
        out.println();

        // замена чисел в массиве на сумму их цифр и вывод
        for (int num = 0; num < sortedArray.length; num++) {
            int sum = 0;
            int temp = sortedArray[num];
            while (temp != 0) {
                sum += temp % 10;
                temp /= 10;
            }
            out.print(sum + " ");
        }
    }
}
