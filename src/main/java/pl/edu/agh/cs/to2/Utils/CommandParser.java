package pl.edu.agh.cs.to2.Utils;

import jdk.nashorn.internal.runtime.ParserException;
import pl.edu.agh.cs.to2.Model.Command;

public class CommandParser {




    public Command parse(String textCommand){
        CommandType type = null;
        if(textCommand.matches("FORWARD.*"))
            type = CommandType.FORWARD;
        if(textCommand.matches("BACKWARD.*"))
            type = CommandType.BACKWARD;
        if(textCommand.matches("LEFT.*"))
            type = CommandType.LEFT;
        if(textCommand.matches("RIGHT.*"))
            type = CommandType.RIGHT;
        if(type == null) throw new ParserException("Couldn't resolve command type");
        int val =Integer.parseInt(textCommand.split(" ")[1]);


        return new Command(val, type);
    }
}
