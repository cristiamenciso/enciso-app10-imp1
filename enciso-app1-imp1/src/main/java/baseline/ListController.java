package baseline;
/*
 *  UCF COP3330 Fall 2021 Application Assignment 1 Solution
 *  Copyright 2021 Cristiam Enciso
 */

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.ComboBoxTableCell;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.stage.FileChooser;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class ListController implements Initializable {

    // Variables for the GUI
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
    FilteredList<ListItem> newList = new FilteredList<>(obList);

    FileChooser fileChooser = new FileChooser();

    // Method to inititalize GUI variables, elemetns and proeperties
    @Override
    public void initialize(URL location, ResourceBundle resource) {
        listName.setCellValueFactory(cellData -> cellData.getValue().itemNameProperty());
        listName.setCellFactory(TextFieldTableCell.forTableColumn());
        date.setCellValueFactory(cellData -> cellData.getValue().dateProperty());
        date.setCellFactory(TextFieldTableCell.forTableColumn());
        status.setCellValueFactory(cellData -> cellData.getValue().statusProperty());
        status.setCellFactory(ComboBoxTableCell.forTableColumn("Complete", "Incomplete"));
        filterBox.setItems(filterList);
        table.setItems(obList);
        fileChooser.setInitialDirectory(new File("C:\\temp"));


        // Attempt to create a listener for combobox to filter list
        FilteredList<ListItem> filteredData = new FilteredList<>(obList, p -> true);
        filterBox.onActionProperty().addListener((observable, oldValue, newValue) -> filteredData.setPredicate(listItem -> {
            if(newValue.toString().equals("Show All")) {
                return true;
            }
            if(newValue.toString().equals("Show Complete")) {
                return true;
            }
            return newValue.toString().equals("Show Incomplete");
        }));
    }


    // Private Methods and events
    @FXML
    public void addItemButtonClicked(javafx.scene.input.MouseEvent mouseEvent) {
        ListItem emptyItem = new ListItem();
        if(dateField.getValue() == null) {
            dateField.getValue();
            ListItem fullList = makeItem(nameField.getText(), emptyItem);
            obList.add(fullList);
            nameField.clear();

        }
        else {
            ListItem fullList = makeItem(nameField.getText(), dateField.getValue(), emptyItem);
            obList.add(fullList);
            nameField.clear();
            dateField.getEditor().clear();
            dateField.setValue(null);
        }

    }


    private ListItem makeItem(String itemName, LocalDate date, ListItem item) {
        item.setItem(itemName);
        item.setDate(date.toString());
        return item;
    }
    private ListItem makeItem(String itemName, ListItem item) {
        item.setItem(itemName);
        return item;
    }

    @FXML
    public void saveButtonClicked(javafx.scene.input.MouseEvent mouseEvent) throws IOException {
        // call saveList method
        saveList(obList);


       /* Window stage = menu.getScene().getWindow();
        fileChooser.setTitle("Save Log");
        fileChooser.setInitialFileName("mysave");
        fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("text file", "*.txt"));
        fileChooser.showSaveDialog(stage);

        try {
            File file = fileChooser.showSaveDialog(stage);
            fileChooser.setInitialDirectory(file.getParentFile());
        }
        catch (Exception ignored) {

        }

        */



    }
    // method to write into a file
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


    // Could not get this load feature to work
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
    // methos to remove item from list
    @FXML
    public void removeItemButtonClicked(javafx.scene.input.MouseEvent mouseEvent) {
        removeItem(obList, selectedItem);


    }
    private void removeItem(ObservableList<ListItem> list, ListItem item) {
        // remove method to remove item object from the item arraylist in list object
        list.remove(item);


    }

    // method to select item from the gui
    @FXML
    private void getSelected(javafx.scene.input.MouseEvent mouseEvent) {
        selectedItem = table.getSelectionModel().getSelectedItem();
    }

    @FXML
    public void removeAllButtonClicked(javafx.scene.input.MouseEvent mouseEvent) {
        removeAll(obList);

    }
    private void removeAll(ObservableList<ListItem> list) {
        list.clear();
    }

     // method to observe the changing of the combobox
    @FXML
    public void comboBoxChange(javafx.event.ActionEvent actionEvent) {
        //filter(filterBox.getValue());

    }

}
