package UI;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import src.Product;

import java.io.IOException;

public class StaffModeUI extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {

        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        VBox layout = new VBox(20);

        Button fillButton = new Button("Fill");
        fillButton.setAlignment(Pos.TOP_CENTER);
        fillButton.setOnAction(e -> fillAllProducts());

        Button printButton = new Button("Transactions");
        printButton.setAlignment(Pos.CENTER);
        printButton.setOnAction(e -> {
            try {
                TransactionUI.display();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });

        Button userButton = new Button("User Mood");
        userButton.setAlignment(Pos.BOTTOM_CENTER);
        userButton.setOnAction(e -> window.close());

        layout.getChildren().addAll(fillButton, printButton, userButton);
        layout.setAlignment(Pos.CENTER);

        window.setTitle("Staff Mode");
        window.setScene(new Scene(layout, 300, 200));
        window.show();
    }

    public static void display() {

        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        VBox layout = new VBox(20);

        Button fillButton = new Button("Fill");
        fillButton.setAlignment(Pos.TOP_CENTER);
        fillButton.setOnAction(e -> fillAllProducts());

        Button printButton = new Button("Print");
        printButton.setAlignment(Pos.CENTER);
        printButton.setOnAction(e -> {
            try {
                TransactionUI.display();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });

        Button userButton = new Button("User Mood");
        userButton.setAlignment(Pos.BOTTOM_CENTER);
        userButton.setOnAction(e -> window.close());

        layout.getChildren().addAll(fillButton, printButton, userButton);
        layout.setAlignment(Pos.CENTER);

        window.setTitle("Staff Mode");
        window.setScene(new Scene(layout, 300, 200));
        window.show();
    }

    public static void fillAllProducts(){
        for (Product p : VendingMachineController.VM.Products.values()) {
            p.fill();
            System.out.println(p.getName() + "has been filled");
        }
    }



}
