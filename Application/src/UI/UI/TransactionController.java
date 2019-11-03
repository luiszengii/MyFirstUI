package UI;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import src.Product;
import src.ShoppingCart;
import src.Transaction;
import src.VendingMachine;

import java.net.URL;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.ResourceBundle;

public class TransactionController implements Initializable {

    //configure Drop Down menu
    @FXML ChoiceBox<Integer> idBox;

    //Text fields
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

        //adding ids in idBox
        for(Transaction t : VendingMachineController.transactions){
            idBox.getItems().add(t.getId());
        }


        //putting data in table
        idBox.getSelectionModel().selectedItemProperty().addListener( (v, oldValue, newValue) -> {

            itemTable.getItems().clear();

            for(Transaction T : VendingMachineController.transactions) {
                if(T.getId()==newValue){

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

        });



    }

}
