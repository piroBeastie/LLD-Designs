public class Main {

    public static void main(String[] args) {

        Lift[] lifts = new Lift[2];
        lifts[0] = new Lift();
        lifts[1] = new Lift();

        ICallLiftStrategy strategy = new IdleFirstStrategy();
        IRequestScheduler scheduler = new LookScheduler(lifts, strategy);

        Floor floor = new Floor(3);

        CallButton callBtn = new CallButton(floor, Direction.UP, scheduler);
        callBtn.press();

        System.out.println("Before move: " + lifts[0].getCurrentLevel());

        lifts[0].move();

        System.out.println("After move: " + lifts[0].getCurrentLevel());
    }
}