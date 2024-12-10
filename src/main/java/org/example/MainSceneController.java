package org.example;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;


public class MainSceneController{

    private List<Product> products;



    @FXML
    private BorderPane borderPane;

    @FXML
    private Button InformaticsBTN;
    @FXML
    private Button MedicineBTN;
    @FXML
    private Button musicBTN;

    @FXML
    private Pane  Pane0,Pane1,Pane2,Pane3,Pane4,Pane5,Pane6;






    @FXML
    private static Button SignUpB;

    @FXML
    private static Button loginB;



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
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public static void switchButtonLogin()
    {
        loginB.setVisible(false);
        SignUpB.setText("Log out");
    }

    @FXML
    public static void switchButtonLogout()
    {
        loginB.setVisible(true);
        SignUpB.setText("Sign Up");
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
        } catch (IOException e) {
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
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void switchToInf(ActionEvent event) {
        populateProducts(Faculties.INFORMATICS);
    }

    @FXML
    void switchToMed(ActionEvent event) {
        populateProducts(Faculties.MEDICINE);
    }

    @FXML
    void switchToMusic(ActionEvent event) {
        populateProducts(Faculties.MUSIC);

    }

    public void PersonalAccount(MouseEvent mouseEvent) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMLPersonalAccount.fxml"));
            Parent root = loader.load();
            Stage AccountStage = new Stage();
            AccountStage.setTitle("Personal Account");
            AccountStage.setScene(new Scene(root));
            AccountStage.initModality(Modality.APPLICATION_MODAL);
            AccountStage.initOwner(((Stage) ((Node) mouseEvent.getSource()).getScene().getWindow()));
            AccountStage.setResizable(false);
            AccountStage.showAndWait();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void initialize() {

        populateProducts(Faculties.INFORMATICS);
    }

    private void populateProducts(Faculties faculty) {
        products = JPAProductDAO.findProductsByFaculty(faculty);
        int i = 0;
        Pane p = pane(products.size());
        GridPane gridPane = (GridPane) p.getChildren().get(0);

        for (Product product : products) {
            Node ap = gridPane.getChildren().get(i);
            ImageView imageView = (ImageView) ap.lookup("#imageView");
            Label itemNameLabel = (Label) ap.lookup("#itemNameLabel");
            Label itemQLabel = (Label) ap.lookup("#itemQLabel");
            itemNameLabel.setText(product.getName());
            itemQLabel.setText(String.valueOf(product.getQuantity()));

            itemNameLabel.setText(product.getName());
            itemQLabel.setText(String.valueOf(product.getQuantity()));
            i++;
        }
        setPanesVisibility(false,Pane0,Pane1,Pane2,Pane3,Pane4,Pane5,Pane6);
        p.setVisible(true);
    }

    public Pane pane (int num){
        switch (num){
            case 1: return Pane1;
            case 2: return Pane2;
            case 3: return Pane3;
            case 4: return Pane4;
            case 5: return Pane5;
            case 6: return Pane6;
            default: return Pane0;
        }
    }

    public static void setPanesVisibility(boolean visibility, Pane... panes) {
        for (Pane pane : panes) {
            pane.setVisible(visibility);
        }
    }
}