public class LookScheduler implements IRequestScheduler {

    private Lift[] lifts;
    private ICallLiftStrategy strategy;

    public LookScheduler(Lift[] lifts, ICallLiftStrategy strategy) {
        this.lifts = lifts;
        this.strategy = strategy;
    }

    @Override
    public void submitRequest(Request request) {
        Lift selectedLift = strategy.chooseLift(lifts, request);
        selectedLift.addStop(request.getFloor());
    }
}