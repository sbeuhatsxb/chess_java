package Board;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

public interface GetSquareFromRankFile {

    static final Hashtable<String, Square> squarePos = new Hashtable<>();

    static Square getSquarePos(String pos) {
        return squarePos.get(pos);
    }

    static void setSquarePos(String filePlusRank, Square square){
        squarePos.put(filePlusRank, square);
    }
}
