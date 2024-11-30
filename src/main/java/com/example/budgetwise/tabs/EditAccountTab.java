package com.example.budgetwise.tabs;

import com.example.budgetwise.models.Account;
import com.example.budgetwise.models.AccountType;
import com.example.budgetwise.models.Currency;
import com.example.budgetwise.models.TransactionType;
import com.example.budgetwise.tables.*;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;

public class EditAccountTab extends Tab {

    public EditAccountTab(){
        this.setText("Edit Account");

        GridPane root = new GridPane();

        root.setPadding(new Insets(10,10,10,10));
        root.setVgap(10);
        root.setHgap(10);


        Label accountLabel = new Label("Account");
        ComboBox<Account> accountComboBox = new ComboBox<>();

        accountComboBox.setItems(FXCollections.observableArrayList(AccountTable.getInstance().getAllAccounts()));
        accountComboBox.setValue(AccountTable.getInstance().getAllAccounts().get(0));
        root.add(accountLabel,0,1);
        root.add(accountComboBox,1,1);

        //creating label and textfield for account form
        Label nameLabel = new Label("New Account Name:");
        TextField nameField = new TextField();
        nameField.setPrefWidth(150);
        root.add(nameLabel,0,2);
        root.add(nameField,1,2);

        Label transactionTypeLabel = new Label("Account Type:");
        ComboBox<AccountType> accountTypeComboBox = new ComboBox<>();
        accountTypeComboBox.setValue(AccountTypeTable.getInstance().getAllAccountTypes().get(0));


        accountTypeComboBox.setItems(FXCollections.observableArrayList(AccountTypeTable.getInstance().getAllAccountTypes()));
        root.add(transactionTypeLabel,0,3);
        root.add(accountTypeComboBox,1,3);

        Label currency = new Label("New Currency:");
        ComboBox<Currency> currencyComboBox = new ComboBox<>();
        currencyComboBox.setItems(FXCollections.observableArrayList(CurrencyTable.getInstance().getAllCurrency()));
        currencyComboBox.setValue(CurrencyTable.getInstance().getAllCurrency().get(0));

        root.add(currency, 0,4);
        root.add(currencyComboBox,1,4);

        Button editBtn = new Button("Edit Account");
        root.add(editBtn,1,5);

        Button deleteBtn  = new Button("Delete Account");
        root.add(deleteBtn,2,5);


        this.setContent(root);


        deleteBtn.setOnAction(event -> {
            Account selectedAccount = accountComboBox.getValue();

            AccountTable.getInstance().deleteAccount(selectedAccount);

        });

        editBtn.setOnAction(event -> {
            Account selectedAccount = accountComboBox.getValue();
            Currency selectedCurrency = currencyComboBox.getValue();
            AccountType selectedAccountType = accountTypeComboBox.getValue();
            String selectedName = nameField.getText();

            System.out.println(selectedAccount);
            selectedAccount.setName(selectedName);
            selectedAccount.setCurrency_id(selectedCurrency.getId());
            selectedAccount.setType_id(selectedAccountType.getId());




            System.out.println(selectedAccount);

            AccountTable.getInstance().updateAccount(selectedAccount);
        });


    }
}
