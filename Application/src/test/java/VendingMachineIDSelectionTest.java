import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class VendingMachineIDSelectionTest {

    @Test
    void select_correctID_whenNoItems(){
        VendingMachine v = new VendingMachine();
        List l = new ArrayList();
        l.add("add");
        l.add("1");
        l.add("1");
        String expected = "The number you input is out of stock";
        String actual =  v.user_add(l);
        assertEquals(expected,actual);
        v.clear();
    }

    @Test
    void select_wrongID_whenNoItems(){
        VendingMachine v = new VendingMachine();
        List l1 = new ArrayList();
        l1.add("add");
        l1.add("9527");
        l1.add("1");
        String expected = "Product not exist, please type in the correct product name" ;
        String actual = v.user_add(l1);
        assertEquals(expected,actual);
        v.clear();
    }

    @Test
    void select_rightID_whenHaveItems(){
        VendingMachine v = new VendingMachine();
        v.staff_fill();
        //fill the machine
        List l = new ArrayList();
        l.add("add");
        l.add("1");
        l.add("1");
        String expected = "SC: 1 of water has been added to your shopping cart.";
        String actual = v.user_add(l);
        assertEquals(expected,actual);
        v.clear();
    }

    @Test
    void select_wrongID_whenHaveItems(){
        VendingMachine v = new VendingMachine();
        v.staff_fill();
        //fill the machine
        List l = new ArrayList();
        l.add("add");
        l.add("9527");
        l.add("1");
        String expected = "Product not exist, please type in the correct product name";
        String actual = v.user_add(l);
        assertEquals(expected,actual);
        v.clear();
    }

    @Test
    void select_IDcomplexItems(){
        VendingMachine v = new VendingMachine();
        List l = new ArrayList();
        l.add("add");
        l.add("1");
        l.add("1");
        String expected = "The number you input is out of stock";
        String actual =  v.user_add(l);
        assertEquals(expected,actual);
        v.staff_fill();
        //fill the machine
        List l1 = new ArrayList();
        l1.add("add");
        l1.add("1");
        l1.add("2");
        String expected1 = "SC: 2 of water has been added to your shopping cart.";
        String actual1 = v.user_add(l1);
        assertEquals(expected1,actual1);
        v.clear();
    }
}