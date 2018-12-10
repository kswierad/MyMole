package pl.edu.agh.cs.to2.Model;

public class Point {
    private final int x;
    private final int y;

    public Point(int x, int y){
        this.x = x;
        this.y = y;
    }

    public Point(Point oldPoint, int moveX, int moveY){
        this.x = oldPoint.x + moveX;
        this.y = oldPoint.y + moveY;
    }

    public Point(Point oldCoord){
        this.x = oldCoord.x;
        this.y = oldCoord.y;
    }
    public int getX(){return x;}
    public int getY(){return y;}

    public boolean isEqual(Point other){
        if(other.x -5 > this.x || other.x +5 < this.x) return false;
        if(other.y -5 > this.y || other.y +5 < this.y) return false;
        return true;
    }

    @Override
    public String toString(){
        return "(" + x + "," + y + ")";
    }
}
