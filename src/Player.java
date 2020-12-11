import Board.ColorInterface;
import Board.GetSquareFromRankFile;
import Board.Square;
import Pieces.*;

import java.util.ArrayList;

import static java.lang.Integer.parseInt;

public class Player {

    //True : Light player / False : Dark player
    private boolean player;

    public Player(){
        player = ColorInterface.Light;
    }

    public Piece getPieceWithPos(String rankFile){
        return PiecePos.getPieceFromPos(rankFile);
    }

    public void movePiece(String oldReadablePosition){

        Piece movingPiece = this.getPieceWithPos(oldReadablePosition);

        //movingPiece.setRank(PiecePos.convertReadableRankToInt(readablePosition.substring(0, 1)));
/*        int file = parseInt(readablePosition.substring(1, 2));
        movingPiece.setFile(file);*/
        int i = 1;
        for (String s: movingPiece.allowedMoves(oldReadablePosition)) {
            System.out.print(i + " : " + s + " | ");
            i++;
        }
        System.out.println();
        Square oldSquare = movingPiece.getSquare();

        oldSquare.setHasPiece(false);
    }

    public void movePieceTo(String oldReadablePosition, String nextPosition){
        Piece movingPiece = this.getPieceWithPos(oldReadablePosition);
        movingPiece.setPosition(nextPosition);
        Square newSquare = GetSquareFromRankFile.getSquarePos(nextPosition);
        newSquare.setPiece(movingPiece);
        movingPiece.setSquare(newSquare);
    }

}
