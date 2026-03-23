abstract class Pen {
    protected String color;
    protected WritingStrategy writingStrategy;
    protected OpenCloseMechanism mechanism;

    public Pen(String color,
               WritingStrategy writingStrategy,
               OpenCloseMechanism mechanism) {
        this.color = color;
        this.writingStrategy = writingStrategy;
        this.mechanism = mechanism;
    }

    public void start() {
        mechanism.open();
    }

    public void write(String text) {
        writingStrategy.write(text);
    }

    public void close() {
        mechanism.close();
    }

    public void refill() {
        System.out.println("Refilling " + color + " pen");
    }
}