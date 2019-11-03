import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculateTest {
    @Test
    void money_reminderTest() {
        VendingMachine a = new VendingMachine();
        String expected = "You can only pay by these denominations of coins or notes: 10c, 20c, 50c, $1, $2, $5, $10, $20\n";
        String actual = a.money_reminder();
        assertEquals(actual,expected);
        a.clear();
    }
    @Test
    void convert_input_moneyTest() {
        VendingMachine a = new VendingMachine();
        double actual = a.convert_input_money("10c");
        double expected =0.1;
        assertEquals(actual,expected);
        double actual1 = a.convert_input_money("20c");
        double expected1 =0.2;
        assertEquals(actual1,expected1);
        double actual2 = a.convert_input_money("50c");
        double expected2 =0.5;
        assertEquals(actual2,expected2);
        double actual3 = a.convert_input_money("$1");
        double expected3 =1;
        assertEquals(actual3,expected3);
        double actual4 = a.convert_input_money("$2");
        double expected4 =2;
        assertEquals(actual4,expected4);
        double actual5 = a.convert_input_money("$5");
        double expected5 =5;
        assertEquals(actual5,expected5);
        double actual6 = a.convert_input_money("$10");
        double expected6 =10;
        assertEquals(actual6,expected6);
        double actual7 = a.convert_input_money("$20");
        double expected7 =20;
        assertEquals(actual7,expected7);
        double actual8 = a.convert_input_money("30c");
        double expected8 =-1;
        assertEquals(actual8,expected8);
        double actual9 = a.convert_input_money("aaa");
        double expected9 =-1;
        assertEquals(actual9,expected9);
        double actual10 = a.convert_input_money("$60");
        double expected10 =-1;
        assertEquals(actual10,expected10);
        double actual11 = a.convert_input_money("66");
        double expected11 =-1;
        assertEquals(actual11,expected11);
        a.clear();
    }
    @Test
    void Calculate_changeTest() {
        VendingMachine a = new VendingMachine();
        ArrayList<String> expected = new ArrayList<String>();
        ArrayList<String> actual = a.Calculate_change(20.00);
        expected.add("1 $20.00");
        assertEquals(actual,expected);
        ArrayList<String> expected1 = new ArrayList<String>();
        ArrayList<String> actual1 = a.Calculate_change(10.00);
        expected1.add("1 $10.00");
        assertEquals(actual1,expected1);
        ArrayList<String> expected2 = new ArrayList<String>();
        ArrayList<String> actual2 = a.Calculate_change(5.00);
        expected2.add("1 $5.00");
        assertEquals(actual2,expected2);
        ArrayList<String> expected3 = new ArrayList<String>();
        ArrayList<String> actual3 = a.Calculate_change(2.00);
        expected3.add("1 $2.00");
        assertEquals(actual3,expected3);
        ArrayList<String> expected4 = new ArrayList<String>();
        ArrayList<String> actual4 = a.Calculate_change(1.00);
        expected4.add("1 $1.00");
        assertEquals(actual4,expected4);
        ArrayList<String> expected5 = new ArrayList<String>();
        ArrayList<String> actual5 = a.Calculate_change(0.50);
        expected5.add("1 $0.50");
        assertEquals(actual5,expected5);
        ArrayList<String> expected6 = new ArrayList<String>();
        ArrayList<String> actual6 = a.Calculate_change(0.10);
        expected6.add("1 $0.10");
        assertEquals(actual6,expected6);
        ArrayList<String> expected7 = new ArrayList<String>();
        ArrayList<String> actual7 = a.Calculate_change(0.20);
        expected7.add("1 $0.20");
        assertEquals(actual7,expected7);
        ArrayList<String> expected8 = new ArrayList<String>();
        ArrayList<String> actual8 = a.Calculate_change(38.8);
        expected8.add("1 $20.00");
        expected8.add("1 $10.00");
        expected8.add("1 $5.00");
        expected8.add("1 $2.00");
        expected8.add("1 $1.00");
        expected8.add("1 $0.50");
        expected8.add("1 $0.20");
        expected8.add("1 $0.10");
        assertEquals(actual8,expected8);
        ArrayList<String> expected9 = new ArrayList<String>();
        ArrayList<String> actual9 = a.Calculate_change(40.00);
        expected9.add("2 $20.00");
        assertEquals(actual9,expected9);
        ArrayList<String> expected10 = new ArrayList<String>();
        ArrayList<String> actual10 = a.Calculate_change(46.90);
        expected10.add("2 $20.00");
        expected10.add("1 $5.00");
        expected10.add("1 $1.00");
        expected10.add("1 $0.50");
        expected10.add("2 $0.20");
        assertEquals(actual10,expected10);
        ArrayList<String> expected11 = new ArrayList<String>();
        ArrayList<String> actual11 = a.Calculate_change(63.6);
        expected11.add("3 $20.00");
        expected11.add("1 $2.00");
        expected11.add("1 $1.00");
        expected11.add("1 $0.50");
        expected11.add("1 $0.10");
        assertEquals(actual11,expected11);
        ArrayList<String> expected12 = new ArrayList<String>();
        ArrayList<String> actual12 = a.Calculate_change(19.4);
        expected12.add("1 $10.00");
        expected12.add("1 $5.00");
        expected12.add("2 $2.00");
        expected12.add("2 $0.20");
        assertEquals(actual12,expected12);
        ArrayList<String> expected13 = new ArrayList<String>();
        ArrayList<String> actual13 = a.Calculate_change(0.3);
        expected13.add("1 $0.20");
        expected13.add("1 $0.10");
        assertEquals(actual13,expected13);
        ArrayList<String> expected14 = new ArrayList<String>();
        ArrayList<String> actual14 = a.Calculate_change(0.00);
        assertEquals(actual14,expected14);
//        ArrayList<String> expected15 = new ArrayList<String>();
//        ArrayList<String> actual15 = a.Calculate_change(-2.0);
//        assertEquals(actual15,expected15);
        a.clear();
    }
}
