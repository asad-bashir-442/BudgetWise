package com.example.budgetwise.tabs;

import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;

public class AddAccountTab extends Tab {

    public AddAccountTab(){
        this.setText("Add Account");

        GridPane root = new GridPane();

        root.setPadding(new Insets(10,10,10,10));
        root.setVgap(10);
        root.setHgap(10);


        //creating label and textfield for account form
        Label nameLabel = new Label("Account Name:");
        TextField nameField = new TextField();
        nameField.setPrefWidth(150);
        root.add(nameLabel,0,0);
        root.add(nameField,1,0);

        //For Account type
        Label accountLabel = new Label("Account Type:");
        ComboBox<String> accountComboBox = new ComboBox<>();
        accountComboBox.getItems().addAll("Checking", "Savings");
        root.add(accountLabel, 0, 1);
        root.add(accountComboBox, 1, 1);


        //For account balance
        Label amountLabel = new Label("Balance:");
        TextField amountField = new TextField();
        amountField.setPrefWidth(120);
        root.add(amountLabel,0,2);
        root.add(amountField,1,2);

        Label currency = new Label("Currency:");
        ComboBox<String> currencyComboBox = new ComboBox<>();
        currencyComboBox.getItems().addAll("USD","CAD");
        root.add(currency, 0,3);
        root.add(currencyComboBox,1,3);

        Label dateLabel = new Label("Create Date");
        TextField dateField = new TextField();
        dateField.setPrefWidth(120);
        root.add(dateLabel,0,4);
        root.add(dateField,1,4);

        Button button = new Button("Add Account");
        root.add(button,1,6);

        this.setContent(root);

    }
}
