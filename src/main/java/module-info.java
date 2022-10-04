module com.example.zad {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.zad to javafx.fxml;
    exports com.example.zad;
}