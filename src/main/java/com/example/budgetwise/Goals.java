package com.example.budgetwise;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
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


        Scene scene = new Scene(gridPane, 800,500);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Account Form");
        primaryStage.show();

    }
}
