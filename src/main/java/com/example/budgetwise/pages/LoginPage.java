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
    public void saveUserInfo(String db_name, String db_pass ,String dblocation, String dbuser) throws IOException {
        String info="info.txt";
        FileWriter myWriter = new FileWriter(info);
        myWriter.write(db_name+"\n");
        myWriter.write(db_pass+"\n");
        myWriter.write(dblocation+"\n");
        myWriter.write(dbuser);

        myWriter.close();
    }
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
