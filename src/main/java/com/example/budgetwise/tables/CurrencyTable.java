package com.example.budgetwise.tables;

import com.example.budgetwise.dao.CurrencyDAO;
import com.example.budgetwise.database.DBConst;
import com.example.budgetwise.database.Database;
import com.example.budgetwise.models.Currency;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class CurrencyTable implements CurrencyDAO {

    private static CurrencyTable instance;

    private Database db = Database.getInstance();

    private ArrayList<Currency> currencies;

    private CurrencyTable(){

    }

    public static CurrencyTable getInstance(){
        if (instance == null){
            instance = new CurrencyTable();
        }
        return instance;
    }

    @Override
    public ArrayList<Currency> getAllCurrency() {
        String query = "SELECT * FROM " + DBConst.TABLE_CURRENCY;

        currencies = new ArrayList<>();

        try{
            Statement getItems = db.getConnection().createStatement();
            ResultSet data = getItems.executeQuery(query);

            while (data.next()){
                currencies.add(new Currency(data.getInt(DBConst.CURRENCY_COLUMN_ID),
                                            data.getString(DBConst.CURRENCY_COLUMN_NAME)));


            }
        } catch (SQLException e){
            e.printStackTrace();
        }

        return currencies;


    }
}
