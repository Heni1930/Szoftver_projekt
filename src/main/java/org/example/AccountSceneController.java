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

    public void noLogin()
    {
        FirstLabel.setText("Please log in!");
        SecondLabel.setText("");
        ThirdLabel.setText("");

    }

    @FXML
    public void PersonalData(ActionEvent actionEvent) {
        if(LoginSceneController.username.equals("")){
            noLogin();
        }
    }

    @FXML
    public void showRentals(ActionEvent actionEvent) {
        if(LoginSceneController.username.equals("")){
            noLogin();
        }
    }

    @FXML
    public void nameOfPerson(ActionEvent actionEvent) {
        if(LoginSceneController.username.equals("")){
            noLogin();
        }
        else
        {
            FirstLabel.setText("Name: " + LoginSceneController.name);
            SecondLabel.setText("");
            ThirdLabel.setText("");
        }
    }
}
