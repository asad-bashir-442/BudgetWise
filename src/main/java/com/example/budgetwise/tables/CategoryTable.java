package com.example.budgetwise.tables;

import com.example.budgetwise.dao.CategoryDAO;
import com.example.budgetwise.database.DBConst;
import com.example.budgetwise.database.Database;
import com.example.budgetwise.models.Category;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class CategoryTable implements CategoryDAO {

    private static CategoryTable instance;
    private Database db = Database.getInstance();

    private ArrayList<Category> categories;

    @Override
    public ArrayList<Category> getAllCategories() {
        String query = "SELECT * FROM " + DBConst.TABLE_CATEGORY;

        categories = new ArrayList<>();

        try{
            Statement getItems = db.getConnection().createStatement();
            ResultSet data = getItems.executeQuery(query);

            while (data.next()){
                categories.add(new Category(data.getInt(DBConst.CATEGORY_COLUMN_ID),
                                data.getString(DBConst.CATEGORY_COLUMN_NAME)));

            }
        } catch (SQLException e){
            e.printStackTrace();
        }

        return categories;
    }

    @Override
    public void addCategory(Category category) {
        String query = "INSERT INTO " + DBConst.TABLE_CATEGORY + " (" + DBConst.CATEGORY_COLUMN_NAME + ") VALUES ('" + category.getName() + "')";

        try {
            db.getConnection().createStatement().execute(query);
            System.out.println("Inserted Record");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }



    public static CategoryTable getInstance(){
        if (instance == null){
            instance = new CategoryTable();
        }
        return instance;
    }
}

