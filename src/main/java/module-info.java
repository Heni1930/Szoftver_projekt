module org.example {
    requires javafx.controls;
    requires javafx.fxml;
    requires jdk.compiler;

    opens org.example to javafx.fxml;
    exports org.example;
}
