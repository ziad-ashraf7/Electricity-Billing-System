package ziad.elictracitybillingsystem;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Admin-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        scene.getStylesheets().add(getClass().getResource("/Styles/Admin-view.css").toExternalForm());
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.setResizable(true);


        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}