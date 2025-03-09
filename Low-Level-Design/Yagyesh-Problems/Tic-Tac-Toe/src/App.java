import Models.StartGame;
import Models.PlayerPiece;
import Models.PlayerPieceX;
import Models.PlayerPieceO;
import Models.Board;

public class App {
    public static void main(String[] args) throws Exception {
        StartGame game = new StartGame();
        System.out.println("Winner is : "+ game.winner());
    }
}
