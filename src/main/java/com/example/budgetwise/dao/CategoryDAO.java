package com.example.budgetwise.dao;

import com.example.budgetwise.models.Account;
import com.example.budgetwise.models.Category;

import java.util.ArrayList;

public interface CategoryDAO {

    public ArrayList<Category> getAllCategories();
    public void addCategory(Category category);

}
