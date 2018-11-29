package pl.edu.agh.cs.to2.Controller;

import ch.obermuhlner.math.big.BigDecimalMath;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.SnapshotParameters;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import pl.edu.agh.cs.to2.Model.Command.Command;
import pl.edu.agh.cs.to2.Model.Mole;
import pl.edu.agh.cs.to2.Model.CommandParser;
import pl.edu.agh.cs.to2.Model.Coordinates;

import java.math.BigDecimal;
import java.math.MathContext;
import java.text.ParseException;
import java.util.List;


public class CanvasController {

    static private final MathContext mathContext = new MathContext(100);
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
        setListenersOnMole();
        clearAndDrawMole();
        gcbg.clearRect(0,0,background.getHeight(),background.getWidth());
    }

    @FXML private void parseAndAdd(ActionEvent event) {
        List<Command> commands;
        try {
            commands = parser.parse(text.getText());
        }catch (ParseException e){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Wrong commands");
            alert.setHeaderText("You have written wrong commands");
            alert.setContentText("Right commands are:\n" +
                    "forward/backward X where X is distance\n" +
                    "left/right X where X is angle\n" +
                    "loop X where X is amount of loops");

            alert.showAndWait();
            return;
        }
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
        setListenersOnMole();
        //mole.CoordsProperty().addListener(new Checker());
        gcfg = foreground.getGraphicsContext2D();
        gcbg = background.getGraphicsContext2D();
        System.out.println("Drawing Mole");
        drawMole();
    }

    public void setListenersOnMole(){
        mole.AngleProperty().addListener((ObservableValue<? extends Number> observableValue, Number number, Number t1) ->
                clearAndDrawMole()
        );
        mole.CoordsProperty().addListener((ObservableValue<? extends Coordinates> observableValue, Coordinates coordinates, Coordinates t1) -> {
            drawPath(coordinates,t1);
            clearAndDrawMole();
        });
    }

    public void drawMole(){
        ImageView iv = new ImageView(new Image( "/mole.png"));
        iv.setRotate(mole.getAngle().divide(BigDecimalMath.pi(mathContext),mathContext).doubleValue()*180.0);
        SnapshotParameters params = new SnapshotParameters();
        params.setFill(Color.TRANSPARENT);
        Image rotatedImage = iv.snapshot(params, null);
        gcfg.drawImage(rotatedImage,mole.getCoords().getX()-rotatedImage.getWidth()/2,mole.getCoords().getY()-rotatedImage.getHeight()/2);
    }

    public void clearAndDrawMole(){
        gcfg.clearRect(0,0,foreground.getHeight(),foreground.getWidth());
        gcfg.setFill(Color.AQUA);
        drawMole();
    }

    public void drawPath(Coordinates oldCoord, Coordinates newCoord){
        gcbg.setStroke(Color.BLACK);
        gcbg.strokeLine(oldCoord.getX(),oldCoord.getY(),newCoord.getX(),newCoord.getY());
    }

}