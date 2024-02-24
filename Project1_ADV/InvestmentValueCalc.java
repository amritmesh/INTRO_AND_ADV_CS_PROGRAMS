import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.geometry.HPos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.event.*;
import javafx.stage.Stage;

public class InvestmentValueCalc extends Application
{
    // Create TextField objects
    private TextField investmentAmt = new TextField();
    private TextField numYears = new TextField();
    private TextField annualIntRate = new TextField();
    private TextField futureVal = new TextField();
    private Button btCalc = new Button("Calculate");  
    
    public void start(Stage primaryStage)
    {
        // Create UI
        GridPane gridPane = new GridPane();
        gridPane.setHgap(5);
        gridPane.setVgap(5);
        gridPane.add(new Label("Investment Amount:"), 0, 0);
        gridPane.add(investmentAmt, 1, 0);
        gridPane.add(new Label("Number of Years:"), 0, 1);
        gridPane.add(numYears, 1, 1);
        gridPane.add(new Label("Annual Interest Rate:"), 0, 2);
        gridPane.add(annualIntRate, 1, 2);
        gridPane.add(new Label("Future Value:"), 0, 3);
        gridPane.add(futureVal, 1, 3);
        gridPane.add(btCalc, 1, 4);

        // Set UI properties
        gridPane.setAlignment(Pos.CENTER);
        investmentAmt.setAlignment(Pos.BOTTOM_RIGHT);
        numYears.setAlignment(Pos.BOTTOM_RIGHT);
        annualIntRate.setAlignment(Pos.BOTTOM_RIGHT);
        futureVal.setAlignment(Pos.BOTTOM_RIGHT);
        futureVal.setEditable(false);
        GridPane.setHalignment(btCalc, HPos.RIGHT);

        // Process button-clicking event
        btCalc.setOnAction(new CalcFutureVal());

        // Create scene and place in a stage
        Scene scene = new Scene(gridPane, 350, 200);
        primaryStage.setTitle("Future Value Calculator");
        primaryStage.setScene(scene);
        primaryStage.show(); 
    }

    // Class to calculate future value
    class CalcFutureVal implements EventHandler<ActionEvent>
    {
        public void handle(ActionEvent e)
        {
            // Get values from text fields
            double P = Double.parseDouble(investmentAmt.getText());
            double n = Double.parseDouble(numYears.getText());
            double i = (Double.parseDouble(annualIntRate.getText()))/100;

            // Calculate future value
            double FV = P*(Math.pow((1 + (i/12)),(12*n))); 

            // Display future value
            futureVal.setText(String.format("$%.2f", FV));
        }
    }

    public static void main(String[]args)
    {
        launch(args);
    }
}