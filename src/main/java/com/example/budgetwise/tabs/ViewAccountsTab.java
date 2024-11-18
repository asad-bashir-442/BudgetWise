package com.example.budgetwise.tabs;

import com.example.budgetwise.models.AccountType;
import com.example.budgetwise.models.Transaction;
import com.example.budgetwise.tables.AccountTypeTable;
import com.example.budgetwise.tables.TransactionTable;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;

public class ViewAccountsTab extends Tab {
    public ViewAccountsTab(){
        this.setText("View Accounts");
        GridPane root=new GridPane();
        root.setPadding(new Insets(10,10,10,10));
        root.setVgap(10);
        root.setHgap(10);
        //select an account
        Label account=new Label("Account");
        ComboBox<AccountType> accountComboBox = new ComboBox<>();
        accountComboBox.setItems(FXCollections.observableArrayList(AccountTypeTable.getInstance().getAllAccountTypes()));
        root.add(account,0,0);
        root.add(accountComboBox,1,0);

        //get chosen account id
       // int accountId= Integer.parseInt(accountComboBox.getId());  wrong way to get account id
//        AccountType chosenAccount=accountComboBox.getSelectionModel().getSelectedItem();
//
//        int accountId=chosenAccount.getId();

        //create a table to show transactions that associate with account chosen in the combbox
        Label transactions=new Label("Transactions");
        root.add(transactions,0,1);
        TransactionTable transactionTable =TransactionTable.getInstance();
        TableView tableView=new TableView<>();
        TableColumn<Transaction, String> column1=new TableColumn<>("Transaction Id");
        column1.setCellValueFactory(e->new SimpleStringProperty(String.valueOf(e.getValue().getId())));
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
        tableView.getColumns().addAll(column1,column2,column3,column4,column5,column6);
        accountComboBox.setOnAction(e->{
                    AccountType chosenAccount=accountComboBox.getSelectionModel().getSelectedItem();
                    int accountId=chosenAccount.getId();
                    tableView.getItems().addAll(transactionTable.searchTransaction(accountId));
        }
        );

        root.add(tableView,0,2,2,1);








     this.setContent(root);

    }
}
