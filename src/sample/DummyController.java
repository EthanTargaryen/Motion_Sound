package sample;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;

import java.io.File;
import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class DummyController implements Initializable {

    @FXML private AnchorPane motherPane;

    private MotionButton motionButton;
    private SpriteView spriteView;


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        File file = new File("src/img/pic1.png");
        SpriteView spriteView = new SpriteView(new Image(file.toURI().toString()));

        motherPane.getChildren().add(spriteView);

        motionButton = new MotionButton("s",spriteView);

    }

    @FXML void func()
    {
        motionButton.goToMousePointer();
    }
}
