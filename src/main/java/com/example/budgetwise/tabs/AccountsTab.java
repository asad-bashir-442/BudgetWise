package com.example.budgetwise.tabs;

import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.layout.GridPane;

public class AccountsTab extends Tab {
    public AccountsTab(){
        this.setText("Accounts");
        Button addNew=new Button("Add Account +");
        GridPane root=new GridPane();
        root.add(addNew,0,1);
        this.setContent(root);

        //set event on button
        addNew.setOnAction(e->{

        });

    }
}
