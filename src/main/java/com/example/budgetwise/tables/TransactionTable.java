package com.example.budgetwise.tables;

import com.example.budgetwise.dao.TransactionDAO;
import com.example.budgetwise.database.DBConst;
import com.example.budgetwise.database.Database;
import com.example.budgetwise.models.Account;
import com.example.budgetwise.models.Transaction;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import static com.example.budgetwise.database.DBConst.*;

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
        String query = "SELECT * FROM " + TABLE_TRANSACTION;

        transactions = new ArrayList<>();

        try{
            Statement getItems = db.getConnection().createStatement();
            ResultSet data = getItems.executeQuery(query);

            while (data.next()){
                transactions.add(new Transaction(data.getInt(DBConst.TRANSACTION_COLUMN_ID),
                        data.getString(DBConst.TRANSACTION_COLUMN_DATE),
                        data.getInt(DBConst.TRANSACTION_COLUMN_TYPE_ID),
                        data.getDouble(TRANSACTION_COLUMN_AMOUNT),
                        data.getString(DBConst.TRANSACTION_COLUMN_DESCRIPTION),
                        data.getInt(TRANSACTION_COLUMN_CATEGORY_ID),
                        data.getInt(DBConst.TRANSACTION_COLUMN_ACCOUNT_ID)));


            }
        } catch (SQLException e){
            e.printStackTrace();
        }

        return transactions;

    }

    @Override
    public void createTransaction(Transaction transaction) {

        String query = "INSERT INTO " + TABLE_TRANSACTION +
                "(" + DBConst.TRANSACTION_COLUMN_TYPE_ID + ", " +
                TRANSACTION_COLUMN_AMOUNT + ", " +
                DBConst.TRANSACTION_COLUMN_DESCRIPTION + ", " +
                TRANSACTION_COLUMN_CATEGORY_ID + ", " +
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

        String query=" SELECT * FROM "+ TABLE_TRANSACTION+" WHERE "+DBConst.TRANSACTION_COLUMN_ACCOUNT_ID+" = "+accountId;
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
                        data.getDouble(TRANSACTION_COLUMN_AMOUNT),
                        data.getString(DBConst.TRANSACTION_COLUMN_DESCRIPTION),
                        data.getInt(TRANSACTION_COLUMN_CATEGORY_ID),
                        data.getInt(DBConst.TRANSACTION_COLUMN_ACCOUNT_ID)));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return transactions;
    }

    public double getCategoryAmount(int cat){
        double amount=0;
        try {
            PreparedStatement getAmount = db.getConnection()
                    .prepareStatement("SELECT "+TRANSACTION_COLUMN_AMOUNT + " FROM "+TABLE_TRANSACTION + " WHERE "
                                    +TRANSACTION_COLUMN_CATEGORY_ID+ " = '" + cat + "'", ResultSet.TYPE_SCROLL_SENSITIVE,
                            ResultSet.CONCUR_UPDATABLE);
            ResultSet data = getAmount.executeQuery();
            //data.last();
            //amount = data.getRow();
            while(data.next()){
                amount += data.getDouble(TRANSACTION_COLUMN_AMOUNT);
            }
        }
        catch(SQLException e) {
            e.printStackTrace();
        }
        return amount;
    }

    @Override
    public void deleteTransactionByAccount(Account account) {

        String query = " DELETE FROM " + DBConst.TABLE_TRANSACTION + " WHERE " +
                DBConst.TRANSACTION_COLUMN_ACCOUNT_ID + " = " + account.getId();

        try{
            db.getConnection().createStatement().execute(query);
            System.out.println("All transactions delete with " + account.getId() + " id");
        }catch (SQLException e){
            e.printStackTrace();
        }


    }

}