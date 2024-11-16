module org.example {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires com.h2database;
    requires java.persistence;
    requires org.hibernate.orm.core;
    requires java.desktop;

    opens org.example to javafx.fxml;
    exports org.example;
}
