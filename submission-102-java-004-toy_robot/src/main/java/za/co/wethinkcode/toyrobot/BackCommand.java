package za.co.wethinkcode.toyrobot;

public class BackCommand extends Command {

    public BackCommand(String argument) {
        super( "back" ,argument);
    }

    @Override
    public boolean execute(Robot robot) {
        int nrSteps = 0;
        try {
            nrSteps = Integer.parseInt(getArgument());
        } catch (NumberFormatException e) {
            robot.setStatus("Invalid argument for forward command.");
            return true;
        }

        if (robot.updatePosition(-nrSteps)) {
            robot.setStatus("Moved back by " + nrSteps + " steps.");
        } else {
            robot.setStatus("Sorry, I cannot go outside my safe zone.");
        }
        return true;
    }
}
