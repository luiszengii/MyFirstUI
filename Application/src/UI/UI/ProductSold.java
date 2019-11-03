package UI;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class ProductSold {

    SimpleStringProperty name;
    SimpleIntegerProperty num_sold;
    SimpleDoubleProperty total_price;

    public ProductSold(String name, Integer num_sold, Double total_price) {
        this.name = new SimpleStringProperty(name);
        this.num_sold = new SimpleIntegerProperty(num_sold);
        this.total_price = new SimpleDoubleProperty(total_price);
    }

    public String getName() {
        return name.get();
    }

    public SimpleStringProperty nameProperty() {
        return name;
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public int getNum_sold() {
        return num_sold.get();
    }

    public SimpleIntegerProperty num_soldProperty() {
        return num_sold;
    }

    public void setNum_sold(int num_sold) {
        this.num_sold.set(num_sold);
    }

    public double getTotal_price() {
        return total_price.get();
    }

    public SimpleDoubleProperty total_priceProperty() {
        return total_price;
    }

    public void setTotal_price(double total_price) {
        this.total_price.set(total_price);
    }
}
