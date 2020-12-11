package Pieces;

import java.math.RoundingMode;
import java.util.ArrayList;

public class Pawn extends Piece {

    boolean firstMove = true;

    public Pawn(String pos){
        super(pos);
        shortname = "P";
    }

    public Class<?> promotion(Class newPiece){
        switch (newPiece.getSimpleName()) {
            case "Queen" :
            case "Rook" :
            case "Bishop" :
            case "Knight" :
                return newPiece;
            default : throw new IllegalStateException(
                    "This piece is not allowed");
        }
    }

    @Override
    public ArrayList<String> allowedMoves(String oldReadablePosition) {
        return PiecePos.allowedMoves(oldReadablePosition, this);
    }
}
