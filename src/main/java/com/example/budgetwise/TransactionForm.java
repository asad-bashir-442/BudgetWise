package com.example.budgetwise;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;


public class TransactionForm extends Application {
    @Override
    public void start(Stage primaryStage)  {

        //gridpane layout for the form
        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(10,10,10,10));
        gridPane.setHgap(10);
        gridPane.setVgap(10);

        //Creating label and text field for the ->Transaction Name Input
        Label name = new Label("Transaction Name:");
        TextField nameField = new TextField();
        nameField.setPrefWidth(120);
        gridPane.add(name,0,0);
        gridPane.add(nameField,1,0);

        // Creating label and comboBox for account type
        Label accountLabel = new Label("Account Type:");
        ComboBox<String> accountComboBox = new ComboBox<>();
        accountComboBox.getItems().addAll("Checking", "Savings");
        gridPane.add(accountLabel,0,1);
        gridPane.add(accountComboBox,1,1);

        // Creating label and Text Field for amount
        Label amountLabel = new Label("Amount:");
        TextField amountField = new TextField();
        amountField.setPrefWidth(120);
        gridPane.add(amountLabel,0,2);
        gridPane.add(amountField,1,2);

        //Creating label and combobox for currency type
        Label currencyLabel = new Label("Currency:");
        ComboBox<String> currencyComboBox = new ComboBox<>();
        currencyComboBox.getItems().addAll("USD", "CAD");
        gridPane.add(currencyLabel,0,3);
        gridPane.add(currencyComboBox,1,3);

        //Cresting Label and textField for description
        Label descriptionLabel = new Label("Description");
        TextArea textArea = new TextArea("Write your description");
        textArea.setPrefRowCount(3);
        gridPane.add(descriptionLabel,0,4);
        gridPane.add(textArea,1,4);

        // for category
        Label categoryLabel = new Label("Category");
        ComboBox<String> categoryComboBox = new ComboBox<>();
        categoryComboBox.getItems().addAll("Food","Transport","Utilities","Entertainment","clothing","other");
        gridPane.add(categoryLabel,0,5);
        gridPane.add(categoryComboBox,1,5);

        
        BorderPane pane = new BorderPane(gridPane);
        pane.setCenter(gridPane);



        Scene scene = new Scene(pane, 800,500);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Transaction Form");
        primaryStage.show();

    }
}
