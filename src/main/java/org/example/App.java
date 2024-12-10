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
import java.net.URL;

/**
 * JavaFX App with corrected FXML loading
 */
public class App extends Application {

    private static Stage primaryStage;
    private static Scene scene;
    private static Object currentController;

    @Override
    public void start(Stage stage) throws IOException {
        primaryStage = stage;
        URL loginFxmlUrl = getClass().getResource("/org/example/FXMLMainScene.fxml");
        FXMLLoader loader = new FXMLLoader(loginFxmlUrl);
        Parent root = loader.load();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Main");
        stage.show();
        stage.setResizable(false);
        stage.setOnCloseRequest(event -> {
            Platform.exit();
            System.exit(0);
        });
    }

    public static void changeScene(String fxml) throws IOException {
        URL fxmlUrl = App.class.getResource("/org/example/" + fxml + ".fxml");
        if (fxmlUrl == null) {
            throw new IOException("Cannot find " + fxml + ".fxml");
        }

        FXMLLoader fxmlLoader = new FXMLLoader(fxmlUrl);
        Parent root = fxmlLoader.load();
        currentController = fxmlLoader.getController();

        scene.setRoot(root);
        primaryStage.sizeToScene();
    }

    public static Object getCurrentController() {
        return currentController;
    }

    public static Parent loadFXML(String fxml) throws IOException {
        URL fxmlUrl = App.class.getResource("/org/example/" + fxml + ".fxml");
        FXMLLoader fxmlLoader = new FXMLLoader(fxmlUrl);
        return fxmlLoader.load();
    }

    private static void startDatabase() throws SQLException {
        new Server().runTool("-tcp", "-web", "-ifNotExists");
    }

    public static void main(String[] args) throws SQLException {
        startDatabase();
        launch();
    }
}