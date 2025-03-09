package Models;
import java.util.*;


public class StartGame{
    public Deque<Players>players;
    public Board gameBoard;

    public StartGame(){
        start();
    }
    public void start(){
        players = new LinkedList<>();
        PlayerPiece playerx = new PlayerPieceX();
        Players player1 = new Players("playerX",playerx);

        PlayerPiece playero = new PlayerPieceO();
        Players player2 = new Players("playerO",playero);

        players.addLast(player1);
        players.addLast(player2);

        gameBoard = new Board(3);
    }

    public String winner(){
        boolean iswinner = true;
        Scanner scanner = new Scanner(System.in);
        while(iswinner){
            gameBoard.printBoard();
            
            Integer freespace = gameBoard.freeSpace();

            if(freespace== 0){
                return "tie";
            }


            Players player = players.getFirst();
            System.out.print("Chance of "+ player.name +" : ");


            String word = scanner.next();
            String[] token = word.split(",");
            
            Integer i = Integer.parseInt(token[0]);
            Integer j = Integer.parseInt(token[1]);
            
            if(gameBoard.grid[i][j] != ' '){
                System.out.println("Invalid move, Try Again");
                continue;
            }
            
            gameBoard.addPlayerPiece(i,j,player.piece);
            
            Boolean ischeckwinner =  checkwinner(i, j, player.piece);
            
            if(ischeckwinner){
                return player.name;
            }

            players.pollFirst();
            players.addLast(player);
            
        }
        scanner.close();
        return "tie";
    }

    public boolean checkwinner(Integer m, Integer n, PlayerPiece p){

        boolean isrow = true;
        boolean iscol = true;
        boolean isdiagonal = true;
        boolean isantidiagonal = true;


        for(int i=0; i<gameBoard.grid.length; i++){
            if(gameBoard.grid[m][i] == ' ' || gameBoard.grid[m][i] != p.pieceType.toString().charAt(0)){
                isrow = false;
                break;
            }
        }


        for(int i=0; i<gameBoard.grid.length; i++){
            if(gameBoard.grid[i][n] == ' ' || gameBoard.grid[i][n] != p.pieceType.toString().charAt(0)){
                iscol = false;
                break;
            }
        }

        for(int i=0, j=0; i<gameBoard.grid.length; i++,j++){
            if(gameBoard.grid[i][j] == ' ' || gameBoard.grid[i][j] != p.pieceType.toString().charAt(0)){
                isdiagonal = false;
                break;
            }
        }

        for(int i=0, j=gameBoard.grid.length - 1; i<gameBoard.grid.length; i++,j--){
            if(gameBoard.grid[i][j] == ' ' || gameBoard.grid[i][j] != p.pieceType.toString().charAt(0)){
                isantidiagonal = false;
                break;
            }
        }
        
        return isrow || iscol || isdiagonal || isantidiagonal;

    }


}