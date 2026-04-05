public class NearestLiftStrategy implements ICallLiftStrategy {

    @Override
    public Lift chooseLift(Lift[] lifts, Request request) {

        Lift closestLift = lifts[0];
        int minDistance = Math.abs(lifts[0].getCurrentLevel() - request.getFloor());

        for (Lift lift : lifts) {
            int distance = Math.abs(lift.getCurrentLevel() - request.getFloor());
            if (distance < minDistance) {
                minDistance = distance;
                closestLift = lift;
            }
        }

        return closestLift;
    }
}