package pl.edu.agh.cs.to2.Command;

import pl.edu.agh.cs.to2.Model.Mole;

public class DownCommand implements Command{


    @Override
    public void execute(Mole mole){
        mole.setIsDown(Boolean.TRUE);

    }
}
