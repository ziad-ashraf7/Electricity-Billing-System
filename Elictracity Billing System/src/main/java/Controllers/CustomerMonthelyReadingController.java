package Controllers;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import ziad.elictracitybillingsystem.HelloApplication;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Scanner;

public class CustomerMonthelyReadingController implements Initializable {
    @FXML
    private Button addNew;

    @FXML
    private TableView<String[]> billTble;

    @FXML
    private TableColumn<String[], String> id;

    @FXML
    private TableColumn<String[], String> reading;

    @FXML
    private TableColumn<String[], String> meterCode;

    @FXML
    private TableColumn<String[], String> date;
//    @FXML
//    private VBox BillsCon;
//
//    @FXML
//    private ImageView billImg;
//    @FXML
//    private Text billTxt;
//    @FXML
//    private VBox mounthlyRadingCon;
//
//    @FXML
//    private ImageView mRadingImg;
//
//    @FXML
//    private Text mReadingTxt;
//
//    List<VBox> containers = new ArrayList<>();

    private void showPopup() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("AddReadingPopup.fxml"));
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
        addNew.setOnAction(event->{
            try {
                showPopup();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
        id.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue()[0]));
        reading.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue()[1]));
        meterCode.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue()[2]));
        date.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue()[3]));

        ObservableList<String[]> data = FXCollections.observableArrayList();

        Scanner fscanner = new Scanner(System.in);
        String[] compRecord = new String[0];
        try {
            fscanner = new Scanner(new File(String.valueOf(Paths.get("data\\readings.csv"))));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        while(fscanner.hasNext()){
            String tmp = fscanner.next();
            compRecord = tmp.split(",");
            String[] x = {compRecord[0], compRecord[4], compRecord[2], compRecord[3]};
            data.add(x);
        }
        billTble.setItems(data);
    }
}
