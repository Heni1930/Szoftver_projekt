package org.example;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import lombok.Getter;

import java.io.IOException;
import java.util.List;


public class MainSceneController{

    public static List<Product> products;

    @FXML
    private Text circleText;

    @Getter
    @FXML
    private Text personName;

    @FXML
    private BorderPane borderPane;

    @FXML
    private StackPane rootPane;

    @FXML
    private Button loginB;

    @FXML
    private Button SignUpB;

    @FXML
    private Circle nameCircle;

    private static Stage loginStage;

    private static Stage AccountStage;

    private String letter = "";

    @FXML
    private Button InformaticsBTN;
    @FXML
    private Button MedicineBTN;
    @FXML
    private Button musicBTN;

    @FXML
    private RentSceneController rentSceneController;

    public static String rid;

    @FXML
    private Pane  Pane0,Pane1,Pane2,Pane3,Pane4,Pane5,Pane6;


    public void setPersonName(String name) {
        if (personName != null) {
            personName.setText(name);
        }
    }

    public String getSignUpButtonText() {
        return SignUpB.getText();
    }


    @FXML
    void LoginButton(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMLLoginScene.fxml"));
            Parent root = loader.load();
            loginStage = new Stage();
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
    public static void LoginSceneOff()
    {
        if (loginStage != null) {
            loginStage.close();
        }
    }
    @FXML
    void SignupButton(ActionEvent event) {
        String buttonText = getSignUpButtonText();
        System.out.println("Current button text: " + buttonText);
        if (getSignUpButtonText().equals("Sign Up")) {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMLSignUpScene.fxml"));
                Parent root = loader.load();
                loginStage = new Stage();
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
        else if (getSignUpButtonText().equals("Log Out"))
        {
            updateButtonsAfterLogout();
            personName.setText("");
            LoginSceneController.name = "";
            LoginSceneController.password = "";
            LoginSceneController.username = "";
        }
    }

    public void rentButton(ActionEvent actionEvent) {
            try {
                Button c = (Button) actionEvent.getSource();
                String rid = c.getId();
                System.out.println("Button ID: " + rid);
                FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMLRentScene.fxml"));
                Parent root = loader.load();
                RentSceneController rentSceneController = loader.getController();
                rentSceneController.desc(rid);
                rentSceneController.quantity(rid);
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
            AccountStage = new Stage();
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

    public void updateButtonsAfterLogin() {
        loginB.setVisible(false);
        SignUpB.setText("Log Out");
    }

    public void updateButtonsAfterLogout() {
        loginB.setVisible(true);
        SignUpB.setText("Sign Up");
    }

    public Text getPersonName() {
        return personName;
    }

    @FXML
    public static void PersonalSceneOff()
    {
        if(AccountStage != null)
        {
            AccountStage.close();
        }
    }
}