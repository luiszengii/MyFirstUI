package UI;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import src.Product;
import src.Transaction;
import src.VendingMachine;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class VendingMachineController implements Initializable {

    //configure the table
    @FXML public TableView<Product> product_table;
    @FXML private TableColumn<Product, String> product_name;
    @FXML private TableColumn<Product, Double> price;
    @FXML private TableColumn<Product, Integer> quantity;
    @FXML private TableColumn<Product, Integer> num_in_cart;
    @FXML private TableColumn<Product, Double> total_price_in_cart;

    //configure the buttons
    @FXML private Button addButton;
    @FXML private Button deleteButton;
    @FXML private Button confirmButton;
    @FXML private Button checkOutButton;

    //configure text fields
    @FXML private TextField input_quantity;
    @FXML private TextField type_in;

    //configure needed objects
    public static VendingMachine VM = new VendingMachine();
    public static int TxIDCount = 100;
    public static ArrayList<Transaction> transactions = new ArrayList<>();

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        //set up columns
        product_name.setCellValueFactory(new PropertyValueFactory<>("name"));
        price.setCellValueFactory(new PropertyValueFactory<>("price"));
        quantity.setCellValueFactory(new PropertyValueFactory<>("num_of_items"));
        num_in_cart.setCellValueFactory(new PropertyValueFactory<>("num_in_cart"));
        total_price_in_cart.setCellValueFactory(new PropertyValueFactory<>("total_price_in_cart"));

        //load data
        product_table.setItems(getProducts());
        product_table.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

        //set up buttons
        addButton.setOnAction(e -> addToCart(input_quantity, VM));
        deleteButton.setOnAction(e -> deleteFromCart(input_quantity, VM));
        confirmButton.setOnAction(e -> isStaff(type_in));
        checkOutButton.setOnAction(e -> {
            try {
                PayingProcessUI.display();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });

    }

    /**
     * This method will return an ObservableList of Product objects
     */
    public static ObservableList<Product> getProducts(){
        ObservableList<Product> products = FXCollections.observableArrayList();
        for (Product p : Product.values()) {
            products.add(p);
        }
        return products;
    }

    public void addToCart(TextField input_quantity, VendingMachine VM) {
        int num_sold = Integer.parseInt(input_quantity.getText());
        ObservableList<Product> products;
        products = product_table.getSelectionModel().getSelectedItems();

        //get selected product and modify the actual ones
        for (Product p : products) {
            Product P = Product.valueOf(p.getName());

            //add to shopping cart only when sold success
            if (num_sold <= P.getNum_of_items()) {
                P.sell(num_sold);
                VM.shoppingCart.add_Product(P, num_sold);
            }

            System.out.println(VM.shoppingCart.showUI());
        }

        product_table.setItems(getProducts());
        product_table.refresh();
    }

    public void deleteFromCart(TextField input_quantity, VendingMachine VM){
        int num_removed = Integer.parseInt(input_quantity.getText());
        ObservableList<Product> products;
        products = product_table.getSelectionModel().getSelectedItems();

        //get selected product and modify the actual ones
        for (Product p : products) {

            Product P = Product.valueOf(p.getName());

            //add to shopping cart only when sold success
            if (num_removed <= P.getNum_in_cart()) {
                P.add_back(num_removed);
                VM.shoppingCart.delete_Product(P, num_removed);
            }

            //print the cart status
            System.out.println(VM.shoppingCart.showUI());

        }

        product_table.setItems(getProducts());
        product_table.refresh();
    }

    public void isStaff(TextField type_in) {
        if (type_in.getText().equals("staff")) {
            StaffModeUI.display();
        }
        product_table.setItems(getProducts());
        product_table.refresh();
    }

}