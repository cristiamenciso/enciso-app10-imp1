package baseline;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.ComboBoxListCell;
import javafx.scene.control.cell.ComboBoxTableCell;
import javafx.scene.control.cell.TextFieldTableCell;

import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

public class ListController implements Initializable {

    @FXML
    private TableView<ListItem> table = new TableView<>();

    @FXML
    private TableColumn<ListItem, String> listName;

    @FXML
    private TableColumn<ListItem, String> date = new TableColumn<>();

    @FXML
    private TableColumn<ListItem, String> status = new TableColumn<>();


    @FXML
    private TextField nameField;

    @FXML
    private DatePicker dateField;


    private ObservableList<ListItem> obList = FXCollections.observableArrayList();

    private ListItem selectedItem;

    @FXML
    private ComboBox<String> filterBox = new ComboBox<>();
    ObservableList<String> filterList = FXCollections.observableArrayList("Show All", "Show Complete", "Show Incomplete");

    @Override
    public void initialize(URL location, ResourceBundle resource) {
        listName.setCellValueFactory(cellData -> cellData.getValue().itemNameProperty());
        listName.setCellFactory(TextFieldTableCell.forTableColumn());
        date.setCellValueFactory(cellData -> cellData.getValue().dateProperty());
        date.setCellFactory(TextFieldTableCell.forTableColumn());
        status.setCellValueFactory(cellData -> cellData.getValue().statusProperty());
        status.setCellFactory(ComboBoxTableCell.forTableColumn("Complete", "Incomplete"));
        table.setItems(obList);
        filterBox.setItems(filterList);

    }

    @FXML
    public void addItemButtonClicked(javafx.scene.input.MouseEvent mouseEvent) {
        ListItem emptyItem = new ListItem();
        if(dateField.getValue() == null) {
            dateField.getValue();
            ListItem fullList = addItem(nameField.getText(), emptyItem);
            obList.add(fullList);
            nameField.clear();

        }
        else {
            ListItem fullList = addItem(nameField.getText(), dateField.getValue(), emptyItem);
            obList.add(fullList);
            nameField.clear();
            dateField.getEditor().clear();
            dateField.setValue(null);
        }

    }
    @FXML
    private ListItem addItem(String itemName, LocalDate date, ListItem item) {
        item.setItem(itemName);
        item.setDate(date.toString());
        return item;
    }
    private ListItem addItem(String itemName, ListItem item) {
        item.setItem(itemName);
        return item;
    }

    @FXML
    public void saveButtonClicked(javafx.scene.input.MouseEvent mouseEvent) throws IOException {
        // call saveList method
        saveList(obList);

    }

    private void saveList(ObservableList<ListItem> list) throws IOException {
        // make a new text file
        File saveFile = new File("data/list.txt");
        try (FileWriter write = new FileWriter(saveFile)) {
            // write into text file
            for(ListItem item : list) {
                write.write(item.getItem() + "\t" + item.getDate() + "\t" + item.getStatus() + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    @FXML
    public void loadButtonClicked(javafx.scene.input.MouseEvent mouseEvent) {
        // prompt user for the name of the file
        // call loadList method
        // call addList method
    }
    public void loadList(String fileName) {
        // open text file
        // read from file
        // get contents of file and store in an array
        // format into list
    }

    @FXML
    public void removeItemButtonClicked(javafx.scene.input.MouseEvent mouseEvent) {
        removeItem(obList, selectedItem);


    }
    public void removeItem(ObservableList<ListItem> list, ListItem item) {
        // remove method to remove item object from the item arraylist in list object
        list.remove(item);


    }
    @FXML
    private void getSelected(javafx.scene.input.MouseEvent mouseEvent) {
        selectedItem = table.getSelectionModel().getSelectedItem();
    }

    @FXML
    public void removeAllButtonClicked(javafx.scene.input.MouseEvent mouseEvent) {
        removeAll(obList);

    }
    public void removeAll(ObservableList<ListItem> list) {
        list.clear();
    }




    private void filter(String comboState) {
        if(comboState.equals("Show Incomplete")) {
            List<ListItem> tempList;
            ObservableList<ListItem> temp;
            temp = copyList(obList);
            tempList = temp.stream().filter(t -> t.getStatus().equals("Incomplete")).toList();
            obList = FXCollections.observableArrayList(tempList);

        }
        else if(comboState.equals("Show Complete")) {
            List<ListItem> tempList;
            ObservableList<ListItem> temp;
            temp = copyList(obList);
            tempList = temp.stream().filter(t -> t.getStatus().equals("Complete")).toList();
            obList = FXCollections.observableArrayList(tempList);
        }

    }

    @FXML
    public void comboBoxChange(javafx.event.ActionEvent actionEvent) {
        filter(filterBox.getValue());
    }

    private ObservableList<ListItem> copyList(ObservableList<ListItem> source) {

        return  FXCollections.observableArrayList(source);


    }
    public void printList(ObservableList<ListItem> list) {
        // only prints if list is not empty
        // loop through items in list object
        // print out the items
        for(ListItem item : list) {
            System.out.print(item.getItem());
        }

    }
    public void completeList(Object selectList) {
        // loop through items in list object
        // use getStatus method to see status of items
        // print out items marked as complete
    }
    public void incompleteList(Object selectList) {
        // loop through items in list object
        // use getStatus method to see status of items
        // print out items marked as incomplete
    }

}
