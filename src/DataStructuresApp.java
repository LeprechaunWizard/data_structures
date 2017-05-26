/**
 * Created by dieterverhufen on 2017-05-20.
 */
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class DataStructuresApp extends Application {

    private Structures model;
    private DataStructuresView view;

    public void start(Stage mainWindow){
        model = new Structures();
        view = new DataStructuresView(model);

        // Event Handlers
        view.getGenerateArrayButton().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                handleGenerateArray();
            }
        });

        view.getInsertButton().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                handleInsertValue();
            }
        });

        view.getDeleteButton().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                handleDeleteIndex();
            }
        });


        mainWindow.setTitle("Data Structures");
        mainWindow.setScene(new Scene(view, 525, 425));
        mainWindow.show();
    }

    public static void main(String[]args){ launch(args); }

    // Handle methods
    private void handleGenerateArray() {
        model.generateRandomArray();
        view.update();
    }

    private void handleInsertValue() {
        if(!view.getInsertValue().getText().trim().equals("")) {
            model.insertValue(Integer.parseInt(view.getInsertValue().getText()));
            view.update();
        }
    }

    private void handleDeleteIndex() {
        if(!view.getDeleteIndex().getText().trim().equals("")) {
            model.deleteIndex(Integer.parseInt(view.getDeleteIndex().getText()));
            view.update();

        }
    }
}

