package com.example.budgetwise.models;

public class Category {
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    private String type;

    public Category(int id, String type){
        this.id = id;
        this.type = type;
    }

    public String toString(){
        return id + " " + type;
    }
}
