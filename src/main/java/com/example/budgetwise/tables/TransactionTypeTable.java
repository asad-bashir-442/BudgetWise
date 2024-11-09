package com.example.budgetwise.tables;

import com.example.budgetwise.dao.TransactionTypeDAO;
import com.example.budgetwise.database.DBConst;
import com.example.budgetwise.database.Database;
import com.example.budgetwise.models.Currency;
import com.example.budgetwise.models.TransactionType;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class TransactionTypeTable implements TransactionTypeDAO {

    private static TransactionTypeTable instance;

    private Database db = Database.getInstance();

    private ArrayList<TransactionType> transactionTypes;

    private TransactionTypeTable(){

    }

    public static TransactionTypeTable getInstance(){
        if (instance == null){
            instance = new TransactionTypeTable();
        }
        return instance;
    }
    @Override
    public ArrayList<TransactionType> getAllTransactionTypes() {
        String query = "SELECT * FROM " + DBConst.TABLE_TRANSACTION_TYPE;

        transactionTypes = new ArrayList<>();

        try{
            Statement getItems = db.getConnection().createStatement();
            ResultSet data = getItems.executeQuery(query);

            while (data.next()){
                transactionTypes.add(new TransactionType(data.getInt(DBConst.TRANSACTION_TYPE_COLUMN_ID),
                                        data.getString(DBConst.TRANSACTION_TYPE_COLUMN_NAME)));


            }
        } catch (SQLException e){
            e.printStackTrace();
        }

        return transactionTypes;
    }
}
