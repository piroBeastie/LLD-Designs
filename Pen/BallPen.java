class BallPen extends Pen {
    public BallPen(String color, OpenCloseMechanism mechanism) {
        super(color, new BallWriting(), mechanism);
    }
}