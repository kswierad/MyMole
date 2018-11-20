package pl.edu.agh.cs.to2.Model;

import pl.edu.agh.cs.to2.Utils.Coordinates;
import pl.edu.agh.cs.to2.Utils.Direction;

import java.util.LinkedList;

public class Mole {
    private Direction direction;
    private Coordinates coords;
    private LinkedList<Command> commands = new LinkedList<>();

    public Direction getDirection(){return this.direction; }
    public Coordinates getCoords(){return coords;}

    public Mole(){
        direction = Direction.RIGHT;
        coords = new Coordinates(300,400);
    }

    public void execute(Command command){
        switch (command.type){
            case RIGHT:
                for (int i=command.value; i>0; i=-90){
                    direction = direction.turnRight();
                }
                break;
            case LEFT:
                for (int i=command.value; i>0; i=-90){
                    direction = direction.turnLeft();
                }
                break;
            case FORWARD:
                switch (direction){
                    case UP:
                        coords = new Coordinates(coords,0,command.value);
                        break;
                    case DOWN:
                        coords = new Coordinates(coords,0,-command.value);
                        break;
                    case LEFT:
                        coords = new Coordinates(coords,-command.value,0);
                        break;
                    case RIGHT:
                        coords = new Coordinates(coords,command.value,0);
                        break;
                }
            case BACKWARD:
                switch (direction){
                    case UP:
                        coords = new Coordinates(coords,0,-command.value);
                        break;
                    case DOWN:
                        coords = new Coordinates(coords,0,command.value);
                        break;
                    case LEFT:
                        coords = new Coordinates(coords,command.value,0);
                        break;
                    case RIGHT:
                        coords = new Coordinates(coords,-command.value,0);
                        break;
                }
        }

        commands.add(command);

    }



}
