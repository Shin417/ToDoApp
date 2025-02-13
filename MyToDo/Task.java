

public class Task {
    private String name;
    private boolean done = false;
    private String dueDate;

    //constructor
    public Task(String Name, String Duedate){
        name = Name;
        dueDate = Duedate;
    }

    //get set
    public String getName(){
        return name;
    }

    public void setName(String newName){
        this.name = newName;
    }

    public boolean  getDone(){
        return done;
    }

    public void setDone(boolean newDone){
        this.done = newDone;
    }

    public String getDueDate(){
        return dueDate;
    }

    public void setDueDate(String newDueDate){
        this.dueDate = newDueDate;
    }
}
