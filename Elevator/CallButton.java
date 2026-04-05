public class CallButton implements IButton {

    private Floor currentFloor;
    private Direction moveDirection;
    private IRequestScheduler scheduler;

    public CallButton(Floor floor, Direction direction, IRequestScheduler scheduler) {
        this.currentFloor = floor;
        this.moveDirection = direction;
        this.scheduler = scheduler;
    }

    @Override
    public void press() {
        Request req = new Request(currentFloor.getNumber(), moveDirection);
        scheduler.submitRequest(req);
    }
}