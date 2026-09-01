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
            System.out.println("3.Mark Task Complete");
            System.out.println("4.Delete Tasks");
            System.out.println("5.Exit");
            String choice = scanner.nextLine();
            switch (choice){
                case "1":
                Task newTask = createTask(scanner);
                tasks.add(newTask);
                break;
                case "2":
                    viewTasks(tasks);
                    break;
                case "3": {
                if (tasks.isEmpty()) {
                    System.out.println("No tasks found");
                    break;
                }

                displayNumberedTasks(tasks);
                System.out.println("Which task would you like to mark as completed");
                int index = getTaskIndex(scanner, tasks);
                tasks.get(index).markComplete();
                System.out.println("Task marked as completed");
                break;
                }
                    
                case "4": {
                    if (tasks.isEmpty()) {
                        System.out.println("No tasks found");
                        break;
                    }

                    displayNumberedTasks(tasks);
                    System.out.println("Which task would you like to delete");
                    int index = getTaskIndex(scanner, tasks);
                    tasks.remove(index);
                    System.out.println("Task Deleted");
                    break;
                }   
                case "5":
                    running = false;
                    break;
                default:
                    System.out.println("Invalid Choice. Please enter 1, 2, 3, 4, or 5.");
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
    public static void viewTasks(ArrayList<Task> tasks){
        if (tasks.isEmpty()){
                        System.out.println("No tasks found");
                    }
                    else{
                        for (Task task : tasks){
                        System.out.println(task);
                        }
                    }
    }
    public static void displayNumberedTasks(ArrayList<Task> tasks){
        for( int i = 0; i < tasks.size() ; i++){
            System.out.println((i + 1) + ". " + tasks.get(i));
        }
    }
    public static int getTaskIndex(Scanner scanner, ArrayList<Task> tasks){
        while (true){
    String input = scanner.nextLine();

    try{
        int userChoice = Integer.parseInt(input);

        if (userChoice >= 1 && userChoice <= tasks.size()){
            return userChoice - 1;
            }
        else{
                System.out.println("Task does not exist");
            }
        }
        catch (NumberFormatException e){
            System.out.println("Please enter a valid number");
        }
    }
    }
}