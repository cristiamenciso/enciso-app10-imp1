package baseline;

import javafx.fxml.FXML;
import javafx.scene.control.ListView;

public class ListController  {

    @FXML
    ListView<String> list = new ListView<>();


    @FXML
    public void addItemButtonClicked(javafx.scene.input.MouseEvent mouseEvent) {
        //prompt user to select a list
        // call select list method
        // prompt user for name of item
        // Call addItem method
    }

    public void addItem(String itemName, Object list) {
        // create list object instance
        // create new item object
        // add method to add item object to item arrayList in List object.
    }

    @FXML
    public void saveButtonClicked(javafx.scene.input.MouseEvent mouseEvent) {
        // prompt user to save a single list or all of them
        // if single list
        // call saveList method

    }

    public void saveList() {
        // make a new text file
        // write into text file
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
        // Prompt user to select list
        // call selectList method
        // Prompt user to select an item
        // call removeItem method
    }
    public void removeItem(Object list, String itemName) {
        // remove method to remove item object from the item arraylist in list object
    }

    @FXML
    public void editItemButtonClicked(javafx.scene.input.MouseEvent mouseEvent) {
        // Prompt user to select list
        // Call selectList method
        // Prompt user to select item
        // Prompt user for edit
        // Call editItem method

    }
    public void editItem(Object list, String itemName, String edit) {
        // make a new item instance
        // setItem method to set new item name
    }

    @FXML
    public void editDateButtonClciked(javafx.scene.input.MouseEvent mouseEvent) {
        // Prompt user to select list
        // Call selectList method
        // Prompt user to select item
        // Prompt user for date edit
        // Call editDate method
    }
    public void editDate(Object list, String itemName, String editDate) {
        // make a new item instance
        // setDate method to set new item date
    }

    @FXML
    public void markCompleteButtonClicked(javafx.scene.input.MouseEvent mouseEvent) {
        // Call markComplete method
    }
    public void markComplete(Object list, String itemName) {
        // create a new item instance
        // setStatus method to set status to "Complete"

    }
    @FXML
    public void markIncompleteButtonClicked(javafx.scene.input.MouseEvent mouseEvent) {
        // Call markIncomplete method
    }

    public void markIncomplete(Object list, String itemName) {
        // create a new item instance
        // set status to incomplete
    }

    @FXML
    public void filterStatusButton(javafx.scene.input.MouseEvent mouseEvent) {
        // if show all selected
        // Call printList method
        // if show complete selected
        // call completeList method
        // if show incomplete selected
        // call incompleteList method
    }
    public void printList(Object selectList) {
        // loop through items in list object
        // print out the items

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
