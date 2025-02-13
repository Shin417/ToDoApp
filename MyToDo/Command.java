
public class Command {
    public Command(){
    }    

    //addTask method
    public void addTask(TaskList taskList, String Name, String Duedate){
        if(checkDateValid(Duedate)){
            Task task = new Task(Name, Duedate);
            taskList.getTaskList().add(task);
        }
    }
    
    //removeTask method
    public void removeTask(TaskList list, String name){
        if(containsName(list, name)){
            list.getTaskList().remove(findIndex(list, name));
        }
    }

    //doneTask method
    public void doneTask(TaskList list, String name){
        if(containsName(list, name)){
            int index = findIndex(list, name);
            if(list.getTaskList().get(index).getDone() == false){
                list.getTaskList().get(index).setDone(true);
            } else {
                list.getTaskList().get(index).setDone(false);
            }
        }
    }

    //check if list contains name
    public static boolean containsName(TaskList list, String name){
        for (Task task : list.getTaskList()) {
            if(task.getName().equals(name)){
                return true;
            }
        }
        System.out.println("The task doesn't exist");
        return false;
    }

    //find index of task of name
    public static int findIndex(TaskList list, String name){
        for (Task task : list.getTaskList()) {
            if(task.getName().equals(name)){
                return list.getTaskList().indexOf(task);
            }
        }
        return 0;
    }

    //edit method
    public void editTask(TaskList list, String name, String target, String newWord){
        int index = findIndex(list, name);
        if(target.equals("name") && containsName(list, name)){
            list.getTaskList().get(index).setName(newWord);
        } else if(target.equals("date") && containsName(list, name) && checkDateValid(newWord)){
            list.getTaskList().get(index).setDueDate(newWord);
        } else {
            System.out.println("Invalid input");
        }
    }
    

    //check if the command is valid
    //check the date input
    public boolean checkDateValid(String date){
        if(date.contains("/")){
            String[] dates = date.split("/");
            if(dates.length!=3){
                System.out.println("Invalid date format. MM/DD/YYYY");
                return false;
            }
            try {
                int days = Integer.parseInt(dates[1]);
                int month = Integer.parseInt(dates[0]);        
            } catch (NumberFormatException e) {
                System.out.println("Invalid date input");
                return false;
            }
            int days = Integer.parseInt(dates[1]);
            int month = Integer.parseInt(dates[0]);
            if(days>31 || month>12 || dates[2].length()!=4 || days < 1 || month < 1) {
                System.out.println("Date is invalid");
                return false;           
            }
            return true;
        } else {
            return false;
        }
    }

    public void checkCommand(String command, TaskList list){
        String[] coms = command.split(" ");
        if(coms.length == 4 && (coms[0].equals("edit"))){
            //String * 4 (edit)
            editTask(list, coms[1], coms[2], coms[3]);

        } else if(coms.length == 3 && (coms[0].equals("add"))){
            //String * 3 (add)
            addTask(list, coms[1], coms[2]);

        } else if(coms.length == 2){
            //String * 2 (remove, done, undo)
            if(coms[0].equals("remove")){
                removeTask(list, coms[1]);
            } else if(coms[0].equals("done") || coms[0].equals("undo")){
                doneTask(list, coms[1]);
            } else {
                System.out.println("Invalid command");
            }

        } else if(coms.length == 1){
            //String * 1 (command, exit)
            if(coms[0].equals("command")){
                showCommand();
            } else if(coms[0].equals("exit")){
                System.exit(0);
            } else {
                System.out.println("Invalid command");
            }
        } else {
            System.out.println("Invalid command");
        }
    }

    public void showCommand(){
        System.out.println("COMMAND:");
        System.out.println("--------------------");
        System.out.println("add TaskName TaskDueDate");
        System.out.println("remove TaskName");
        System.out.println("done TaskName");
        System.out.println("undo TaskName");
        System.out.println("edit TaskName name or date newTaskName or newTaskDueDate");
        System.out.println("exit");
        System.out.println("--------------------");
        System.out.println("NOTE");
        System.out.println("TaskDueDate is must be formated MM/DD/YYYY");
    }
}
