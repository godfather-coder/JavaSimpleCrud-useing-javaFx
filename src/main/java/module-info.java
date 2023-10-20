module com.example.fxfx {
    requires javafx.controls;
    requires javafx.fxml;
    requires lombok;
    requires java.sql;


    opens com.example.fxfx to javafx.fxml;
    exports com.example.fxfx;
}