package pl.edu.agh.cs.to2.Model.Command;

import pl.edu.agh.cs.to2.Utils.Coordinates;
import pl.edu.agh.cs.to2.Utils.Direction;

public class BackwardCommand implements Command {

    @Override
    public Direction modifyDirection(Direction direction){
        return direction;
    }

    @Override
    public Coordinates modifyCoordinates(Coordinates coordinates){
        return coordinates;
    }
}
