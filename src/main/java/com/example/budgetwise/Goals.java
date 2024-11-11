package com.example.budgetwise;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
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




        Scene scene = new Scene(gridPane, 800,500);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Account Form");
        primaryStage.show();

    }

    public static void main(String[] args) {
        Application.launch();
    }
}
