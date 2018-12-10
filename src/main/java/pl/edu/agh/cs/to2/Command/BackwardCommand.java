package pl.edu.agh.cs.to2.Command;

import pl.edu.agh.cs.to2.Model.Point;
import pl.edu.agh.cs.to2.Model.Mole;

import java.math.BigDecimal;
import java.math.MathContext;

import ch.obermuhlner.math.big.*;

public class BackwardCommand implements Command {

    MathContext mathContext = new MathContext(100);

    public BackwardCommand(int distance) {
        this.distance = distance;
    }

    private int distance;

    @Override
    public void execute(Mole mole){
        BigDecimal angle = mole.getAngle();
        Point point = mole.getPoint();
        Point newcoords = new Point(point, BigDecimalMath.cos(angle,mathContext).multiply(new BigDecimal(-distance)).intValue(),
                                        BigDecimalMath.sin(angle,mathContext).multiply(new BigDecimal(-distance)).intValue());
        mole.setCoords(newcoords);

    }
}
