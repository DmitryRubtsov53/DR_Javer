public class Main {
    public static void main(String[] args) {
        System.out.println("Домашнее задание Циклы - Повышенная сложность");

        System.out.println(" ");
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
    }
}