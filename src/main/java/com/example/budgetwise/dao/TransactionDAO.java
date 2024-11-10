package com.example.budgetwise.dao;

import com.example.budgetwise.models.Transaction;

import java.util.ArrayList;

public interface TransactionDAO {

    public ArrayList<Transaction> getAllTransactions();

}
