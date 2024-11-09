package com.example.budgetwise;

import com.example.budgetwise.database.Database;
import com.example.budgetwise.database.NewConst;
import com.example.budgetwise.models.Account;
import com.example.budgetwise.tables.AccountTable;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Stack;

public class HomePage extends Stage {
    //no content just use it to show here is the home page
    public HomePage(){
        Text text=new Text("HomePage");
        BorderPane borderPane=new BorderPane();

        Database.getInstance();
        borderPane.setCenter(text);

        ArrayList<Account> accounts = new AccountTable().getAllAccounts();

        for (Account account : accounts){
            System.out.println(account);
        }

        super.setTitle("homepage");
        super.setScene(new Scene(borderPane,500,500));
    }
}
