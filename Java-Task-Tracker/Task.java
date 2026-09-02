public class Task{    
    private String title;
    private String description;
    private boolean completed;
    private Priority priority; 
    private int id;
    private static int nextId = 1;

    public Task(String title, String description, Priority priority){
        this.title = title;
        this.description = description;
        this.completed = false;
        this.priority = priority;
        this.id = nextId;
        nextId++;

        
        
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
    public Priority getPriority(){
        return priority;
    }
    public int getId(){
        return id;
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
    public void updatePriority(Priority priority){
        this.priority = priority;
    }

    public void updateTask(String title, String description){
        this.title = title;
        this.description = description;
    }
    public String toFileString(){
        
       return id + "|" + title + "|" + description + "|" + completed +  "|" + priority;
    }
    @Override
    public String toString(){
        if (isCompleted()){
            return "ID: " + getId() + " - " + getTitle() + " - " + getDescription()  + " - Complete - " + getPriority();
        }
        else{
            return "ID: " + getId() + " - " + getTitle() + " - " + getDescription() + " - Incomplete - " + getPriority();
        }
        
    }
}