package Board;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

public interface GetSquareFromRankFile {

    static final Hashtable<String, Square> squarePos = new Hashtable<>();

    static Square getSquarePos(String pos) {
        try{
            return squarePos.get(pos);
        } catch(NullPointerException e) {
            e.printStackTrace();
            return null;
        }
    }

    static void setSquarePos(String filePlusRank, Square square){
        squarePos.put(filePlusRank, square);
    }
}
