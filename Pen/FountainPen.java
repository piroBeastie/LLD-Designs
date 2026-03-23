class FountainPen extends Pen {
    public FountainPen(String color, OpenCloseMechanism mechanism) {
        super(color, new FountainWriting(), mechanism);
    }
}