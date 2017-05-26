/**
 * Created by dieterverhufen on 2017-05-20.
 */
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.scene.layout.GridPane;
import javafx.geometry.Pos;

public class DataStructuresView extends Pane {

    private Structures model;
    // Program elements
    private Button insertButton;
    private Button deleteButton;
    private Button findButton;
    private Button sortButton;
    private Button generateArrayButton;
    private ListView<String> arrayView;
    private RadioButton ascending;
    private RadioButton descending;
    private RadioButton linearSearch;
    private RadioButton binarySearch;
    private ToggleGroup searchGroup;
    private ToggleGroup sortGroup;
    private TextField insertValue;
    private TextField deleteIndex;
    private TextField findValue;

    // Getters
    public Button getInsertButton() { return insertButton; }
    public Button getDeleteButton() { return deleteButton; }
    public Button getFindButton() { return findButton; }
    public Button getSortButton() { return sortButton; }
    public Button getGenerateArrayButton() { return generateArrayButton; }
    public ListView<String> getArrayView() { return arrayView; }
    public TextField getInsertValue() { return insertValue; }
    public TextField getDeleteIndex() { return deleteIndex; }
    public TextField getFindValue() { return findValue; }

    public DataStructuresView(Structures s){
        model = s;
        // Set up GridPane
        GridPane root = new GridPane();
        root.setVgap(10);
        root.setHgap(10);
        root.setPadding(new Insets(10, 10, 10, 10));
        root.setAlignment(Pos.CENTER);

        // TextFields
        insertValue = new TextField();
        insertValue.setPromptText("Value");
        root.add(insertValue, 0, 0);

        deleteIndex = new TextField();
        deleteIndex.setPromptText("Index");
        root.add(deleteIndex, 0, 1);

        findValue = new TextField();
        findValue.setPromptText("Value");
        root.add(findValue, 0, 3);

        // Buttons
        insertButton = new Button("Insert");
        root.add(insertButton, 1, 0);

        deleteButton = new Button("Delete");
        root.add(deleteButton, 1, 1);

        findButton = new Button("Find");
        root.add(findButton, 1, 3);

        sortButton = new Button("Sort");
        root.add(sortButton, 0, 6);

        generateArrayButton = new Button("Generate Array");
        root.add(generateArrayButton, 0, 7, 2, 1);

        // Set up ToggleGroups for RadioButtons
        searchGroup = new ToggleGroup();
        sortGroup = new ToggleGroup();

        // RadioButtons
        linearSearch = new RadioButton("Linear");
        linearSearch.setToggleGroup(searchGroup);
        root.add(linearSearch, 0, 2);

        binarySearch = new RadioButton("Binary");
        binarySearch.setToggleGroup(searchGroup);
        root.add(binarySearch, 1, 2);

        ascending = new RadioButton("Ascending");
        ascending.setToggleGroup(sortGroup);
        root.add(ascending, 0, 4);

        descending = new RadioButton("Descending");
        descending.setToggleGroup(sortGroup);
        root.add(descending, 0, 5);

        // TableView
        arrayView = new ListView<>();
        root.add(arrayView, 3, 0, 1, 8);

        // add root to pane and update
        getChildren().add(root);
    }

    public void update() {
        arrayView.setItems(FXCollections.observableArrayList(model.generateDisplayArray()));
    }
}
