package com.example.budgetwise;

import com.example.budgetwise.tabs.AccountsTab;
import com.example.budgetwise.tabs.GoalsTab;
import com.example.budgetwise.tabs.TransactionsTab;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TabPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.Stack;

public class HomePage extends Stage {
    //no content just use it to show here is the home page
    public HomePage(){

        BorderPane borderPane=new BorderPane();
        //add tab in the homepage
        TabPane tabPane=new TabPane();
        AccountsTab accountsTab=new AccountsTab();
        GoalsTab goalsTab=new GoalsTab();
        TransactionsTab transactionsTab=new TransactionsTab();
        tabPane.getTabs().addAll(accountsTab,goalsTab,transactionsTab);
        tabPane.setTabClosingPolicy(TabPane.TabClosingPolicy.UNAVAILABLE);
        // set default tab is account
        tabPane.getSelectionModel().select(accountsTab);

        //set menu bar
        MenuBar menuBar=new MenuBar();
        Menu fileMenu =new Menu("File");
        Menu creditsMenu=new Menu("Credits");
        MenuItem exit=new MenuItem("Exit");
        exit.setOnAction(e->System.exit(0));
        fileMenu.getItems().add(exit);
        menuBar.getMenus().addAll(fileMenu,creditsMenu);

        borderPane.setTop(menuBar);
        borderPane.setCenter(tabPane);

        super.setTitle("homepage");
        super.setScene(new Scene(borderPane,500,500));
    }
}
