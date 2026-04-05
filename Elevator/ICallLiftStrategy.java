public interface ICallLiftStrategy {
    Lift chooseLift(Lift[] lifts, Request request);
}