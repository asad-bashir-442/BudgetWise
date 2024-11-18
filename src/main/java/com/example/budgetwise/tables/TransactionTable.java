package com.example.budgetwise.tables;

import com.example.budgetwise.dao.TransactionDAO;
import com.example.budgetwise.database.DBConst;
import com.example.budgetwise.database.Database;
import com.example.budgetwise.models.Transaction;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class TransactionTable implements TransactionDAO {

    private static TransactionTable instance;

    private ArrayList<Transaction> transactions;

    private Database db = Database.getInstance();

    private TransactionTable(){

    }

    public static TransactionTable getInstance(){
        if (instance == null){
            instance = new TransactionTable();
        }
        return instance;
    }
    @Override
    public ArrayList<Transaction> getAllTransactions() {
        String query = "SELECT * FROM " + DBConst.TABLE_TRANSACTION;

        transactions = new ArrayList<>();

        try{
            Statement getItems = db.getConnection().createStatement();
            ResultSet data = getItems.executeQuery(query);

            while (data.next()){
                transactions.add(new Transaction(data.getInt(DBConst.TRANSACTION_COLUMN_ID),
                        data.getString(DBConst.TRANSACTION_COLUMN_DATE),
                        data.getInt(DBConst.TRANSACTION_COLUMN_TYPE_ID),
                        data.getDouble(DBConst.TRANSACTION_COLUMN_AMOUNT),
                        data.getString(DBConst.TRANSACTION_COLUMN_DESCRIPTION),
                        data.getInt(DBConst.TRANSACTION_COLUMN_CATEGORY_ID),
                        data.getInt(DBConst.TRANSACTION_COLUMN_ACCOUNT_ID)));


            }
        } catch (SQLException e){
            e.printStackTrace();
        }

        return transactions;

    }

    @Override
    public void createTransaction(Transaction transaction) {

        String query = "INSERT INTO " + DBConst.TABLE_TRANSACTION +
            "(" + DBConst.TRANSACTION_COLUMN_TYPE_ID + ", " +
                DBConst.TRANSACTION_COLUMN_AMOUNT + ", " +
                DBConst.TRANSACTION_COLUMN_DESCRIPTION + ", " +
                DBConst.TRANSACTION_COLUMN_CATEGORY_ID + ", " +
                DBConst.TRANSACTION_COLUMN_ACCOUNT_ID + ", " +
                DBConst.TRANSACTION_COLUMN_DATE + ") VALUES ('" +
                transaction.getType() + "','" + transaction.getAmount() + "','" +
                transaction.getDescription() + "','" + transaction.getCategory_id() + "','" +
                transaction.getAccount_id() + "','" + transaction.getDate() + "')";



        try {
            db.getConnection().createStatement().execute(query);
            System.out.println("Inserted Record");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public ArrayList<Transaction> searchTransaction(int accountId){

        String query=" SELECT * FROM "+DBConst.TABLE_TRANSACTION+" WHERE "+DBConst.TRANSACTION_COLUMN_ACCOUNT_ID+" = "+accountId;
        transactions=new ArrayList<>();

        try{
//            db.getConnection().createStatement().executeQuery(query);
//            System.out.println("find records");
            Statement getItems=db.getConnection().createStatement();
            ResultSet data=getItems.executeQuery(query);

            while(data.next()){
                transactions.add(new Transaction(data.getInt(DBConst.TRANSACTION_COLUMN_ID),
                        data.getString(DBConst.TRANSACTION_COLUMN_DATE),
                        data.getInt(DBConst.TRANSACTION_COLUMN_TYPE_ID),
                        data.getDouble(DBConst.TRANSACTION_COLUMN_AMOUNT),
                        data.getString(DBConst.TRANSACTION_COLUMN_DESCRIPTION),
                        data.getInt(DBConst.TRANSACTION_COLUMN_CATEGORY_ID),
                        data.getInt(DBConst.TRANSACTION_COLUMN_ACCOUNT_ID)));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return transactions;
    }



}
