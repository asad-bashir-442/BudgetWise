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

    public CategoryTab() {
        this.setText("Add Category");

        // Create GridPane and set padding, gaps, and styles
        GridPane root = new GridPane();
        root.setPadding(new Insets(10, 10, 10, 10));
        root.setVgap(10);
        root.setHgap(10);
        root.getStyleClass().add("tab-background");



        // Create and add label
        Label nameLabel = new Label("Category Name:");
        nameLabel.getStyleClass().add("label-style");

        root.add(nameLabel, 0, 0);

        // Create and add text field
        TextField nameField = new TextField();
        nameField.getStyleClass().add("textfield-style");

        nameField.setPrefWidth(150);
        root.add(nameField, 1, 0);

        // Create and add button
        Button button = new Button("Add category");
        button.getStyleClass().add("button-style");


        root.add(button, 1, 2);

        // Attach CSS file to the GridPane

        String css = getClass().getResource("/styles.css").toExternalForm();
        root.getStylesheets().add(css); // Ensure this line is executed


        this.setContent(root);

        // Button action handler
        button.setOnAction(event -> {
            String categoryName = nameField.getText();
            Category newCategory = new Category(0, categoryName);
            CategoryTable.getInstance().addCategory(newCategory);
            System.out.println("Added new Category: " + newCategory);
        });
    }
}
