package Pieces;

import java.util.ArrayList;

public class King extends Piece {

    public King(String pos){
        super(pos);
        shortname = "K";
    }

    @Override
    public ArrayList<String> allowedMoves(String oldReadablePosition) {
        firstMove = false;
        return new ArrayList<String>();
    }
}
