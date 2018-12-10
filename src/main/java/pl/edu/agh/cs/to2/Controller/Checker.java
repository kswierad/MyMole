package pl.edu.agh.cs.to2.Controller;


import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.Alert;
import pl.edu.agh.cs.to2.Model.Point;
import pl.edu.agh.cs.to2.Model.Level;
import pl.edu.agh.cs.to2.Model.Vector;

import java.util.Iterator;

public class Checker implements ChangeListener<Point> {

    public Checker(Level template){
        this.level = template;
        vectorIterator = template.getVectors().iterator();
        if(vectorIterator.hasNext()) currentVector = vectorIterator.next();
    }

    private Level level;

    private Iterator<Vector> vectorIterator;

    private Vector currentVector;

    public void changed(ObservableValue<? extends Point> observableValue, Point oldC, Point newC){
        if(currentVector.getEnd().isEqual(newC)){
            if(vectorIterator.hasNext()){
                currentVector = vectorIterator.next();
            }
            else {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Victory");
                alert.setHeaderText("You matched the level!");
                alert.setContentText("Congratulations you beat this level!");
                alert.showAndWait();
            }
        } else {
            if(!currentVector.contains(newC)){
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Mistake");
                alert.setHeaderText("You didn't match the level");
                alert.setContentText("You have to follow the grey line!");
                alert.showAndWait();
            }
        }
    }
}
