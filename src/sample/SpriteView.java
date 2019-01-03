package sample;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

import static java.lang.StrictMath.PI;

public class SpriteView extends ImageView {

    private double orientAngle;

    private double orgSceneX, orgSceneY, orgTranslateX, orgTranslateY;

    SpriteView(Image image)
    {
        super(image);
        this.setPreserveRatio(true);
        this.setFitHeight(169.0);
        this.setPickOnBounds(true);
        this.setLayoutX(0);
        this.setLayoutY(0);
        this.setTranslateX(100);
        this.setTranslateY(50);
        this.setOnMousePressed(event -> onMousePressed(event));
        this.setOnMouseDragged(event -> onMouseDragged(event));
        orientAngle = 0;
    }

    void rotateDegree(double degree)
    {
        orientAngle += degree*PI/180.0;
    }

    public double getOrientAngle() {
        return orientAngle;
    }

    public void onMousePressed(MouseEvent mouseEvent)
    {
        orgSceneX = mouseEvent.getSceneX();
        orgSceneY = mouseEvent.getSceneY();

//        System.out.println("It happened at " + orgSceneX + "," + orgSceneY );

        orgTranslateX = this.getTranslateX();
        orgTranslateY = this.getTranslateY();
    }

    public void onMouseDragged(MouseEvent mouseEvent)
    {

        double newTranslateX = orgTranslateX + mouseEvent.getSceneX() - orgSceneX;
        double newTranslateY = orgTranslateY + mouseEvent.getSceneY() - orgSceneY;

        ((ImageView)(mouseEvent.getSource())).setTranslateX(newTranslateX);
        ((ImageView)(mouseEvent.getSource())).setTranslateY(newTranslateY);

        /*System.out.println("Source image is at " + this.getTranslateX() + "," + this.getTranslateY());
        System.out.println(" In Parent at " + this.getBoundsInParent());
        System.out.println(" In Local  at " + this.getBoundsInLocal());*/

    }

    /*
    <children>
            <ImageView fx:id="imageView" fitHeight="169.0" fitWidth="228.0" pickOnBounds="true" preserveRatio="true" />
    </children>
     */
}
