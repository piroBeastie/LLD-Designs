package SnakeAndLadder;

public class Main {
    public static void main(String[] args) {

        GameService service = new GameService();

        Game game = service.createGame(10, 2, Difficulty.EASY);

        game.start();
    }
}