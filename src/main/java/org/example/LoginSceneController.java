package org.example;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginSceneController {

    @FXML
    private PasswordField LoginPasswordField;

    @FXML
    private TextField LoginUsernamefield;

    public static String username = "";
    public static String password = "";
    public static String name = "";

    public void login(ActionEvent actionEvent) {
        username = LoginUsernamefield.getText();
        password = LoginPasswordField.getText();

        Customer customer = JPACustomerDAO.login(username, password);

        if (customer != null) {

            MainSceneController.LoginSceneOff();
            name = customer.getName();

            try {
                App.changeScene("FXMLMainScene");
                MainSceneController mainController = (MainSceneController) App.getCurrentController();
                if (mainController != null) {
                    mainController.setPersonName(name);
                    mainController.updateButtonsAfterLogin();
                }
            } catch (IOException e) {
                e.printStackTrace();
                Alert errorAlert = new Alert(Alert.AlertType.ERROR);
                errorAlert.setTitle("Scene Change Error");
                errorAlert.setHeaderText(null);
                errorAlert.setContentText("Could not switch to main scene.");
                errorAlert.showAndWait();
            }

        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Login Error");
            alert.setHeaderText(null);
            alert.setContentText("Invalid username or password!");
            alert.showAndWait();
        }
    }

    public void SignupButton(ActionEvent actionEvent) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMLSignUpScene.fxml"));
            Parent root = loader.load();
            Stage currentStage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            Scene SignUPScene = new Scene(root);
            currentStage.setScene(SignUPScene);
            currentStage.setTitle("Sign Up");
            currentStage.centerOnScreen();
            currentStage.setResizable(false);
            currentStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
