package com.example.budgetwise.database;

import java.sql.*;

import static com.example.budgetwise.database.Const.*;


public class Database {

    private static Database instance;
    private Connection connection = null;

    private Database(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.
                    getConnection("jdbc:mysql://localhost/"+ DB_NAME +
                                    "?serverTimezone=UTC",
                            DB_USER,
                            DB_PASS);
            System.out.println("Created Connection!");
            createTable(DBConst.TABLE_ACCOUNT_TYPE, DBConst.CREATE_TABLE_ACCOUNT_TYPES,connection);
            createTable(DBConst.TABLE_CURRENCY, DBConst.CREATE_TABLE_CURRENCY,connection);
            createTable(DBConst.TABLE_ACCOUNT, DBConst.CREATE_TABLE_ACCOUNTS,connection);
            createTable(DBConst.TABLE_TRANSACTION_TYPE,DBConst.CREATE_TABLE_TRANSACTION_TYPES,connection);
            createTable(DBConst.TABLE_TRANSACTION,DBConst.CREATE_TABLE_TRANSACTIONS,connection);
            createTable(DBConst.TABLE_CATEGORY,DBConst.CREATE_TABLE_CATEGORIES,connection);

            /**
             * This method populates the tables with mock data
             * should only be run once. Uncomment then Comment again.
             */
            //populateMockData();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static Database getInstance(){
        if(instance == null){
            instance = new Database();
        }
        return instance;
    }

    public void createTable(String tableName, String tableQuery, Connection connection) throws SQLException {
        Statement createTable;
        DatabaseMetaData md = connection.getMetaData();
        ResultSet resultSet = md.getTables(DB_NAME, null, tableName, null);
        if(resultSet.next()){
            System.out.println(tableName + " table already exists");
        }
        else{
            createTable = connection.createStatement();
            createTable.execute(tableQuery);
            System.out.println("The " + tableName + " table has been created");
        }
    }

    public void populateMockData(){

        try{
            connection.createStatement().execute(DBConst.POPULATE_TRANSACTION_TYPE_TABLE);
            connection.createStatement().execute(DBConst.POPULATE_CATEGORY_TABLE);
            connection.createStatement().execute(DBConst.POPULATE_CURRENCY_TABLE);
            connection.createStatement().execute(DBConst.POPULATE_ACCOUNT_TYPE_TABLE);
            connection.createStatement().execute(DBConst.POPULATE_TRANSACTION_TABLE);
            connection.createStatement().execute(DBConst.POPULATE_ACCOUNT_TABLE);


        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public Connection getConnection() {
        return connection;
    }
}
