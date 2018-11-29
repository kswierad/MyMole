package pl.edu.agh.cs.to2.Model.Command;

import pl.edu.agh.cs.to2.Model.Coordinates;
import pl.edu.agh.cs.to2.Model.Mole;

import static java.lang.Math.*;

public class BackwardCommand implements Command {
    public BackwardCommand(int distance) {
        this.distance = distance;
    }

    private int distance;

    @Override
    public void execute(Mole mole){
        double angle = toRadians(mole.getAngle());
        Coordinates coordinates = mole.getCoords();
        Coordinates newcoords = new Coordinates(coordinates, -(int) (distance*cos(angle)), -(int) (distance*sin(angle)));
        mole.setCoords(newcoords);

    }
}
