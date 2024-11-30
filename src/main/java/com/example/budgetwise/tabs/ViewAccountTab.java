package com.example.budgetwise.tabs;

import com.example.budgetwise.database.Database;
import com.example.budgetwise.models.Account;
import com.example.budgetwise.tables.AccountTable;
import javafx.beans.property.SimpleStringProperty;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.BorderPane;

import java.util.ArrayList;

public class ViewAccountTab extends Tab {
    public TableView tableView;

    private ArrayList<Account> accounts;

    public ViewAccountTab(){
        this.setText("View Account Table");
        accounts = AccountTable.getInstance().getAllAccounts();
        BorderPane root=new BorderPane();
        tableView=new TableView<>();
        //Account Id column
        TableColumn<Account,String>column1=new TableColumn<>("Account ID");
        column1.setCellValueFactory(e->new SimpleStringProperty(String.valueOf(e.getValue().getId())));
        //Account Name column
        TableColumn<Account,String>column2=new TableColumn<>("Account Name");
        column2.setCellValueFactory(e->new SimpleStringProperty(e.getValue().getName()));
        //Account type id
        TableColumn<Account,String>column3=new TableColumn<>("Account Type Id");
        column3.setCellValueFactory(e->new SimpleStringProperty(String.valueOf(e.getValue().getId())));
        //Account Balance
        TableColumn<Account,String>column4=new TableColumn<>("Balance");
        column4.setCellValueFactory(e->new SimpleStringProperty(String.valueOf(e.getValue().getBalance())));
        //Currency id
        TableColumn<Account,String>column5=new TableColumn<>("Currency");
        column5.setCellValueFactory(e->new SimpleStringProperty(String.valueOf(e.getValue().getId())));
        tableView.getColumns().addAll(column1,column2,column3,column4,column5);
        tableView.getItems().addAll(accounts);
        root.setCenter(tableView);
        this.setContent(root);
    }

}
