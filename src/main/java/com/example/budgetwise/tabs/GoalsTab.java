package com.example.budgetwise.tabs;

import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.layout.GridPane;

public class GoalsTab extends Tab {
    public GoalsTab(){
        this.setText("Goals");
        Button addNew=new Button("Add Goal +");
        GridPane root=new GridPane();
        root.add(addNew,0,1);
        this.setContent(root);
        //set event on button
        addNew.setOnAction(e->{

        });
    }
}
