module org.example {
    requires javafx.controls;
    requires javafx.fxml;
    requires jakarta.persistence;
    requires jakarta.validation;
    requires spring.data.commons;

    opens org.example to javafx.fxml;
    exports org.example;
    exports org.example.model;
    opens org.example.model to javafx.fxml;
}
