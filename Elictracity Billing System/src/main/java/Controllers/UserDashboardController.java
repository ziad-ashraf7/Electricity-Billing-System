package Controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import ziad.elictracitybillingsystem.HelloApplication;

import java.io.IOException;

public class UserDashboardController{
    @FXML
    private VBox addUsrCon;

    @FXML
    private VBox delUsrCon;

    @FXML
    private VBox editUsrCon;

    @FXML
    void showAddUser(MouseEvent event) throws IOException {
        Stage stage = new Stage();
        stage.setTitle("Add User");

        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getClass().getResource("test.fxml"));
        Scene scene = new Scene(FXMLLoader.load(HelloApplication.class.getResource("AddUser.fxml")));
        stage.setScene(scene);
        stage.show();


    }

    @FXML
    void showDelUser(MouseEvent event) {

    }

    @FXML
    void showEditeUsr(MouseEvent event) {

    }
}
