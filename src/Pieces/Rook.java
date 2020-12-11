package Pieces;

import java.util.ArrayList;

public class Rook extends Piece {

    public Rook(String pos) {
        super(pos);
        shortname = "R";
    }

    @Override
    public ArrayList<String> allowedMoves(String oldReadablePosition) {
        firstMove = false;
        return new ArrayList<String>();
    }
}
