module com.example.laboratorio{
    requires javafx.controls;
    requires javafx.fxml;
    exports com.example.laboratorio;
    opens com.example.laboratorio to javafx.fxml;
    exports com.example.laboratorio.controllers;
    opens  com.example.laboratorio.controllers to javafx.fxml;
    exports com.example.laboratorio.model;
    opens com.example.laboratorio.model to javafx.base;
}