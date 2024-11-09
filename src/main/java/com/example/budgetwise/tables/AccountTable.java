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


    private Database db = Database.getInstance();

    public AccountTable(){

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
                    data.getDouble(DBConst.ACCOUNT_BALANCE),
                    data.getString(DBConst.ACCOUNT_CREATE_DATE)));


        }
        } catch (SQLException e){
            e.printStackTrace();
        }

        return accounts;

    }
}
