package com.example.budgetwise.tabs;

import com.example.budgetwise.models.Account;
import com.example.budgetwise.models.AccountType;
import com.example.budgetwise.models.Transaction;
import com.example.budgetwise.tables.AccountTable;
import com.example.budgetwise.tables.AccountTypeTable;
import com.example.budgetwise.tables.TransactionTable;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.chart.Chart;
import javafx.scene.chart.PieChart;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ViewAccountsTab extends Tab {
    private ComboBox<Account> accountComboBox;

    private Account chosenAccount;
    private PieChart chart;
    public ViewAccountsTab(){
        this.setText("View Accounts");
        BorderPane root=new BorderPane();
        GridPane topPanel=new GridPane();
        topPanel.setPadding(new Insets(10,10,10,10));
        topPanel.setVgap(10);
        topPanel.setHgap(10);

        //select an account
        Label account=new Label("Account");
        accountComboBox = new ComboBox<>();
        accountComboBox.setItems(FXCollections.observableArrayList(AccountTable.getInstance().getAllAccounts()));
        accountComboBox.getSelectionModel().selectFirst();
        chosenAccount = AccountTable.getInstance().getAllAccounts().get(0);
        topPanel.add(account,0,0);
        topPanel.add(accountComboBox,1,0);

        Button refresh=new Button("Refresh");
        refresh.setOnAction(event -> generateChart());
        topPanel.add(refresh,2,0);

        //get chosen account id
       // int accountId= Integer.parseInt(accountComboBox.getId());  wrong way to get account id
//        AccountType chosenAccount=accountComboBox.getSelectionModel().getSelectedItem();
//
//        int accountId=chosenAccount.getId();

        //create a table to show transactions that associate with account chosen in the combbox
        TransactionTable transactionTable =TransactionTable.getInstance();
        TableView tableView=new TableView<>();
//        TableColumn<Transaction, String> column1=new TableColumn<>("Transaction Id");
//        column1.setCellValueFactory(e->new SimpleStringProperty(String.valueOf(e.getValue().getId())));
        // Date column
        TableColumn<Transaction, String>column2 =new TableColumn<>("Date");
        column2.setCellValueFactory(e->new SimpleStringProperty(e.getValue().getDate()));
        // type column
        TableColumn<Transaction,String>column3=new TableColumn<>(" Transaction Type");
        column3.setCellValueFactory(e->new SimpleStringProperty(String.valueOf(e.getValue().getType())));
        //Amount Column
        TableColumn<Transaction,String>column4=new TableColumn<>("Amount");
        column4.setCellValueFactory(e->new SimpleStringProperty(String.valueOf(e.getValue().getAmount())));
        //currency id
        TableColumn<Transaction,String>column5=new TableColumn<>("Currency");
        column5.setCellValueFactory(e->new SimpleStringProperty(String.valueOf(e.getValue().getType())));
        //Description
        TableColumn<Transaction,String>column6=new TableColumn<>("Description");
        column6.setCellValueFactory(e->new SimpleStringProperty(e.getValue().getDescription()));
        tableView.getColumns().addAll(column2,column3,column4,column5,column6);
        tableView.getItems().addAll(transactionTable.searchTransaction(chosenAccount.getId()));
        accountComboBox.setOnAction(e->{
                    chosenAccount = accountComboBox.getSelectionModel().getSelectedItem();
                    System.out.println(chosenAccount);
//                    int accountId=chosenAccount.getId();
                    tableView.getItems().clear();
                    tableView.getItems().addAll(transactionTable.searchTransaction(chosenAccount.getId()));
        }
        );

        topPanel.add(tableView,0,2,2,1);
        chart=new PieChart();
        chart.setTitle("Transactions Breakdown");
        VBox bottomPanel=new VBox(10,chart);
        root.setTop(topPanel);
        root.setCenter(tableView);
        root.setBottom(bottomPanel);




     this.setContent(root);

    }

    public void generateChart() {

    }


}
