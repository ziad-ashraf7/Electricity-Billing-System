package Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import ziad.elictracitybillingsystem.HelloApplication;

import java.io.IOException;
import java.util.Objects;

public class CollectPaymentsController {
    public void goBack(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) Stage.getWindows().getFirst();
        Parent root = FXMLLoader.load(HelloApplication.class.getResource("OperatorView.fxml"));
        stage.setScene(new Scene(root));
    }
}
