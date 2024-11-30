package com.example.budgetwise.tabs;

import com.example.budgetwise.models.Account;
import com.example.budgetwise.models.AccountType;
import com.example.budgetwise.models.Currency;
import com.example.budgetwise.tables.AccountTable;
import com.example.budgetwise.tables.AccountTypeTable;
import com.example.budgetwise.tables.CategoryTable;
import com.example.budgetwise.tables.CurrencyTable;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

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
        ComboBox<AccountType> accountComboBox = new ComboBox<>();

        // ArrayList of accounts type
        //accountComboBox.getItems().addAll("Checking", "Savings");
        accountComboBox.setItems(FXCollections.observableArrayList(AccountTypeTable.getInstance().getAllAccountTypes()));
        accountComboBox.setValue(AccountTypeTable.getInstance().getAllAccountTypes().get(0));
        root.add(accountLabel, 0, 1);
        root.add(accountComboBox, 1, 1);


        //For account balance
        Label amountLabel = new Label("Balance:");
        TextField amountField = new TextField();
        amountField.setPrefWidth(120);
        root.add(amountLabel,0,2);
        root.add(amountField,1,2);

        Label currency = new Label("Currency:");
        ComboBox<Currency> currencyComboBox = new ComboBox<>();
        currencyComboBox.setItems(FXCollections.observableArrayList(CurrencyTable.getInstance().getAllCurrency()));
        currencyComboBox.setValue(CurrencyTable.getInstance().getAllCurrency().get(0));

        root.add(currency, 0,3);
        root.add(currencyComboBox,1,3);



        Button button = new Button("Add Account");
        root.add(button,1,4);

        this.setContent(root);

        button.setOnAction(event -> {
            String accountName = nameField.getText();
            AccountType accountType = accountComboBox.getValue();
            double accountBalance = Double.parseDouble(amountField.getText());
            Currency accountCurrency = currencyComboBox.getValue();

            Account newAccount = new Account(accountName,accountBalance,accountCurrency.getId(),accountType.getId());
            System.out.println(newAccount);
           // ViewAccountTab.getInstance().refreshTable();
            AccountTable.getInstance().createAccount(newAccount);
        });


    }
}
