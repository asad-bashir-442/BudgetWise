package com.example.budgetwise;

import javafx.application.Application;
import javafx.stage.Stage;

public class MainEntry extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        LoginPage loginPage=new LoginPage();
        loginPage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
