import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ProductTest {

    Product product;

    @BeforeEach
    public void setUp() {
        product = Product.water;
    }

    // Testing if getName() function returns product's name correctly.
    // What we expect is a string "water".
    @Test
    public void test_getName(){
        assertEquals("water",product.getName());
    }

    // Tesing if getNum_of_items() function returns the number of products correctly.
    // What we expect is a integer "0".
    @Test
    public void test_getNum_of_items(){
        assertEquals(0,product.getNum_of_items());
    }

    // Tesing if getProduct_id() function returns the id of the product correctly.
    // What we expect is integer "1".
    @Test
    public void test_getProduct_id(){
        assertEquals(1,product.getProduct_id());
    }

    // Testing if getCategory() function returns the category of the product correctly.
    // What we expect is a string "drinks".
    @Test
    public void test_getCategory(){
        assertEquals("drinks",product.getCategory());
    }

    // Testing if getPrice() function returns the price of product correctly.
    // What we expect is a double 2.00.
    @Test
    public void test_getPrice(){
        assertEquals(2.00,product.getPrice(),0.1);
    }

    // Testing if fill() function actually change the number of product to 10.
    // What we expect is a integer 10.
    @Test
    public void test_fill(){
        product.fill();
        assertEquals(10,product.getNum_of_items());
        product.setNum_of_items(0);
    }

    @Test
    public void test_sell_less_than_1() {
        product.sell(-1);
        assertEquals(0,product.getNum_of_items());
    }

    @Test
    public void test_sell_more_than_stock() {
        product.fill();
        product.sell(12);
        assertEquals(10, product.getNum_of_items());
    }

    @Test
    public void test_sell() {
        product.fill();
        product.sell(5);
        assertEquals(5,product.getNum_of_items());
        product.setNum_of_items(0);
    }
}
