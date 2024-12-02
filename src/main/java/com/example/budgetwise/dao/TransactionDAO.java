package com.example.budgetwise.dao;

import com.example.budgetwise.models.Account;
import com.example.budgetwise.models.Transaction;

import java.util.ArrayList;

public interface TransactionDAO {

    public ArrayList<Transaction> getAllTransactions();


    public void createTransaction(Transaction transaction);


    void deleteTransactionByAccount(Account account);
}
