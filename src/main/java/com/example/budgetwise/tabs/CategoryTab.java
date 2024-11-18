package com.example.budgetwise.tabs;

import javafx.geometry.Insets;
import javafx.scene.control.Tab;
import javafx.scene.layout.GridPane;

public class CategoryTab extends Tab {

    public CategoryTab(){
        this.setText("Category ");

        GridPane root = new GridPane();

        root.setPadding(new Insets(10,10,10,10));
        root.setVgap(10);
        root.setHgap(10);
    }

}
