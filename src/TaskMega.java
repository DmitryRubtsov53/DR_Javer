import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class TaskMega {
    private final Integer id ;
    private static int counter = 1;
    private LinkedHashMap<Integer, Task> taskMaps = new LinkedHashMap<>();

    public TaskMega(Integer id, Task tasks) {
        this.id = counter;
        counter++;
    }

//    public TaskMega(LinkedHashMap<Integer, Task> taskMaps) {
//        this.taskMaps = taskMaps;
//        this.id = counter;
//        counter++;
//    }

    public Integer getId() { return id;
    }
    public static int getCounter() { return counter;
    }

    @Override
    public String toString() {
        return
                " :" + id +
                ", taskMaps=" + taskMaps +
                '}';
    }
}