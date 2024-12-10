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
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class SignUpSceneController {

    public Text SignUpProblem;
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
                SignUpProblem.setText("All fields must be filled out!");
            }
            else {
                if(JPACustomerDAO.isEmailExist(EmailAddress) > 0) {
                    System.out.println("This email address is already taken");
                    SignUpProblem.setText("This email address is already taken");
                }
                else if (JPACustomerDAO.isUsernameExist(Username) > 0) {
                    System.out.println("This username is already taken");
                    SignUpProblem.setText("This username is already taken");
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


