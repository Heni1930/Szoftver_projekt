package org.example;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class SignUpSceneController {


    @FXML
    private TextField EmailAdressTextField;

    @FXML
    private TextField NameTextField;

    @FXML
    private PasswordField Password;

    @FXML
    private Button SignUpBt;

    @FXML
    private TextField SurameTextField;

    @FXML
    private TextField UsernameTextField;

    @FXML
    private ComboBox<Faculties> faculty;

    @FXML
    public void initialize() {
        ObservableList<Faculties> facultyList = FXCollections.observableArrayList(Faculties.values());
        faculty.setItems(facultyList);
    }

    public Customer signUp(ActionEvent actionEvent){


        String EmailAddress = EmailAdressTextField.getText();
        String Name = NameTextField.getText();
        String Psswrd = Password.getText();
        String Surname = SurameTextField.getText();
        String Username = UsernameTextField.getText();
        String Faculty = faculty.getValue().toString();
        if (EmailAddress.isEmpty() || Name.isEmpty() || Psswrd.isEmpty() || Surname.isEmpty() || Username.isEmpty() || Faculty.isEmpty()) {
            System.out.println("Minden mezőt ki kell tölteni!"); //Üzenetkiíró részt csinálni !!!
            return null;
        }
        else
        {
            Customer customer = new Customer(Name, Psswrd, Username, EmailAddress, Faculties.valueOf(Faculty));
            //CustomerUtils.saveCustomer(customer);
            return customer;
        }

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
}


