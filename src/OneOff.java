import java.time.LocalDate;
import java.time.LocalDateTime;

public class OneOff extends Task {


    public OneOff(String taskName, String descript, String type, LocalDateTime dataActivity, String periodicity) {
        super(taskName,descript, type, dataActivity, periodicity);
    }

    @Override
    public boolean isTaskForDate(LocalDate localDate) {
        return this.dataActivity.toLocalDate().equals(localDate);
    }

    @Override
    public void periodicity() {
        String periodicity = "Однократная";
        // передать параметр в Мапу..................
        System.out.println("Периодичность задачи: " + periodicity);
    }
}

