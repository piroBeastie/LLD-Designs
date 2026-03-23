package SnakeAndLadder;

import java.util.*;

public class Game {
    private final Board board;
    private final Queue<Player> players;
    private final Dice dice;
    private final int max;
    private GameStatus status;

    public Game(Board board, List<Player> playerList) {
        this.board = board;
        this.players = new LinkedList<>(playerList);
        this.dice = new Dice();
        this.max = board.getMax();
        this.status = GameStatus.NOT_STARTED;
    }

    public void start() {
        status = GameStatus.IN_PROGRESS;

        while (status == GameStatus.IN_PROGRESS) {
            playTurn();

            if (getActivePlayers() <= 1) {
                status = GameStatus.FINISHED;
            }
        }

        System.out.println("Game Over!");
    }

    public void playTurn() {
        Player player = getNextActivePlayer();
        if (player == null) return;

        int roll = dice.roll();
        int nextPos = player.getPosition() + roll;

        if (nextPos > max) {
            System.out.println("Player " + player.getId() + " rolled " + roll + " (cannot move)");
        } else {
            nextPos = board.getJump(nextPos);
            player.setPosition(nextPos);

            System.out.println("Player " + player.getId() + " rolled " + roll + " → moved to " + nextPos);

            if (nextPos == max) {
                System.out.println("Player " + player.getId() + " WINS!");
                player.deactivate();
            }
        }

        if (player.isActive()) {
            players.offer(player);
        }
    }

    private Player getNextActivePlayer() {
        int size = players.size();

        while (size-- > 0) {
            Player p = players.poll();
            if (p.isActive()) return p;
            players.offer(p);
        }

        return null;
    }

    private int getActivePlayers() {
        int count = 0;
        for (Player p : players) {
            if (p.isActive()) count++;
        }
        return count;
    }
}