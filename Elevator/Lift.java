import java.util.*;

public class Lift {

    private int currentLevel;
    private Direction currentDirection;
    private TreeSet<Integer> stops;

    public Lift() {
        this.currentLevel = 0;
        this.currentDirection = Direction.NONE;
        this.stops = new TreeSet<>();
    }

    public boolean isIdle() {
        return stops.isEmpty();
    }

    public void addStop(int floor) {
        stops.add(floor);
    }

    public void move() {
        if (stops.isEmpty()) return;

        int nextFloor = stops.first();

        if (nextFloor > currentLevel) {
            currentDirection = Direction.UP;
        } else if (nextFloor < currentLevel) {
            currentDirection = Direction.DOWN;
        }

        currentLevel = nextFloor;
        stops.remove(nextFloor);

        if (stops.isEmpty()) {
            currentDirection = Direction.NONE;
        }
    }

    public int getCurrentLevel() {
        return currentLevel;
    }

    public Direction getDirection() {
        return currentDirection;
    }
}