package org.example;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.h2.tools.Server;
import javafx.application.Platform;

import java.io.IOException;
import java.sql.SQLException;

/**
 * JavaFX  App
 */
public class App extends Application {

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("FXMLMainScene"));
        stage.setScene(scene);
        stage.show();
        stage.setResizable(false);

        stage.setOnCloseRequest(event->{
            Platform.exit();
            System.exit(0);
        });
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    public static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    private static void startDatabase() throws SQLException {
        new Server().runTool("-tcp", "-web", "-ifNotExists");
    }

    public static void main(String[] args) throws SQLException {
        startDatabase();
        launch();


//        CustomerUtils cUtils = new CustomerUtils(new JPACustomerDAO());
//        cUtils.runUtils();

    }



}