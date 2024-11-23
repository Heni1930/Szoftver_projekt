package org.example;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;


public class MainSceneController {

    @FXML
    private StackPane rootPane;

    @FXML
    void LoginButton(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMLLoginScene.fxml"));
            Parent root = loader.load();
            Stage loginStage = new Stage();
            loginStage.setTitle("Login");
            loginStage.setScene(new Scene(root));
            loginStage.initModality(Modality.APPLICATION_MODAL);
            loginStage.initOwner(((Stage) ((Node) event.getSource()).getScene().getWindow()));
            loginStage.setResizable(false);
            loginStage.showAndWait();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    @FXML
    void SignupButton(ActionEvent event) {

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMLSignUpScene.fxml"));
            Parent root = loader.load();
            Stage loginStage = new Stage();
            loginStage.setTitle("Sign Up");
            loginStage.setScene(new Scene(root));
            loginStage.initModality(Modality.APPLICATION_MODAL);
            loginStage.initOwner(((Stage) ((Node) event.getSource()).getScene().getWindow()));
            loginStage.setResizable(false);
            loginStage.showAndWait();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public void rentButton(ActionEvent actionEvent) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMLRentScene.fxml"));
            Parent root = loader.load();
            Stage loginStage = new Stage();
            loginStage.setTitle("Rental");
            loginStage.setScene(new Scene(root));
            loginStage.initModality(Modality.APPLICATION_MODAL);
            loginStage.initOwner(((Stage) ((Node) actionEvent.getSource()).getScene().getWindow()));
            loginStage.setResizable(false);
            loginStage.showAndWait();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
