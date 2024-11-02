package com.example.budgetwise;

import com.example.budgetwise.database.Database;
import com.example.budgetwise.database.newConst;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;

import static com.example.budgetwise.database.newConst.*;

public class Login extends Application {
    @Override
    public void start(Stage stage)  {

      String infoFile="info.txt";
      checkInfoExist();
        BorderPane root = new BorderPane();
        VBox userLoginBox = new VBox();

        HBox userNameHBox = new HBox();
        Label userNameLabel = new Label("Username");
        TextField userNameTextField = new TextField();
        userNameHBox.getChildren().addAll(userNameLabel,userNameTextField);


        HBox passwordHBox = new HBox();
        Label passwordLabel = new Label("Password");
        PasswordField passwordField = new PasswordField();
        passwordHBox.getChildren().addAll(passwordLabel,passwordField);


        HBox serverHbox = new HBox();
        Label serverLabel = new Label("Server Location");
        TextField serverTextField = new TextField();
        serverHbox.getChildren().addAll(serverLabel,serverTextField);

        HBox databaseHBox = new HBox();
        Label databaseLabel = new Label("Database Name");
        TextField databaseTextField = new TextField();
        databaseHBox.getChildren().addAll(databaseLabel,databaseTextField);


        Button testConnectionBtn = new Button("Test Connection");
        testConnectionBtn.setOnAction(event -> {
          newConst.DB_NAME=databaseTextField.getText();
          newConst.DB_PASS=passwordField.getText();
          newConst.DB_USER=userNameTextField.getText();
          DB_LOCATION=serverTextField.getText();

            if(validCredentials(DB_NAME,DB_PASS,DB_LOCATION,DB_USER)){
              try {
                saveUserInfo(DB_NAME, DB_PASS, DB_LOCATION, DB_USER);
              } catch (IOException e) {
                e.printStackTrace();
              }

            }



        });

        Image logo=new Image(getClass().getResource("logo1.png").toString());
        ImageView logoView=new ImageView(logo);
        logoView.setFitHeight(200);
        logoView.setFitWidth(200);

      userNameHBox.setAlignment(Pos.CENTER);
      passwordHBox.setAlignment(Pos.CENTER);
      serverHbox.setAlignment(Pos.CENTER);
      databaseHBox.setAlignment(Pos.CENTER);

        userLoginBox.setAlignment(Pos.CENTER);
        userLoginBox.getChildren().addAll(logoView,userNameHBox,passwordHBox,serverHbox,databaseHBox,testConnectionBtn);
        root.setCenter(userLoginBox);
        Database.getInstance();
        Scene scene = new Scene(root, 500, 500);
        stage.setTitle("BudgetWise");
        stage.setScene(scene);
        stage.show();


    }

    public void saveUserInfo(String db_name, String db_pass ,String dblocation, String dbuser) throws IOException {
      String info="info.txt";
      FileWriter myWriter=new FileWriter(info);
      myWriter.write(db_name+"\n");
      myWriter.write(db_pass+"\n");
      myWriter.write(dblocation+"\n");
      myWriter.write(dbuser);

      myWriter.close();
    }
    public boolean validCredentials(String dbName, String dbpass, String dblocation, String dbuser){
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


    public void checkInfoExist(){
      File info=new File("Info.txt");
      Login login=new Login();
      if(info.exists()){
        //showHomePage
      }
    }


    public static void main(String[] args) {
        launch();
    }
}