package com.example.budgetwise;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
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

        // Creating label and text field for account type
        Label accountLabel = new Label("Account Type");
        ComboBox<String> accountComboBox = new ComboBox<>();
        accountComboBox.getItems().addAll("Checking", "Savings");
        gridPane.add(accountLabel,0,1);
        gridPane.add(accountComboBox,1,1);

        BorderPane pane = new BorderPane(gridPane);
        pane.setCenter(gridPane);



        Scene scene = new Scene(pane, 800,500);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Transaction Form");
        primaryStage.show();

    }
}
