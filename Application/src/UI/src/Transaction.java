package src;

import UI.ProductSold;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;

public class Transaction {

    private int id;
    private LocalDateTime date_time;
    private ArrayList<ProductSold> item_sold;
    private double money_paid;
    private double change;
    private double total_price;

    public Transaction(int id, LocalDateTime date_time, ArrayList<ProductSold> item_sold,
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

    public int getId(){
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDate_time(LocalDateTime date_time) {
        this.date_time = date_time;
    }

    public void setItem_sold(ArrayList<ProductSold> item_sold) {
        this.item_sold = item_sold;
    }

    public void setMoney_paid(double money_paid) {
        this.money_paid = money_paid;
    }

    public void setChange(double change) {
        this.change = change;
    }

    public void setTotal_price(double total_price) {
        this.total_price = total_price;
    }

    public LocalDateTime getDate_time (){
        return this.date_time;
    }

    public ArrayList<ProductSold> getItem_sold(){
        return this.item_sold ;
    }

    public double getMoney_paid (){
        return this.money_paid ;
    }

    public double getChange (){
        return this.change;
    }


}
