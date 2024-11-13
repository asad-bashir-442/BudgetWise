package com.example.budgetwise;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Account extends Application {
    @Override
    public void start(Stage primaryStage)  {

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

        //For account balance
        Label amountLabel = new Label("Balance:");
        TextField amountField = new TextField();
        amountField.setPrefWidth(120);
        gridPane.add(amountLabel,0,2);
        gridPane.add(amountField,1,2);

        Label currency = new Label("Currency:");
        ComboBox<String> currencyComboBox = new ComboBox<>();
        currencyComboBox.getItems().addAll("USD","CAD");
        gridPane.add(currency, 0,3);
        gridPane.add(currencyComboBox,1,3);

        Label dateLabel = new Label("Create Date");
        TextField dateField = new TextField();
        dateField.setPrefWidth(120);
        gridPane.add(dateLabel,0,4);
        gridPane.add(dateField,1,4);

        Button button = new Button("Add Account +");
        gridPane.add(button,1,6);


        Scene scene = new Scene(gridPane, 800,500);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Account Form");
        primaryStage.show();
    }
}
