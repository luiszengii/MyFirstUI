import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class OverStockTest {

    private static VendingMachine v;

//    @BeforeEach
//    void new_VM(){
//        v = new VendingMachine();
//    }
//
//    @AfterEach
//    void clear_VendingMachine(){
//        v.clear();
//    }

    @Test
    void test_overstockA_whenNoItems_useName(){
        VendingMachine vm = new VendingMachine();
        List lo = new ArrayList();
        lo.add("add");
        lo.add("juice");
        lo.add("1");
        String actual = vm.user_add(lo);
        String expected = "The number you input is out of stock";
        assertEquals(expected,actual);
        vm.clear();
    }

    @Test
    void test_overstockB_whenNoItems_useID(){
        v = new VendingMachine();
        List l = new ArrayList();
        l.add("add");
        l.add("1");
        l.add("1");
        String actual = v.user_add(l);
        String expected = "The number you input is out of stock";
        assertEquals(expected,actual);
        v.clear();
    }

    @Test
    void test_overstockC_whenHaveItems_useName(){
        v = new VendingMachine();
        List l = new ArrayList();
        v.staff_fill();
        l.add("add");
        l.add("water");
        l.add("11");
        String actual = v.user_add(l);
        String expected = "The number you input is out of stock";
        assertEquals(expected,actual);
        v.clear();
    }

    @Test
    void test_overstockD_whenHaveItems_useID(){
        v = new VendingMachine();
        v.staff_fill();
        List l = new ArrayList();
        l.add("add");
        l.add("1");
        l.add("11");
        String actual = v.user_add(l);
        String expected = "The number you input is out of stock";
        assertEquals(expected,actual);
        v.clear();
    }

    @Test
    void test_overstockE_whenAlreadyAddItems_useName(){
        v = new VendingMachine();
        v.staff_fill();
        List l1 = new ArrayList();
        l1.add("add");
        l1.add("water");
        l1.add("3");
        v.user_add(l1);
        List l2 = new ArrayList();
        l2.add("add");
        l2.add("water");
        l2.add("8");
        String actual = v.user_add(l2);
        String expected = "The number you input is out of stock";
        assertEquals(expected,actual);
        v.clear();
    }

    @Test
    void test_overstockF_whenAlreadyAddItems_useID(){
        v = new VendingMachine();
        v.staff_fill();
        List l1 = new ArrayList();
        l1.add("add");
        l1.add("1");
        l1.add("3");
        v.user_add(l1);
        List l2 = new ArrayList();
        l2.add("add");
        l2.add("1");
        l2.add("8");
        String actual = v.user_add(l2);
        String expected = "The number you input is out of stock";
        assertEquals(expected,actual);
        v.clear();
    }

}