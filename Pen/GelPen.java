class GelPen extends Pen {
    public GelPen(String color, OpenCloseMechanism mechanism) {
        super(color, new GelWriting(), mechanism);
    }
}