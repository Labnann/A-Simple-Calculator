package calculator.simple;

import com.sun.scenario.effect.impl.Renderer;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import javafx.scene.Scene;
import javafx.scene.input.Clipboard;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.StackPane;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javax.sound.midi.Receiver;


public class CalculatorSimple extends Application {

    String text;
    RandomColor color = new RandomColor();

    simpleUnit calculator = new simpleUnit();
    Expression expression = new Expression();
    Text result = new Text("Result");
    TextField textField = new TextField();
    Rectangle rectangle = new Rectangle(250, 100, 30, 30);

    @Override
    public void start(Stage primaryStage) throws Exception {

        textField.setLayoutX(50);
        textField.setLayoutY(100);
        rectangle.setFill(Color.ALICEBLUE);
        rectangle.setOpacity(10);
        Text equalSign = new Text(250, 125, " =");

        equalSign.setFont(Font.font("Calibri", 30));
//        StackPane stack  = new StackPane();
//        stack.getChildren().addAll(rectangle,equalSign);
//        stack.setLayoutX(250);
//        stack.setLayoutY(100);
        
        
        result.setX(50);
        result.setY(175);
        result.setFont(Font.font("SolaimanLipi", 30));
        
        Text copierText = new Text(50, 50, "Copy");
        Rectangle copierRectangle = new Rectangle(200,250,40,30);
        copierRectangle.setFill(Color.ALICEBLUE);
        
        StackPane copyButton = new StackPane();
        copyButton.getChildren().addAll(copierRectangle,copierText);
        copyButton.setLayoutX(150);
        copyButton.setLayoutY(175);
        
        
        Group root = new Group(equalSign, textField, rectangle, result);
        EventHandler<MouseEvent> buttonClick = new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {

                showResult();

            }

        };
        EventHandler<KeyEvent> enterPress = new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                //showResult
                // i
                Object key;
                key = event.getCode();
                if (key == KeyCode.ENTER) {
                    showResult();
                }
               // System.out.println(event.getCode());
                if (key == KeyCode.ESCAPE) {
                    primaryStage.close();
                }
                if (key == KeyCode.C)
                    Utils.copyTextToClipboard(result.getText());

                //
            }
        };
        EventHandler<MouseEvent> resultPress = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
            //    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                try {
                    root.getChildren().add(copyButton);
                } catch (Exception e) {
                    
                }
                
          
            }
        };
        EventHandler<MouseEvent> clickCopy = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                Utils.copyTextToClipboard(result.getText());
                root.getChildren().remove(copyButton);
            }
        };
        
        textField.addEventFilter(KeyEvent.KEY_PRESSED, enterPress);
        equalSign.addEventFilter(MouseEvent.MOUSE_CLICKED, buttonClick);
        rectangle.addEventFilter(MouseEvent.MOUSE_CLICKED, buttonClick);
        result.addEventFilter(MouseEvent.MOUSE_CLICKED, resultPress);
        copyButton.addEventFilter(MouseEvent.MOUSE_CLICKED, clickCopy);
        
        equalSign.toFront();
        Scene scene = new Scene(root, 400, 300);
        
        primaryStage.setTitle("Calculator");
        
        primaryStage.setScene(scene);
        primaryStage.show();
        
        

    }

    public static void main(String[] args) {
        launch(args);
    }

    private void showResult() {
        text = textField.getText();
        // calculator.calculateTerms(text);
        expression.setExpression(text);
        expression.calculate();
        result.setText(expression.getResult());
        System.out.println(expression.getResult());
        rectangle.setFill(color.getColor());
    }

}
