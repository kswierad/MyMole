package pl.edu.agh.cs.to2.Model.Command;

import pl.edu.agh.cs.to2.Model.Mole;
import pl.edu.agh.cs.to2.Utils.Coordinates;
import pl.edu.agh.cs.to2.Utils.Direction;

public class ForwardCommand implements Command {


    private int value;

    public ForwardCommand(int moveValue){
        value = moveValue;
    }

    @Override
    public Direction modifyDirection(Direction direction){
        return direction;
    }

    @Override
    public Coordinates modifyCoordinates(Coordinates coordinates){
        return coordinates;
    }
}
