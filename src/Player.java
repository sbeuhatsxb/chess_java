import Board.ColorInterface;
import Board.GetSquareFromRankFile;
import Board.Square;
import Pieces.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static java.lang.Integer.parseInt;

public class Player {

    //True : Light player / False : Dark player
    private boolean player;
    private String name;
    private Map<String, Integer> convertMap = new HashMap<>();

    public Player(String name){
        player = ColorInterface.Light;
        this.name = name;
    }

    public Piece getPieceWithPos(String readablePos){
        return PiecePos.getPieceFromPos(readablePos);
    }

    public void movePiece(String oldReadablePosition){
        //TODO DEBUG FROM HERE
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
        Square newSquare = GetSquareFromRankFile.getSquarePos(nextPosition);
        newSquare.setPiece(movingPiece);
        movingPiece.setPosition(nextPosition);
        setupConvertMap(movingPiece, nextPosition);
        movingPiece.setSquare(newSquare);
        PiecePos.removeAndSetupPieceFromPos(oldReadablePosition, nextPosition, movingPiece);
        movingPiece.setFirstMove(false);
    }


    private void setupConvertMap(Piece piece, String readablePos){
        /*Un peu tricky ici :
        La chaîne alphanumérique est inversée en raison de l'ordre de positionnement
        initial des pièces dans la boucle. Or dans un jeu d'échec, le a est "en bas".
        L'idée est de récupérer un "e" de redablePos qui renvoie "e1" par exemple
        On transforme le premier charactère de readablePos en vue de son calcul puis
        de son insertion en String
        */

        //Conversion du premier caractère en chiffre
        char c = readablePos.charAt(0);
        Character alphaChar = c;
        //La démarche ici consiste à récupérer 8 quand (alpha - a) vaut zero
        //Puis il suffit d'en récupérer la valeur absolue
        Integer intFile = Math.abs(alphaChar - 'a' + 1);
        piece.setFile(intFile);
        int intRank = Character.getNumericValue(readablePos.charAt(1));
        piece.setRank(intRank);
    }


    public String getName() {
        return name;
    }
}
