package pl.edu.agh.cs.to2.Model;

import pl.edu.agh.cs.to2.Utils.CommandType;
import pl.edu.agh.cs.to2.Utils.Coordinates;
import pl.edu.agh.cs.to2.Utils.Direction;

public class Command {

    public final CommandType type;

    public final int value;

    public Command(int value, CommandType type){
        this.value = value;
        this.type = type;
    }
}
