package com.example.budgetwise.tabs;

import com.example.budgetwise.models.*;
import com.example.budgetwise.tables.*;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class AddTransactionTab extends Tab {

    public AddTransactionTab(){

        this.setText("Add Transaction");

        //gridpane layout for the form
        GridPane root = new GridPane();
        root.setPadding(new Insets(10,10,10,10));
        root.setHgap(10);
        root.setVgap(10);
        root.getStyleClass().add("tab-background");


        // Creating label and comboBox for account type
        Label accountLabel = new Label("Account");
        accountLabel.getStyleClass().add("label-style");

        ComboBox<Account> accountComboBox = new ComboBox<>();
        accountComboBox.getStyleClass().add("textfield-style");


        accountComboBox.setItems(FXCollections.observableArrayList(AccountTable.getInstance().getAllAccounts()));
        root.add(accountLabel,0,1);
        root.add(accountComboBox,1,1);



        // Creating label and comboBox for transaction type
        Label transactionLabel = new Label("Transaction Type:");
        transactionLabel.getStyleClass().add("label-style");

        ComboBox<TransactionType> transactionTypeComboBox = new ComboBox<>();
        transactionTypeComboBox.getStyleClass().add("textfield-style");



        transactionTypeComboBox.setItems(FXCollections.observableArrayList(TransactionTypeTable.getInstance().getAllTransactionTypes()));
        root.add(transactionLabel,0,2);
        root.add(transactionTypeComboBox,1,2);

        // Creating label and Text Field for amount
        Label amountLabel = new Label("Amount:");
        amountLabel.getStyleClass().add("label-style");

        TextField amountField = new TextField();
        amountField.getStyleClass().add("textfield-style");

        amountField.setPrefWidth(120);
        root.add(amountLabel,0,3);
        root.add(amountField,1,3);


        //Cresting Label and textField for description
        Label descriptionLabel = new Label("Description");
        descriptionLabel.getStyleClass().add("label-style");


        TextArea textArea = new TextArea();
        textArea.getStyleClass().add("textarea-style");
        textArea.setPrefRowCount(3);
        root.add(descriptionLabel,0,4);
        root.add(textArea,1,4);

        // for category
        Label categoryLabel = new Label("Category");
        categoryLabel.getStyleClass().add("label-style");

        ComboBox<Category> categoryComboBox = new ComboBox<>();
        categoryComboBox.getStyleClass().add("textfield-style");

        categoryComboBox.setItems(FXCollections.observableArrayList(CategoryTable.getInstance().getAllCategories()));
        root.add(categoryLabel,0,5);
        root.add(categoryComboBox,1,5);

        Label dateLabel = new Label("Create Date");
        dateLabel.getStyleClass().add("label-style");

        DatePicker datePicker = new DatePicker();
        datePicker.getStyleClass().add("textfield-style");

        root.add(dateLabel,0,6);
        root.add(datePicker,1,6);


        //button to add transaction
        Button button = new Button("Add Transaction");
        button.getStyleClass().add("button-style");

        root.add(button,1,7);

        String css = getClass().getResource("/styles.css").toExternalForm();
        root.getStylesheets().add(css);

        button.setOnAction(event -> {
            Account account = accountComboBox.getValue();
            TransactionType transactionType = transactionTypeComboBox.getValue();
            double amount = Double.parseDouble(amountField.getText());
            String description = textArea.getText();
            Category category = categoryComboBox.getValue();

            LocalDate date = datePicker.getValue();

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            String formattedDate = date.format(formatter);

            Transaction newTransaction = new Transaction(formattedDate, transactionType.getId(), amount,description,category.getId(),account.getId());
            System.out.println(newTransaction);
            TransactionTable.getInstance().createTransaction(newTransaction);

        });

        this.setContent(root);

    }



}
