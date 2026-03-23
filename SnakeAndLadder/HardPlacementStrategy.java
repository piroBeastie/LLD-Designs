package SnakeAndLadder;

public class HardPlacementStrategy implements PlacementStrategy {

    @Override
    public void placeJumps(Board board) {
        board.placeRandomJumps(board.getSize() * 2);
    }
}