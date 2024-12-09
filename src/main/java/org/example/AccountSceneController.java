package org.example;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Circle;

public class AccountSceneController {

    @FXML
    public void SignOut(ActionEvent actionEvent) {
        MainSceneController.PersonalSceneOff();
        MainSceneController mainController = (MainSceneController) App.getCurrentController();
        if (mainController != null) {
            mainController.updateButtonsAfterLogin();
            mainController.updateButtonsAfterLogout();
            mainController.getPersonName().setText("");
            LoginSceneController.name = "";
            LoginSceneController.password = "";
            LoginSceneController.username = "";
        }
    }

    @FXML
    public void PersonalData(ActionEvent actionEvent) {
    }

    @FXML
    public void showRentals(ActionEvent actionEvent) {
    }

    @FXML
    public void nameOfPerson(ActionEvent actionEvent) {
    }
}
