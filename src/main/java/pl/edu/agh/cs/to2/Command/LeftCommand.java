package pl.edu.agh.cs.to2.Command;

import pl.edu.agh.cs.to2.Model.Mole;
import ch.obermuhlner.math.big.*;
import java.math.BigDecimal;
import java.math.MathContext;

public class LeftCommand implements Command {

    MathContext mathContext = new MathContext(4);
    public LeftCommand(double angle) {
        this.angle = new BigDecimal(2*angle).divide(new BigDecimal(360),mathContext).multiply(BigDecimalMath.pi(mathContext));
    }

    private BigDecimal angle;

    @Override
    public void execute(Mole mole){
        BigDecimal oldAngle = mole.getAngle();
        mole.setAngle(oldAngle.subtract(angle));
    }
}