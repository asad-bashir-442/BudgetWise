package com.example.budgetwise;

import javafx.application.Application;
import javafx.stage.Stage;

import java.io.File;

public class MainEntry extends Application {
    public final String FILE="info.txt";

    public void start(Stage primaryStage) throws Exception {
        File file=new File(FILE);
        if(!file.exists()){

        LoginPage loginPage=new LoginPage();
        loginPage.show();
        }else{
            
            HomePage homePage=new HomePage();
            homePage.show();
        }
    }

    public static void main(String[] args) {
        launch();
    }
}
