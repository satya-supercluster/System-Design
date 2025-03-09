package Models;

public abstract class PlayerPiece{
    PieceType pieceType;
    public PlayerPiece(){};
    public PlayerPiece(PieceType pieceType){
        this.pieceType = pieceType;
    };
}