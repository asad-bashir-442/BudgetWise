package com.example.budgetwise.tabs;

import com.example.budgetwise.models.*;
import com.example.budgetwise.tables.*;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class AddTransactionTab extends Tab {

    private static AddTransactionTab instance;

    private ComboBox<Account> accountComboBox = new ComboBox<>();

    private AddTransactionTab(){

        this.setText("Add Transaction");

        //gridpane layout for the form
        GridPane root = new GridPane();
        root.setPadding(new Insets(10,10,10,10));
        root.setHgap(10);
        root.setVgap(10);


        // Creating label and comboBox for account type
        Label accountLabel = new Label("Account");
        accountLabel.getStyleClass().add("label-style");
        accountComboBox.getStyleClass().add("textfield-style");



        refresh();
        root.add(accountLabel,0,1);
        root.add(accountComboBox,1,1);



        // Creating label and comboBox for transaction type
        Label transactionLabel = new Label("Transaction Type:");
        transactionLabel.getStyleClass().add("label-style");
        ComboBox<TransactionType> transactionTypeComboBox = new ComboBox<>();
        transactionTypeComboBox.getStyleClass().add("textfield-style");


        transactionTypeComboBox.setItems(FXCollections.observableArrayList(TransactionTypeTable.getInstance().getAllTransactionTypes()));
        transactionTypeComboBox.setValue(TransactionTypeTable.getInstance().getAllTransactionTypes().get(0));
        root.add(transactionLabel,0,2);
        root.add(transactionTypeComboBox,1,2);

        // Creating label and Text Field for amount
        Label amountLabel = new Label("Amount:");
        amountLabel.getStyleClass().add("label-style");
        TextField amountField = new TextField();
        amountField.getStyleClass().add("textfield-style");
        //amountField.setPrefWidth(50);
        root.add(amountLabel,0,3);
        root.add(amountField,1,3);


        //Cresting Label and textField for description
        Label descriptionLabel = new Label("Description");
        descriptionLabel.getStyleClass().add("label-style");
        TextArea textArea = new TextArea();
        textArea.getStyleClass().add("textarea-style");
//        textArea.setPrefRowCount(3);
        root.add(descriptionLabel,0,4);
        root.add(textArea,1,4);

        // for category
        Label categoryLabel = new Label("Category");
        categoryLabel.getStyleClass().add("label-style");
        ComboBox<Category> categoryComboBox = new ComboBox<>();
        categoryComboBox.getStyleClass().add("textfield-style");
        categoryComboBox.setItems(FXCollections.observableArrayList(CategoryTable.getInstance().getAllCategories()));
        categoryComboBox.setValue(CategoryTable.getInstance().getAllCategories().get(0));
        root.add(categoryLabel,0,5);
        root.add(categoryComboBox,1,5);

        Label dateLabel = new Label("Create Date");
        dateLabel.getStyleClass().add("label-style");
        DatePicker datePicker = new DatePicker();
        datePicker.getStyleClass().add("textfield-style");
        root.add(dateLabel,0,6);
        root.add(datePicker,1,6);


        //button to add transaction
        Button addTransactionBtn = new Button("Add Transaction");
        addTransactionBtn.getStyleClass().add("button-style");
        root.add(addTransactionBtn,1,7);

        Text error = new Text("Please fill all fields");
        error.setFill(Color.rgb(255,0,0,0));
        root.add(error,2,7);

        Text success = new Text("Transaction successfully created");
        success.setFill(Color.rgb(0,255,0,0));

        String css = getClass().getResource("/styles.css").toExternalForm();
        root.getStylesheets().add(css);

        root.add(success,2,7);



        this.setOnSelectionChanged(event -> {
            error.setFill(Color.rgb(255,0,0,0));

            success.setFill(Color.rgb(0,255,0,0));

        });

        addTransactionBtn.setOnAction(event -> {
            Account account = accountComboBox.getValue();
            TransactionType transactionType = transactionTypeComboBox.getValue();

            String description = textArea.getText();
            Category category = categoryComboBox.getValue();

            LocalDate date = datePicker.getValue();



            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");




            if(amountField.getText().length() >=1 && textArea.getText().length() >=1 && date != null && isNumeric(amountField.getText()) && account != null){
                double amount = Double.parseDouble(amountField.getText());
                String formattedDate = date.format(formatter);
                Transaction newTransaction = new Transaction(formattedDate, transactionType.getId(), amount,description,category.getId(),account.getId());
                TransactionTable.getInstance().createTransaction(newTransaction);

                error.setFill(Color.rgb(255,0,0,0));
                success.setFill(Color.rgb(0,255,0,1));

                ViewAccountsTab.getInstance().refresh();

            }else {
                success.setFill(Color.rgb(0,255,0,0));
                error.setFill(Color.rgb(255,0,0,1));
            }

        });

        this.setContent(root);

    }

    public static AddTransactionTab getInstance(){
        if (instance == null){
            instance = new AddTransactionTab();
        }
        return instance;

    }

    public void refresh(){
        accountComboBox.setItems(FXCollections.observableArrayList(AccountTable.getInstance().getAllAccounts()));
        if (AccountTable.getInstance().getAllAccounts().size() >=1){
            accountComboBox.getSelectionModel().selectFirst();
        }else{
            accountComboBox.setPlaceholder(new Text("Please create an account"));
        }
    }


    private boolean isNumeric(String str){
        try{
            Double.parseDouble(str);
            return true;
        }catch (NumberFormatException e){
            return false;
        }


    }




}