package SnakeAndLadder;

import java.util.*;

public class GameService {

    public Game createGame(int n, int numPlayers, Difficulty difficulty) {
        Board board = new Board(n);

        PlacementStrategy strategy =
                (difficulty == Difficulty.EASY)
                        ? new EasyPlacementStrategy()
                        : new HardPlacementStrategy();

        strategy.placeJumps(board);

        List<Player> players = new ArrayList<>();
        for (int i = 1; i <= numPlayers; i++) {
            players.add(new Player(i));
        }

        return new Game(board, players);
    }
}