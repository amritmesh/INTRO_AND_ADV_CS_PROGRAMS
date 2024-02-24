import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.event.*;

public class CardFlipFX extends Application
{
    // Create ImageView objects
    ImageView image1 = new ImageView(new Image("image/c1.gif"));            
    ImageView image2 = new ImageView(new Image("image/c2.gif"));
    ImageView image3 = new ImageView(new Image("image/c3.gif"));

    // Create Button objects
    Button bt1 = new Button("Flip");            
    Button bt2 = new Button("Flip");            
    Button bt3= new Button("Flip");

    public void start(Stage myStage)
    {
        // New BorderPane
        BorderPane pane = new BorderPane();

        // Set respective positions for HBoxes
        pane.setCenter(Cards());
        pane.setBottom(Buttons());

        // Pass event to button handler
        bt1.setOnAction(new ButtonHandler1());
        bt2.setOnAction(new ButtonHandler2());
        bt3.setOnAction(new ButtonHandler3());

        // New scene, title, and display the whole scene
        Scene scene = new Scene(pane);
        myStage.setTitle("Card Flip FX Application");
        myStage.setScene(scene);
        myStage.show();
    }

    // HBox for cards
    private HBox Cards()
    {
        HBox hBox = new HBox(2);
        hBox.setPadding(new Insets(25, 55, 1, 55));

        hBox.getChildren().add(image1);
        hBox.getChildren().add(image2);
        hBox.getChildren().add(image3);

        return hBox;
    }

    // HBox for buttons
    private HBox Buttons()
    {
        HBox hBox = new HBox(37);
        hBox.setPadding(new Insets(1, 74.25, 25, 74.25));            

        hBox.getChildren().add(bt1);
        hBox.getChildren().add(bt2);
        hBox.getChildren().add(bt3);

        return hBox;
    }

    // Handler for first button event action
    class ButtonHandler1 implements EventHandler<ActionEvent>
    {
        public void handle(ActionEvent e)
        {
            image1.setImage(new Image("image/b1fv.gif"));
        }
    }

    // Handler for second button event action
    class ButtonHandler2 implements EventHandler<ActionEvent>
    {
        public void handle(ActionEvent e)
        {
            image2.setImage(new Image("image/b1fv.gif")); 
        }
    }

    // Handler for third button event action
    class ButtonHandler3 implements EventHandler<ActionEvent>
    {
        public void handle(ActionEvent e)
        {
            image3.setImage(new Image("image/b1fv.gif")); 
        }
    }
    public static void main(String[]args)
    {
        launch(args);
    }
}