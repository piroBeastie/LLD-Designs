class GripPen extends PenDecorator {
    public GripPen(Pen pen) {
        super(pen);
    }

    @Override
    public void write(String text) {
        System.out.print("Writing with grip: ");
        pen.write(text);
    }
}