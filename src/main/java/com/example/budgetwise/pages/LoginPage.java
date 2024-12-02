package com.example.budgetwise.pages;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;

import static com.example.budgetwise.database.Const.*;

public class LoginPage extends Stage {
    /**
     * @author Lujia Yang
     * 0841073
     * a graphical interface for user to login database
     * the user enter credentials, it will test the connection
     * <p>>this page contain</p>
     * <ul>
     *     <li>text filed for user input username password server location and db name</li>\
     *     <li>a button to connect to database</li>
     *     <li>if connection is successful, will go to homepage</li>
     * </ul>
     */
    public LoginPage(){
        GridPane root =new GridPane();
        root.setHgap(10);
        root.setVgap(10);

        Label userNameLabel = new Label("Username");
        TextField userNameTextField = new TextField();

        Label passwordLabel = new Label("Password");
        PasswordField passwordField = new PasswordField();

        Label serverLabel = new Label("Server Location");
        TextField serverTextField = new TextField();

        Label databaseLabel = new Label("Database Name");
        TextField databaseTextField = new TextField();

        Button testConnectionBtn = new Button("Test Connection");
        //write method on the button
        testConnectionBtn.setOnAction(event -> {
            DB_NAME=databaseTextField.getText();
            DB_PASS=passwordField.getText();
            DB_USER=userNameTextField.getText();
            DB_LOCATION=serverTextField.getText();

            if(validCredentials()){
                try {
                    saveUserInfo(DB_NAME, DB_PASS, DB_LOCATION, DB_USER);
                    HomePage homePage=new HomePage();
                    homePage.show();
                    this.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        });

        Image logo=new Image(getClass().getResource("/logo1.png").toString());
        ImageView logoView=new ImageView(logo);
        logoView.setFitHeight(200);
        logoView.setFitWidth(200);
        //set the index
        root.add(logoView,0,0,2,1);
        root.add(userNameLabel,0,1);
        root.add(userNameTextField,1,1);

        root.add(passwordLabel,0,2);
        root.add(passwordField,1,2);

        root.add(serverLabel,0,3);
        root.add(serverTextField,1,3);

        root.add(databaseLabel,0,4);
        root.add(databaseTextField,1,4);

        root.add(testConnectionBtn,1,5);
        root.setAlignment(Pos.CENTER);

        Scene scene=new Scene(root,500,500);
        super.setTitle("LogIn");
        super.setScene(scene);
        super.show();


    }

    /**
     * this method is to save user information and user dont need to input again when he uses the database next time
     * @param db_name
     * @param db_pass
     * @param dblocation
     * @param dbuser
     * @throws IOException
     */
    public void saveUserInfo(String db_name, String db_pass ,String dblocation, String dbuser) throws IOException {
        String info="info.txt";
        FileWriter myWriter = new FileWriter(info);
        myWriter.write(db_name+"\n");
        myWriter.write(db_pass+"\n");
        myWriter.write(dblocation+"\n");
        myWriter.write(dbuser);

        myWriter.close();
    }

    /**
     * to validate the database connection using the user entered credentials.
     * @return
     */
    public boolean validCredentials(){
        Connection connection;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.
                    getConnection("jdbc:mysql://localhost/"+ DB_NAME +
                                    "?serverTimezone=UTC",
                            DB_USER,
                            DB_PASS);
            return connection.isValid(300);
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }


}
