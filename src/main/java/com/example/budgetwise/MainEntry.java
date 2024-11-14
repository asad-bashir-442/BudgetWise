package com.example.budgetwise;

import com.example.budgetwise.database.Const;
import com.example.budgetwise.pages.HomePage;
import com.example.budgetwise.pages.LoginPage;
import javafx.application.Application;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class MainEntry extends Application {
    public final String FILE="info.txt";

    public void start(Stage primaryStage) throws Exception {

        File file = new File(FILE);
        if(!file.exists()){

        LoginPage loginPage = new LoginPage();
        loginPage.show();
        }else{

            try{
                BufferedReader reader = new BufferedReader(new FileReader("info.txt"));
                String line;
                int lineCount = 0;
                while ((line = reader.readLine()) != null){
                    lineCount++;
                    if (lineCount == 1){
                        Const.DB_NAME = line;
                    } else if (lineCount == 2) {
                        Const.DB_PASS = line;
                    } else if (lineCount == 3) {
                        Const.DB_LOCATION = line;
                    } else if (lineCount == 4) {
                        Const.DB_USER = line;

                    }
                }

                reader.close();
                HomePage homePage=new HomePage();
                homePage.show();
            } catch (IOException e){
                e.printStackTrace();

            }



        }
    }

    public static void main(String[] args) {
        launch();
    }
}
