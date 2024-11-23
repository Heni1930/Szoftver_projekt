package org.example;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

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
    public void SignupButton(ActionEvent actionEvent) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMLSignUpScene.fxml"));
            Parent root = loader.load();
            Stage currentStage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            Scene signUpScene = new Scene(root);
            currentStage.setScene(signUpScene);
            currentStage.setTitle("Sign Up");
            currentStage.centerOnScreen();
            currentStage.setResizable(false);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
