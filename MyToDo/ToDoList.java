import java.util.Scanner;
public class ToDoList{

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String command = null;
        Command com = new Command();
        TaskList list = new TaskList();
        while(!"exit".equals(command)){
            System.out.println("YOUR TASK");
            //show task list here
            showTask(list);
            //get command
            System.out.print(">");
            command = scanner.nextLine();
            com.checkCommand(command, list);
        }
        scanner.close();
    }

    public static void showTask(TaskList list){
        System.out.println("-------------------------------------------");
        for (Task task : list.getTaskList()) {
            if(task.getDone() == false){
                System.out.print("[ ]");
            } else {
                System.out.print("[*]");
            }
            System.out.print(task.getName() + "  ");
            System.out.print(task.getDueDate());
            System.out.println();
        }
        System.out.println("-------------------------------------------");
    }
}