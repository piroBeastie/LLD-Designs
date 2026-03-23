package SnakeAndLadder;

public class Player {
    private final int id;
    private int position;
    private boolean isActive;

    public Player(int id) {
        this.id = id;
        this.position = 1;
        this.isActive = true;
    }

    public int getId() {
        return id;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public boolean isActive() {
        return isActive;
    }

    public void deactivate() {
        this.isActive = false;
    }
}