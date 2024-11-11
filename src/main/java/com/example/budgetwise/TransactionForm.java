package com.example.budgetwise;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class TransactionForm extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {

        //gridpane layout for the form
        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(10,10,10,10));
        gridPane.setHgap(10);
        gridPane.setVgap(10);


        Scene scene = new Scene(gridPane, 800,500);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Transaction Form");
        primaryStage.show();

    }
}
