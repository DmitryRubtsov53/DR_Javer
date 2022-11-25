import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Scanner;

import static java.time.temporal.ChronoUnit.DAYS;

public class Test {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите дату и время 1-й активации задачи (в формате yyyy-MM-ddTHH:mm:ss): ");
        LocalDateTime dateActivity = LocalDateTime.parse(scanner.nextLine());
        System.out.println("Дата активации задачи - " + dateActivity);
        //nextActivity(dateActivity);
        System.out.println("Следующая дата активации (+ 3 дня) - " + dateActivity.toLocalDate().plusDays(3));
        System.out.println("Следующая дата активации (+ неделя) - " + dateActivity.toLocalDate().plusWeeks(1));
        System.out.println("Следующая дата активации (+ месяц) - " + dateActivity.toLocalDate().plusMonths(2));
        System.out.println("Следующая дата активации (+ год) - " + dateActivity.toLocalDate().plusYears(1));

        System.out.println(DAYS.between(LocalDate.now(), dateActivity )); // вычислил разницу м/у датами.

//        System.out.print("Введите дату и время 1-й активации задачи (в формате yyyy-MM-ddTHH:mm:ss): ");
        //LocalDateTime dateActivity = LocalDateTime.parse(scanner.nextLine());
        // String dateActivity  = scanner.nextLine();
        System.out.println("Дата активации задачи - " + dateActivity);



    }
    public static void nextActivity (LocalDate date) {
        while (true) {
            if (LocalDate.now().equals(date)) {
                System.out.println("Сегодня нужно выполнить ЗАДАЧУ !");
                break;
            } else {  if (LocalDate.now().equals(date.minusDays(1))) {
                System.out.println("ЗАДАЧУ надо выполнить завтра.");
                break;
                }
            }
        }

    }
} //Class
