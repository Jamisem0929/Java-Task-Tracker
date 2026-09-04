
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
import java.nio.file.Path;

public class TaskTrackerApp extends Application {
    


    Path path = Path.of("tasks.txt");

    @Override
    public void start(Stage stage){
        VBox layout =new VBox();
        Label titleLabel = new Label("Task Tracker");
        layout.getChildren().add(titleLabel);

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
        priorityBox.setValue(Priority.MEDIUM);
        addButton.setOnAction(event -> {
            String title = titleField.getText();
            System.out.println(title);

            String description = descriptionArea.getText();
            System.out.println(description);

            Priority priority = priorityBox.getValue();

        });

        
        layout.getChildren().add(addButton);
        layout.getChildren().add(titleField);
        layout.getChildren().add(descriptionArea);
        layout.getChildren().add(priorityBox);




        stage.setTitle("Task Tracker");
        stage.show();
    }
    public static void main(String[] args){
        launch(args);
    }

}


