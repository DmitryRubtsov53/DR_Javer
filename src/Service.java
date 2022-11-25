import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Service {


    // п.1 Меню: Добавить задачу......................................................
    public static void printMenu() {
        System.out.println("1. Добавить задачу" + "\n"
                + "2. Удалить задачу" + "\n"
                + "3. Получить задачи на указанный день" + "\n"
                + "0. Выход");
    }
    public static Task inputTask(Scanner scanner) {  // Ввод задачи пользователем.

        String periodicity = definePeriodicity(scanner);
        switch (periodicity) {
            case "Однократная":
                Task task1 = new OneOff(null, null, null, null, null);
                // передать параметр в Мапу..................
                task1.setTaskName(enterName(scanner));
                task1.setDescript(enterDescript(scanner));
                task1.setType(defineType(scanner));
                task1.setDataActivity(defineDateTime(scanner));
                task1.setPeriodicity(periodicity);
                return task1;
            case "Ежедневная":
                Task task2 = new EveryDay(null, null, null, null, null);
                // передать параметр в Мапу..................
                task2.setTaskName(enterName(scanner));
                task2.setDescript(enterDescript(scanner));
                task2.setType(defineType(scanner));
                task2.setDataActivity(defineDateTime(scanner));
                task2.setPeriodicity(periodicity);
                return task2;
            case "Еженедельная":
                Task task3 = new Weekly(null, null, null, null, null);
                // передать параметр в Мапу..................
                task3.setTaskName(enterName(scanner));
                task3.setDescript(enterDescript(scanner));
                task3.setType(defineType(scanner));
                task3.setDataActivity(defineDateTime(scanner));
                task3.setPeriodicity(periodicity);
                return task3;
            case "Ежемесячная":
                Task task4 = new Monthly(null, null, null, null, null);
                // передать параметр в Мапу..................
                task4.setTaskName(enterName(scanner));
                task4.setDescript(enterDescript(scanner));
                task4.setType(defineType(scanner));
                task4.setDataActivity(defineDateTime(scanner));
                task4.setPeriodicity(periodicity);
                return task4;
            case "Ежегодная":
                Task task5 = new Yearly(null, null, null, null, null);
                // передать параметр в Мапу..................
                task5.setTaskName(enterName(scanner));
                task5.setDescript(enterDescript(scanner));
                task5.setType(defineType(scanner));
                task5.setDataActivity(defineDateTime(scanner));
                task5.setPeriodicity(periodicity);
                return task5;
            default:
                Task task6 = new Yearly("Только", "винтовка", "рождает власть!", null, "@ Мао Дзедун.");
                return task6;
        }
    }
    public static String enterDescript(Scanner scanner) {
        System.out.print("Введите описание задачи: ");
        String descript = scanner.nextLine();
        if (descript == null || descript.isBlank()) {
            //    throw new RuntimeException("Тип задачи введен не верно! Повторите.");
            System.out.println("Название задачи введено не корректно! Повторите всё снова.");
            enterDescript(scanner);
        }
        return descript;
    }
    public static String enterName(Scanner scanner) {
        System.out.print("Введите название задачи: ");
        String taskName = scanner.nextLine();
        if (taskName == null || taskName.isBlank()) {
            //    throw new RuntimeException("Тип задачи введен не верно! Повторите.");
            System.out.println("Название задачи введено не корректно! Повторите всё снова.");
            enterName(scanner);
        }
        return taskName;
    }
    public static String defineType(Scanner scanner) {
        System.out.print("Выберите тип задачи или введите № пункта меню: " + "\n"
                + "1. Личная" + "\n" + "2. Рабочая" + "\n");
        String type = scanner.nextLine();
        if ( type.equals("1") || type.equals("Личная")) {
            type = "Личная";
        } else if (type.equals("2") || type.equals("Рабочая")) {
            type = "Рабочая";
        } else {
            //    throw new RuntimeException("Тип задачи введен не верно! Повторите.");
            System.out.println("Тип задачи введен не верно! Повторите всё снова.");
            defineType(scanner);
            }
        System.out.println("Тип задачи: " + type);
        return type;
    }
    public static LocalDateTime defineDateTime(Scanner scanner) {
        System.out.print("Введите дату и время 1-й активации задачи (в формате yyyy-MM-ddTHH:mm:ss): ");
        LocalDateTime dateActivity = LocalDateTime.parse(scanner.nextLine());

        // Как обработать ошибку ввода с отсылом на старт этого метода ?

        System.out.println("Дата и время активации задачи: " + dateActivity);
        return dateActivity;
    }

    public static String definePeriodicity(Scanner scanner) {
        String periodicity;
        System.out.print("Однократная" + "\n"
                + "Ежедневная" + "\n"
                + "Еженедельная" + "\n"
                + "Ежемесячная" + "\n"
                + "Ежегодная" + "\n"
                + "Выберите периодичность задачи, указанную в меню: ");
        String period = scanner.nextLine();
        if (!(period.equals("Однократная") || period.equals("Ежедневная") ||period.equals("Еженедельная")
                ||period.equals("Ежемесячная") ||period.equals("Ежегодная"))) {
            //throw new RuntimeException("Периодичность задачи введен не верно! Повторите.");
            System.out.println("Периодичность задачи введен не верно! Повторите всё снова.");
            definePeriodicity(scanner);
            //  tmp(scanner);
        }
        return period;
    }

    // п.2 Меню: Удаление задачи по ID.........................................................
    public static int removeTask(Scanner scanner) {  // Удаление задачи пользователем.

        System.out.print("Введите id задачи для её удаления: ");
        int idTmp = scanner.nextInt();
        // Цикл перебора Мапы, поиска по id == idTmp и удаления задачи......................
        System.out.println("Задача с id " + idTmp + " удалена из Ежедневника." + "\n" );
        return idTmp;
    }

    // п.3 Меню: Получить задачи на указанный день ......... ....................................
    public static LocalDate toGetListTasks(Scanner scanner) {  // Получение списка задачи на заданную дату.
        System.out.print("Введите дату (yyyy-MM-dd) для получения списка задач: ");
        LocalDate localDate = LocalDate.parse(scanner.nextLine());
        //System.out.println(localDate);
    return localDate;
    }
    public static void tmp(Scanner scanner) {
        definePeriodicity(scanner);
    }

} // Class -----------------------------------------------------------------------








//    String periodicity = null;
//        System.out.print("1. Однократная" + "\n"
//                + "2. Ежедневная" + "\n"
//                + "3. Еженедельная" + "\n"
//                + "4. Ежемесячная" + "\n"
//                + "5. Ежегодная" + "\n"
//                + "Выберите периодичность задачи и введите № пункта меню: ");
//    String repeat = scanner.nextLine();
//        if (repeat.equals("1") || repeat.equals("Однократная")) {
//        periodicity = "Однократная";
//        // передать параметр в Мапу..................
//        System.out.println("Периодичность задачи: " + periodicity + "\n");
////            return periodicity;
//    } else if (repeat.equals("2") || repeat.equals("Ежедневная")) {
//        periodicity = "Ежедневная";
//        // передать параметр в Мапу..................
//        System.out.println("Периодичность задачи: " + periodicity + "\n");
////            return periodicity;
//    } else if (repeat.equals("3") || repeat.equals("Еженедельная")) {
//        periodicity = "Еженедельная";
//        // передать параметр в Мапу..................
//        System.out.println("Периодичность задачи: " + periodicity + "\n");
////            return periodicity;
//    } else if (repeat.equals("4") || repeat.equals("Ежемесячная")) {
//        periodicity = "Ежемесячная";
//        // передать параметр в Мапу..................
//        System.out.println("Периодичность задачи: " + periodicity + "\n");
////            return periodicity;
//    } else if (repeat.equals("5") || repeat.equals("Ежегодная")) {
//        periodicity = "Ежегодная";
//        // передать параметр в Мапу..................
//        System.out.println("Периодичность задачи: " + periodicity + "\n");
//
//    }
//        return periodicity;
//}
//-----------------------------------------
//String periodicity;
//        System.out.print( "1. Однократная" + "\n"
//                + "2. Ежедневная" + "\n"
//                + "3. Еженедельная" + "\n"
//                + "4. Ежемесячная" + "\n"
//                + "5. Ежегодная" + "\n"
//                + "Выберите периодичность задачи и введите № пункта меню: " );
//                String period = scanner.nextLine();
//                int repeat = Integer.parseInt(period.trim());
////        System.out.println(repeat);
//                switch (repeat) {                        //int i = Integer.parseInt(s.trim());
//                case 1:
//                periodicity = "Однократная";
//                // передать параметр в Мапу..................
//                System.out.println("Периодичность задачи: " + periodicity + "\n");
//                break;
//
//                case 2:
//                periodicity = "Ежедневная";
//                // передать параметр в Мапу..................
//                System.out.println("Периодичность задачи: " + periodicity + "\n" );
//                break;
//
//                case 3:
//                periodicity = "Еженедельная";
//                // передать параметр в Мапу..................
//                System.out.println("Периодичность задачи: " + periodicity + "\n" );
//                break;
//
//                case 4:
//                periodicity = "Ежемесячная";
//                // передать параметр в Мапу..................
//                System.out.println("Периодичность задачи: " + periodicity + "\n" );
//
//                break;
//                case 5:
//                periodicity = "Ежегодная";
//                // передать параметр в Мапу..................
//                System.out.println("Периодичность задачи: " + periodicity + "\n" );
//
//                break;
//default:
//        throw new RuntimeException("Периодичность задачи введен не верно! Повторите.");
////                System.out.println("Периодичность задачи введен не верно! Повторите всё снова.");
////                tmp(scanner);
////                definePeriodicity(scanner);
//
//        }
//        return periodicity;

