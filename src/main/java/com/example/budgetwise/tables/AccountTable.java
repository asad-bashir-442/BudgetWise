package com.example.budgetwise.tables;

import com.example.budgetwise.dao.AccountDAO;
import com.example.budgetwise.database.DBConst;
import com.example.budgetwise.database.Database;
import com.example.budgetwise.models.Account;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class AccountTable implements AccountDAO {


    private static AccountTable instance;
    private Database db = Database.getInstance();

    private AccountTable(){

    }

    public static AccountTable getInstance(){
        if(instance == null){
            instance = new AccountTable();
        }
        return instance;
    }

    private ArrayList<Account> accounts;
    @Override
    public ArrayList<Account> getAllAccounts() {
        String query = "SELECT * FROM " + DBConst.TABLE_ACCOUNT;
        accounts = new ArrayList<>();

        try{
            Statement getItems = db.getConnection().createStatement();
            ResultSet data = getItems.executeQuery(query);

        while (data.next()){
            accounts.add(new Account(data.getInt(DBConst.ACCOUNT_COLUMN_ID),
                    data.getString(DBConst.ACCOUNT_COLUMN_NAME),
                    data.getDouble(DBConst.ACCOUNT_COLUMN_BALANCE),
                    data.getInt(DBConst.ACCOUNT_COLUMN_CURRENCY_ID),
                    data.getInt(DBConst.ACCOUNT_COLUMN_TYPE_ID)));




        }
        } catch (SQLException e){
            e.printStackTrace();
        }

        return accounts;

    }

    @Override
    public void createAccount(Account account) {
        String query = "INSERT INTO " + DBConst.TABLE_ACCOUNT +
        "(" + DBConst.ACCOUNT_COLUMN_BALANCE + ", " +
        DBConst.ACCOUNT_COLUMN_NAME + ", " +
        DBConst.ACCOUNT_COLUMN_CURRENCY_ID + ", " +
        DBConst.ACCOUNT_COLUMN_TYPE_ID + ") VALUES ('" +
        account.getBalance() + "','" + account.getName() + "','" +
        account.getCurrency_id() + "','" +
        account.getType_id() + "')";

        try {
            db.getConnection().createStatement().execute(query);
            System.out.println("Inserted Record");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


}
