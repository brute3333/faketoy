package za.co.wethinkcode.toyrobot;

public class ForwardCommand extends Command {

    public ForwardCommand(String argument) {
        super("forward", argument);
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

        if (robot.updatePosition(nrSteps)) {
            robot.setStatus("Moved forward by " + nrSteps + " steps.");
        } else {
            robot.setStatus("Sorry, I cannot go outside my safe zone.");
        }
        return true;
    }
}
// public class ForwardCommand extends Command {
//     @Override
//     public boolean execute(Robot target) {
//         int nrSteps = Integer.parseInt(getArgument());
//         if (target.updatePosition(nrSteps)){
//             target.setStatus("Moved forward by "+nrSteps+" steps.");
//         } else {
//             target.setStatus("Sorry, I cannot go outside my safe zone.");
//         }
//         return true;
//     }

//     public ForwardCommand(String argument) {
//         super("forward", argument);
//     }
// }

