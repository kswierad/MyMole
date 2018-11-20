package pl.edu.agh.cs.to2.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import pl.edu.agh.cs.to2.Model.Command;
import pl.edu.agh.cs.to2.Model.Mole;
import pl.edu.agh.cs.to2.Utils.CommandParser;
import pl.edu.agh.cs.to2.Utils.Coordinates;


public class CanvasController {

    @FXML
    private Canvas img ;

    private CommandParser parser;

    private GraphicsContext gc ;

    private Mole mole;

    @FXML
    private TextField text;

    @FXML private void parseAndAdd(ActionEvent event) {
        Command command = parser.parse(text.getText());
        Coordinates oldCoord = mole.getCoords();

        clearMole();
        System.out.println("Moving Mole");

        mole.execute(command);
        System.out.println(oldCoord);
        System.out.println(mole.getCoords());
        drawPath(oldCoord,mole.getCoords());
        drawMole();

    }

    @FXML
    public void initialize() {
        parser = new CommandParser();
        mole = new Mole();
        gc = img.getGraphicsContext2D();
        System.out.println("Drawing Mole");
        drawMole();
    }

    public void drawMole(){
        gc.setFill(Color.AQUA);
        gc.fillOval(mole.getCoords().getX(),mole.getCoords().getY(),30,30);
    }

    public void clearMole(){
        gc.setFill(Color.WHITE);
        gc.fillOval(mole.getCoords().getX(),mole.getCoords().getY(),30,30);
    }

    public void drawPath(Coordinates oldCoord, Coordinates newCoord){
        gc.setStroke(Color.BLACK);
        gc.strokeLine(oldCoord.getX(),oldCoord.getY(),newCoord.getX(),newCoord.getY());
    }

}