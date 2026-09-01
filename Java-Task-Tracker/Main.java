import java.util.ArrayList;
import java.util.Scanner;
public class Main{
    public static void main(String[] args){
        ArrayList<Task> tasks = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        boolean runAgain = false;
        do {
            Task newTask = createTask(scanner);
            tasks.add(newTask);
            while(true){
                System.out.println("Would you like to make another task? ");
                String choice = scanner.nextLine();
                if (choice.equalsIgnoreCase("yes")){
                    runAgain = true;
                    break;
                }
                else if (choice.equalsIgnoreCase("no")){
                    runAgain = false;
                    break;
                }
                else{
                    System.out.println("Please enter yes or no.");
                }
            }
        } while(runAgain);
        
        
        for (Task task : tasks){
            System.out.println(task);
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