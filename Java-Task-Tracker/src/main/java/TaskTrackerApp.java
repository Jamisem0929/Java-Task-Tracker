import java.nio.file.Path;
import java.util.ArrayList;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.TextArea;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;

public class TaskTrackerApp extends Application {
    


    Path path = Path.of("tasks.txt");
    ArrayList<Task> tasks = TaskStorage.loadTasks(path);
    TaskManager taskManager = new TaskManager(tasks);
    

    @Override
    public void start(Stage stage){
        VBox layout =new VBox();
        Label titleLabel = new Label("Task Tracker");
        layout.getChildren().add(titleLabel);
        Label errorLabel = new Label();
        Button completeButton = new Button("Mark Complete");
        Button deleteButton = new Button("Delete Task");

        Scene scene = new Scene(layout, 500, 400);
        stage.setScene(scene);
        Button addButton = new Button("Add Task");

        TextField titleField = new TextField();
        titleField.setPromptText("Enter Task Title here");

        TextArea descriptionArea = new TextArea();
        descriptionArea.setPromptText("Enter Description here");

        ComboBox<Priority> priorityBox = new ComboBox<>();
        priorityBox.getItems().addAll(
            Priority.LOW,
            Priority.MEDIUM,
            Priority.HIGH
        );
        ListView<Task> taskList = new ListView<>();
        taskList.getItems().addAll(tasks);
        priorityBox.setValue(Priority.MEDIUM);
        addButton.setOnAction(event -> {
            String title = titleField.getText();
            if(title.isBlank()){
                errorLabel.setText("Title cannot be empty");
                return;
            }
           

            String description = descriptionArea.getText();
            

            Priority priority = priorityBox.getValue();
            Task newTask = new Task(title, description, priority);
            taskManager.addTask(newTask);
            TaskStorage.saveTasks(tasks, path);
            errorLabel.setText(" ");
            taskList.getItems().add(newTask);
            titleField.clear();
            descriptionArea.clear();
            priorityBox.setValue(Priority.MEDIUM);
        });

        layout.getChildren().add(addButton);
        layout.getChildren().add(errorLabel);
        layout.getChildren().add(titleField);
        layout.getChildren().add(descriptionArea);
        layout.getChildren().add(priorityBox);
        layout.getChildren().add(completeButton);
        layout.getChildren().add(deleteButton);
        layout.getChildren().add(taskList);
        
        completeButton.setOnAction(event -> {
            Task selectedTask = taskList.getSelectionModel().getSelectedItem();
            if (selectedTask == null){
                errorLabel.setText("Please select a task");
                return;
            }
            taskManager.completeTask(selectedTask.getId());
            TaskStorage.saveTasks(tasks, path);
            taskList.refresh();
            errorLabel.setText(" ");
        });
        deleteButton.setOnAction(event -> {
            Task selectedTask = taskList.getSelectionModel().getSelectedItem();
            if (selectedTask == null){
                errorLabel.setText("Please select a task");
                return;
            }  
            taskManager.deleteTask(selectedTask.getId());
            taskList.getItems().remove(selectedTask);
            taskList.refresh();
            TaskStorage.saveTasks(tasks, path);
            errorLabel.setText(" ");
        });
        



        stage.setTitle("Task Tracker");
        stage.show();
    }
    public static void main(String[] args){
        launch(args);
    }

}


