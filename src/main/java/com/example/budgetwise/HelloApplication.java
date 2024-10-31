package com.example.budgetwise;

import com.example.budgetwise.database.Database;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
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
        Label databaseLabel = new Label("Database Connection");
        TextField databaseTextField = new TextField();
        databaseHBox.getChildren().addAll(databaseLabel,databaseTextField);


        Button testConnectionBtn = new Button("Test Connection");

        userLoginBox.getChildren().addAll(userNameHBox,passwordHBox,serverHbox,databaseHBox,testConnectionBtn);

        root.setCenter(userLoginBox);
        Database.getInstance();
        Scene scene = new Scene(root, 320, 240);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();


    }

    public static void main(String[] args) {
        launch();
    }
}