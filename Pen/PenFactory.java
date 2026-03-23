class PenFactory {

    public static Pen getPen(String type, String color, boolean withCap) {

        OpenCloseMechanism mechanism =
                withCap ? new Cap() : new Click();

        switch (type.toLowerCase()) {
            case "gel":
                return new GelPen(color, mechanism);

            case "ball":
                return new BallPen(color, mechanism);

            case "fountain":
                return new FountainPen(color, mechanism);

            default:
                throw new IllegalArgumentException("Invalid pen type: " + type);
        }
    }
}