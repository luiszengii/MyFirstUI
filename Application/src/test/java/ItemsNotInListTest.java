import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ItemsNotInListTest {
    @Test
    void test_whenNoItems(){
        VendingMachine v = new VendingMachine();
        List l = new ArrayList();
        l.add("add");
        l.add("YIFAN");
        l.add("1");
        String expected = "Product not exist, please type in the correct product name";
        String actual = v.user_add(l);
        assertEquals(expected,actual);
        v.clear();
    }

    @Test
    void test_whenHaveItems(){
        VendingMachine v = new VendingMachine();
        List l = new ArrayList();
        l.add("add");
        l.add("YIFAN");
        l.add("1");
        v.staff_fill();
        String expected = "Product not exist, please type in the correct product name";
        String actual = v.user_add(l);
        assertEquals(expected,actual);
        v.clear();
    }

}