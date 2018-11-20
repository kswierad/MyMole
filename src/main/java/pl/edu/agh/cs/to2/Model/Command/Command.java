package pl.edu.agh.cs.to2.Model.Command;

import pl.edu.agh.cs.to2.Utils.Coordinates;
import pl.edu.agh.cs.to2.Utils.Direction;

public interface Command {


    Direction modifyDirection(Direction direction);

    Coordinates modifyCoordinates(Coordinates coordinates);
}
