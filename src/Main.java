public class Main {
    public static void main(String[] args) {
        System.out.println("Домашние задания - Повышенная сложность");

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
    }
}