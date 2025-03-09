package Models;
import java.util.*;

public class Board{

    Character[][] grid;
    
    public Board(int size){
        
        grid = new Character[size][size];

        for(int i=0; i<size; i++){
            for(int j=0; j<size; j++){
                grid[i][j] = ' ';
            }
        }
    }

    public void printBoard(){
        for(int i=0; i<grid.length; i++){
            System.out.println(Arrays.toString(grid[i]));
        }
    }

    public Integer freeSpace(){
        Integer count = 0;
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid.length; j++){
                if(grid[i][j] == ' ') count++;
            }
        }
        return count;
    }

    public void addPlayerPiece(Integer i , Integer j, PlayerPiece p){
        Character piec = p.pieceType.toString().charAt(0);
        
        grid[i][j] = piec;
    }
}