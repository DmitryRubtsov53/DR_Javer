import java.time.LocalDate;
import java.time.LocalDateTime;

public class Weekly extends Task {


    public Weekly(String taskName, String descript, String type, LocalDateTime dataActivity, String periodicity) {
        super(taskName, descript, type, dataActivity, periodicity);
    }

    @Override
    public boolean isTaskForDate(LocalDate localDate) {
           return this.dataActivity.toLocalDate().equals(localDate)
               || this.dataActivity.toLocalDate().plusWeeks(1).equals(localDate);
    }

    @Override
    public void periodicity() {

    }
}

