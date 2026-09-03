import java.util.ArrayList;

public class TaskManager {

    private ArrayList<Task> tasks;
//constructor
    public TaskManager(ArrayList<Task> tasks) {
        this.tasks = tasks;
    }
//getter
public ArrayList<Task> getTasks() {
    return tasks;
}



//methods
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
    public void updateTaskTitle(int id, String newTitle){
        Task task = findTaskById(id);
        if (task != null){
            task.updateTitle(newTitle);
        }
    }
    public void updateTaskDescription(int id, String newDescription){
        Task task = findTaskById(id);
        if (task != null){
            task.updateDescription(newDescription);
        }
    }
    public void updateTaskPriority(int id, Priority newPriority){
        Task task = findTaskById(id);
        if (task != null){
            task.updatePriority(newPriority);
        }
    }
}