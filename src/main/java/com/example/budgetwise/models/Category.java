package com.example.budgetwise.models;

public class Category {
    private int id;

    private String name;

    private double limit;

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

    public double getLimit() {
        return limit;
    }

    public void setLimit(double limit) {
        this.limit = limit;
    }

    public Category(int id, String name, double limit) {
        this.id = id;
        this.name = name;
        this.limit = limit;
    }

    public String toString(){
        return id + " " + name + " " + limit;
    }
}
