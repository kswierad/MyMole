package pl.edu.agh.cs.to2.Model;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleObjectProperty;

import java.math.BigDecimal;

public class Mole {
    private DoubleProperty angle = new SimpleDoubleProperty();
    private ObjectProperty<Coordinates> coords = new SimpleObjectProperty<>();

    public double getAngle(){return this.angle.getValue(); }
    public Coordinates getCoords(){return coords.getValue();}
    public void setAngle(double angle){ this.angle.setValue(angle); }
    public void setCoords(Coordinates coordinates){ this.coords.setValue(coordinates); }
    public DoubleProperty AngleProperty(){ return this.angle; }
    public ObjectProperty<Coordinates> CoordsProperty(){ return this.coords; }

    public Mole(){
        angle.setValue(90.0);
        coords.setValue(new Coordinates(300,400));
    }


}




