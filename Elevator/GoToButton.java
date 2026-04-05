public class GoToButton implements IButton {

    private int destinationFloor;
    private Lift assignedLift;

    public GoToButton(int floor, Lift lift) {
        this.destinationFloor = floor;
        this.assignedLift = lift;
    }

    @Override
    public void press() {
        assignedLift.addStop(destinationFloor);
    }
}