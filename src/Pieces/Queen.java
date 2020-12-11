package Pieces;

import java.util.ArrayList;

public class Queen extends Piece {

    public Queen(String pos){
        super(pos);
        shortname = "Q";
    }

    @Override
    public ArrayList<String> allowedMoves(String oldReadablePosition) {
        return new ArrayList<String>();
    }
}
