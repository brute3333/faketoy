package za.co.wethinkcode.toyrobot;

public class SprintCommand extends Command {
    @Override
    public boolean execute(Robot target) {
       int nrSteps = Integer.parseInt(getArgument());
       sprint (target,nrSteps);
       return true;
    }

    public void sprint(Robot target , int nrSteps) {
        
        
        if (nrSteps == 1){
            target.updatePosition(nrSteps );
            target.setStatus("Moved forward by " + nrSteps   + " steps.");
            return;
        }
        if (target.updatePosition(nrSteps )) {
            target.setStatus("Moved forward by "+ nrSteps   + " steps.");
            System.out.print(target + "\n");
            sprint(target, nrSteps - 1);
        }else target.setStatus("Sorry, i cannot go outside of my safe zone.");
    }
    public SprintCommand(String argument) {
        super("sprint",argument);
    }
}
