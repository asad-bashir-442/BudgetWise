package com.example.budgetwise;

import com.example.budgetwise.models.Account;
import com.example.budgetwise.models.AccountType;
import com.example.budgetwise.models.Currency;
import com.example.budgetwise.tables.AccountTable;
import com.example.budgetwise.tables.AccountTypeTable;
import com.example.budgetwise.tables.CurrencyTable;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.ArrayList;

public class HomePage extends Stage {
    //no content just use it to show here is the home page
    public HomePage(){
        Text text=new Text("HomePage");
        BorderPane borderPane=new BorderPane();

        borderPane.setCenter(text);

        ArrayList<Account> accounts = AccountTable.getInstance().getAllAccounts();
        ArrayList<AccountType> accountTypes = AccountTypeTable.getInstance().getAllAccountTypes();
        ArrayList<Currency> currencies = CurrencyTable.getInstance().getAllCurrency();

        for (Account account : accounts){
            System.out.println(account);
        }

        for (AccountType accountType : accountTypes){
            System.out.println(accountType);
        }

        for (Currency category : currencies){
            System.out.println(category);
        }

        super.setTitle("homepage");
        super.setScene(new Scene(borderPane,500,500));
    }
}
