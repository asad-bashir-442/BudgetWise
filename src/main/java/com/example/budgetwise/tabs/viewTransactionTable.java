package com.example.budgetwise.tabs;

import com.example.budgetwise.models.Transaction;
import com.example.budgetwise.tables.TransactionTable;
import javafx.beans.property.SimpleStringProperty;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.BorderPane;

public class viewTransactionTable extends Tab {
 public TableView tableView;
 public viewTransactionTable(){
     this.setText("View Transaction Table");
     TransactionTable transactionTable =new TransactionTable();
     BorderPane root =new BorderPane();
     tableView=new TableView<>();

     //id column
     TableColumn<Transaction, String>column1=new TableColumn<>("Transaction Id");
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
     tableView.getColumns().addAll(column1,column2,column3,column4,column5);
     tableView.getItems().addAll(transactionTable.getAllTransactions());
     root.setCenter(tableView);
     this.setContent(root);
 }
}
