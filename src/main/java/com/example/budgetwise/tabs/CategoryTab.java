package com.example.budgetwise.tabs;

import com.example.budgetwise.models.Category;
import com.example.budgetwise.tables.CategoryTable;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

/**
 * This class allows the user to add a category
 */
public class CategoryTab extends Tab {

    public CategoryTab() {
        this.setText("Add Category");

        /**
         * Create GridPane and set padding, gaps, and styles
         */
        GridPane root = new GridPane();
        root.setPadding(new Insets(10, 10, 10, 10));
        root.setVgap(10);
        root.setHgap(10);
        root.getStyleClass().add("tab-background");


        /**
         * Create and add label
         */
        Label nameLabel = new Label("Category Name:");
        nameLabel.getStyleClass().add("label-style");

        root.add(nameLabel, 0, 0);

        /**
         * Create and add text field
         */
        TextField nameField = new TextField();
        nameField.getStyleClass().add("textfield-style");

        nameField.setPrefWidth(150);
        root.add(nameField, 1, 0);

        /**
         * Create and add button
         */
        Button addCategoryBtn = new Button("Add category");
        addCategoryBtn.getStyleClass().add("button-style");


        root.add(addCategoryBtn, 1, 2);

        /**
         * Attach CSS file to the GridPane
         */

        String css = getClass().getResource("/styles.css").toExternalForm();
        root.getStylesheets().add(css); // Ensure this line is executed


        /**
         * Error and success are for form validation
         */
        Text error = new Text("Please fill all fields");
        error.setFill(Color.rgb(255,0,0,0));
        root.add(error,2,3);


        Text success = new Text("Category successfully created");
        success.setFill(Color.rgb(0,255,0,0));

        root.add(success,2,3);

        this.setOnSelectionChanged(event -> {
            error.setFill(Color.rgb(255,0,0,0));

            success.setFill(Color.rgb(0,255,0,0));

        });

        this.setContent(root);

        /**
         * Button action handler
         */
        addCategoryBtn.setOnAction(event -> {
            String categoryName = nameField.getText();
            if (categoryName.length()>=1){
                Category newCategory = new Category(0, categoryName);
                CategoryTable.getInstance().addCategory(newCategory);
                System.out.println("Added new Category: " + newCategory);
                success.setFill(Color.rgb(0,255,0,1));
                error.setFill(Color.rgb(255,0,0,0));
                AddTransactionTab.getInstance().refresh();
            }else{
                error.setFill(Color.rgb(255,0,0,1));
                success.setFill(Color.rgb(0,255,0,0));



            }

        });
    }
}
