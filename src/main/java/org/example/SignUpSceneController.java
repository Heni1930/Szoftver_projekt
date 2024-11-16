package org.example;

import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import javax.swing.*;

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

    public void signUp(ActionEvent actionEvent){

        String EmailAddress = EmailAdressTextField.getText();
        String Name = NameTextField.getText();
        String Psswrd = Password.getText();
        String Surname = SurameTextField.getText();
        String Username = UsernameTextField.getText();
        String Faculty = faculty.getValue().toString();
        if (EmailAddress.isEmpty() || Name.isEmpty() || Psswrd.isEmpty() || Surname.isEmpty() || Username.isEmpty() || Faculty.isEmpty()) {
            System.out.println("Minden mezőt ki kell tölteni!"); //Üzenetkiíró részt csinálni !!!
            return;
        }
        else{
            //fejlesztés alatt
        }

        //Még egyenlőre kiíratva
        System.out.println("Email: " + EmailAddress);
        System.out.println("Név: " + Surname + " " + Name);
        System.out.println("Felhasználónév: " + Username);
        System.out.println("Jelszó: " + Psswrd);
        System.out.println("Kar: " + Faculty);

    }

}


