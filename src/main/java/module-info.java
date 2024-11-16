module org.example {
    requires javafx.controls;
    requires javafx.fxml;
    requires jdk.compiler;
    requires java.desktop;

    opens org.example to javafx.fxml;
    exports org.example;
}
