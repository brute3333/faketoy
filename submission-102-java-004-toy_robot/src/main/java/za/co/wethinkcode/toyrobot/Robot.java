package za.co.wethinkcode.toyrobot;

import java.util.Arrays;
import java.util.List;

public class Robot {
    private final Position TOP_LEFT = new Position(-200,100);
    private final Position BOTTOM_RIGHT = new Position(100,-200);

    public static final Position CENTRE = new Position(0,0);

    private Position position;
    private Direction currentDirection;
    private String status;
    private String name;

    public Robot(String name) {
        this.name = name;
        this.status = "Ready";
        this.position = CENTRE;
        this.currentDirection = Direction.UP;
//        this.commandHistory = new ArrayList<();
    }

    public String getStatus() {
        return this.status;
    }

    public Direction getCurrentDirection() {
        return this.currentDirection;
    }

    public boolean handleCommand(Command command) {
        return command.execute(this);
    }

    public boolean updatePosition(int nrSteps){
        int newX = this.position.getX();
        int newY = this.position.getY();

        if (Direction.UP.equals(this.currentDirection)) {
            newY += nrSteps;
        } else if (Direction.DOWN.equals(this.currentDirection)) {
            newY -= nrSteps;
        } else if (Direction.RIGHT.equals(this.currentDirection)) {
            newX += nrSteps;
        } else if (Direction.LEFT.equals(this.currentDirection)) {
            newX -= nrSteps;
        }
        

        Position newPosition = new Position(newX, newY);
        if (newPosition.isIn(TOP_LEFT,BOTTOM_RIGHT)){
            this.position = newPosition;
            return true;
        }
        return false;
    }

    public void turnLeft(){
        switch (this.currentDirection) {
            case UP:
                this.currentDirection = Direction.LEFT;
                break;
            case LEFT:
                this.currentDirection = Direction.DOWN;
                break;
            case DOWN:
                this.currentDirection = Direction.RIGHT;
                break;
            case RIGHT:
                this.currentDirection = Direction.UP;
                break;
        }
    }

    public void turnRight(){
        switch (this.currentDirection) {
            case UP:
                this.currentDirection = Direction.RIGHT;
                break;
            case RIGHT:
                this.currentDirection = Direction.DOWN;
                break;
            case DOWN:
                this.currentDirection = Direction.LEFT;
                break;
            case LEFT:
                this.currentDirection = Direction.UP;
                break;
        }
    }
    

    @Override
    public String toString() {
       return "[" + this.position.getX() + "," + this.position.getY() + "] "
               + this.name + "> " + this.status;
    }

    public Position getPosition() {
        return this.position;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getName() {
        return name;
    }
}