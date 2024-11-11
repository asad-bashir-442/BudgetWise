package com.example.budgetwise;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Goals extends Application {
    @Override
    public void start(Stage primaryStage)  {
        // grid pane Layout for the form
        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(10,10,10,10));
        gridPane.setVgap(10);
        gridPane.setHgap(10);

        //creating input for Goal Name
        Label nameLabel = new Label("Goal Name:");
        TextField nameField = new TextField();
        nameField.setPrefWidth(120);
        gridPane.add(nameLabel,0,0);
        gridPane.add(nameField,1,0);

        //target amount
        Label targetAmount = new Label("Target Amount:");
        TextField amountField = new TextField();
        amountField.setPrefWidth(120);
        gridPane.add(targetAmount,0,1);
        gridPane.add(amountField,1,1);

        Label currentAmount = new Label("Current Amount:");
        TextField currentAmountField = new TextField();
        currentAmountField.setPrefWidth(120);
        gridPane.add(currentAmount,0,2);
        gridPane.add(currentAmountField,1,2);

        Label dateLabel = new Label("Due Date:");
        TextField dateField = new TextField();
        dateField.setPrefWidth(120);  // Set smaller width for amount
        gridPane.add(dateLabel, 0, 3);
        gridPane.add(dateField, 1, 3);

        Label status = new Label("Status");
        TextField statusField = new TextField();
        statusField.setPrefWidth(120);
        gridPane.add(status, 0,4);
        gridPane.add(statusField,1,4);

        Button button = new Button("Add new Goal");
        gridPane.add(button,1,5);

        

        Scene scene = new Scene(gridPane, 800,500);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Account Form");
        primaryStage.show();

    }

    public static void main(String[] args) {
        Application.launch();
    }
}
