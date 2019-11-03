package UI;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class PayingProcessUI extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        Parent root = FXMLLoader.load(TransactionUI.class.getResource("PayingProcessUI.fxml"));
        primaryStage.setTitle("Paying Process");
        primaryStage.setScene(new Scene(root, 640, 400));
        primaryStage.show();
    }

    public static void display() throws IOException {
        Parent root = FXMLLoader.load(TransactionUI.class.getResource("PayingProcessUI.fxml"));
        Stage window = new Stage();
        window.setTitle("Paying Process");
        window.setScene(new Scene(root, 640, 400));
        window.show();
    }

}
