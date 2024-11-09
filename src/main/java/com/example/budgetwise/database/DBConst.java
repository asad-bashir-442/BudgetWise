package com.example.budgetwise.database;

public class DBConst {

    /**
     * Account Table
     */

    public static String TABLE_ACCOUNT = "account";

    public static String ACCOUNT_COLUMN_ID = "account_id";

    public static String ACCOUNT_COLUMN_NAME = "account_name";

    public static String ACCOUNT_COLUMN_TYPE_ID = "account_type_id";

    public static String ACCOUNT_COLUMN_BALANCE = "account_balance";

    public static String ACCOUNT_COLUMN_CURRENCY_ID = "currency_id";

    public static String ACCOUNT_COLUMN_CREATE_DATE = "created_date";


    /**
     * Account type table
     */

    public static String TABLE_ACCOUNT_TYPE = "accounttype";

    public static String ACCOUNT_TYPE_COLUMN_NAME = "account_type";
    public static String ACCOUNT_TYPE_COLUMN_ID = "account_type_id";



    /**
     * Currency table
     */

    public static String TABLE_CURRENCY = "currency";

    public static String CURRENCY_COLUMN_ID = "currency_id";

    public static String CURRENCY_COLUMN_NAME = "currency_type";



    public static String CREATE_TABLE_ACCOUNTS =
            " CREATE TABLE " + TABLE_ACCOUNT + " (" +
            ACCOUNT_COLUMN_ID + " INT NOT NULL AUTO_INCREMENT PRIMARY KEY, " +
            ACCOUNT_COLUMN_NAME + " VARCHAR(50) NOT NULL, " +
            ACCOUNT_COLUMN_TYPE_ID + " INT NOT NULL, " +
            ACCOUNT_COLUMN_BALANCE + " DECIMAL (15,2) NOT NULL, " +
            ACCOUNT_COLUMN_CURRENCY_ID + " INT NOT NULL, " +
            ACCOUNT_COLUMN_CREATE_DATE + " DATE NOT NULL, " +
            "FOREIGN KEY (" + ACCOUNT_COLUMN_TYPE_ID + ")" +
                    " REFERENCES " + TABLE_ACCOUNT_TYPE + "(" + ACCOUNT_TYPE_COLUMN_ID + ")," +
            "FOREIGN KEY (" + ACCOUNT_COLUMN_CURRENCY_ID + ")" +
                    " REFERENCES " + TABLE_CURRENCY + "(" + CURRENCY_COLUMN_ID + "));";



    public static String CREATE_TABLE_ACCOUNT_TYPES =
            " CREATE TABLE " + TABLE_ACCOUNT_TYPE + " (" +
            ACCOUNT_TYPE_COLUMN_ID + " int NOT NULL AUTO_INCREMENT PRIMARY KEY, " +
            ACCOUNT_TYPE_COLUMN_NAME + " VARCHAR(50) NOT NULL" +
            ");";

    public static String CREATE_TABLE_CURRENCY =
            " CREATE TABLE " + TABLE_CURRENCY + " (" +
                    CURRENCY_COLUMN_ID + " int NOT NULL AUTO_INCREMENT PRIMARY KEY, " +
                    CURRENCY_COLUMN_NAME + " VARCHAR(50) NOT NULL" +
                    ");";
}
