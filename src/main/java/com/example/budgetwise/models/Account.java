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


    private String name;
    private double balance;
    private int type_id;

    public int getType_id() {
        return type_id;
    }

    public void setType_id(int type_id) {
        this.type_id = type_id;
    }

    public int getCurrency_id() {
        return currency_id;
    }

    public void setCurrency_id(int currency_id) {
        this.currency_id = currency_id;
    }

    private int currency_id;

    public Account(int id, String name, double balance, int currency_id, int type_id){
        this.id = id;
        this.name = name;
        this.balance = balance;
        this.currency_id = currency_id;
        this.type_id = type_id;
    }

    public Account(String name, double balance, int currency_id, int type_id){
        this.name = name;
        this.balance = balance;
        this.currency_id = currency_id;
        this.type_id = type_id;
    }

    public String toString(){
        //return id+" "+name + " " + balance + " " + " " + currency_id + " " + type_id ;
        return name;
    }

}
