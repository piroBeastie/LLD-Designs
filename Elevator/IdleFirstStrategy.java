public class IdleFirstStrategy implements ICallLiftStrategy {

    @Override
    public Lift chooseLift(Lift[] lifts, Request request) {
        for (Lift lift : lifts) {
            if (lift.isIdle()) {
                return lift;
            }
        }
        return lifts[0];
    }
}