package org.example;

import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Circle;

public class AccountSceneController {

    @FXML
    public void SignOut(MouseEvent mouseEvent) {
        MainSceneController mainController = (MainSceneController) App.getCurrentController();
        if (mainController != null) {
            mainController.updateButtonsAfterLogin();
        }
    }

    public void PersonalData(MouseEvent mouseEvent) {
    }

    public void showRentals(MouseEvent mouseEvent) {
    }

    public void nameOfPerson(MouseEvent mouseEvent) {
    }
}
