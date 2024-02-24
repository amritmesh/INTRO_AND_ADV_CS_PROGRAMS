import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.geometry.Insets;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class CardFX extends Application
{
    public void start(Stage myStage)
    {
        Pane pane = new HBox(5);
        pane.setPadding(new Insets(50, 100, 50, 100));

        Image image1 = new Image("image/c1.gif");
        Image image2 = new Image("image/c2.gif");
        Image image3 = new Image("image/c3.gif");

        pane.getChildren().add(new ImageView(image1));
        pane.getChildren().add(new ImageView(image2));
        pane.getChildren().add(new ImageView(image3));

        ImageView imageView1 = new ImageView(image1);

        ImageView imageView2 = new ImageView(image2);

        ImageView imageView3 = new ImageView(image3);

        Scene scene = new Scene(pane);
        myStage.setTitle("Simple Card FX Application");
        myStage.setScene(scene);
        myStage.show();
    }
    public static void main(String[]args)
    {
        launch(args);
    }
}