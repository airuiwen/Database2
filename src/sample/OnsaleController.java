package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;


import java.io.IOException;
import java.util.List;

public class OnsaleController {
    static Manager manager;
    static SplitPane splitPane;
    
    public OnsaleController(){
    }
    public void init(SplitPane tPane, Manager manager) throws IOException {
        FXMLLoader loader = new FXMLLoader(Main.class.getResource("/onsale.fxml"));
        System.out.println(loader.getLocation());
        AnchorPane anchorPane = loader.load();
        splitPane = tPane;
        this.manager = manager;
        splitPane.getItems().set(1,anchorPane);
    }

    @FXML
    public void Ping() throws IOException {
        FXMLLoader loader = new FXMLLoader(Main.class.getResource("/ping.fxml"));
        ScrollPane anchorPane = loader.load();
        splitPane.getItems().set(1,anchorPane);
        GridPane gridPane = (GridPane)anchorPane.getContent();
        List<House> list = manager.getPing();
        int i = 1;
        for (House e: list
             ) {
            Image image = new Image("/2f9dd9642431bbef883d72313dd8aed4.jpg");
            ImageView imageView = new ImageView(image);
            Label rent = new Label();
            Text Loc = new Text();
            Loc.setText(e.Loca);
            Loc.setWrappingWidth(120);
            Loc.setFont(Font.font("system",15));
            Loc.setFill(Color.WHITE);
            rent.setText("￥"+e.rent+"");
            rent.getStyleClass().add("label-x");
            imageView.setFitHeight(100);
            imageView.setFitWidth(100);
            gridPane.add(imageView,0,i);
            gridPane.add(rent,1,i);
            gridPane.add(Loc,2,i);
            i++;
        }
    }
}
