package org.example;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Circle;

public class AccountSceneController {

    public Label FirstLabel;
    public Label SecondLabel;
    public Label ThirdLabel;

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
        if(LoginSceneController.username.equals("")){
            FirstLabel.setText("Please log in!");
            SecondLabel.setText("");
            ThirdLabel.setText("");
        }
        else
        {
            FirstLabel.setText("Name: " + LoginSceneController.name);
            SecondLabel.setText("");
            ThirdLabel.setText("");
        }
    }
}
