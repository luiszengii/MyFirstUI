package UI;

import javafx.beans.binding.Bindings;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import src.Application;
import src.Product;
import src.Transaction;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.ResourceBundle;

public class PayingProgressController implements Initializable {

    @FXML TextField money_due_amount;
    @FXML Button c10;
    @FXML Button c20;
    @FXML Button c50;
    @FXML Button $1;
    @FXML Button $2;
    @FXML Button $5;
    @FXML Button $10;
    @FXML Button $20;

    public static Double total_price_due = VendingMachineController.VM.shoppingCart.Calculate_total_price();
    public static SimpleDoubleProperty money_due_amount_double = new SimpleDoubleProperty();
    public static double input_amount = 0.00;
    public static double change = 0.00;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        //resetting the variables
        total_price_due = VendingMachineController.VM.shoppingCart.Calculate_total_price();
        money_due_amount_double = new SimpleDoubleProperty();
        input_amount = 0.00;
        change = 0.00;

        c10.setOnAction(e -> Subtract(0.1));
        c20.setOnAction(e -> Subtract(0.2));
        c50.setOnAction(e -> Subtract(0.5));
        $1.setOnAction(e -> Subtract(1.0));
        $2.setOnAction(e -> Subtract(2.0));
        $5.setOnAction(e -> Subtract(5.0));
        $10.setOnAction(e -> Subtract(10.0));
        $20.setOnAction(e -> Subtract(20.0));

        //checking cart
        System.out.println("total price due: " + total_price_due);
        money_due_amount_double.setValue(total_price_due);
        System.out.println("remain price due: " + money_due_amount_double.get());

        money_due_amount.textProperty().bind(money_due_amount_double.asString());
        money_due_amount.textProperty().addListener( (v, oldValue, newValue) -> {

            System.out.println("the new Value is: " + newValue);

            if (newValue.equals("0.0")) {
                System.out.println("add transaction and clear cart then print receipt");
                try {
                    ReceiptUI.display();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });


    }

    public static void Subtract(Double d) {

        money_due_amount_double.set((double) Math.round((money_due_amount_double.get() - d)*100) / 100);
        input_amount = (double) Math.round((input_amount + d)*100) / 100;
        System.out.println("the customer has put in: " + input_amount);

        if (money_due_amount_double.get() <= 0.0) {
            change = Math.abs(money_due_amount_double.get());
            System.out.println("the change for this tx is: " + change);
            money_due_amount_double.setValue(0.0);
        }

        System.out.println("remain price due: " + money_due_amount_double);
    }


}
