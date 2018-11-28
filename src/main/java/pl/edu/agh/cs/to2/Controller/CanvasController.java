package pl.edu.agh.cs.to2.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import pl.edu.agh.cs.to2.Model.Command;
import pl.edu.agh.cs.to2.Model.Mole;
import pl.edu.agh.cs.to2.Model.CommandParser;
import pl.edu.agh.cs.to2.Model.Coordinates;


public class CanvasController {

    @FXML
    private Canvas foreground;

    @FXML
    private Canvas background;

    private CommandParser parser;

    private GraphicsContext gcfg ;

    private GraphicsContext gcbg ;

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
        gcfg = foreground.getGraphicsContext2D();
        gcbg = background.getGraphicsContext2D();
        System.out.println("Drawing Mole");
        drawMole();
    }

    public void drawMole(){
        gcfg.setFill(Color.AQUA);
        gcfg.fillOval(mole.getCoords().getX(),mole.getCoords().getY(),30,30);
    }

    public void clearMole(){
        gcfg.clearRect(0,0,foreground.getHeight(),foreground.getWidth());
    }

    public void drawPath(Coordinates oldCoord, Coordinates newCoord){
        gcbg.setStroke(Color.BLACK);
        gcbg.strokeLine(oldCoord.getX(),oldCoord.getY(),newCoord.getX(),newCoord.getY());
    }

}