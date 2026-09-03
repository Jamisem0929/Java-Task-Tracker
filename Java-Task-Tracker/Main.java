import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Files;
import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Path path = Path.of("tasks.txt");
        ArrayList<Task> tasks = loadTasks(path);  
        Scanner scanner = new Scanner(System.in);
        boolean running = true;
        while (running) {
            System.out.println("1. Add Task");
            System.out.println("2. View Tasks");
            System.out.println("3. Mark Task Complete");
            System.out.println("4. Delete Tasks");
            System.out.println("5. Edit Tasks");
            System.out.println("6. Exit");
            String choice = scanner.nextLine();
            switch (choice) {
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

                    viewTasks(tasks);
                    System.out.println("Which task would you like to mark as completed");
                    Task task = getTaskById(scanner, tasks);
                    task.markComplete();
                    System.out.println("Task marked as completed");
                    break;
                }

                case "4": {
                    if (tasks.isEmpty()) {
                        System.out.println("No tasks found");
                        break;
                    }

                    viewTasks(tasks);
                    System.out.println("Which task would you like to delete");
                    Task task = getTaskById(scanner, tasks);
                    tasks.remove(task);
                    System.out.println("Task Deleted");
                    break;
                }
                case "5": {
                    if (tasks.isEmpty()) {
                        System.out.println("No tasks found");
                        break;
                    }
                    viewTasks(tasks);
                    Task task = getTaskById(scanner, tasks);
                    while (true) {

                        System.out.println("What would you like to edit?");
                        System.out.println("1. Title");
                        System.out.println("2. Description");
                        System.out.println("3. Priority");
                        System.out.println("4. Title and Description");

                        String editChoice = scanner.nextLine();

                        switch (editChoice) {
                            case "1":
                                System.out.println("Enter new title: ");
                                String newTitle = scanner.nextLine();
                                task.updateTitle(newTitle);
                                break;
                            case "2":
                                System.out.println("Enter new description: ");
                                String newDescription = scanner.nextLine();
                                task.updateDescription(newDescription);
                                break;
                            case "3":
                                Priority priority = getPriorityInput(scanner);

                                task.updatePriority(priority);
                                break;
                            case "4":
                                System.out.println("Enter new title: ");
                                String title = scanner.nextLine();

                                System.out.println("Enter new description: ");
                                String description = scanner.nextLine();

                                task.updateTask(title, description);
                                System.out.println("Task updated");
                                break;
                            default:
                                System.out.println("Invalid choice please choose 1, 2, 3, or 4");
                                continue;

                        }
                        break;
                    }
                    break;
                }

                case "6":
                    running = false;
                    break;
                default:
                    System.out.println("Invalid Choice. Please enter 1, 2, 3, 4, 5 or 6.");
            }
        }

            saveTasks(tasks, path);


        scanner.close();
    }

    public static Task createTask(Scanner scanner) {
        System.out.println("Enter Task Title: ");
        String title = scanner.nextLine();
        System.out.println("Enter Task Description: ");
        String description = scanner.nextLine();
        Priority priority = getPriorityInput(scanner);
        return new Task(title, description, priority);
    }

    public static void viewTasks(ArrayList<Task> tasks) {
        if (tasks.isEmpty()) {
            System.out.println("No tasks found");
        } else {
            for (Task task : tasks) {
                System.out.println(task);
            }
        }
    }

    public static Priority getPriorityInput(Scanner scanner) {
        while (true) {
            try {
                System.out.println("Enter Task Priority (LOW, MEDIUM, HIGH): ");
                String priorityInput = scanner.nextLine().toUpperCase();

                return Priority.valueOf(priorityInput);
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid priority. Please enter LOW, MEDIUM, or HIGH.");
            }
        }
    }

    public static Task findTaskById(ArrayList<Task> tasks, int id) {
        for (Task task : tasks) {
            if (task.getId() == id) {
                return task;
            }
        }
        return null;
    }

    public static Task getTaskById(Scanner scanner, ArrayList<Task> tasks) {
        while (true) {
            System.out.println("Which Id would you like to select");
            String input = scanner.nextLine();
            try {
                int userChoice = Integer.parseInt(input);
                Task task = findTaskById(tasks, userChoice);
                if (task == null) {
                    System.out.println("Task not found");
                } else {
                    return task;

                }
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number");

            }
        }
    }
    public static void saveTasks(ArrayList<Task> tasks, Path path){
         ArrayList<String> lines = new ArrayList<>();
        
        for (Task task : tasks) {
            lines.add(task.toFileString());

        }
        try{
        Files.write(path, lines);
        } catch (IOException e){
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
                    int id = Integer.parseInt(parts[0]);
                    String title = parts[1];
                    String description = parts[2];
                    boolean completed = Boolean.parseBoolean(parts[3]);
                    Priority priority = Priority.valueOf(parts[4]);
                    Task task = new Task(id, title, description, completed, priority);
                    tasks.add(task);
                }
                
            } catch (IOException e){
                System.out.println("Tasks failed to load");
            }
        return tasks;
    }

}
