import java.util.Arrays; // добавил для Задачи 2.
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

        System.out.println();
        System.out.println("Задача 5 ПС Массивы2 - 2-х мерный массив 3х3");

        int [][] matrix = new int[3][3];
        // Заполняем диагонали единицами:
        for (int a = 0; a < 3; a++)
            for (int b = 0; b < 3; b++) {
                if ((a % 2 == 0 && b % 2 == 0) || (a % 2 != 0 && b % 2 != 0)) matrix[a][b] = 1;
            }
        // Печатаем массив:
        for (int[] row : matrix) {
            for (int column : row) {
                System.out.print(column + " ");
            }
            System.out.println();
        }
        System.out.println();
        System.out.println("Задача 8 ПС Массивы2 - Найти в массиве пары чисел с суммой -2");
        int [] cat = {-6, 2, 5, -8, 8, 10, 4, -7, 12, 1};
        //Arrays.sort(cat);
        //System.out.print(Arrays.toString(cat));
        System.out.println();
        for (int s = 0; s < cat.length; s++) {

            for (int z = s + 1; z < cat.length; z++) {   // важно ! если написать z = 1; будет другой результат !
                if (cat[s] + cat[z] == -2) {
                    System.out.println(cat[s] + " " + cat[z]);
                    break;
                }
            }
        }
//------------------------------------------------------------------------------------------------
        Cat kisa = new Cat ("murzik");
//        kisa.name = "kisa";
//        kisa.age = 5;
        System.out.println(kisa.name + " " + kisa.age);
        Cat kot = new Cat("Туз",3);

    }   // ********* скобка закрывает метод Main !!! ***********************************************************
    public static int[] generateRandomArray() {
        java.util.Random random = new java.util.Random();
        int[] arr = new int[30];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(100_000) + 100_000;
        }
        return arr;
    }

} // ********** скобка закрывает public class Main **********************************************************