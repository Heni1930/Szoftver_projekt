package org.example;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.text.Text;
import lombok.Getter;
import lombok.Setter;

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

    public void setDate(String db) {
        this.date.setText(db);
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

}
