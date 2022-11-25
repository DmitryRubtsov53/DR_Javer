import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;

public class EveryDay extends Task {


    public EveryDay(String taskName, String descript, String type, String dataActivity, String periodicity) {
        super(taskName, descript, type, dataActivity, periodicity);
    }

//    @Override
//    public boolean isTaskForTomorrow(LocalDate localDate) {
//            return this.dataActivity.toLocalDate().isBefore(localDate)
//                || this.dataActivity.toLocalDate().equals(localDate);
//    }

    @Override
    public void periodicity() {

    }
}
