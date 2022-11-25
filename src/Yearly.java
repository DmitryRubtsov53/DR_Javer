import java.time.LocalDate;
import java.time.LocalDateTime;

public class Yearly extends Task {


    public Yearly(String taskName, String descript, String type, LocalDateTime dataActivity, String periodicity) {
        super(taskName, descript, type, dataActivity, periodicity);
    }
    @Override
    public boolean isTaskForDate(LocalDate localDate) {
              return this.dataActivity.toLocalDate().equals(localDate)
                  || this.dataActivity.toLocalDate().plusYears(1).equals(localDate);
    }
    @Override
    public void periodicity() {

    }
}



// ********************************************************************************

//    ArrayList<Task> tasks = new ArrayList<>();
//    // IF periodicity = "Единоразовая" :
//    Task task1 = new OneOff(null, null, null, null, null);
//    Task task2 = new EveryDay(null, null, null, null, null);
//    Task task3 = new Weekly(null, null, null, null, null);
//    Task task4 = new Monthly(null, null, null, null, null);
//    Task task5 = new Yearly(null, null, null, null, null);
//        tasks.add(task1); tasks.add(task2); tasks.add(task3); tasks.add(task4); tasks.add(task5);
//
//    String taskName = "Месть";                        task1.setTaskName(taskName);
//    String descript = "Набить морду соседу за дебош"; task1.setDescript(descript);
//    String type = "Личная";                           task1.setType(type);
//    String dataActivity = "2022-11-25";      task1.setDataActivity(dataActivity);                //T20:00:00
//    String periodicity = "Единоразовая";              task1.setPeriodicity(periodicity);
//    //  IF periodicity = "ЕЖедневная" :                    //  IF periodicity = "ЕЖенедельная" :
//        task2.setTaskName("Зарядка");                     task3.setTaskName("Баня");
//        task2.setDescript("15 мин. присяданий-отжиманий");task3.setDescript("Моюсь, парюсь, пью пиво");
//        task2.setType("Личная");                          task3.setType("Личная");
//        task2.setDataActivity("2022-11-24T07:00:00");     task3.setDataActivity("2022-11-24T12:00:00");
//        task2.setPeriodicity("Ежедневная");               task3.setPeriodicity("Еженедельная");
//    //  IF periodicity = "ЕЖемесячная" :                    //  IF periodicity = "ЕЖегодная" :
//        task4.setTaskName("Зарплата");                    task5.setTaskName("Встреча НГ");
//        task4.setDescript("Получить в банке зарплату");   task5.setDescript("Празднуем с семьёй приход НГ");
//        task4.setType("Рабочая");                         task5.setType("Личная");
//        task4.setDataActivity("2022-11-25");     task5.setDataActivity("2022-12-31T23:00:00");      //T17:00:00
//        task4.setPeriodicity("Ежемесячная");               task5.setPeriodicity("Ежегодная");

//System.out.println(task1 + "\n" + task2+ "\n" + task3+ "\n" + task4+ "\n" + task5);
//------------------------------------------------------------------------------------------

//    HashMap<Integer, Task> taskMaps = new HashMap<>();
//        for (int i = 0; i < tasks.size(); i++) {
//        Integer id = i+1;
//        taskMaps.put(id,tasks.get(i));
//    }
//    // Получить список дел на 254.11.2022
//    String localDate = "2022-11-25";
//        for (HashMap.Entry<Integer, Task> pair: taskMaps.entrySet()) {
//        if ((pair.getValue().getDataActivity()).equals(localDate))
//            System.out.println("Object " + pair.getKey() + ": " + pair.getValue());
//    }
//        System.out.println();
//
//        taskMaps.remove(1);
//
//