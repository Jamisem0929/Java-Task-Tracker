import java.util.ArrayList;

public class TaskManager {

    private ArrayList<Task> tasks;

    public TaskManager(ArrayList<Task> tasks) {
        this.tasks = tasks;
    }

    public Task findTaskById(int id) {
        for (Task task : tasks) {
            if (task.getId() == id) {
                return task;
            }
        }

        return null;
    }

    public void addTask(Task task) {
        tasks.add(task);
    }

    public void deleteTask(int id) {
        Task task = findTaskById(id);

        if (task != null) {
            tasks.remove(task);
        }
    }

    public void completeTask(int id) {
        Task task = findTaskById(id);

        if (task != null) {
            task.markComplete();
        }
    }
}