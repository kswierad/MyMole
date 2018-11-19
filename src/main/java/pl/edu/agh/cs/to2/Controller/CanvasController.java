package pl.edu.agh.cs.to2.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import pl.edu.agh.cs.to2.Model.Command.Command;
import pl.edu.agh.cs.to2.Utils.CommandParser;




public class CanvasController {

    @FXML
    private Canvas img ;

    private CommandParser parser;

    private GraphicsContext gc ;

    @FXML
    private TextField text;

    @FXML private void parseAndAdd(ActionEvent event) {
        Command command = parser.parse(text.getText());
        



    }

    @FXML
    public void initialize() {
        gc = img.getGraphicsContext2D();
        gc.setFill(Color.BLACK);
        System.out.println("color set to black");
        gc.fillRect(50, 50, 100, 100);
        System.out.println("draw rectangle");
    }

}