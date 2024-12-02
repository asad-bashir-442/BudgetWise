package com.example.budgetwise.models;

import com.example.budgetwise.tables.CategoryTable;
import com.example.budgetwise.tables.CurrencyTable;
import com.example.budgetwise.tables.TransactionTypeTable;

import java.util.ArrayList;

public class Transaction {
    private int id;

    private String date;

    private int type;

    private double amount;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    private String description;

    private int category_id;

    public int getCategory_id() {
        return category_id;
    }

    private int account_id;

    public int getAccount_id() {
        return account_id;
    }

    public void setAccount_id(int account_id) {
        this.account_id = account_id;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }

    private String name;

    private String category;

    public String getCategory(){
        return category;
    }

    public String getName(){
        return name;
    }

    public Transaction(int id, String date, int type, double amount, String description, int category_id, int account_id) {
        this.id = id;
        this.date = date;
        this.type = type;
        this.amount = amount;
        this.description = description;
        this.category_id = category_id;
        this.account_id = account_id;

        ArrayList<TransactionType> transactionTypes = TransactionTypeTable.getInstance().getAllTransactionTypes();
        ArrayList<Category> categories = CategoryTable.getInstance().getAllCategories();

        for (Category category : categories){
            if (category_id == category.getId()){
                this.category = category.getName();
            }

        }

        for (TransactionType transactionType : transactionTypes){
            if (type == transactionType.getId()){
                name = transactionType.getType();
            }
        }
    }

    public Transaction (String date, int type, double amount, String description, int category_id, int account_id){
        this.date = date;
        this.type = type;
        this.amount = amount;
        this.description = description;
        this.category_id = category_id;
        this.account_id = account_id;

        ArrayList<TransactionType> transactionTypes = TransactionTypeTable.getInstance().getAllTransactionTypes();

        for (TransactionType transactionType : transactionTypes){
            if (type == transactionType.getId()){
                name = transactionType.getType();
            }
        }
    }

    public String toString(){
        return id + " " + date + " " + type + " " +amount + " " + description + " " + category_id ;
    }
}
