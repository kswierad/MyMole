package pl.edu.agh.cs.to2.Model.Command;

import pl.edu.agh.cs.to2.Model.Mole;

import java.math.BigDecimal;

public class LeftCommand implements Command {
    public LeftCommand(double angle) {
        this.angle = angle;
    }

    private double angle;

    @Override
    public void execute(Mole mole){
        double oldAngle = mole.getAngle();
        if(oldAngle >= 0)
            mole.setAngle(oldAngle - angle);
        else
            mole.setAngle(oldAngle + angle);

    }
}