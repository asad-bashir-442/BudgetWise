module com.example.budgetwise {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.budgetwise to javafx.fxml;
    exports com.example.budgetwise;
}