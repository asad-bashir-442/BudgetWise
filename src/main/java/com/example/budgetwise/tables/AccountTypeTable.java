package com.example.budgetwise.tables;

import com.example.budgetwise.dao.AccountTypeDAO;
import com.example.budgetwise.database.DBConst;
import com.example.budgetwise.database.Database;
import com.example.budgetwise.models.AccountType;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class AccountTypeTable implements AccountTypeDAO {

    private static AccountTypeTable instance;
    private Database db = Database.getInstance();

    private ArrayList<AccountType> accountTypes;

    private AccountTypeTable(){

    }

    public static AccountTypeTable getInstance(){
        if (instance == null){
            instance = new AccountTypeTable();
        }
        return instance;
    }
    @Override
    public ArrayList<AccountType> getAllAccountTypes() {
        String query = "SELECT * FROM " + DBConst.TABLE_ACCOUNT_TYPE;

        accountTypes = new ArrayList<>();

        try{
            Statement getItems = db.getConnection().createStatement();
            ResultSet data = getItems.executeQuery(query);

            while (data.next()){
                accountTypes.add(new AccountType(data.getInt(DBConst.ACCOUNT_TYPE_COLUMN_ID),
                                data.getString(DBConst.ACCOUNT_TYPE_COLUMN_NAME)));


            }
        } catch (SQLException e){
            e.printStackTrace();
        }

        return accountTypes;

    }
}
