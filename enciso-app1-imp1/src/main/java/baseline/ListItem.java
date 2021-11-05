package baseline;

public class ListItem {
    private String itemName;
    private String date;
    private String status = "incomplete";

    public String getItem() {
        return itemName;
    }

    public void setItem(String item) {
        // Set item name with value in the parameter
        this.itemName = item;
    }

    public String getDate() {
        return date;
    }
    public void setDate(String date) {
        // set date with the date value in the parameter
        this.date = date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        // set status with the variable provided in parameter
        this.status = status;
    }
}
