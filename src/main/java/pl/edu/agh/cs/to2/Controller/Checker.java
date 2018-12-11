package pl.edu.agh.cs.to2.Controller;


import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.Alert;
import pl.edu.agh.cs.to2.Model.Point;
import pl.edu.agh.cs.to2.Model.Level;
import pl.edu.agh.cs.to2.Model.Vector;

import java.util.Iterator;
import java.util.ListIterator;

public class Checker implements ChangeListener<Point> {

    public Checker(Level template){
        this.level = template;
    }

    private Level level;

    private Boolean toRight = null;

    private ListIterator<Vector> vectorIterator;

    private Vector currentVector;

    public void changed(ObservableValue<? extends Point> observableValue, Point oldC, Point newC){
        if(toRight == null){
            if(level.getVectors().get(level.getVectors().size()-1).getStart().isEqual(newC)){
                toRight = false;
                vectorIterator = level.getVectors().listIterator(level.getVectors().size());
                currentVector = vectorIterator.previous();
                //System.out.println("Left \n" + currentVector);

            } else if(level.getVectors().get(level.getVectors().size()-1).contains(newC)){
                toRight = false;
                vectorIterator = level.getVectors().listIterator(level.getVectors().size());
                currentVector = vectorIterator.previous();
                //System.out.println("Left \n" + currentVector);

            } else {

                toRight = true;
                vectorIterator = level.getVectors().listIterator();
                currentVector = vectorIterator.next();
                //System.out.println("Right\n" + currentVector);
            }

        }
        if(!toRight){
            //System.out.println("cur: " + currentVector + " newC: " + newC);
            if (currentVector.getStart().isEqual(newC)) {
                if (vectorIterator.hasPrevious()) {
                    currentVector = vectorIterator.previous();
                } else {
                    alertVictory();
                }
            } else {
                if (!currentVector.contains(newC)) {
                    alertMistake();
                }
            }
        } else {
            //System.out.println("cur: " + currentVector + " newC: " + newC);
            if (currentVector.getEnd().isEqual(newC)) {
                if (vectorIterator.hasNext()) {
                    currentVector = vectorIterator.next();
                } else {
                    alertVictory();
                }
            } else {
                if (!currentVector.contains(newC)) {
                    alertMistake();
                }
            }
        }
    }

    private void alertMistake(){
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Mistake");
        alert.setHeaderText("You didn't match the level");
        alert.setContentText("You have to follow the grey line!");
        alert.showAndWait();
    }

    private void alertVictory(){
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Victory");
        alert.setHeaderText("You matched the level!");
        alert.setContentText("Congratulations you beat this level!");
        alert.showAndWait();
    }
}
