package Controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.beans.property.SimpleStringProperty;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import ziad.elictracitybillingsystem.HelloApplication;
import ziad.elictracitybillingsystem.UserUnitTesting;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Paths;
import java.util.ResourceBundle;
import java.util.Scanner;

public class CustomerBillsController implements Initializable {
    @FXML
    private Button complain;

    @FXML
    private TableView<String[]> billTble;

    @FXML
    private TableColumn<String[], String> billIdColumn;

    @FXML
    private TableColumn<String[], String> Cost;

    @FXML
    private TableColumn<String[], String> MeterCode;

    @FXML
    private TableColumn<String[], String> Date;

    private void showComplain() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("ComaplainPage.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.showAndWait();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        complain.setOnAction(event->{
            try {
                showComplain();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

        billIdColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue()[0]));
        Cost.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue()[1]));
        MeterCode.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue()[2]));
        Date.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue()[3]));

        // Add data to the TableView
        ObservableList<String[]> data = FXCollections.observableArrayList();

        Scanner fscanner = new Scanner(System.in);
        String[] compRecord = new String[0];
        try {
            fscanner = new Scanner(new File(String.valueOf(Paths.get("data\\bills.csv"))));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        while(fscanner.hasNext()){
            String tmp = fscanner.next();
            compRecord = tmp.split(",");
            String[] x = {compRecord[0], compRecord[3], compRecord[2], compRecord[4]};
            data.add(x);
        }

        billTble.setItems(data);
    }
}
