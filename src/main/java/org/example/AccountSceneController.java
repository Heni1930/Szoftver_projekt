package org.example;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class AccountSceneController {

    @FXML
    public Label FirstLabel;

    @FXML
    public Label SecondLabel;

    @FXML
    public Label ThirdLabel;

    @FXML
    public Button SignUpOrInB;

    @FXML
    public ImageView persImage;

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
        else if(JPARentalDAO.isRentalExist(LoginSceneController.username).equals("Not Exist"))
        {
            FirstLabel.setText("You don't have any rental yet");
            SecondLabel.setText("");
            ThirdLabel.setText("");
        }
        else
        {
            FirstLabel.setText(JPARentalDAO.findProduct(LoginSceneController.username));
            SecondLabel.setText("Date to return product:");
            String[] Date = JPARentalDAO.findDate().toString().split(" ");
            ThirdLabel.setText(Date[0]);
            String picURL = MainSceneController.getPic(FirstLabel.getText());
            System.out.println(FirstLabel.getText());
            Image image = new Image(picURL);
            persImage.setImage(image);
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
