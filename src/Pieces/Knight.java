package Pieces;

import java.util.ArrayList;

public class Knight extends Piece {

    public Knight(String pos){
        super(pos);
        shortname = "N";
    }

    @Override
    public ArrayList<String> allowedMoves(String oldReadablePosition) {
        return new ArrayList<String>();
    }
}
