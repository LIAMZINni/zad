module com.example.zad {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.zad to javafx.fxml;
    opens com.example.zad.domen to javafx.base;

    exports com.example.zad;
}