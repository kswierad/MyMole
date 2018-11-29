package pl.edu.agh.cs.to2.Model.Command;

import pl.edu.agh.cs.to2.Model.Mole;

import java.math.BigDecimal;

public class RightCommand implements Command {
    private double angle;

    public RightCommand(double angle){
        this.angle = angle;
    }

    @Override
    public void execute(Mole mole){
        double oldAngle = mole.getAngle();
        if(oldAngle >= 0)
            mole.setAngle(oldAngle + angle);
        else
            mole.setAngle(oldAngle - angle);
    }
}

