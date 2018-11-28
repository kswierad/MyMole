package pl.edu.agh.cs.to2.Model;

public class Command {

    public final CommandType type;

    public final int value;

    public Command(int value, CommandType type){
        this.value = value;
        this.type = type;
    }
}
