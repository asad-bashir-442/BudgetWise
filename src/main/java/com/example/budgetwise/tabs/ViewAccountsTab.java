package com.example.budgetwise.tabs;

import com.example.budgetwise.models.Account;
import com.example.budgetwise.models.Category;
import com.example.budgetwise.models.Transaction;
import com.example.budgetwise.tables.AccountTable;

import com.example.budgetwise.tables.CategoryTable;
import com.example.budgetwise.tables.TransactionTable;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;

import javafx.scene.chart.PieChart;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

import java.util.ArrayList;


/**
 * This class allows the user to view all their accounts and transactions
 */

/**
 * @author :Lujia, Asad
 * a tab for user to check and managing accounts
 * <p>it contains:</p>
 * <ul>
 *     <li>a table for displaying transactions</li>
 *     <li>a combobox for selecting account</li>
 *     <li>a pie chart for viewing transaction breakdown details</li>
 * </ul>
 */


public class ViewAccountsTab extends Tab {
    private ComboBox<Account> accountComboBox;
    private PieChart chart = new PieChart();;
    public TableView tableView = new TableView<>();

    private static ViewAccountsTab instance;

    private Account chosenAccount;

    private ViewAccountsTab(){
        this.setText("Accounts");
        BorderPane root=new BorderPane();
        GridPane topPanel=new GridPane();
        topPanel.setPadding(new Insets(10,10,10,10));
        topPanel.setVgap(10);
        topPanel.setHgap(10);

        /**
         * select an account
         */
        Label account=new Label("Account");
        accountComboBox = new ComboBox<>();
        accountComboBox.getStyleClass().add("textfield-style");
        accountComboBox.setItems(FXCollections.observableArrayList(AccountTable.getInstance().getAllAccounts()));

        TransactionTable transactionTable =TransactionTable.getInstance();
        if (AccountTable.getInstance().getAllAccounts().size() >= 1){
            chosenAccount = AccountTable.getInstance().getAllAccounts().get(0);
            accountComboBox.getSelectionModel().selectFirst();
            tableView.getItems().addAll(transactionTable.searchTransaction(chosenAccount.getId()));
            generateChart();
        }else{
            accountComboBox.setPlaceholder(new Text("Please create an account"));
        }



        topPanel.add(account,0,0);
        topPanel.add(accountComboBox,1,0);

        /**
         * Date column
         */
        TableColumn<Transaction, String>column2 =new TableColumn<>("Date");
        column2.setCellValueFactory(e->new SimpleStringProperty(e.getValue().getDate().substring(0,10)));
        /**
         * type column
         */
        TableColumn<Transaction,String>column3=new TableColumn<>(" Transaction Type");
        column3.setCellValueFactory(e->new SimpleStringProperty(String.valueOf(e.getValue().getName())));
        column3.setPrefWidth(175);
        /**
         * Amount Column
         */
        TableColumn<Transaction,String>column4=new TableColumn<>("Amount");
        column4.setCellValueFactory(e->new SimpleStringProperty(String.valueOf(e.getValue().getAmount())));
        column4.setPrefWidth(125);
        /**
         * currency id
         */
        TableColumn<Transaction,String>column5=new TableColumn<>("Category");
        column5.setCellValueFactory(e->new SimpleStringProperty(String.valueOf(e.getValue().getCategory())));
        column5.setPrefWidth(140);
        /**
         * Description
         */
        TableColumn<Transaction,String>column6=new TableColumn<>("Description");
        column6.setCellValueFactory(e->new SimpleStringProperty(e.getValue().getDescription()));
        column6.setPrefWidth(200);
        tableView.getColumns().addAll(column2,column3,column4,column5,column6);


        accountComboBox.setOnAction(e->{

            chosenAccount = accountComboBox.getSelectionModel().getSelectedItem();
            System.out.println(chosenAccount);
            refreshTable();

            generateChart();

        }
        );
        tableView.setPrefHeight(250);
        tableView.setPrefWidth(800);
        topPanel.add(tableView,0,2,2,1);

        chart.setTitle("Transactions Breakdown");
        VBox bottomPanel=new VBox(10,chart);
        root.setTop(topPanel);
        root.setCenter(tableView);
        root.setBottom(bottomPanel);

        String css = getClass().getResource("/styles.css").toExternalForm();
        root.getStylesheets().add(css); // Ensure this line is executed


        this.setContent(root);

    }

    /**
<<<<<<< HEAD
     * This method will generate the pie chart based on what accpunt is selected
=======
     * generates pie chart data based on transaction amount
>>>>>>> 87be54dad54670854cb3408755c233f292ae7002
     */
    private void generateChart() {
        if (chosenAccount == null){
            return;
        }
        TransactionTable transactionTable=TransactionTable.getInstance();
        CategoryTable categoryTable=CategoryTable.getInstance();

        //get all types of categories
        ArrayList<Category> categories=categoryTable.getAllCategories();
        ArrayList<PieChart.Data> data=new ArrayList<>();
        //have to write a method in transaction table
        for(Category category:categories){
            double amount=transactionTable.getCategoryAmount(category.getId(),chosenAccount.getId());
            if(amount>0){
                data.add(new PieChart.Data(category.getName(),amount));

            }
        }
        ObservableList<PieChart.Data> chartData=FXCollections.observableArrayList(data);
        chart.setData(chartData);


    }

    /**
<<<<<<< HEAD
     * This method will refresh the transaction table
=======
     * Refreshes the table view to display the latest transactions of the selected account.
>>>>>>> 87be54dad54670854cb3408755c233f292ae7002
     */
    private void refreshTable(){
        TransactionTable table=TransactionTable.getInstance();
        if (chosenAccount != null){
            ArrayList<Transaction> transactions=table.searchTransaction(chosenAccount.getId());
            tableView.getItems().clear();
            tableView.getItems().addAll(transactions);
        }



    }

    /**
     * get instance
     * @return
     */
    public static ViewAccountsTab getInstance() {
        if(instance == null){
            instance = new ViewAccountsTab();
        }
        return instance;
    }

    /**
     * Refreshes the table view to display the latest selected account.
     */
    public void refresh(){
        refreshTable();
        generateChart();

        accountComboBox.setItems(FXCollections.observableArrayList(AccountTable.getInstance().getAllAccounts()));
        accountComboBox.getSelectionModel().selectFirst();
    }
}
