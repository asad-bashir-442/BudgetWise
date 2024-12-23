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

/**
 * This class acts as the login page and is the first thing the user sees
 * If the user already has valid credentials move them to homepage
 * otherwise show them login form
 */
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
        root.getStyleClass().add("tab-background");


        Label userNameLabel = new Label("Username");
        userNameLabel.getStyleClass().add("label-style");
        TextField userNameTextField = new TextField();
        userNameTextField.getStyleClass().add("textfield-style");

        Label passwordLabel = new Label("Password");
        passwordLabel.getStyleClass().add("label-style");
        PasswordField passwordField = new PasswordField();
        passwordField.getStyleClass().add("textfield-style");

        Label serverLabel = new Label("Server Location");
        serverLabel.getStyleClass().add("label-style");
        TextField serverTextField = new TextField();
        serverTextField.getStyleClass().add("textfield-style");

        Label databaseLabel = new Label("Database Name");
        databaseLabel.getStyleClass().add("label-style");

        TextField databaseTextField = new TextField();
        databaseTextField.getStyleClass().add("textfield-style");

        Button testConnectionBtn = new Button("Test Connection");
        testConnectionBtn.getStyleClass().add("button-style");
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

        String css = getClass().getResource("/styles.css").toExternalForm();
        root.getStylesheets().add(css);


        Scene scene=new Scene(root,500,500);
        super.setTitle("LogIn");
        super.setScene(scene);
        super.show();


    }

    /**
<<<<<<< HEAD
     * This method takes the user credentials and save them to a text file
=======
     * this method is to save user information and user dont need to input again when he uses the database next time
>>>>>>> 87be54dad54670854cb3408755c233f292ae7002
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
<<<<<<< HEAD
     * This method checks against the database if credentials given from the user are valid
     * and builds a proper connection to the database
=======
     * to validate the database connection using the user entered credentials.
>>>>>>> 87be54dad54670854cb3408755c233f292ae7002
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
