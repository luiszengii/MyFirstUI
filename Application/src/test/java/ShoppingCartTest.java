import jdk.internal.jline.console.UserInterruptException;
import jdk.internal.jline.internal.ShutdownHooks;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestTemplate;

import java.util.HashMap;
import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;

class ShoppingCartTest {

    @Test
    void showUI_noAdd() {
        ShoppingCart s = new ShoppingCart();
        String actual = s.showUI();
        String expected =   "           Shopping Cart            \n"+
                "------------------------------------\n"+
                "|     Drinks      |   Chocolates   |\n"+
                "------------------------------------\n"+
                "|     water 0    |     MandM 0   |\n"+
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
                "------------------------------------\n";
        assertEquals(actual,expected);
        s.clear();
    }
    //Test could it show the correct UI when no adding items
    //What we expected is the UI with all the items 0

    @Test
    void showUI_withAdd(){
        ShoppingCart s = new ShoppingCart();
        s.add_Product(Product.water,1);
        s.add_Product(Product.juice,2);
        String actual = s.showUI();
        String expected =   "           Shopping Cart            \n"+
                "------------------------------------\n"+
                "|     Drinks      |   Chocolates   |\n"+
                "------------------------------------\n"+
                "|     water 1    |     MandM 0   |\n"+
                "|   soft_drink 0 |      Mars 0   |\n"+
                "|     juice 2    |    Sneakers 0 |\n"+
                "|                 |     Bounty 0  |\n"+
                "------------------------------------\n"+
                "|     Chips       |     Lollies    |\n"+
                "------------------------------------\n"+
                "|    original 0  |  sour_worms 0 |\n"+
                "|     chicken 0  |  jellybeans 0 |\n"+
                "|       BBQ 0    | little_bears 0|\n"+
                "|sweet_chillies 0|   part_mix 0  |\n"+
                "------------------------------------\n";
        assertEquals(actual,expected);
        s.clear();
    }
    //Test could it show the correct UI when adding items
    //What we expected is the UI with 1 water and 2 juice

    @Test
    void getList_of_Products_noAdd() {
        ShoppingCart s = new ShoppingCart();
        HashMap actual_map = s.getList_of_Products();
        Iterator it = actual_map.entrySet().iterator();
        Object expected_value;
        Object actual = 0;
        while(it.hasNext()){
            HashMap.Entry entry = (HashMap.Entry)it.next();
            expected_value=entry.getValue();
            assertEquals(expected_value,actual);
        }
        s.clear();
    }
    //Test could it get the right list when no adding items
    //What we expected is an empty list of products

    @Test
    void getList_of_Products_formal() {
        ShoppingCart s = new ShoppingCart();
        s.add_Product(Product.water,1);
        s.add_Product(Product.BBQ,1);
        HashMap actual_map = s.getList_of_Products();
        Object expected_value_1 = actual_map.get(Product.water);
        Object expected_value_2 = actual_map.get(Product.BBQ);
        Object actual = 1;
        assertEquals(expected_value_1,actual);
        assertEquals(expected_value_2,actual);
        s.clear();
    }
    //Test could it get the right list when adding items
    //What we expected is a list of 1 water and 2 BBQ

    @Test
    void add_Product_negativeNum() {
        ShoppingCart s = new ShoppingCart();
        s.add_Product(Product.water,0);
        s.add_Product(Product.BBQ,-1);
        int actual_1 = s.getList_of_Products().get(Product.water);
        int expected_1 = 0;
        assertEquals(actual_1, expected_1);
        int actual_2 = s.getList_of_Products().get(Product.BBQ);
        int expected_2 = 0;
        assertEquals(actual_2,expected_2);
        s.clear();
    }
    //Test could it add products to the shoppingcart when number is 0 or negative
    //What we expected is the num would not change if the number is incorrect

    @Test
    void add_Product_normal(){
        ShoppingCart s = new ShoppingCart();
        s.add_Product(Product.water,1);
        s.add_Product(Product.BBQ,2);
        int actual_1 = s.getList_of_Products().get(Product.water);
        int expected_1 = 1;
        assertEquals(actual_1, expected_1);
        int actual_2 = s.getList_of_Products().get(Product.BBQ);
        int expected_2 = 2;
        assertEquals(actual_2,expected_2);
        s.clear();
    }
    //Test could it add products to the shoppingcart when number is correct
    //What we expected is the num would change to 1 for water and 2 for BBQ

    @Test
    void delete_Product_negative() {
        ShoppingCart s = new ShoppingCart();
        s.add_Product(Product.water,1);
        s.delete_Product(Product.water,0);
        s.delete_Product(Product.BBQ,-1);
        int actual_1 = s.getList_of_Products().get(Product.water);
        int expected_1 = 1;
        assertEquals(actual_1, expected_1);
        int actual_2 = s.getList_of_Products().get(Product.BBQ);
        int expected_2 = 0;
        assertEquals(actual_2,expected_2);
        s.clear();
    }
    //Test could it delete products when number is 0 or negative
    //What we expected is that the num would not change if number is 0 or negative

    @Test
    void delete_Product_overProducts() {
        ShoppingCart s = new ShoppingCart();
        s.add_Product(Product.water,1);
        s.delete_Product(Product.water,2);
        int actual = s.getList_of_Products().get(Product.water);
        int expected = 1;
        assertEquals(actual, expected);
        s.clear();
    }
    //Test could it delete products when number is over stock
    //What we expected is that the num would not change if number is over stock

    @Test
    void delete_Product_normal() {
        ShoppingCart s = new ShoppingCart();
        s.add_Product(Product.water,2);
        s.delete_Product(Product.water,1);
        s.add_Product(Product.BBQ,3);
        s.delete_Product(Product.BBQ,3);
        int actual_1 = s.getList_of_Products().get(Product.water);
        int expected_1 = 1;
        assertEquals(actual_1, expected_1);
        int actual_2 = s.getList_of_Products().get(Product.BBQ);
        int expected_2 = 0;
        assertEquals(actual_2,expected_2);
        s.clear();
    }
    //Test could it delete products when number is correct
    //What we expected is that the num would change to 1 for water and 0 for BBQ

    @Test
    void chage_num_of_product_negative(){
        ShoppingCart s =new ShoppingCart();
        s.add_Product(Product.water,2);
        s.change_num_of_product(Product.water,-1);
        int actual = s.getList_of_Products().get(Product.water);
        int expected = 2;
        assertEquals(actual, expected);
        s.clear();
    }
    //Test could it change the num when entering a negative number
    //What we expected is the num would not change

    @Test
    void change_num_of_product_zero(){
        ShoppingCart s =new ShoppingCart();
        s.add_Product(Product.water,2);
        s.change_num_of_product(Product.water,0);
        int actual = s.getList_of_Products().get(Product.water);
        int expected = 0;
        assertEquals(actual, expected);
        s.clear();
    }
    //Test could it change the num when entering a 0 number
    //What we expected is the num would not change

    @Test
    void change_num_of_product_formal() {
        ShoppingCart s = new ShoppingCart();
        s.add_Product(Product.water,2);
        s.add_Product(Product.BBQ,2);
        s.change_num_of_product(Product.water,3);
        s.change_num_of_product(Product.BBQ,4);
        int actual_1 = s.getList_of_Products().get(Product.water);
        int expected_1 = 3;
        assertEquals(actual_1, expected_1);
        int actual_2 = s.getList_of_Products().get(Product.BBQ);
        int expected_2 = 4;
        assertEquals(actual_2,expected_2);
        s.clear();

    }
    //Test could it change the num when entering a correct number
    //What we expected is the num would change to 3 for water and 4 for BBQ

    @Test
    void change_num_of_product_wrongGood(){
        ShoppingCart s =new ShoppingCart();
        s.add_Product(Product.water,2);
        s.change_num_of_product(Product.BBQ,1);
        int actual = s.getList_of_Products().get(Product.water);
        int expected = 2;
        assertEquals(actual, expected);
        s.clear();
    }
    //Test could it change the num when entering wrong goods
    //What we expected is that the num would not change

    @Test
    void calculate_total_price() {
        ShoppingCart s =new ShoppingCart();
        s.add_Product(Product.water,2);
        s.add_Product(Product.BBQ,1);
        double actual = s.Calculate_total_price();
        double expected = 6.70;
        assertEquals(actual, expected);
        s.clear();
    }
    //Test could it calculate the total price
    //What we expected is the total price is $6.70

    @Test
    void clear() {
        ShoppingCart s =new ShoppingCart();
        s.add_Product(Product.water,2);
        s.add_Product(Product.BBQ,1);
        s.clear();
        int actual_1 = s.getList_of_Products().get(Product.water);
        int expected_1 = 0;
        assertEquals(actual_1, expected_1);
        int actual_2 = s.getList_of_Products().get(Product.BBQ);
        int expected_2 = 0;
        assertEquals(actual_2,expected_2);
        s.clear();
    }
    //Test could it clear the shoppingcart correctly
    //What we expected is that the shoppingcart could be cleared
}