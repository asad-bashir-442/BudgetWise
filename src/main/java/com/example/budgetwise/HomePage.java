package com.example.budgetwise;

import com.example.budgetwise.models.*;
import com.example.budgetwise.tables.*;
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
        ArrayList<TransactionType> transactionTypes = TransactionTypeTable.getInstance().getAllTransactionTypes();
        ArrayList<Transaction> transactions = TransactionTable.getInstance().getAllTransactions();
        ArrayList<Category> categories = CategoryTable.getInstance().getAllCategories();

        for (Account account : accounts){
            System.out.println(account);
        }

        for (AccountType accountType : accountTypes){
            System.out.println(accountType);
        }

        for (Currency category : currencies){
            System.out.println(category);
        }

        for (TransactionType transactionType : transactionTypes){
            System.out.println(transactionType);
        }

        for (Transaction transaction : transactions){
            System.out.println(transaction);
        }

        for (Category category : categories){
            System.out.println(category);
        }

        super.setTitle("homepage");
        super.setScene(new Scene(borderPane,500,500));
    }
}
