package pl.edu.agh.cs.to2.Model;

import java.util.LinkedList;
import java.util.List;

public class Level {

    public List<Vector> getVectors() {
        return vectors;
    }

    private final List<Vector> vectors;

    public String getDescription() {
        return description;
    }

    private String description;

    public Level(List<Point> points){
        vectors = new LinkedList<>();
        for (int i=0; i < points.size()-1; i++){

            vectors.add(new Vector(points.get(i), points.get(i+1)));
        }
        vectors.add(new Vector(points.get(points.size()-1), points.get(0)));
    }

    public Level(List<Point> points, String description){
        this.description = description;
        vectors = new LinkedList<>();
        for (int i=0; i < points.size()-1; i++){

            vectors.add(new Vector(points.get(i), points.get(i+1)));
        }
        vectors.add(new Vector(points.get(points.size()-1), points.get(0)));
    }

    @Override
    public String toString(){
        StringBuilder bld = new StringBuilder();
        for(Vector vec : vectors) {
            bld.append(vec);
            bld.append("\n");
        }
        return bld.toString();
    }


}
