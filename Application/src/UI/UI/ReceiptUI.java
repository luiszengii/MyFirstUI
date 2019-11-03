package UI;

import javafx.application.Application;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import src.Product;
import src.Transaction;
import src.VendingMachine;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;

public class ReceiptUI extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    static Transaction current_transaction;



    @Override
    public void start(Stage primaryStage) throws IOException {
        //generating a new transaction record
        ArrayList<ProductSold> temp = new ArrayList<ProductSold>();
        for (Product p: VendingMachineController.VM.shoppingCart.getList_of_Products().keySet()){
            if (p.getNum_in_cart() > 0) {
                temp.add(new ProductSold(p.getName(), p.getNum_in_cart(), p.getTotal_price_in_cart()));
            }
        }


        double customer_actual_input_amount = (double) Math.round((PayingProgressController.change+PayingProgressController.total_price_due)*100) / 100;

        current_transaction = new Transaction(VendingMachineController.TxIDCount, LocalDateTime.now(),
                temp, customer_actual_input_amount, PayingProgressController.change, PayingProgressController.total_price_due);
        VendingMachineController.transactions.add(current_transaction);
        System.out.println("customer paid : " + current_transaction.getMoney_paid());
        System.out.println("customer get change : " + current_transaction.getChange());
        VendingMachineController.TxIDCount += 1;

        //clear cart
        VendingMachineController.VM.shoppingCart.clear();
        System.out.println("cart total price after clear: " + VendingMachineController.VM.shoppingCart.Calculate_total_price());


        //open new window
        Parent root = FXMLLoader.load(ReceiptUI.class.getResource("ReceiptUI.fxml"));
        primaryStage.setTitle("Your Receipt");
        primaryStage.setScene(new Scene(root, 640, 400));
        primaryStage.show();
    }

    public static void display() throws IOException{

        Stage primaryStage = new Stage();

        //generating a new transaction record
        ArrayList<ProductSold> temp = new ArrayList<ProductSold>();
        for (Product p: VendingMachineController.VM.shoppingCart.getList_of_Products().keySet()){
            if (p.getNum_in_cart() > 0) {
                temp.add(new ProductSold(p.getName(), p.getNum_in_cart(), p.getTotal_price_in_cart()));
            }
        }


        double customer_actual_input_amount = (double) Math.round((PayingProgressController.change+PayingProgressController.total_price_due)*100) / 100;

        current_transaction = new Transaction(VendingMachineController.TxIDCount, LocalDateTime.now(),
                temp, customer_actual_input_amount, PayingProgressController.change, PayingProgressController.total_price_due);
        VendingMachineController.transactions.add(current_transaction);
        System.out.println("customer paid : " + current_transaction.getMoney_paid());
        System.out.println("customer get change : " + current_transaction.getChange());
        VendingMachineController.TxIDCount += 1;

        //clear cart
        VendingMachineController.VM.shoppingCart.clear();
        System.out.println("cart total price after clear: " + VendingMachineController.VM.shoppingCart.Calculate_total_price());


        //open new window
        Parent root = FXMLLoader.load(ReceiptUI.class.getResource("ReceiptUI.fxml"));
        primaryStage.setTitle("Your Receipt");
        primaryStage.setScene(new Scene(root, 640, 400));
        primaryStage.show();

    }

}
