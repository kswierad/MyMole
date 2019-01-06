package pl.edu.agh.cs.to2.Model;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;

import java.math.BigDecimal;

public class Mole {
    private ObjectProperty<BigDecimal> angle = new SimpleObjectProperty<>();
    private ObjectProperty<Point> coords = new SimpleObjectProperty<>();
    private Boolean isDown;

    public BigDecimal getAngle(){return this.angle.getValue(); }
    public Point getPoint(){return coords.getValue();}
    public void setAngle(BigDecimal angle){ this.angle.setValue(angle); }
    public void setCoords(Point point){ this.coords.setValue(point); }
    public ObjectProperty<BigDecimal> AngleProperty(){ return this.angle; }
    public ObjectProperty<Point> CoordsProperty(){ return this.coords; }
    public void setIsDown(Boolean state){this.isDown = state; }
    public Boolean isDown(){return this.isDown; }

    public Mole(){
        angle.setValue(new BigDecimal(0));
        coords.setValue(new Point(300,400));
        isDown = Boolean.TRUE;
    }




}




