package baseline;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ListItemTest {

    @Test
    void getItem() {
        ListItem test = new ListItem();
        String actual = test.getItem();
        String expected = null;
        assertEquals(expected, actual);
    }
    @Test
    void setItem() {
        ListItem test = new ListItem();
        test.setItem("Stick");
        String actual = test.getItem();
        String expected = "Stick";
        assertEquals(expected, actual);
    }

    @Test
    void getDate() {
        ListItem test = new ListItem();
        String actual = test.getDate();
        String expected = null;
        assertEquals(expected, actual);
    }

    @Test
    void setDate() {
        ListItem test = new ListItem();
        test.setDate("09/29/1994");
        String actual = test.getDate();
        String expected = "09/29/1994";
        assertEquals(actual, expected);
    }

    @Test
    void getStatus() {
        ListItem test = new ListItem();
        String actual = test.getStatus();
        String expected = null;
        assertEquals(expected, actual);
    }

    @Test
    void setStatus() {
        ListItem test = new ListItem();
        test.setStatus("complete");
        String actual = test.getStatus();
        String expected = "complete";
        assertEquals(expected, actual);
    }
}