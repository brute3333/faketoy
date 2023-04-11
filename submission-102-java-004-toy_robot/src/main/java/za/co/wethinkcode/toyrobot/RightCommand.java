// package za.co.wethinkcode.toyrobot;

// public class RightCommand extends Command {
//     public RightCommand() {
//         super("right");
//     }
    
//    @Override
//    public boolean execute(Robot target) {target.updatePosition(0);
//            target.setStatus("Turned right.");

//        return true;
//    }

// }

package za.co.wethinkcode.toyrobot;

public class RightCommand extends Command {
    public RightCommand() {
        super("right");
    }

    @Override
    public boolean execute(Robot target) {
        target.turnRight();
        target.setStatus("Turned right.");
        return true;
    }
}
