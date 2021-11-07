package baseline;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.time.LocalDate;

public class ListItem {
    private SimpleStringProperty itemName = new SimpleStringProperty();
    private SimpleStringProperty date = new SimpleStringProperty();
    private SimpleStringProperty status;

    public StringProperty itemNameProperty() {
        return itemName;
    }
    public StringProperty dateProperty() {
        return date;
    }
    public StringProperty statusProperty() {
        return status;
    }

    public ListItem(String item, String date) {
        this.itemName = new SimpleStringProperty(item);
        this.date = new SimpleStringProperty(date);
        this.status = new SimpleStringProperty("Incomplete");
    }

    public ListItem() {
        // constructor without arguments
        this.status = new SimpleStringProperty("Incomplete");
    }


    public String getItem() {
        return itemName.get();
    }

    public void setItem(String item) {
        // Set item name with value in the parameter
        itemName.set(item);
    }

    public String getDate() {

        return date.get();
    }

    public void setDate(String date) {
        // set date with the date value in the parameter
        this.date.set(date);
    }

    public String getStatus() {

        return status.get();
    }

    public void setStatus(String status) {
        // set status with the variable provided in parameter
        this.status.set(status);
    }
}
