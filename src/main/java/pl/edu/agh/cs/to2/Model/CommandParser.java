package pl.edu.agh.cs.to2.Model;

import jdk.nashorn.internal.runtime.ParserException;
import pl.edu.agh.cs.to2.Model.Command.*;

import java.util.ArrayList;
import java.util.List;

public class CommandParser {




    public List<Command> parse(String textCommand){
        System.out.print(textCommand);
        List<List<Command>> commands = new ArrayList<>();
        int loopCounter=0;
        commands.add(new ArrayList<>());
        for(String cmd : textCommand.split("\n")) {
            if (cmd.matches("[Ff][Oo][Rr][Ww][Aa][Rr][Dd].*")) {
                int distance = Integer.parseInt(cmd.split(" ")[1]);
                commands.get(loopCounter).add(new ForwardCommand(distance));
            }

            else if (cmd.matches("[Bb][Aa][Cc][Kk][Ww][Aa][Rr][Dd].*")) {
                int distance = Integer.parseInt(cmd.split(" ")[1]);
                commands.get(loopCounter).add(new BackwardCommand(distance));
            }
            else if (cmd.matches("[Ll][Ee][Ff][Tt].*")) {
                double angle = Double.parseDouble(cmd.split(" ")[1]);
                commands.get(loopCounter).add(new LeftCommand(angle));
            }
            else if (cmd.matches("[Rr][Ii][Gg][Hh][Tt].*")) {
                double angle = Double.parseDouble(cmd.split(" ")[1]);
                commands.get(loopCounter).add(new RightCommand(angle));
            }
            else if (cmd.matches("[Ll][Oo][Oo][Pp].*")) {
                int amount = Integer.parseInt(cmd.split(" ")[1]);
                LoopCommand command =  new LoopCommand(amount);
                commands.get(loopCounter).add(command);
                loopCounter++;
                commands.add(command.getCommands());
            } else{
                throw new ParserException("Couldn't resolve command type");
            }

        }
        return commands.get(0);
    }
}
