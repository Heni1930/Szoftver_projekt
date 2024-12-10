package org.example;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import lombok.Getter;
import lombok.Setter;

import java.io.IOException;
import java.time.LocalDate;
import java.time.Period;


@Getter
public class RentSceneController {

    @FXML
    private Label date;

    @FXML
    private Text description;

    @Setter
    @FXML
    private Label db;

    public void setDescription(String description) {
        this.description.setText(description);
    }

    public void setDb(String db) {
        this.db.setText(db);
    }

    public void setDate(String date) {
        this.date.setText(date);
    }

    public void desc(String id) {
        Product pro = MainSceneController.products.get(Integer.parseInt(id) - 1);
        System.out.println(pro);
        System.out.println(pro.getDescription());
        System.out.println("" + pro.getQuantity());
        setDescription(pro.getDescription());
    }

    public void quantity(String id) {
        Product pro = MainSceneController.products.get(Integer.parseInt(id) - 1);
        setDb("" + pro.getQuantity());
    }

    public void dateSet(String id) {
        Product pro = MainSceneController.products.get(Integer.parseInt(id) - 1);
        LocalDate today = LocalDate.now();
        LocalDate futureDate = today.plus(Period.ofWeeks(4));
        setDate("" + futureDate);
    }

    public void userRent(ActionEvent actionEvent) {
        if(LoginSceneController.username.equals(""))
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
        else
        {
            MainSceneController.RentSceneOff();
        }
    }
}
