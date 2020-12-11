package Pieces;

import java.util.ArrayList;

public class Bishop extends Piece {

    public Bishop(String pos){
        super(pos);
        shortname = "B";
    }

    @Override
    public ArrayList<String> allowedMoves(String oldReadablePosition) {
        return new ArrayList<String>();
    }

}
