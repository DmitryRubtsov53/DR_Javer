import java.util.Arrays;
public class Main {
    public static void main(String[] args) {
        System.out.println("Домашние задания * Повышенная сложность");

        System.out.println("Тема: Циклы");
        System.out.println("Задание 4 - Ping pong");

                for (int i = 1; i <= 30; i++) {
                    if (i % 3 == 0 && i % 5 == 0) { System.out.println(i + " ping pong"); }
                    else if (i % 5 == 0) { System.out.println(i + " pong"); }
                    else if (i % 3 == 0) { System.out.println(i + " ping"); }
                    else System.out.println(i);
            }

        System.out.println(" ");
        System.out.println("Задание 5 - Последовательность Фибоначи из 64 чисел");
                long x = 0; // первое число ряда
                long y = 1; // второе число ряда

        System.out.print(x + " ");
        System.out.print(y + " ");
        int i = 1;
        while ( i < 63 ) {
            long tmp = y;
            y = x + y;
            x = tmp;
            i++;
            System.out.print(y + " ");
        }
        System.out.println("Тема: Массивы");
        System.out.println("Задание 6 - Последовательность Фибоначи с использованием массива");

        long[] fib = new long[64]; // размер массива равен числу клеток на шахматной доске
        fib[1] = 1; // второе число массива
        System.out.print(fib[0] + " " + fib[1] + " ");

        int j = 2;
        while ( j < fib.length - 1 ) {
            fib[j] = fib[j-2] + fib[j-1];
            System.out.print(fib[j] + " ");
            j++;
        }
        System.out.println();
        System.out.println("Задача 2 - Найти минимальную и максимальную трату в день.");

        int[] arr = generateRandomArray();  // Вызов внешнего по отношению к Main метода !!!

        Arrays.sort(arr);
        // Для себя - Распечатаем отсортированный по возрастанию массив для сравнения с MAX и MIN:
        System.out.println(Arrays.toString(arr));
        /* Вариант 1. С помощью сортировки.
        int maxTrata = arr[arr.length -1], minTrata = arr[0];
        System.out.println("Максимальная сумма трат за день составила " + maxTrata + " рублей");
        System.out.println("Минимальная сумма трат за день составила " + minTrata + " рублей");
        */
        // Вариант 2. Классическим перебором элементов с сравнением.
        int maxEl = 0, minEl = 200_000;  // Переменные для хранения значений макс-ого и мин-ого значения элемента массива.
        for (int k = 0; k < arr.length; k++) {
            if (arr[k] > maxEl)  maxEl = arr[k];
            if (arr[k] < minEl)  minEl = arr[k];
        }
        System.out.println("Максимальная сумма трат в день составила " + maxEl + " рублей");
        System.out.println("Минимальная сумма трат в день составила " + minEl + " рублей");

    }   // скобка закрывает метод Main !!!
    public static int[] generateRandomArray() {
        java.util.Random random = new java.util.Random();
        int[] arr = new int[30];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(100_000) + 100_000;
        }
        return arr;
    }
}