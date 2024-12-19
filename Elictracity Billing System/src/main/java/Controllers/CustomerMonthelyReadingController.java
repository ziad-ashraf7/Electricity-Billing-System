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

//    @FXML
//    private TableView<String[]> billTble;
//
//    @FXML
//    private TableColumn<String[], String> billIdColumn;
//
//    @FXML
//    private TableColumn<String[], String> Cost;
//
//    @FXML
//    private TableColumn<String[], String> MeterCode;
//
//    @FXML
//    private TableColumn<String[], String> Date;
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
//
//        billIdColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue()[0]));
//        Cost.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue()[1]));
//        MeterCode.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue()[2]));
//        Date.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue()[3]));
//
//        // Add data to the TableView
//        ObservableList<String[]> data = FXCollections.observableArrayList();
//
//        Scanner fscanner = new Scanner(System.in);
//        String[] compRecord = new String[0];
//        try {
//            fscanner = new Scanner(new File(String.valueOf(Paths.get("data\\bills.csv"))));
//        } catch (FileNotFoundException e) {
//            throw new RuntimeException(e);
//        }
//        while(fscanner.hasNext()){
//            String tmp = fscanner.next();
//            compRecord = tmp.split(",");
//            String[] x = {compRecord[0], compRecord[3], compRecord[2], compRecord[4]};
//            data.add(x);
//        }
//
//        billTble.setItems(data);
    }
//
//    public void showBills(MouseEvent mouseEvent) {
//
//    }
//
//    public void showMounthlyReadings(MouseEvent mouseEvent) {
//    }
//
//    private void HandelClick(ImageView imageView , Text text, String name){
//        // Deselecting the button
//        deSelect();
//
//        // Selecting the button
//        imageView.setImage(new Image(HelloApplication.class.getResourceAsStream("/Icons/" + name + "-selected.png")));
//        text.setFill(Color.rgb(52 ,74 ,219));
//
//
//        // Showing the Controlls
////        Board.setCenter(null);
//    }
//
//
//    private void deSelect(){
//        billImg.setImage(new Image(HelloApplication.class.getResourceAsStream("/Icons/user.png")));
//
//        for (VBox imageView : containers){
//            for(Node node : imageView.getChildren()){
//                if(node instanceof Text){
//                    ((Text) node).setFill(Color.BLACK);
//                }
//            }
//        }
//    }
}
