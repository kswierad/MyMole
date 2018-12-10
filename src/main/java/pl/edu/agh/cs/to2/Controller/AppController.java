package pl.edu.agh.cs.to2.Controller;

import ch.obermuhlner.math.big.BigDecimalMath;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.SnapshotParameters;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import pl.edu.agh.cs.to2.Command.Command;
import pl.edu.agh.cs.to2.Model.*;
import pl.edu.agh.cs.to2.Model.LevelGenerator.LevelGenerator;

import java.math.BigDecimal;
import java.math.MathContext;
import java.text.ParseException;
import java.util.LinkedList;
import java.util.List;


public class AppController {

    static private final MathContext mathContext = new MathContext(100);
    @FXML
    private Canvas foreground;

    @FXML
    private Canvas background;

    @FXML
    private Canvas example;

    private CommandParser parser;

    private GraphicsContext gcfg ;

    private GraphicsContext gcbg ;

    private GraphicsContext exmpl ;

    private Mole mole;

    private List<Level> levels;

    private int levelNumber;

    @FXML
    private Text levelIndicator;

    @FXML
    private void next(ActionEvent event){
        if(levelNumber + 1 == levels.size()){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("No more levels");
            alert.setHeaderText("There is no more levels :(");
            alert.setContentText("We are sorry, but currently this is the last level");

            alert.showAndWait();
            return;
        }
        reset(null);
        levelNumber++;
        levelIndicator.setText("Level " + (levelNumber+1));
        mole.CoordsProperty().addListener(new Checker(levels.get(levelNumber)));
        drawLevel(levels.get(levelNumber));
    }

    @FXML
    private void previous(ActionEvent event){
        if(levelNumber == 0){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("No more levels");
            alert.setHeaderText("YOU ARE ON THE FIRST LEVEL");
            alert.setContentText("You can't go back, when on first level");

            alert.showAndWait();
            return;
        }

        reset(null);
        levelNumber--;
        levelIndicator.setText("Level " + (levelNumber+1));
        mole.CoordsProperty().addListener(new Checker(levels.get(levelNumber)));
        drawLevel(levels.get(levelNumber));
    }

    @FXML
    private TextArea commandText;

    @FXML private void reset(ActionEvent event){
        mole = new Mole();
        setListenersOnMole();
        clearAndDrawMole();
        gcbg.clearRect(0,0,background.getWidth(),background.getHeight());
        mole.CoordsProperty().addListener(new Checker(levels.get(levelNumber)));
        drawLevel(levels.get(levelNumber));
    }

    @FXML private void parseAndAdd(ActionEvent event) {
        List<Command> commands;
        try {
            commands = parser.parse(commandText.getText());
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
        Point oldPoint = mole.getPoint();

        System.out.println("Moving Mole");
        for(Command cmd : commands) cmd.execute(mole);

        System.out.println(oldPoint);
        System.out.print(mole.getPoint());
        System.out.print(" ");
        System.out.println(mole.getAngle().divide(BigDecimalMath.pi(new MathContext(50)), new MathContext(50)));

    }

    @FXML
    public void initialize() {
        parser = new CommandParser();
        mole = new Mole();
        setListenersOnMole();

        gcfg = foreground.getGraphicsContext2D();
        gcbg = background.getGraphicsContext2D();
        exmpl = example.getGraphicsContext2D();
        LevelGenerator generator = new LevelGenerator();
        levels = generator.generate();
        levelNumber = 0;
        mole.CoordsProperty().addListener(new Checker(levels.get(levelNumber)));
        drawLevel(levels.get(levelNumber));
        System.out.println("Drawing Mole");
        drawMole();
    }

    public void setListenersOnMole(){
        mole.AngleProperty().addListener((ObservableValue<? extends BigDecimal> observableValue, BigDecimal number, BigDecimal t1) ->
                clearAndDrawMole()
        );
        mole.CoordsProperty().addListener((ObservableValue<? extends Point> observableValue, Point point, Point t1) -> {
            drawPath(point,t1);
            clearAndDrawMole();
        });
    }

    public void drawMole(){
        ImageView iv = new ImageView(new Image( "/mole.png"));
        iv.setRotate(mole.getAngle().divide(BigDecimalMath.pi(mathContext),mathContext).doubleValue()*180.0);
        SnapshotParameters params = new SnapshotParameters();
        params.setFill(Color.TRANSPARENT);
        Image rotatedImage = iv.snapshot(params, null);
        gcfg.drawImage(rotatedImage,mole.getPoint().getX()-rotatedImage.getWidth()/2,mole.getPoint().getY()-rotatedImage.getHeight()/2);
    }

    public void clearAndDrawMole(){
        gcfg.clearRect(0,0,foreground.getWidth(),foreground.getHeight());
        drawMole();
    }

    public void drawLevel(Level lvl){
        exmpl.clearRect(0,0,example.getWidth(),example.getHeight());
        exmpl.setStroke(Color.LIGHTGRAY);
        for(Vector vec : lvl.getVectors()) {
            exmpl.strokeLine(vec.getStart().getX(), vec.getStart().getY(), vec.getEnd().getX(), vec.getEnd().getY());
        }

    }

    public void drawPath(Point oldPoint, Point newPoint){
        gcbg.setStroke(Color.BLACK);
        gcbg.strokeLine(oldPoint.getX(),oldPoint.getY(),newPoint.getX(),newPoint.getY());
    }

}