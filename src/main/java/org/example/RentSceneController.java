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

import javax.persistence.EntityManager;
import java.io.IOException;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.List;


@Getter
public class RentSceneController {

    int ButtonID = Integer.parseInt(MainSceneController.rid);
    Product pro = MainSceneController.products.get(ButtonID);
    @FXML
    private Label date;

    @FXML
    private Text description;

    @Setter
    @FXML
    private Label db;

//    RentalDAO rentalDAO = new JPARentalDAO();
//    public RentSceneController() {
//        RentalUtils.initialize(rentalDAO);
//    }

    public void setDescription(String description) {
        this.description.setText(description);
    }

    public void setDb(String db) {
        this.db.setText(db);
    }

    public void setDate(String date) {
        this.date.setText(date);
    }

    public void desc() {

        System.out.println(pro);
        System.out.println(pro.getDescription());
        System.out.println("" + pro.getQuantity());
        setDescription(pro.getDescription());
    }

    public void quantity() {
        setDb("" + pro.getQuantity());
    }

    public void dateSet() {
        LocalDate today = LocalDate.now();
        LocalDate futureDate = today.plus(Period.ofWeeks(4));
        setDate("" + futureDate);
    }

    public Date getFormattedDate()
    {
        // Aktuális dátum és idő lekérése
        LocalDateTime now = LocalDateTime.now();

        // Formátum beállítása (pl. yyyy-MM-dd HH:mm:ss)
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        // LocalDateTime átalakítása Date típusra
        return Date.from(now.atZone(ZoneId.systemDefault()).toInstant());
    }

    public Date getFormattedDatePlusFourWeeks() {
        // Aktuális dátum és idő lekérése
        LocalDateTime now = LocalDateTime.now();

        // 4 héttel későbbi dátum és idő lekérése
        LocalDateTime futureDateTime = now.plusWeeks(4);

        // Formátum beállítása (pl. yyyy-MM-dd HH:mm:ss)
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        // LocalDateTime átalakítása Date típusra
        return Date.from(futureDateTime.atZone(ZoneId.systemDefault()).toInstant());
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
            //
            Product product = JPAProductDAO.fProductById(pro.getId());
            Customer customer = JPACustomerDAO.findCustomerByUsername(LoginSceneController.username);
            Date rentalDate = getFormattedDate();
            Date returnDate = getFormattedDatePlusFourWeeks();

            if (customer != null && product != null) {
                customer = JPACustomerDAO.mergeCustomer(customer);
                product = JPAProductDAO.mergeProduct(product);
            }

            Rental rental = new Rental();
            rental.setCustomerId(customer);
            rental.setProductId(product);
            rental.setRentalDate(rentalDate);
            rental.setReturnDate(returnDate);



            RentalUtils.SaveRental(rental);

            MainSceneController.RentSceneOff();
        }
    }
}
