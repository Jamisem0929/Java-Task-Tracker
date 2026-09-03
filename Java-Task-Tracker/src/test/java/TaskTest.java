import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
public class TaskTest{
    @Test
    public void markCompleteSetsTaskToComplete() {
        //Creates New Task
        Task task = new Task("Test Task", "Testing markComplete", Priority.LOW);
        //Marks the task complete
        task.markComplete();
        //check if it was mark completed
        assertTrue(task.isCompleted());
    }
    @Test
    public void tasksStartIncomplete(){
        Task task = new Task("Test Task", "Testing StartsIncomplete", Priority.LOW);
        assertFalse(task.isCompleted());
    }
    @Test
    public void taskStoresTitle(){
        Task task = new Task("Study Java", "JUnit practice", Priority.LOW);
        assertEquals("Study Java", task.getTitle());
    }
    @Test
    public void taskStoresDescription(){
        Task task = new Task("Test Task", "Testing Storing Description", Priority.LOW);
        assertEquals("Testing Storing Description", task.getDescription());
    }
    @Test
    public void taskStoresPriority(){
        Task task = new Task("Test Task", "Testing Storing Description", Priority.LOW);
        assertEquals(Priority.LOW, task.getPriority());
    }
    @Test
    public void tasksUpdateDescription(){
        Task task = new Task("Test Task", "Testing Storing Description", Priority.LOW);
        task.updateDescription("Updated Description");
        assertEquals("Updated Description", task.getDescription());
    }
    @Test
    public void tasksUpdateTitle(){
        Task task = new Task("Test Task", "Testing Storing Description", Priority.LOW);
        task.updateTitle("Updated Title");
        assertEquals("Updated Title", task.getTitle());
    }
    @Test
    public void taskUpdatesPriority(){
        Task task = new Task("Test Task", "Testing Storing Description", Priority.LOW);
        task.updatePriority(Priority.HIGH);
        assertEquals(Priority.HIGH, task.getPriority());
    }
}
