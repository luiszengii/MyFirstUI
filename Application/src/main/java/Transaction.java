import java.util.*;
import java.time.*;

public class Transaction {

    private int id;
    private LocalDateTime date_time;
    private HashMap<Product,Integer> item_sold;
    private double money_paid;
    private double change;
    private double total_price;

    Transaction(int id, LocalDateTime date_time, HashMap<Product,Integer> item_sold,
                double money_paid, double change, double total_price){
        this.id = id;
        this.date_time =date_time;
        this.item_sold = item_sold;
        this.money_paid = money_paid ;
        this.change = change;
        this.total_price = total_price;
    }

    public double getTotal_price() {
        return total_price;
    }

    int getId(){
        return this.id;
    }

    LocalDateTime getDate_time (){
        return this.date_time;
    }

    HashMap<Product, Integer> getItem_sold(){
        return this.item_sold ;
    }

    double getMoney_paid (){
        return this.money_paid ;
    }

    double getChange (){
        return this.change;
    }


}
