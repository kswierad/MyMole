package pl.edu.agh.cs.to2.Model.Command;

import pl.edu.agh.cs.to2.Model.Coordinates;
import pl.edu.agh.cs.to2.Model.Mole;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;

import ch.obermuhlner.math.big.*;
import static java.lang.Math.*;

public class BackwardCommand implements Command {

    MathContext mathContext = new MathContext(100);

    public BackwardCommand(int distance) {
        this.distance = distance;
    }

    private int distance;

    @Override
    public void execute(Mole mole){
        BigDecimal angle = mole.getAngle();
        Coordinates coordinates = mole.getCoords();
        Coordinates newcoords = new Coordinates(coordinates, BigDecimalMath.cos(angle,mathContext).multiply(new BigDecimal(-distance)).intValue(),
                                        BigDecimalMath.sin(angle,mathContext).multiply(new BigDecimal(-distance)).intValue());
        mole.setCoords(newcoords);

    }
}
