module org.example {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.persistence;
    requires com.sun.istack.runtime;
    requires java.sql;
    requires com.h2database;
    requires org.hibernate.orm.core;

//    requires jakarta.persistence;
//    requires jakarta.validation;
//    requires spring.data.commons;
//    requires static lombok;
//    requires com.h2database;

    opens org.example to javafx.fxml, org.hibernate.orm.core;
    exports org.example;
}
