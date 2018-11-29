package pl.edu.agh.cs.to2.Model;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;

import java.math.BigDecimal;

public class Mole {
    private ObjectProperty<BigDecimal> angle = new SimpleObjectProperty<>();
    private ObjectProperty<Coordinates> coords = new SimpleObjectProperty<>();

    public BigDecimal getAngle(){return this.angle.getValue(); }
    public Coordinates getCoords(){return coords.getValue();}
    public void setAngle(BigDecimal angle){ this.angle.setValue(angle); }
    public void setCoords(Coordinates coordinates){ this.coords.setValue(coordinates); }
    public ObjectProperty<BigDecimal> AngleProperty(){ return this.angle; }
    public ObjectProperty<Coordinates> CoordsProperty(){ return this.coords; }

    public Mole(){
        angle.setValue(new BigDecimal(0));
        coords.setValue(new Coordinates(300,400));
    }


}




