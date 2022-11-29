import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Service {

    private final static DateTimeFormatter TASK_DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm");
    private final static DateTimeFormatter LIST_DATE_FORMATTER = DateTimeFormatter.ofPattern("dd.MM.yyyy");

    // п.1 Меню: Добавить задачу......................................................
    public static void printMenu() {
        System.out.println("\n" + "-------- ЕЖЕДНЕВНИК. ГЛАВНОЕ МЕНЮ -----------" +"\n"
                + "1. Добавить задачу." + "\n"
                + "2. Удалить задачу." + "\n"
                + "3. Получить задачи на указанный день." + "\n"
                + "4. Показать все задачи Еженедельника." + "\n"
                + "0. ВЫХОД из приложения.");
    }
    public static Task inputTask() {  // Ввод задачи пользователем.
        Scanner scanner = new Scanner(System.in);

                String taskName = enterName(),
                        description = enterDescript(),
                        type = defineType(),
                        periodicity = definePeriodicity(scanner);
                LocalDateTime dateActivity = defineDateTime(scanner);

                switch (periodicity) {
                    case "1":
                        return new OneOff(taskName, description, type, dateActivity, "Однократная");
                    case "2":
                        return new EveryDay(taskName, description, type, dateActivity, "Ежедневная");
                    case "3":
                        return new Weekly(taskName, description, type, dateActivity, "Еженедельная");
                    case "4":
                        return new Monthly(taskName, description, type, dateActivity, "Ежемесячная");
                    case "5":
                        return new Yearly(taskName, description, type, dateActivity, "Ежегодная");
                    default:
                        return new Yearly("Винтовка", " рождает", " власть!",
                                null, "@ Мао Дзэдун.");
                }
        }
    public static String enterDescript() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            try {
                System.out.print("Введите описание задачи: ");
                String descript = scanner.nextLine();
                System.out.println("----------------------------------------------");
                if (descript != null || !descript.isBlank())
                    return descript;
            } catch (Exception e) {
                System.out.println("Название задачи введено не корректно! Повторите ввод.");
                }
        }
    }
    public static String enterName() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            try {
                System.out.print("Введите название задачи: ");
                String taskName = scanner.nextLine();
                if (taskName != null || !taskName.isBlank())
                    return taskName;
            } catch (Exception e) {
                System.out.println("Название задачи введено не корректно! Повторите ввод.");
                }
        }
    }
    public static String defineType() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print( "1. Личная" + "\n" + "2. Рабочая" + "\n" +
                    "Выберите тип задачи и введите № пункта меню: ");
        String type = scanner.nextLine();
        System.out.println("----------------------------------------------");
        switch (type) {
            case "1":
                return "Личная";
            case "2":
                return "Рабочая";
            default:
                System.out.println("Тип задачи введен не верно! Повторите ввод.");
                break;
            }
        }
    }
    public static String definePeriodicity(Scanner scanner) {
        while (true) {
        //String periodicity;
        System.out.print("1. Однократная" + "\n"
                + "2. Ежедневная" + "\n"
                + "3. Еженедельная" + "\n"
                + "4. Ежемесячная" + "\n"
                + "5. Ежегодная" + "\n"
                + "Выберите периодичность задачи и введите № пункта меню: ");
        String period = scanner.nextLine();
        System.out.println("----------------------------------------------");

            switch (period) {
                case "1": return "1";
                case "2": return "2";
                case "3": return "3";
                case "4": return "4";
                case "5": return "5";
                default:
                    System.out.println("Периодичность задачи введен не верно! Повторите ввод.");
                    break;
            }
        }
    }
    // п.2 Меню: Удаление задачи по ID.........................................................
    public static int removeTask(Scanner scanner) {  // Удаление задачи пользователем.
        System.out.print("Введите id задачи для её удаления: ");
        int idTmp = scanner.nextInt();
        System.out.println("Задача с id " + idTmp + " удалена из Ежедневника." + "\n" );
        return idTmp;
    }
    public static LocalDateTime defineDateTime(Scanner scanner) {  // Получаем дату АКТИВАЦИИ задачи.
        while (true) {
            try {
                System.out.print("Введите дату и время АКТИВАЦИИ задачи (в формате dd.MM.yyyy HH:mm): ");
                String dateActivity = scanner.nextLine();
                System.out.println("----------------------------------------------");
                return LocalDateTime.parse(dateActivity, TASK_DATE_TIME_FORMATTER);
            } catch (DateTimeParseException e) {
                System.out.println("Ведены не правильно дата и время! Повторите ввод.");
            }
        }
    }
    // п.3 Меню: Получить задачи на указанный день ......... ....................................
    public static LocalDate toGetDateTasks() {  // Получение даты списка задач.
        Scanner scanner = new Scanner(System.in);
        while (true) {
            try {
                System.out.print("Введите дату (в формате dd.MM.yyyy) для получения списка задач: ");
                String localDate = scanner.nextLine();
                return LocalDate.parse(localDate, LIST_DATE_FORMATTER);
            } catch (DateTimeParseException e) {
                System.out.println("Дата введена не правильно! Повторите ввод.");
            }
        }
    } //.........................................................................................

} // Class -----------------------------------------------------------------------




// СТАРЫЙ ВАРИАНТ. ПОЧЕМУ-ТО НЕ РАБОТАЛ ?!
//    public static Task inputTask(Scanner scanner) {  // Ввод задачи пользователем.
//
//        String periodicity = definePeriodicity(scanner);
//        switch (periodicity) {
//            case "Однократная":
//                Task task1 = new OneOff(null, null, null, null, null);
//                // передать параметр в Мапу..................
//                task1.setTaskName(enterName(scanner));
//                task1.setDescript(enterDescript(scanner));
//                task1.setType(defineType(scanner));
//                task1.setDataActivity(defineDateTime(scanner));
//                task1.setPeriodicity(periodicity);
//                return task1;
//            case "Ежедневная":
//                Task task2 = new EveryDay(null, null, null, null, null);
//                // передать параметр в Мапу..................
//                task2.setTaskName(enterName(scanner));
//                task2.setDescript(enterDescript(scanner));
//                task2.setType(defineType(scanner));
//                task2.setDataActivity(defineDateTime(scanner));
//                task2.setPeriodicity(periodicity);
//                return task2;
//            case "Еженедельная":
//                Task task3 = new Weekly(null, null, null, null, null);
//                // передать параметр в Мапу..................
//                task3.setTaskName(enterName(scanner));
//                task3.setDescript(enterDescript(scanner));
//                task3.setType(defineType(scanner));
//                task3.setDataActivity(defineDateTime(scanner));
//                task3.setPeriodicity(periodicity);
//                return task3;
//            case "Ежемесячная":
//                Task task4 = new Monthly(null, null, null, null, null);
//                // передать параметр в Мапу..................
//                task4.setTaskName(enterName(scanner));
//                task4.setDescript(enterDescript(scanner));
//                task4.setType(defineType(scanner));
//                task4.setDataActivity(defineDateTime(scanner));
//                task4.setPeriodicity(periodicity);
//                return task4;
//            case "Ежегодная":
//                Task task5 = new Yearly(null, null, null, null, null);
//                // передать параметр в Мапу..................
//                task5.setTaskName(enterName(scanner));
//                task5.setDescript(enterDescript(scanner));
//                task5.setType(defineType(scanner));
//                task5.setDataActivity(defineDateTime(scanner));
//                task5.setPeriodicity(periodicity);
//                return task5;
//            default:
//                Task task6 = new Yearly("Только", "винтовка", "рождает власть!", null, "@ Мао Дзедун.");
//                return task6;
//        }
//    }