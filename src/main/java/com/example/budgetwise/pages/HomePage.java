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

/**
 * This file acts as the main homepage and where the main application is held
 */
public class HomePage extends Stage {
    public HomePage(){
        BorderPane borderPane=new BorderPane();

        /**
         * Tabs for the user to navigate to the different parts of the application
         */
        TabPane tabPane = new TabPane();
        AddTransactionTab addTransactionTab = AddTransactionTab.getInstance();
        AddAccountTab addAccountTab = new AddAccountTab();

        CategoryTab categoryTab = new CategoryTab();



        EditAccountTab editAccountTab = EditAccountTab.getInstance();
        ViewAccountsTab viewAccountsTab= ViewAccountsTab.getInstance();
        tabPane.getTabs().addAll(viewAccountsTab,addAccountTab,addTransactionTab,editAccountTab,categoryTab);

        tabPane.setTabClosingPolicy(TabPane.TabClosingPolicy.UNAVAILABLE);



        borderPane.setCenter(tabPane);
        /**
         * Set menu bar
         */
        MenuBar menuBar=new MenuBar();
        Menu fileMenu=new Menu("File");
        Menu creditsMenu=new Menu("About");
        MenuItem about=new MenuItem("Credits");
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
        super.setTitle("homepage");
        super.setScene(new Scene(borderPane,800,850));
    }
}
