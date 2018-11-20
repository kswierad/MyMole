package pl.edu.agh.cs.to2.Utils;

public class Coordinates {
    private final int x;
    private final int y;

    public Coordinates(int x, int y){
        this.x = x;
        this.y = y;
    }

    public Coordinates(Coordinates oldCoord, int moveX, int moveY){
        this.x = oldCoord.x + moveX;
        this.y = oldCoord.y + moveY;
    }
}
