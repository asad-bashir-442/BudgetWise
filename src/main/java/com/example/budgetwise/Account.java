package com.example.budgetwise;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Account extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {

        // grid pane Layout for the form
        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(10,10,10,10));
        gridPane.setVgap(10);
        gridPane.setHgap(10);

        //creating label and textfield for account form
        Label nameLabel = new Label("Account Name:");
        TextField nameField = new TextField();
        nameField.setPrefWidth(150);
        gridPane.add(nameLabel,0,0);
        gridPane.add(nameField,1,0);

        //For Account type
        Label accountLabel = new Label("Account Type:");
        ComboBox<String> accountComboBox = new ComboBox<>();
        accountComboBox.getItems().addAll("Checking", "Savings");
        gridPane.add(accountLabel, 0, 1);
        gridPane.add(accountComboBox, 1, 1);





        Scene scene = new Scene(gridPane, 800,500);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Account Form");
        primaryStage.show();
    }
}
