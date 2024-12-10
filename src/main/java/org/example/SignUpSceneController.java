package org.example;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class SignUpSceneController {

    @FXML
    private TextField EmailAddressTextField;

    @FXML
    private TextField NameTextField;

    @FXML
    private PasswordField Password;

    @FXML
    private Button SignUpB;

    @FXML
    private TextField SureNameTextField;

    @FXML
    private TextField UsernameTextField;

    @FXML
    private ComboBox<Faculties> faculty;

    @FXML
    public void initialize() {
        ObservableList<Faculties> facultyList = FXCollections.observableArrayList(Faculties.values());
        faculty.setItems(facultyList);
    }

    public void LoginButton(ActionEvent actionEvent) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMLLoginScene.fxml"));
            Parent root = loader.load();
            Stage currentStage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            Scene signUpScene = new Scene(root);
            currentStage.setScene(signUpScene);
            currentStage.setTitle("Login");
            currentStage.centerOnScreen();
            currentStage.setResizable(false);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void signUp(ActionEvent actionEvent) {
     try {
            String EmailAddress = EmailAddressTextField.getText();
            String Name = NameTextField.getText();
            String Psswrd = Password.getText();
            String Surname = SureNameTextField.getText();
            String Username = UsernameTextField.getText();
            Faculties Faculty = faculty.getValue();
            String fullName = Name + " " + Surname;

            if (EmailAddress.isEmpty() || Name.isEmpty() || Psswrd.isEmpty() || Surname.isEmpty() || Username.isEmpty() || Faculty == null) {
                System.out.println("Minden mezőt ki kell tölteni!");
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Hiba");
                alert.setHeaderText("All fields must be filled out!");
                alert.showAndWait();
            }
            else {
                if(JPACustomerDAO.isEmailExist(EmailAddress) > 0) {
                    System.out.println("This email address is already taken");
                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setTitle("Hiba");
                    alert.setHeaderText("This email address is already taken");
                    alert.showAndWait();
                }
                else if (JPACustomerDAO.isUsernameExist(Username) > 0) {
                    System.out.println("This username is already taken");
                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setTitle("Hiba");
                    alert.setHeaderText("This username is already taken");
                    alert.showAndWait();
                }
                else {
                    Customer customer = new Customer(Username, Psswrd, fullName, EmailAddress, Faculty);
                    CustomerUtils.saveCustomer(customer);
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Success");
                    alert.setHeaderText("Registration is complete!");
                    alert.showAndWait();
                    LoginButton(actionEvent);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}



