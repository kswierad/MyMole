package pl.edu.agh.cs.to2.Model.Command;

import pl.edu.agh.cs.to2.Model.Mole;
import ch.obermuhlner.math.big.*;
import java.math.BigDecimal;
import java.math.MathContext;

public class RightCommand implements Command {

    MathContext mathContext = new MathContext(100);
    private BigDecimal angle;

    public RightCommand(double angle){
        this.angle = new BigDecimal(2*angle).divide(new BigDecimal(360), mathContext).multiply(BigDecimalMath.pi(mathContext));
    }

    @Override
    public void execute(Mole mole){
        BigDecimal oldAngle = mole.getAngle();
        mole.setAngle(oldAngle.add(angle));
    }
}

