public class Task{    
    private String title;
    private String description;
    private boolean completed;
    private Priority priority; 
    public Task(String title, String description){
        this.title = title;
        this.description = description;
        this.completed = false;
        this.priority = Priority.MEDIUM;
        
        
    }
    //Getters
    public String getTitle(){
        return title;
    }
    public String getDescription(){
        return description;
    }
    public boolean isCompleted(){
        return completed;
    }
    //methods
    public void markComplete(){
        completed = true; 
    }
    public void updateTitle(String title){
        this.title = title;
    }
    public void updateDescription(String description){
        this.description = description; 

    }
    public void updateTask(String title, String description){
        this.title = title;
        this.description = description;
    }
    @Override
    public String toString(){
        if (isCompleted()){
            return getTitle() + " - " + getDescription() + " - Complete";
        }
        else{
            return getTitle() + " - " + getDescription() + " - Incomplete";
        }
        
    }
}