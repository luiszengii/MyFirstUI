import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TransactionTest {
    @Test
    void getId1() {
        HashMap<Product,Integer> items = new HashMap<Product,Integer>();
        items.put(Product.BBQ,3);
        items.put(Product.chicken,6);
        String date1 = "2019-07-28 14:11:15";
        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime dateTime1 = LocalDateTime.parse(date1, df);
        Transaction a = new Transaction(01,dateTime1,items,50.50,15.3, 10.0);
        int actual = a.getId();
        int expected = 01;
        assertEquals(actual, expected);
    }
    @Test
    void getId2() {
        HashMap<Product,Integer> items = new HashMap<Product,Integer>();
        items.put(Product.jellybeans,5);
        items.put(Product.chicken,6);
        String date1 = "2019-05-12 15:06:15";
        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime dateTime1 = LocalDateTime.parse(date1, df);
        Transaction a = new Transaction(11,dateTime1,items,60.70,29.40, 10.0);
        int actual = a.getId();
        int expected = 11;
        assertEquals(actual, expected);
    }
    @Test
    void getId3() {
        HashMap<Product,Integer> items = new HashMap<Product,Integer>();
        items.put(Product.jellybeans,50);
        items.put(Product.juice,16);
        items.put(Product.Mars,14);
        String date1 = "2019-11-07 23:06:15";
        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime dateTime1 = LocalDateTime.parse(date1, df);
        Transaction a = new Transaction(43,dateTime1,items,644.70,429.40, 10.0);
        int actual = a.getId();
        int expected = 43;
        assertEquals(actual, expected);
    }
    @Test
    void getDate_time1() {
        HashMap<Product, Integer> items = new HashMap<Product, Integer>();
        items.put(Product.jellybeans, 50);
        items.put(Product.juice, 16);
        items.put(Product.Mars, 14);
        String date1 = "2019-11-07 23:06:15";
        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime dateTime1 = LocalDateTime.parse(date1, df);
        Transaction a = new Transaction(43, dateTime1, items, 644.70, 429.40, 10.0);
        LocalDateTime actual = a.getDate_time();
        assertEquals(actual, dateTime1);
    }
    @Test
    void getDate_time2() {
        HashMap<Product, Integer> items = new HashMap<Product, Integer>();
        items.put(Product.jellybeans, 50);
        items.put(Product.juice, 16);
        items.put(Product.Mars, 14);
        String date1 = "2018-12-25 07:46:59";
        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime dateTime1 = LocalDateTime.parse(date1, df);
        Transaction a = new Transaction(43, dateTime1, items, 644.70, 429.40, 10.0);
        LocalDateTime actual = a.getDate_time();
        assertEquals(actual, dateTime1);
    }
    @Test
    void getDate_time3() {
        HashMap<Product, Integer> items = new HashMap<Product, Integer>();
        items.put(Product.jellybeans, 50);
        String date1 = "1918-01-01 00:00:00";
        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime dateTime1 = LocalDateTime.parse(date1, df);
        Transaction a = new Transaction(00, dateTime1, items, 0, 0, 10.0);
        LocalDateTime actual = a.getDate_time();
        assertEquals(actual, dateTime1);
    }
    @Test
    void getItem_sold1() {
        HashMap<Product, Integer> items = new HashMap<Product, Integer>();
        items.put(Product.juice, 18);
        items.put(Product.sweet_chillies, 3);
        items.put(Product.MandM, 29);
        String date1 = "2000-01-01 00:00:00";
        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime dateTime1 = LocalDateTime.parse(date1, df);
        Transaction a = new Transaction(00, dateTime1, items, 0, 0, 10.0);
        HashMap<Product, Integer> actual = a.getItem_sold();
        assertEquals(actual, items);
    }
    @Test
    void getItem_sold2() {
        HashMap<Product, Integer> items = new HashMap<Product, Integer>();
        String date1 = "2000-01-01 00:00:00";
        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime dateTime1 = LocalDateTime.parse(date1, df);
        Transaction a = new Transaction(00, dateTime1, items, 0, 0, 10.0);
        HashMap<Product, Integer> actual = a.getItem_sold();
        assertEquals(actual, items);
    }
    @Test
    void getItem_sold3() {
        HashMap<Product, Integer> items = new HashMap<Product, Integer>();
        items.put(Product.juice, 1);
        items.put(Product.sweet_chillies, 2);
        items.put(Product.Mars, 3);
        items.put(Product.jellybeans, 4);
        items.put(Product.chicken, 5);
        items.put(Product.BBQ, 6);
        items.put(Product.Bounty, 7);
        items.put(Product.little_bears,8);
        items.put(Product.original, 9);
        items.put(Product.part_mix, 10);
        items.put(Product.Sneakers, 11);
        items.put(Product.soft_drink, 12);
        items.put(Product.water, 13);
        items.put(Product.sour_worms, 14);
        items.put(Product.MandM, 15);
        String date1 = "2000-01-01 00:00:00";
        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime dateTime1 = LocalDateTime.parse(date1, df);
        Transaction a = new Transaction(00, dateTime1, items, 0, 0, 10.0);
        HashMap<Product, Integer> actual = a.getItem_sold();
        assertEquals(actual, items);
    }
    @Test
    void getMoney_paid1() {
        HashMap<Product, Integer> items = new HashMap<Product, Integer>();
        String date1 = "2000-01-01 00:00:00";
        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime dateTime1 = LocalDateTime.parse(date1, df);
        Transaction a = new Transaction(00, dateTime1, items, 0, 0, 10.0);
        double actual = a.getMoney_paid();
        double expected = 0;
        assertEquals(actual, expected);
    }
    @Test
    void getMoney_paid2() {
        HashMap<Product, Integer> items = new HashMap<Product, Integer>();
        items.put(Product.juice, 18);
        items.put(Product.sweet_chillies, 3);
        items.put(Product.MandM, 29);
        String date1 = "2000-01-01 00:00:00";
        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime dateTime1 = LocalDateTime.parse(date1, df);
        Transaction a = new Transaction(00, dateTime1, items, 234.6, 25.8, 10.0);
        double actual = a.getMoney_paid();
        double expected = 234.6;
        assertEquals(actual, expected);
    }
    @Test
    void getMoney_paid3() {
        HashMap<Product, Integer> items = new HashMap<Product, Integer>();
        items.put(Product.part_mix, 10);
        items.put(Product.Sneakers, 11);
        items.put(Product.soft_drink, 12);
        String date1 = "2000-01-01 00:00:00";
        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime dateTime1 = LocalDateTime.parse(date1, df);
        Transaction a = new Transaction(00, dateTime1, items, 40, 2.80, 10.0);
        double actual = a.getMoney_paid();
        double expected = 40;
        assertEquals(actual, expected);
    }
    @Test
    void getChange1() {
        HashMap<Product, Integer> items = new HashMap<Product, Integer>();
        String date1 = "2000-01-01 00:00:00";
        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime dateTime1 = LocalDateTime.parse(date1, df);
        Transaction a = new Transaction(00, dateTime1, items, 0, 0, 10.0);
        double actual = a.getChange();
        double expected = 0;
        assertEquals(actual, expected);
    }
    @Test
    void getChange2() {
        HashMap<Product, Integer> items = new HashMap<Product, Integer>();
        items.put(Product.Mars, 3);
        items.put(Product.jellybeans, 4);
        items.put(Product.chicken, 5);
        items.put(Product.BBQ, 6);
        String date1 = "2000-01-01 00:00:00";
        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime dateTime1 = LocalDateTime.parse(date1, df);
        Transaction a = new Transaction(00, dateTime1, items, 328.6, 243.7, 10.0);
        double actual = a.getChange();
        double expected = 243.7;
        assertEquals(actual, expected);
    }
    @Test
    void getChange3() {
        HashMap<Product, Integer> items = new HashMap<Product, Integer>();
        items.put(Product.Mars, 33);
        items.put(Product.jellybeans, 14);
        String date1 = "2000-01-01 00:00:00";
        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime dateTime1 = LocalDateTime.parse(date1, df);
        Transaction a = new Transaction(00, dateTime1, items, 200, 50, 10.0);
        double actual = a.getChange();
        double expected = 50;
        assertEquals(actual, expected);
    }
    @Test
    void getTotalPrice() {
        HashMap<Product, Integer> items = new HashMap<Product, Integer>();
        items.put(Product.Mars, 33);
        items.put(Product.jellybeans, 14);
        String date1 = "2000-01-01 00:00:00";
        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime dateTime1 = LocalDateTime.parse(date1, df);
        Transaction a = new Transaction(00, dateTime1, items, 200, 50, 10.0);
        double actual = a.getTotal_price();
        double expected = 10.0;
        assertEquals(actual, expected);
    }

}
