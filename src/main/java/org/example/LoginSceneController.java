package org.example;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginSceneController {

    @FXML
    private Button LoginBt;

    @FXML
    private PasswordField LoginPasswordField;

    @FXML
    private TextField LoginUsernamefield;

    public void login(ActionEvent actionEvent) {
        String LoginUsername = LoginUsernamefield.getText();
        String LoginPassword = LoginPasswordField.getText();

        System.out.println("Usename: " + LoginUsername);
        System.out.println("Password: " + LoginPassword);
    }
}
