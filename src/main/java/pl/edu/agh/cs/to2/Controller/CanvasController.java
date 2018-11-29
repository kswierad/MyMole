package pl.edu.agh.cs.to2.Controller;

import ch.obermuhlner.math.big.BigDecimalMath;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import pl.edu.agh.cs.to2.Model.Command.Command;
import pl.edu.agh.cs.to2.Model.Mole;
import pl.edu.agh.cs.to2.Model.CommandParser;
import pl.edu.agh.cs.to2.Model.Coordinates;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.List;


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
    private TextArea text;

    @FXML private void reset(ActionEvent event){
        mole = new Mole();
        clearAndDrawMole();
        gcbg.clearRect(0,0,background.getHeight(),background.getWidth());
    }

    @FXML private void parseAndAdd(ActionEvent event) {
        List<Command> commands = parser.parse(text.getText());
        Coordinates oldCoord = mole.getCoords();

        System.out.println("Moving Mole");
        for(Command cmd : commands) cmd.execute(mole);

        System.out.println(oldCoord);
        System.out.print(mole.getCoords());
        System.out.print(" ");
        System.out.println(mole.getAngle().divide(BigDecimalMath.pi(new MathContext(50)), new MathContext(50)));

    }

    @FXML
    public void initialize() {
        parser = new CommandParser();
        mole = new Mole();
        mole.AngleProperty().addListener((ObservableValue<? extends Number> observableValue, Number number, Number t1) ->
                    clearAndDrawMole()
                );
        mole.CoordsProperty().addListener((ObservableValue<? extends Coordinates> observableValue, Coordinates coordinates, Coordinates t1) -> {
                drawPath(coordinates,t1);
                clearAndDrawMole();
            });
        gcfg = foreground.getGraphicsContext2D();
        gcbg = background.getGraphicsContext2D();
        System.out.println("Drawing Mole");
        drawMole();
    }

    public void drawMole(){
        gcfg.setFill(Color.AQUA);
        gcfg.fillOval(mole.getCoords().getX()-15,mole.getCoords().getY()-15,30,30);
    }

    public void clearAndDrawMole(){
        gcfg.clearRect(0,0,foreground.getHeight(),foreground.getWidth());
        gcfg.setFill(Color.AQUA);
        gcfg.fillOval(mole.getCoords().getX()-15,mole.getCoords().getY()-15,30,30);
    }

    public void drawPath(Coordinates oldCoord, Coordinates newCoord){
        gcbg.setStroke(Color.BLACK);
        gcbg.strokeLine(oldCoord.getX(),oldCoord.getY(),newCoord.getX(),newCoord.getY());
    }

}