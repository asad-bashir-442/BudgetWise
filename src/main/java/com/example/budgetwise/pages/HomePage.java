package com.example.budgetwise.pages;

import com.example.budgetwise.Credits;
import com.example.budgetwise.models.*;
import com.example.budgetwise.tables.*;
import com.example.budgetwise.tabs.*;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TabPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.util.ArrayList;

public class HomePage extends Stage {
    //no content just use it to show here is the home page
    public HomePage(){
        BorderPane borderPane=new BorderPane();

        TabPane tabPane = new TabPane();

        AddTransactionTab addTransactionTab = new AddTransactionTab();
        AddAccountTab addAccountTab = new AddAccountTab();
        //ViewTransactionTab addTranscationTable = new ViewTransactionTab();

        // ViewAccountTab viewAccountTable=new ViewAccountTab();
        EditAccountTab editAccountTab = new EditAccountTab();
        // ViewAccountTab addAccountTable=new ViewAccountTab();
        CategoryTab categoryTab = new CategoryTab();
        ViewAccountsTab viewAccountsTab= ViewAccountsTab.getInstance();
        tabPane.getTabs().addAll(viewAccountsTab,addAccountTab,addTransactionTab,categoryTab, editAccountTab);


        tabPane.setTabClosingPolicy(TabPane.TabClosingPolicy.UNAVAILABLE);

        String css = getClass().getResource("/styles.css").toExternalForm();
        tabPane.getStylesheets().add(css);

        borderPane.setCenter(tabPane);
        //set menu bar
        MenuBar menuBar=new MenuBar();
        Menu fileMenu=new Menu("File");
        fileMenu.getStyleClass().add("label-style");
        Menu creditsMenu=new Menu("About");
        MenuItem about=new MenuItem("Credits");
        about.getStyleClass().add("credits");
        MenuItem exit=new MenuItem("Exit");
        exit.setOnAction(e->System.exit(0));
        fileMenu.getItems().add(exit);
        creditsMenu.getItems().add(about);
        menuBar.getMenus().addAll(fileMenu,creditsMenu);
        about.setOnAction(e->{
            Credits credit=new Credits();
            credit.show();
        });
        borderPane.setTop(menuBar);

        String css1 = getClass().getResource("/styles.css").toExternalForm();

        //scene with css
        Scene scene = new Scene(borderPane, 800, 850);
        scene.getStylesheets().add(css1);
        super.setTitle("homepage");
        super.setScene(scene);



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



    }
}