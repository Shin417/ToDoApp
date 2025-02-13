
import java.util.ArrayList;
import java.util.List;

public class TaskList {
    private List<Task> taskList = new ArrayList<>();

    //constructor
    public TaskList(){
    }

    //properties
    public List<Task> getTaskList(){
        return taskList;
    }

    public void setTaskList(List<Task> TaskList){
        this.taskList = TaskList;
    }


}

