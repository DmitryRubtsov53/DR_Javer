import java.time.LocalDate;
import java.time.LocalDateTime;

public class EveryDay extends Task {

    public EveryDay(String taskName, String descript, String type, LocalDateTime dataActivity, String periodicity) {
        super(taskName, descript, type, dataActivity, periodicity);
    }

    @Override
    public boolean isTaskForDate(LocalDate localDate) {
            return this.dataActivity.toLocalDate().isBefore(localDate)
                || this.dataActivity.toLocalDate().equals(localDate);
    }

    @Override
    public void periodicity() {

    }
}
