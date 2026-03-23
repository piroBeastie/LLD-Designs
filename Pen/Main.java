public class Main {
    public static void main(String[] args) {

        Pen pen = PenFactory.getPen("gel", "blue", false);

        pen.start();
        pen.write("Hello");
        pen.close();

        System.out.println("---- Adding Grip ----");

        pen = new GripPen(pen);

        pen.start();
        pen.write("S");
        pen.close();
    }
}