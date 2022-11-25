import java.time.LocalDate;
import java.time.LocalDateTime;

public class Monthly extends Task {


    public Monthly(String taskName, String descript, String type, LocalDateTime dataActivity, String periodicity) {
        super(taskName, descript, type, dataActivity, periodicity);
    }

//    @Override
//    public boolean isTaskForTomorrow(LocalDate localDate) {
//
//        return this.dataActivity.toLocalDate().equals(localDate)
//                || this.dataActivity.toLocalDate().plusMonths(1).equals(localDate);
//    }

    @Override
    public void periodicity() {

    }
}

