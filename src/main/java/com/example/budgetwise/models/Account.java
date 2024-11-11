package com.example.budgetwise.models;

public class Account {
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    private String name;
    private double balance;
    private String date;

    public Account(int id, String name, double balance, String date){
        this.id = id;
        this.name = name;
        this.balance = balance;
        this.date = date;
    }

    public String toString(){
        return id+" "+name + " " + balance + " " + date;
    }

}
