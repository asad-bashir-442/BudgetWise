package com.example.budgetwise;

import com.example.budgetwise.database.Database;
import com.example.budgetwise.database.NewConst;
import javafx.application.Application;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class MainEntry extends Application {
    public final String FILE="info.txt";

    public void start(Stage primaryStage) throws Exception {

        File file=new File(FILE);
        if(!file.exists()){

        LoginPage loginPage=new LoginPage();
        loginPage.show();
        }else{

            try{
                BufferedReader reader = new BufferedReader(new FileReader("info.txt"));
                String line;
                int lineCount = 0;
                while ((line = reader.readLine()) != null){
                    lineCount++;
                    if (lineCount == 1){
                        NewConst.DB_NAME = line;
                    } else if (lineCount == 2) {
                        NewConst.DB_PASS = line;
                    } else if (lineCount == 3) {
                        NewConst.DB_LOCATION = line;
                    } else if (lineCount == 4) {
                        NewConst.DB_USER = line;

                    }
                }

                Database.getInstance();

                reader.close();
            } catch (IOException e){
                e.printStackTrace();

            }


            HomePage homePage=new HomePage();
            homePage.show();
        }
    }

    public static void main(String[] args) {
        launch();
    }
}
