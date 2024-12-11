package org.example;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Circle;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class AccountSceneController {

    @FXML
    public Label FirstLabel;

    @FXML
    public Label SecondLabel;

    @FXML
    public Label ThirdLabel;

    @FXML
    public Button SignUpOrInB;

    public void initialize() {
        if(LoginSceneController.username.equals("")){
            noLogin();
            SignUpOrInB.setText("Log In");
        }
        else
        {
            FirstLabel.setText("Name: " + LoginSceneController.name);
            //SecondLabel.setText("Faculity: " + JPACustomerDAO.);
            SecondLabel.setText("");
            ThirdLabel.setText("");
            SignUpOrInB.setText("Log Out");
        }

    }

    @FXML
    public void SignOut(ActionEvent actionEvent) {
        if(SignUpOrInB.getText().equals("Log Out"))
        {
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
        else
        {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMLLoginScene.fxml"));
                Parent root = loader.load();
                Stage currentStage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
                Scene loginScene = new Scene(root);
                currentStage.setScene(loginScene);
                currentStage.setTitle("Login");
                currentStage.centerOnScreen();
                currentStage.setResizable(false);
                currentStage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
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
        else
        {
            FirstLabel.setText("Email: " + JPACustomerDAO.findEmailByUsername(LoginSceneController.username));
            //SecondLabel.setText("Faculity: " + JPACustomerDAO.);
            SecondLabel.setText("");
            ThirdLabel.setText("");
        }
    }

    @FXML
    public void showRentals(ActionEvent actionEvent) {
        if(LoginSceneController.username.equals("")){
            noLogin();
        }
        else
        {
            //FirstLabel.setText(JPARentalDAO.findProductNamesByUsername(LoginSceneController.username).toString());
            SecondLabel.setText("Date to return product:");
            ThirdLabel.setText("2024/12/12");
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
