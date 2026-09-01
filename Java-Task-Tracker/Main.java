import java.util.ArrayList;
import java.util.Scanner;
public class Main{
    public static void main(String[] args){
        ArrayList<Task> tasks = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;
        while(running){
            System.out.println("1.Add Task");
            System.out.println("2.View Tasks");
            System.out.println("3.Exit");
            String choice = scanner.nextLine();
            switch (choice){
                case "1":
                Task newTask = createTask(scanner);
                tasks.add(newTask);
                break;
                case "2":
                    if (tasks.isEmpty()){
                        System.out.println("No tasks found");
                    }
                    else{
                        for (Task task : tasks){
                        System.out.println(task);
                        }
                        }
                        
                break;
                case "3":
                    running = false;
                    break;
                default:
                    System.out.println("Invalid Choice. Please enter 1, 2, or 3.");
                    
            }
        }
    }
    public static Task createTask(Scanner scanner){
        System.out.println("Enter Task Title: ");
        String title = scanner.nextLine();
        System.out.println("Enter Task Description: ");
        String description = scanner.nextLine();
        return new Task(title, description);
       
    }
}