package com.example.budgetwise.tabs;

import com.example.budgetwise.models.Account;
import com.example.budgetwise.models.AccountType;
import com.example.budgetwise.models.Currency;
import com.example.budgetwise.tables.AccountTable;
import com.example.budgetwise.tables.AccountTypeTable;
import com.example.budgetwise.tables.CurrencyTable;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

/**
 * This class allows the user to add an account
 */
public class AddAccountTab extends Tab {

    public AddAccountTab(){
        this.setText("Add Account");

        GridPane root = new GridPane();

        root.setPadding(new Insets(10,10,10,10));
        root.setVgap(10);
        root.setHgap(10);
        root.getStyleClass().add("tab-background");


        /**
         * creating label and textfield for account form
         */
        Label nameLabel = new Label("Account Name:");
        nameLabel.getStyleClass().add("label-style");
        TextField nameField = new TextField();
        nameField.getStyleClass().add("textfield-style");

        nameField.setPrefWidth(150);
        root.add(nameLabel,0,0);
        root.add(nameField,1,0);

        /**
         * For Account type
         */
        Label accountLabel = new Label("Account Type:");
        accountLabel.getStyleClass().add("label-style");

        nameLabel.getStyleClass().add("label-style");

        ComboBox<AccountType> accountComboBox = new ComboBox<>();
        accountComboBox.getStyleClass().add("textfield-style");

        /**
         * ArrayList of accounts type
         */
        accountComboBox.setItems(FXCollections.observableArrayList(AccountTypeTable.getInstance().getAllAccountTypes()));
        accountComboBox.setValue(AccountTypeTable.getInstance().getAllAccountTypes().get(0));

        root.add(accountLabel, 0, 1);
        root.add(accountComboBox, 1, 1);


        /**
         * For account balance
         */
        Label amountLabel = new Label("Balance:");
        amountLabel.getStyleClass().add("label-style");

        TextField amountField = new TextField();
        amountField.getStyleClass().add("textfield-style");

        amountField.setPrefWidth(120);
        root.add(amountLabel,0,2);
        root.add(amountField,1,2);

        Label currency = new Label("Currency:");
        currency.getStyleClass().add("label-style");

        ComboBox<Currency> currencyComboBox = new ComboBox<>();
        currencyComboBox.getStyleClass().add("textfield-style");
        currencyComboBox.setItems(FXCollections.observableArrayList(CurrencyTable.getInstance().getAllCurrency()));
        currencyComboBox.setValue(CurrencyTable.getInstance().getAllCurrency().get(0));

        root.add(currency, 0,3);
        root.add(currencyComboBox,1,3);

        /**
         * Error and success are for form validation
         */

        Text error = new Text("Please fill all fields");
        error.setFill(Color.rgb(255,0,0,0));
        root.add(error,2,3);


        Text success = new Text("Account successfully created");
        success.setFill(Color.rgb(0,255,0,0));

        root.add(success,2,3);



        Button addAccountBtn = new Button("Add Account");
        addAccountBtn.getStyleClass().add("button-style");

        root.add(addAccountBtn,1,4);

        this.setOnSelectionChanged(event -> {
            error.setFill(Color.rgb(255,0,0,0));

            success.setFill(Color.rgb(0,255,0,0));

        });

        this.setContent(root);

        String css = getClass().getResource("/styles.css").toExternalForm();
        root.getStylesheets().add(css);

        addAccountBtn.setOnAction(event -> {
            String accountName = nameField.getText();
            AccountType accountType = accountComboBox.getValue();

            Currency accountCurrency = currencyComboBox.getValue();


            if(accountName.length() >=1 && amountField.getText().length()>=1 ){
                double accountBalance = Double.parseDouble(amountField.getText());
                Account newAccount = new Account(accountName,accountBalance,accountCurrency.getId(),accountType.getId());
                AccountTable.getInstance().createAccount(newAccount);
                error.setFill(Color.rgb(255,0,0,0));
                success.setFill(Color.rgb(0,255,0,1));

                ViewAccountsTab.getInstance().refresh();
                AddTransactionTab.getInstance().refresh();
                EditAccountTab.getInstance().refresh();
            }else{
                error.setFill(Color.rgb(255,0,0,1));
                success.setFill(Color.rgb(0,255,0,0));
            }




        });


    }
}
