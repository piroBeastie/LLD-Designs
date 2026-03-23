abstract class PenDecorator extends Pen {

    protected Pen pen;

    public PenDecorator(Pen pen) {
        super(pen.color, pen.writingStrategy, pen.mechanism);
        this.pen = pen;
    }

    public void start() {
        pen.start();
    }

    public void close() {
        pen.close();
    }

    public void refill() {
        pen.refill();
    }
}