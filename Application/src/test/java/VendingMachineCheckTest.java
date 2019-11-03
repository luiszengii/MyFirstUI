import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class VendingMachineCheckTest {
    @Test
    void test1_wrongFormatCheck_whenNoItems_emptysc(){
        VendingMachine v = new VendingMachine();
        List l =new ArrayList();
        l.add("check");
        l.add("heyman");
        String actual = v.user_check(l);
        String expected = "'CHECK' command is a wrong format";
        assertEquals(expected,actual);
        v.clear();
    }

    @Test
    void test2_wrongFormatCheck_whenHaveItems_emptysc(){
        VendingMachine v = new VendingMachine();
        v.staff_fill();
        List l =new ArrayList();
        l.add("check");
        l.add("heyman");
        String actual = v.user_check(l);
        String expected = "'CHECK' command is a wrong format";
        assertEquals(expected,actual);
        v.clear();
    }

    @Test
    void test3_wrongFormatCheck_whenHaveItems_Noemptysc_useName(){
        VendingMachine v = new VendingMachine();
        v.staff_fill();
        List ll = new ArrayList();
        ll.add("add");
        ll.add("water");
        ll.add("1");
        v.user_add(ll);
        List l =new ArrayList();
        l.add("check");
        l.add("heyman");
        String actual = v.user_check(l);
        String expected = "'CHECK' command is a wrong format";
        assertEquals(expected,actual);
        v.clear();
    }

    @Test
    void test4_wrongFormatCheck_whenHaveItems_Noemptysc_useID(){
        VendingMachine v = new VendingMachine();
        v.staff_fill();
        List ll = new ArrayList();
        ll.add("add");
        ll.add("1");
        ll.add("1");
        v.user_add(ll);
        List l =new ArrayList();
        l.add("check");
        l.add("heyman");
        String actual = v.user_check(l);
        String expected = "'CHECK' command is a wrong format";
        assertEquals(expected,actual);
        v.clear();
    }

    @Test
    void test5_Check_whenNoItems_emptysc(){
        VendingMachine v = new VendingMachine();
        String actual = v.user_input("check");
        String expected = "add something to shoppingcart\n";
        assertEquals(expected,actual);
        v.clear();
    }

    @Test
    void test6_Check_whenHaveItems_emptysc() {
        VendingMachine v = new VendingMachine();
        v.staff_fill();
        String actual = v.user_input("check");
        String expected = "add something to shoppingcart\n";
        assertEquals(expected, actual);
        v.clear();
    }

    @Test
    void test7_Check_whenHaveItems_Noemptysc_useName() {
        VendingMachine v = new VendingMachine();
        v.staff_fill();
        List l = new ArrayList();
        l.add("add");
        l.add("water");
        l.add("1");
        v.user_add(l);
        List ll = new ArrayList();
        ll.add("check");
        String actual = v.user_check(ll);
        String expected = "           Shopping Cart            \n"+
                "------------------------------------\n"+
                "|     Drinks      |   Chocolates   |\n"+
                "------------------------------------\n"+
                "|     water 1    |     MandM 0   |\n"+
                "|   soft_drink 0 |      Mars 0   |\n"+
                "|     juice 0    |    Sneakers 0 |\n"+
                "|                 |     Bounty 0  |\n"+
                "------------------------------------\n"+
                "|     Chips       |     Lollies    |\n"+
                "------------------------------------\n"+
                "|    original 0  |  sour_worms 0 |\n"+
                "|     chicken 0  |  jellybeans 0 |\n"+
                "|       BBQ 0    | little_bears 0|\n"+
                "|sweet_chillies 0|   part_mix 0  |\n"+
                "------------------------------------\n"+"\n"+
                "The total price you need to pay is: $2.00\n"+
                "Now you will enter paying progress\n"+
                "You can only pay by these denominations of coins or notes: 10c, 20c, 50c, $1, $2, $5, $10, $20\n";
                ;
        assertEquals(expected, actual);
        v.clear();
    }

    @Test
    void test8_Check_whenHaveItems_Noemptysc_useID() {
        VendingMachine v = new VendingMachine();
        v.staff_fill();
        List l = new ArrayList();
        l.add("add");
        l.add("1");
        l.add("1");
        v.user_add(l);
        List ll = new ArrayList();
        ll.add("check");
        String actual = v.user_check(ll);
        String expected = "           Shopping Cart            \n"+
                "------------------------------------\n"+
                "|     Drinks      |   Chocolates   |\n"+
                "------------------------------------\n"+
                "|     water 1    |     MandM 0   |\n"+
                "|   soft_drink 0 |      Mars 0   |\n"+
                "|     juice 0    |    Sneakers 0 |\n"+
                "|                 |     Bounty 0  |\n"+
                "------------------------------------\n"+
                "|     Chips       |     Lollies    |\n"+
                "------------------------------------\n"+
                "|    original 0  |  sour_worms 0 |\n"+
                "|     chicken 0  |  jellybeans 0 |\n"+
                "|       BBQ 0    | little_bears 0|\n"+
                "|sweet_chillies 0|   part_mix 0  |\n"+
                "------------------------------------\n"+"\n"+
                "The total price you need to pay is: $2.00\n"+
                "Now you will enter paying progress\n"+
                "You can only pay by these denominations of coins or notes: 10c, 20c, 50c, $1, $2, $5, $10, $20\n";
                ;
        assertEquals(expected, actual);
        v.clear();
    }

}