package pl.edu.agh.cs.to2.Command;

import pl.edu.agh.cs.to2.Model.Mole;

public class UpCommand implements Command{


    @Override
    public void execute(Mole mole){
        mole.setIsDown(Boolean.FALSE);

    }
}
