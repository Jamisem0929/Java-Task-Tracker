import java.util.ArrayList;
import java.util.Scanner;
public class Main{
    public static void main(String[] args){
        ArrayList<Task> tasks = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        Task newTask = createTask(scanner);
        tasks.add(newTask);
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