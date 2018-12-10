package pl.edu.agh.cs.to2.Model;

public class Vector {

    private final Point start;

    public Point getStart() {
        return start;
    }

    public Point getEnd() {
        return end;
    }

    private final Point end;

    public Vector(Point start, Point end){
        this.start = start;
        this.end = end;
    }




    public Boolean contains(Point point){
        if(start.getX() == end.getX())
            return point.getX()==start.getX();
        if(start.getY() == end.getY())
            return point.getY() == start.getY();
        double slope =  (double)(end.getY() - start.getY())/ (double)(end.getX() - start.getX());
        return Math.abs(slope* (point.getX() - start.getX()) - point.getY()) < 5;
    }
}
