package com.example.budgetwise.tabs;

import com.example.budgetwise.models.Account;
import com.example.budgetwise.models.AccountType;
import com.example.budgetwise.models.Category;
import com.example.budgetwise.models.Currency;
import com.example.budgetwise.tables.AccountTable;
import com.example.budgetwise.tables.AccountTypeTable;
import com.example.budgetwise.tables.CategoryTable;
import com.example.budgetwise.tables.CurrencyTable;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;

import java.util.ArrayList;

public class AddTransactionTab extends Tab {

    public AddTransactionTab(){

        this.setText("Add Transaction");

        //gridpane layout for the form
        GridPane root = new GridPane();
        root.setPadding(new Insets(10,10,10,10));
        root.setHgap(10);
        root.setVgap(10);
        //Creating label and text field for the ->Goal Name Input
        Label name = new Label("Transaction Name:");
        TextField nameField = new TextField();
        nameField.setPrefWidth(120);
        root.add(name,0,0);
        root.add(nameField,1,0);

        // Creating label and comboBox for account type
        Label accountLabel = new Label("Account Type:");
        ComboBox<String> accountComboBox = new ComboBox<>();

        // create arrayList of account type names
        ArrayList<String> accountTypeNames = new ArrayList<>();

        for (AccountType accountType : AccountTypeTable.getInstance().getAllAccountTypes()){
            accountTypeNames.add(accountType.getType());
        }

        accountComboBox.setItems(FXCollections.observableArrayList(accountTypeNames));
        root.add(accountLabel,0,1);
        root.add(accountComboBox,1,1);

        // Creating label and Text Field for amount
        Label amountLabel = new Label("Amount:");
        TextField amountField = new TextField();
        amountField.setPrefWidth(120);
        root.add(amountLabel,0,2);
        root.add(amountField,1,2);

        //Creating label and combobox for currency type
        Label currencyLabel = new Label("Currency:");
        ComboBox<String> currencyComboBox = new ComboBox<>();

        // create arrayList of currency type names
        ArrayList<String> currencyNames = new ArrayList<>();

        for (Currency currency : CurrencyTable.getInstance().getAllCurrency()){
            currencyNames.add(currency.getType());
        }
        currencyComboBox.setItems(FXCollections.observableArrayList(currencyNames));
        root.add(currencyLabel,0,3);
        root.add(currencyComboBox,1,3);

        //Cresting Label and textField for description
        Label descriptionLabel = new Label("Description");
        TextArea textArea = new TextArea("Write your description");
        textArea.setPrefRowCount(3);
        root.add(descriptionLabel,0,4);
        root.add(textArea,1,4);

        // create arrayList for category names

        ArrayList<String> categoryNames = new ArrayList<>();

        for (Category categoryName : CategoryTable.getInstance().getAllCategories()){
            categoryNames.add(categoryName.getName());
        }

        // for category
        Label categoryLabel = new Label("Category");
        ComboBox<String> categoryComboBox = new ComboBox<>();
        categoryComboBox.setItems(FXCollections.observableArrayList(categoryNames));
        root.add(categoryLabel,0,5);
        root.add(categoryComboBox,1,5);


        //button to add transaction
        Button button = new Button("Add Transaction");
        root.add(button,1,6);

        this.setContent(root);

    }



}
