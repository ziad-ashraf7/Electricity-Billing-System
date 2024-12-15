package Controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import ziad.elictracitybillingsystem.HelloApplication;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class AdminViewController implements Initializable {

    ArrayList<VBox> containers = new ArrayList<>();

    @FXML
    private VBox userBillsCont;

    @FXML
    private ImageView userBillsImg;

    @FXML
    private Text userBillsTxt;

    @FXML
    private VBox userStatCon;

    @FXML
    private ImageView userStatImg;

    @FXML
    private Text userStatTxt;

    @FXML
    private BorderPane Board;

    @FXML
    private VBox userControllsCon;

    @FXML
    private ImageView userControllsImg;

    @FXML
    private Text userControllsTxt;

    @FXML
    void showUserControlls(MouseEvent event) throws IOException {

        HandelClick(userControllsImg , userControllsTxt);

        Pane pane =  FXMLLoader.load(HelloApplication.class.getResource("User-Controlls.fxml"));

        Board.setCenter(pane);

    }

    @FXML
    void showStat(MouseEvent event) {
        HandelClick(userStatImg , userStatTxt);



        System.out.println("Showing User Stats");
    }

    @FXML
    void showUserBills(MouseEvent event) {
        HandelClick(userBillsImg , userBillsTxt);



        System.out.println("Showing User Stats");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        containers.add(userControllsCon);
        containers.add(userStatCon);
        containers.add(userBillsCont);
    }

    private void HandelClick(ImageView imageView , Text text){
        // Deselecting the button
        deSelect();

        // Selecting the button
        imageView.setImage(new Image(HelloApplication.class.getResourceAsStream("/Icons/user-selected.png")));
        text.setFill(Color.rgb(52 ,74 ,219));


        // Showing the Controlls
        Board.setCenter(null);
    }


    private void deSelect(){
        for (VBox imageView : containers){
            for(Node node : imageView.getChildren()){
                if(node instanceof ImageView){
                    ((ImageView) node).setImage(new Image(HelloApplication.class.getResourceAsStream("/Icons/user.png")));
                }else if(node instanceof Text){
                    ((Text) node).setFill(Color.BLACK);

                }
            }
        }
    }
}