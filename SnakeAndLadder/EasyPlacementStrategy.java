package SnakeAndLadder;

public class EasyPlacementStrategy implements PlacementStrategy {

    @Override
    public void placeJumps(Board board) {
        board.placeRandomJumps(board.getSize());
    }
}