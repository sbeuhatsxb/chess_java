package Pieces;

import Board.GetSquareFromRankFile;
import Board.Square;

import java.util.*;

public interface PiecePos {
    static final char[] tebahpla = "hgfedcba".toCharArray();
    static final char[] alphabet = "abcdefgh".toCharArray();
    static final Hashtable<String, Piece> piecePos = new Hashtable<>();
    //DEPRECATED
    static final Map<String, Integer> convertMap = new HashMap<>();

    public static Piece getPieceFromPos(String pos) {
        return piecePos.get(pos);
    }

    static void setupPieceFromPos(String readablePos, Piece childClass){
        piecePos.put(readablePos, childClass);
    }

    //DEPRECATED
    static void setupConvertMap(String readablePos){
        /*Un peu tricky ici :
        La chaîne alphanumérique est inversée en raison de l'ordre de positionnement
        initial des pièces dans la boucle. Or dans un jeu d'échec, le a est "en bas".
        L'idée est de récupérer un "e" de redablePos qui renvoie "e1" par exemple

        On transforme le premier charactère de readablePos en vue de son calcul puis
        de son insertion en String
        */

        //Récupération du premier caractère (le seul)
        char c = readablePos.charAt(0);
        Character alphaChar = c;
        //La démarche ici consiste à récupérer 8 quand (alpha - a) vaut zero
        //Puis il suffit d'en récupérer la valeur absolue
        Integer rank = Math.abs(alphaChar - 'a' - 8);
        //On convertit enfin ce char en String
        String alpha = Character.toString(alphaChar);
        convertMap.put(alpha, rank);
        for (String i: convertMap.keySet()) {
            System.out.println("Key :" + i + " value " + convertMap.get(i));
        }
    }

    //DEPRECATED
    static int convertReadableRankToInt(String letter){
        return convertMap.get(letter);
    }

    static ArrayList<String> allowedMoves(String oldReadablePosition, Piece piece){
        boolean color = piece.getColor();
        boolean firstmove = piece.isFirstMove();
        int rank = piece.getRank();
        int file = piece.getFile();
        switch (piece.getShortname()) {
            case "P" -> {
                return pawnAllowedMoves(rank, file, color, firstmove);
            }
            default -> throw new IllegalStateException(
                    "This piece is not allowed");
        }
    }

    static ArrayList<String> pawnAllowedMoves(int rank, int file, boolean color, boolean firstmove){
        ArrayList<String> allowedMovesList = new ArrayList<String>();
        int newrank = 0;
        int newfile = file;
        if(!color){
            //Vérification du premier mouvement
            if(!firstmove){
                newrank = rank - 1;
            } else {
                newrank = rank - 2;
            }
            //Vérification de l'existence de pièces adjacentes


        } else {
            if(!firstmove){
                newrank = rank + 1;
            } else {
                newrank = rank + 2;
            }
            //Vérification de l'existence de pièces adjacentes
        }

        //Prise
        //!color
        //gauche rank+1 file-1
        //droite rank+1 file+1
        //color
        //gauche rank-1 file-1
        //droite rank-1 file+1
        //Square pieceExists = GetSquareFromRankFile.getSquarePos("a3");
        Square pieceExists = GetSquareFromRankFile.getSquarePos("c3");
        System.out.println(pieceExists.getHasPiece());
        //Déplacements verticaux
        for(int i = 1; i < newrank ; i++){
            System.out.println(i+rank + " " + newfile);
            if(inBoard(i+rank, newfile)){
                String s = convertIntToAlpha(newfile)+(i+rank);
                allowedMovesList.add(s);
            }
        }
        return allowedMovesList;
    }

    static int convertAlphaValue(String oldReadablePosition){
        char c = oldReadablePosition.charAt(0);
        int i = c - 'a';
        return i;
    }

    static int convertStringToInt(String oldReadablePosition){
        return Integer.valueOf(oldReadablePosition.substring(1,2));
    }

    static String convertIntToString(int rank){
        return String.valueOf(rank);
    }

    static String convertIntToAlpha(int file){
        return String.valueOf(alphabet[file]);
    }

    static boolean inBoard(int rank, int file){
        if((rank >= 0 && rank <= 7) && (file >= 0 && file <= 7)){
            return true;
        } else {
            return false;
        }
    }

}
