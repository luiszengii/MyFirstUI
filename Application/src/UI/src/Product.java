package src;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public enum Product {

    water("water", 0, "drinks", 1, 2),
    soft_drink("soft_drink", 0, "drinks", 2, 3),
    juice("juice", 0, "drinks", 3,2.5),
    MandM("MandM", 0, "chocolates", 4,8),
    Mars("Mars", 0, "chocolates", 5,5),
    Sneakers("Sneakers", 0, "chocolates", 6,2.5),
    Bounty("Bounty", 0, "chocolates", 7,1),
    original("original", 0, "chips", 8,2.5),
    chicken("chicken", 0, "chips", 9,3),
    BBQ("BBQ", 0, "chips", 10,2.7),
    sweet_chillies("sweet_chillies", 0, "chips", 11,3),
    sour_worms("sour_worms", 0, "lollies", 12,5),
    jellybeans("jellybeans", 0, "lollies", 13,2),
    little_bears("little_bears", 0, "lollies", 14,6.5),
    part_mix("part_mix", 0, "lollies", 15,4.5);

    private SimpleStringProperty name;
    private SimpleIntegerProperty num_of_items;
    private SimpleStringProperty category;
    private SimpleIntegerProperty product_id;
    private SimpleDoubleProperty price;
    private SimpleIntegerProperty num_in_cart;
    private SimpleDoubleProperty total_price_in_cart;

    Product(String name, int num_of_items, String category, int id, double price) {
        this.name = new SimpleStringProperty(name);
        this.num_of_items = new SimpleIntegerProperty(num_of_items);
        this.category = new SimpleStringProperty(category);
        this.product_id = new SimpleIntegerProperty(id);
        this.price = new SimpleDoubleProperty(price);
        this.num_in_cart = new SimpleIntegerProperty(0);
        this.total_price_in_cart = new SimpleDoubleProperty(0.00);
    }

    public double getTotal_price_in_cart() {
        return total_price_in_cart.get();
    }

    public SimpleDoubleProperty total_price_in_cartProperty() {
        return total_price_in_cart;
    }

    public void setTotal_price_in_cart(double total_price_in_cart) {
        this.total_price_in_cart.set(total_price_in_cart);
    }

    public int getNum_in_cart() {
        return num_in_cart.get();
    }

    public SimpleIntegerProperty num_in_cartProperty() {
        return num_in_cart;
    }

    public void setNum_in_cart(int num_in_cart) {
        this.num_in_cart.set(num_in_cart);
    }

    public SimpleDoubleProperty total_value_in_cartProperty() {
        return total_price_in_cart;
    }

    public String getName() {
        return name.get();
    }

    public int getNum_of_items() {
        return num_of_items.get();
    }

    public String getCategory() {
        return category.get();
    }

    public int getProduct_id() {
        return product_id.get();
    }

    public double getPrice() {
        return price.get();
    }

    public SimpleStringProperty nameProperty() {
        return name;
    }

    public void setNum_of_items(int num_of_items) {
        this.num_of_items.set(num_of_items);
    }

    public SimpleIntegerProperty num_of_itemsProperty() {
        return num_of_items;
    }

    public SimpleStringProperty categoryProperty() {
        return category;
    }

    public void setCategory(String category) {
        this.category.set(category);
    }

    public SimpleIntegerProperty product_idProperty() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id.set(product_id);
    }

    public SimpleDoubleProperty priceProperty() {
        return price;
    }

    public void setPrice(double price) {
        this.price.set(price);
    }

    // fill can only be used by the staff
    public void fill(){
        this.num_of_items.set(10);
    }

    // used after the transaction has been confirmed
    public void sell(int n){
        if(n < 1){
            System.out.println("VM: Cannot sell less than 1 product");
            return;
        } else if (n > this.num_of_items.get()) {
            System.out.println("VM: Cannot sell more than we have");
            return;
        }
        this.num_of_items.set(this.num_of_items.get() - n);
        this.num_in_cart.set(this.num_in_cart.get() + n);
        this.total_price_in_cart.set((double)Math.round((this.num_in_cart.get() * this.getPrice())*100)/100);
        System.out.println(n + " has been added to shopping cart");
    }

    public void add_back(int n) {
        if(n < 1){
            System.out.println("VM: Cannot add back less than 1 product");
            return;
        } else if (n > (10 - this.num_of_items.get())) {
            System.out.println("VM: Cannot add back more than 10");
            return;
        }
        this.num_of_items.set(this.num_of_items.get() + n);
        this.num_in_cart.set(this.num_in_cart.get() - n);
        this.total_price_in_cart.set((double)Math.round((this.num_in_cart.get() * this.getPrice())*100)/100);
        System.out.println(n + " has been removed from shopping cart");
    }

}