package pl.edu.agh.cs.to2.Model.Command;

import pl.edu.agh.cs.to2.Model.Mole;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class LoopCommand implements Command {

    private List<Command> commands = new ArrayList<>();

    public LoopCommand(int amount) {
        this.amount = amount;
    }

    private int amount;

    public void addCommand(Command command){
        this.commands.add(command);
    }

    public List<Command> getCommands(){ return commands; }


    @Override
    public void execute(Mole mole){
        IntStream.range(0,amount).forEach( i -> {
            for(Command cmd : commands) cmd.execute(mole);
        });
    }
}
