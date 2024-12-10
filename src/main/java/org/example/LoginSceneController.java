package org.example;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginSceneController {

    @FXML
    private PasswordField LoginPasswordField;

    @FXML
    private TextField LoginUsernamefield;

    public void login(ActionEvent actionEvent) {
        String username = LoginUsernamefield.getText();
        String password = LoginPasswordField.getText();

        Customer customer = JPACustomerDAO.login(username, password);

        if (customer != null) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Login success");
            alert.setHeaderText(null);
            alert.setContentText("The logged-in user is " + customer.getName() + ".");
            alert.showAndWait();

            Stage stage = (Stage) LoginPasswordField.getScene().getWindow();
            stage.close();

            System.out.println(customer);
        }
        else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Login error");
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
