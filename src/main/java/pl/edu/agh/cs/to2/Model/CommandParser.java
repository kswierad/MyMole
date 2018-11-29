package pl.edu.agh.cs.to2.Model;

import jdk.nashorn.internal.runtime.ParserException;
import pl.edu.agh.cs.to2.Model.Command.*;

public class CommandParser {




    public Command parse(String textCommand){
        if(textCommand.matches("FORWARD.*")){
            int distance =Integer.parseInt(textCommand.split(" ")[1]);
            return new ForwardCommand(distance);
        }

        if(textCommand.matches("BACKWARD.*")){
            int distance =Integer.parseInt(textCommand.split(" ")[1]);
            return new BackwardCommand(distance);
        }
        if(textCommand.matches("LEFT.*")){
            double angle = Double.parseDouble(textCommand.split(" ")[1]);
            return new LeftCommand(angle);
        }
        if(textCommand.matches("RIGHT.*")){
            double angle = Double.parseDouble(textCommand.split(" ")[1]);
            return new RightCommand(angle);
        }
        throw new ParserException("Couldn't resolve command type");

    }
}
