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
                        data.getString(DBConst.TRANSACTION_COLUMN_DESCRIPTION)));


            }
        } catch (SQLException e){
            e.printStackTrace();
        }

        return transactions;

    }
}
