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

        view.getFindButton().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if(view.getLinearSearch().isSelected()) {
                    handleLinearSearch();
                }
            }
        });

        view.getSortButtonBubble().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                handleSortButtonBubble();
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

    private void handleLinearSearch() {
        System.out.println(model.linearSearch(Integer.parseInt(view.getFindValue().getText())));

    }

    private void handleSortButtonBubble() {
        if (view.getAscendingBubble().isSelected()) {
            model.bubbleSortAscending();
        }
        else if (view.getDescendingBubble().isSelected()) {
            model.bubbleSortDescending();
        }
        view.update();
    }
}

