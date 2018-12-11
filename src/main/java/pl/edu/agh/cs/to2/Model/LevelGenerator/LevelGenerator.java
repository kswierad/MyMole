package pl.edu.agh.cs.to2.Model.LevelGenerator;

import pl.edu.agh.cs.to2.Model.Level;
import pl.edu.agh.cs.to2.Model.Point;

import java.util.LinkedList;
import java.util.List;

public class LevelGenerator {

    public List<Level> generate(){
        List<Point> points = new LinkedList<>();
        List<Level> ret = new LinkedList<>();
        points.add(new Point(300, 400));
        points.add(new Point(400, 400));
        points.add(new Point(400, 300));
        points.add(new Point(300, 300));
        ret.add(new Level(points, "\nSquare to right and up of side length 100"));
        points.clear();

        points.add(new Point(300, 400));
        points.add(new Point(400, 400));
        points.add(new Point(350, 314));
        ret.add(new Level(points, "\nEquilateral triangle to the right and up of side length 100"));
        points.clear();

        points.add(new Point(300, 400));
        points.add(new Point(400, 400));
        points.add(new Point(470, 330));
        points.add(new Point(470, 230));
        points.add(new Point(400, 160));
        points.add(new Point(300, 160));
        points.add(new Point(230, 230));
        points.add(new Point(230, 330));
        ret.add(new Level(points, "\nRegular octagon to the right and up of side length 100"));
        points.clear();

        points.add(new Point(300, 400));
        points.add(new Point(250, 400));
        points.add(new Point(250, 350));
        points.add(new Point(300, 350));
        ret.add(new Level(points, "\nSquare to the left and up of side length 50"));
        points.clear();

        return ret;
    }
}
