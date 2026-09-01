import java.util.ArrayList;
public class Main{
    public static void main(String[] args){
        ArrayList<Task> tasks = new ArrayList<>();
        Task t1 = new Task("Test Task", "This task is a test #1");
        Task t2 = new Task("Test Task", "This task is a test#2");
        Task t3 = new Task("Test Task", "This task is a test#3");
        tasks.add(t1);
        tasks.add(t2);
        tasks.add(t3);
        
        
    }
}