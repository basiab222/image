package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.awt.*;
import java.io.File;


public class Main extends Application {
    Stage stage = new Stage();

    @Override
    public void start(Stage primaryStage) throws Exception{
        GridPane root = new GridPane();
        Scene scene = new Scene(root, 500,500);

        stage.setTitle("Image");
        stage.setScene(scene);
        stage.show();

        imageLayout();

    }

    public void imageLayout(){
        GridPane root = new GridPane();
        stage.setTitle("Image");
        root.setAlignment(Pos.CENTER);
        root.setVgap(50);
        root.setHgap(50);

        ImageView imageView = new ImageView();
        imageView.setFitWidth(300);
        imageView.setPreserveRatio(true);
        imageView.setSmooth(true);
        imageView.setCache(true);
        root.add(imageView,0,1);

        Button button = new Button("Browse");
        button.setOnAction(event -> {
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Open File");
            File file = fileChooser.showOpenDialog(new Stage());
            if(file != null){
                Image image = new Image("file:" + file.getAbsolutePath());
                imageView.setImage(image);
            }
        });
        root.add(button,0,0);

        stage.getScene().setRoot(root);

    }


    public static void main(String[] args) {
        launch(args);
    }
}
