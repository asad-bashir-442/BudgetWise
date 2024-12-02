module com.example.budgetwise {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;



    opens com.example.budgetwise to javafx.fxml;
    exports com.example.budgetwise;
    exports com.example.budgetwise.pages;
    opens com.example.budgetwise.pages to javafx.fxml;
}