package com.example.budgetwise.dao;

import com.example.budgetwise.models.Account;

import java.util.ArrayList;

public interface AccountDAO {
    public ArrayList<Account> getAllAccounts();

    public void createAccount(Account account);

    public void updateAccount(Account account);
}
