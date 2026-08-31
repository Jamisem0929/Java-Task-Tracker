public class Task{    
    private String title;
    private String description;
    private boolean completed;
    Task(String title, String description, boolean completed){
        this.title = title;
        this.description = description;
        this.completed = completed;
        
    }
    public boolean getCompleted(){
        return completed;
    }
}