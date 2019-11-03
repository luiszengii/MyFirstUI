package UI;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import src.Transaction;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class ReceiptController implements Initializable {



    //Text fields
    @FXML TextField TxID;
    @FXML TextField time;
    @FXML TextField total_money;
    @FXML TextField money_paid;
    @FXML TextField change;

    //table
    @FXML TableView<ProductSold> itemTable;
    @FXML TableColumn<ProductSold, String> product_name;
    @FXML TableColumn<ProductSold, Integer> amount;
    @FXML TableColumn<ProductSold, Double> total_money_column;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        itemTable.getItems().clear();

        TxID.setText(String.valueOf(VendingMachineController.TxIDCount - 1));

        Transaction T = VendingMachineController.transactions.get(VendingMachineController.transactions.size() - 1);

        //get product sold
        ArrayList<ProductSold> ls_p = T.getItem_sold();

        // set text fields
        time.setText(T.getDate_time().toString());
        total_money.setText(String.valueOf(T.getTotal_price()));
        money_paid.setText(String.valueOf(T.getMoney_paid()));
        change.setText(String.valueOf(T.getChange()));

        //set columns
        product_name.setCellValueFactory(new PropertyValueFactory<>("name"));
        amount.setCellValueFactory(new PropertyValueFactory<>("num_sold"));
        total_money_column.setCellValueFactory(new PropertyValueFactory<>("total_price"));
        for (ProductSold p : ls_p) {
            itemTable.getItems().add(p);
        }



    }
}
