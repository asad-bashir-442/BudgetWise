module com.example.budgetwise {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires jfxrt;
    requires rt;


    opens com.example.budgetwise to javafx.fxml;
    exports com.example.budgetwise;
}