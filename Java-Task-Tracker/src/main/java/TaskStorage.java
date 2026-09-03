import java.nio.file.Path;
import java.util.ArrayList;
import java.nio.file.Files;
import java.io.IOException;
import java.util.List;

public class TaskStorage {

    public static void saveTasks(ArrayList<Task> tasks, Path path) {
    ArrayList<String> lines = new ArrayList<>();

    for (Task task : tasks) {
        String conversion = task.toFileString();
        lines.add(conversion);
    }

    try {
        Files.write(path, lines);
    } catch (IOException e) {
        System.out.println("Failed to save tasks");
    }
  } 
  public static ArrayList<Task> loadTasks(Path path){

    ArrayList<Task> tasks = new ArrayList<>();
        if (!Files.exists(path)){
            return tasks;
        }
            try {
                List<String> lines = Files.readAllLines(path);
                for (String line : lines){
                    String[] parts = line.split("\\|");
                    if (parts.length != 5){
                        continue;
                    }
                    if (!parts[3].equalsIgnoreCase("true") && !parts[3].equalsIgnoreCase("false")){
                        continue;
                    }
                    try {
                    int id = Integer.parseInt(parts[0]);
                    String title = parts[1].replace("\\p", "|");
                    String description = parts[2].replace("\\p", "|");
                    boolean completed = Boolean.parseBoolean(parts[3]);
                    Priority priority = Priority.valueOf(parts[4]);
                    Task task = new Task(id, title, description, completed, priority);
                    tasks.add(task);

                    } catch(IllegalArgumentException e){
                        continue;
                    }
                }
                
            } catch (IOException e){
                System.out.println("Tasks failed to load");
            }
        return tasks;

  }

  

}