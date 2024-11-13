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

    public static String ACCOUNT_TYPE_COLUMN_ID = "account_type_id";

    public static String ACCOUNT_TYPE_COLUMN_NAME = "account_type";



    /**
     * Currency table
     */

    public static String TABLE_CURRENCY = "currency";

    public static String CURRENCY_COLUMN_ID = "currency_id";

    public static String CURRENCY_COLUMN_NAME = "currency_type";

    /**
     * Transaction table
     */

    public static String TABLE_TRANSACTION = "transaction";

    public static String TRANSACTION_COLUMN_ID = "transaction_id";

    public static String TRANSACTION_COLUMN_DATE = "transaction_date";

    public static String TRANSACTION_COLUMN_AMOUNT = "transaction_amount";

    public static String TRANSACTION_COLUMN_TYPE_ID = "transaction_type_id";

    public static String TRANSACTION_COLUMN_DESCRIPTION = "transaction_description";




    /**
     * Transaction type table
     */
    public static String TABLE_TRANSACTION_TYPE = "transactiontype";

    public static String TRANSACTION_TYPE_COLUMN_ID = "transaction_type_id";

    public static String TRANSACTION_TYPE_COLUMN_NAME = "transaction_type";


    /**
     * Category table
     */

    public static String TABLE_CATEGORY = "category";

    public static String CATEGORY_COLUMN_ID = "category_id";

    public static String CATEGORY_COLUMN_NAME = "category_name";

    public static String CATEGORY_COLUMN_LIMIT = "category_limit";

    public static String CREATE_TABLE_CATEGORIES =
            " CREATE TABLE " + TABLE_CATEGORY + " (" +
                CATEGORY_COLUMN_ID + " INT NOT NULL AUTO_INCREMENT PRIMARY KEY, " +
                CATEGORY_COLUMN_NAME + " VARCHAR(255) NOT NULL, " +
                CATEGORY_COLUMN_LIMIT + " DECIMAL(15,2) NOT NULL " +
                ");";


    public static String CREATE_TABLE_TRANSACTION_TYPES =
            " CREATE TABLE " + TABLE_TRANSACTION_TYPE + " (" +
                    TRANSACTION_TYPE_COLUMN_ID + " INT NOT NULL AUTO_INCREMENT PRIMARY KEY, " +
                    TRANSACTION_TYPE_COLUMN_NAME + " VARCHAR(50) NOT NULL" +
                    ");";

    public static String CREATE_TABLE_TRANSACTIONS =
            " CREATE TABLE " + TABLE_TRANSACTION + " (" +
                TRANSACTION_COLUMN_ID + " INT NOT NULL AUTO_INCREMENT PRIMARY KEY, " +
                TRANSACTION_COLUMN_DATE + " DATETIME NOT NULL, " +
                TRANSACTION_COLUMN_AMOUNT + " DECIMAL (15,2) NOT NULL, " +
                TRANSACTION_COLUMN_TYPE_ID + " INT NOT NULL, " +
                TRANSACTION_COLUMN_DESCRIPTION + " VARCHAR(255) NOT NULL, " +
                "FOREIGN KEY (" + TRANSACTION_COLUMN_TYPE_ID + ")" +
                    " REFERENCES " + TABLE_TRANSACTION_TYPE + "(" + TRANSACTION_TYPE_COLUMN_ID + "));";




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
            ACCOUNT_TYPE_COLUMN_ID + " INT NOT NULL AUTO_INCREMENT PRIMARY KEY, " +
            ACCOUNT_TYPE_COLUMN_NAME + " VARCHAR(50) NOT NULL" +
            ");";

    public static String CREATE_TABLE_CURRENCY =
            " CREATE TABLE " + TABLE_CURRENCY + " (" +
                    CURRENCY_COLUMN_ID + " INT NOT NULL AUTO_INCREMENT PRIMARY KEY, " +
                    CURRENCY_COLUMN_NAME + " VARCHAR(50) NOT NULL" +
                    ");";


    /**
     * MockData insertion tables
     */
    public static String POPULATE_CURRENCY_TABLE =
            "INSERT INTO " + TABLE_CURRENCY +
            "(" + CURRENCY_COLUMN_NAME + ")" +
            " VALUES ('CAD'),('USD'),('EUR');";


    public static String POPULATE_CATEGORY_TABLE =
            "INSERT INTO " + TABLE_CATEGORY +
            "(" + CATEGORY_COLUMN_NAME + ", " +
            CATEGORY_COLUMN_LIMIT + ")" + " VALUES " +
            " ('Food',400), ('Rent',1200), ('Utilities',325);";

    public static String POPULATE_ACCOUNT_TYPE_TABLE =
            "INSERT INTO " + TABLE_ACCOUNT_TYPE +
            "(" + ACCOUNT_TYPE_COLUMN_NAME + ")" +
            " VALUES ('Checking'),('Savings'),('Credit');";

    public static String POPULATE_TRANSACTION_TYPE_TABLE =
            "INSERT INTO " + TABLE_TRANSACTION_TYPE +
            "(" + TRANSACTION_TYPE_COLUMN_NAME + ")" +
            " VALUES ('Debit'),('Credit');";


    public static String POPULATE_TRANSACTION_TABLE =
            "INSERT INTO " + TABLE_TRANSACTION +
            "(" + TRANSACTION_COLUMN_DATE + ", " +
            TRANSACTION_COLUMN_AMOUNT + "," +
            TRANSACTION_COLUMN_DESCRIPTION + ", " +
            TRANSACTION_COLUMN_TYPE_ID + ")" +
            " VALUES (NOW(),'100','Grocery Shopping Walmart',2), " +
            "(NOW(),'800','Car Repair',2), " +
            "(NOW(),'2000','Paid',1), " +
            "(NOW(),'100','Tax Refunded',1);";


    public static String POPULATE_ACCOUNT_TABLE =
            "INSERT INTO " + TABLE_ACCOUNT +
            "(" + ACCOUNT_COLUMN_BALANCE + ", " +
            ACCOUNT_COLUMN_NAME + ", " +
            ACCOUNT_COLUMN_CREATE_DATE + ", " +
            ACCOUNT_COLUMN_TYPE_ID + ", " +
            ACCOUNT_COLUMN_CURRENCY_ID + ")" +
            "VALUES (20000,'Checking Account',NOW(),1,1), " +
            "(80000,'Saving Account',NOW(),2,2), " +
            "(175000,'Line Of Credit',NOW(),3,3);";
}
