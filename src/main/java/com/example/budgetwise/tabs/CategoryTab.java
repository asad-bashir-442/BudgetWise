package com.example.budgetwise.tabs;

import com.example.budgetwise.models.Category;
import com.example.budgetwise.tables.CategoryTable;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class CategoryTab extends Tab {

    public CategoryTab(){
        this.setText(" Add Category ");

        GridPane root = new GridPane();

        root.setPadding(new Insets(10,10,10,10));
        root.setVgap(10);
        root.setHgap(10);
        root.getStyleClass().add("tab-background");


        Label nameLabel = new Label("Category Name:");
        nameLabel.getStyleClass().add("label-style");
        TextField nameField = new TextField();
        nameField.getStyleClass().add("textfield-style");
        nameField.setPrefWidth(150);
        root.add(nameLabel,0,0);
        root.add(nameField,1,0);

        Button button = new Button("Add category");
        button.getStyleClass().add("button-style");
        root.add(button,1,2);

        String css = getClass().getResource("/styles.css").toExternalForm();
        root.getStylesheets().add(css);

        this.setContent(root);
        button.setOnAction(event ->{
            String categoryName = nameField.getText();
            Category newCategory = new Category(0, categoryName);
            CategoryTable.getInstance().addCategory(newCategory);
            System.out.println("Added new Category: " + newCategory);
        });
    }

}
