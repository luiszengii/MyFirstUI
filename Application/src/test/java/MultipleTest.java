import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import java.time.*;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class MultipleTest {

    private static VendingMachine v;

    @Test
    public void wrong_format_check(){
        VendingMachine v = new VendingMachine();
        List l = new ArrayList();
        l.add("check");
        l.add("water");
        String exp = "'CHECK' command is a wrong format";
        String act = v.user_check(l);
        assertEquals(exp,act);
        v.clear();
    }

    @Test
    public void calculate_total_price(){
        ShoppingCart car = new ShoppingCart();
        car.add_Product(Product.water,2);
        car.add_Product(Product.original,2);
        double act = car.Calculate_total_price();
        double exp = 9.00;
        assertEquals(exp,act);
        car.clear();
    }

    @Test
    public void stock_check(){
        VendingMachine vm = new VendingMachine();
        vm.staff_fill();
        String exp = "------------------------------------\n" +
                "|     Drinks      |   Chocolates   |\n" +
                "------------------------------------\n" +
                "|     water 10     |     MandM 10    |\n"+
                "|   soft_drink 10  |      Mars 10    |\n"+
                "|     juice 10     |    Sneakers 10  |\n"+
                "|                 |     Bounty 10   |\n"+
                "------------------------------------\n" +
                "|     Chips       |     Lollies    |\n" +
                "------------------------------------\n" +
                "|    original 10   |  sour_worms 10  |\n"+
                "|     chicken 10   |  jellybeans 10  |\n"+
                "|       BBQ 10     | little_bears 10 |\n"+
                "|sweet_chillies 10 |   part_mix 10   |\n"+
                "------------------------------------\n";
        String act = vm.Product_statusUI();
        assertEquals(exp,act);
        vm.clear();
    }

    @Test
    public void multiple_item_of_same_kind(){
        VendingMachine vm = new VendingMachine();
        List ls = new ArrayList();
        ls.add("add");
        ls.add("water");
        String exp = "Sorry, we are out of " + ls.get(1);
        String act = vm.user_add(ls);
        assertEquals(exp,act);
        vm.clear();
    }

//    @Test
//    public void staff_print_command(){
//        VendingMachine vm = new VendingMachine();
//        List ls = new ArrayList();
//        List a = new ArrayList();
//        ls.add("add");
//        ls.add("water");
//        ls.add("3");
//        a.add("check");
//        vm.staff_fill();
//        vm.user_add(ls);
//        vm.user_check(a);
//        String act = vm.staff_print();
//        String exp = "This part is about daily transaction details\n" +
//                "Transaction 100:\n"+
//                "(1) Transaction date and time are "+ LocalDateTime.now()+"\n"+
//                "(2) In this transaction, these are sold items and sold number:\n"+
//                "    0 Bounty are(is) sold\n"+
//                "    0 soft_drink are(is) sold\n"+
//                "    0 original are(is) sold\n"+
//                "    0 part_mix are(is) sold\n"+
//                "    0 Sneakers are(is) sold\n"+
//                "    0 Mars are(is) sold\n"+
//                "    0 chicken are(is) sold\n"+
//                "    0 jellybeans are(is) sold\n"+
//                "    0 juice are(is) sold\n"+
//                "    0 sour_worms are(is) sold\n"+
//                "    3 water are(is) sold\n"+
//                "    0 little_bears are(is) sold\n"+
//                "    0 sweet_chillies are(is) sold\n"+"    0 BBQ are(is) sold\n"+
//                "    0 MandM are(is) sold\n"+
//                "(3) In this transaction, amount of money paid is $10.00\n"+
//                "(4) In this transaction, the change is $4.00\n"+
//                "--------------------------------------------------\n"+
//                "This part is about available stock\n"+
//                "The stock of chicken is 10\n"+
//                "The stock of Sneakers is 10\n"+
//                "The stock of original is 10\n"+
//                "The stock of soft_drink is 10\n"+
//                "The stock of part_mix is 10\n"+
//                "The stock of MandM is 10\n"+
//                "The stock of juice is 10\n"+
//                "The stock of water is 7\n" +
//                "The stock of sour_worms is 10\n"+
//                "The stock of BBQ is 10\n"+
//                "The stock of Mars is 10\n"+
//                "The stock of jellybeans is 10\n"+
//                "The stock of sweet_chillies is 10\n"+
//                "The stock of Bounty is 10\n"+
//                "The stock of little_bears is 10\n"+
//                "--------------------------------------------------\n";
//        assertEquals(exp,act);
//        vm.clear();
//    }

    @Test
    public void multiple_item(){
        VendingMachine vm = new VendingMachine();
        vm.staff_fill();
        List ls = new ArrayList();
        ls.add("add");
        ls.add("water");
        String act = vm.user_add(ls);
        String exp = "SC: 1 of water has been added to your shopping cart.";
        assertEquals(exp,act);
        vm.clear();
    }

    @Test
    public void category_item(){
        VendingMachine vm = new VendingMachine();
        List ls = new ArrayList();
        List a = new ArrayList();
        List b = new ArrayList();
        ls.add("add");
        ls.add("water");
        ls.add("3");
        b.add("add");
        b.add("original");
        b.add("4");
        a.add("check");
        vm.staff_fill();
        vm.user_add(ls);
        vm.user_check(a);
        vm.user_add(b);
        vm.user_check(a);
        String exp = vm.Product_statusUI();
        String act ="------------------------------------\n" +
                "|     Drinks      |   Chocolates   |\n" +
                "------------------------------------\n" +
                "|     water 7     |     MandM 10    |\n"+
                "|   soft_drink 10  |      Mars 10    |\n"+
                "|     juice 10     |    Sneakers 10  |\n"+
                "|                 |     Bounty 10   |\n"+
                "------------------------------------\n" +
                "|     Chips       |     Lollies    |\n" +
                "------------------------------------\n" +
                "|    original 6   |  sour_worms 10  |\n"+
                "|     chicken 10   |  jellybeans 10  |\n"+
                "|       BBQ 10     | little_bears 10 |\n"+
                "|sweet_chillies 10 |   part_mix 10   |\n"+
                "------------------------------------\n";;
        assertEquals(exp,act);
        vm.clear();
    }

}
