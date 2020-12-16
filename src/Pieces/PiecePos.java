package Pieces;

import Board.GetSquareFromRankFile;
import Board.Square;

import java.util.*;

public interface PiecePos {
    //Pushing one caracter in the begining since index begins with 1;
    static final char[] alphabet = "$abcdefgh".toCharArray();
    static final char[] tebahpla = "$hgfedcba".toCharArray();
    static final Hashtable<String, Piece> piecePos = new Hashtable<>();

    public static Piece getPieceFromPos(String pos) {
        return piecePos.get(pos);
    }

    static void setupPieceFromPos(String readablePos, Piece childClass){
        piecePos.put(readablePos, childClass);
    }

    static void removeAndSetupPieceFromPos(String oldPosition, String readablePos, Piece childClass){
        piecePos.remove(oldPosition);
        piecePos.put(readablePos, childClass);
    }

    static ArrayList<String> allowedMoves(Piece piece){
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

        //Position à partir de laquelle on bouge
        int maxRankRange = 0;
        int maxFileRange = 1;
        int newfile = file;

        if(!color){
            //Vérification du premier mouvement
            if(!firstmove){
                maxRankRange = -1;
            } else {
                maxRankRange = -2;
            }
            //Vérification de l'existence de pièces adjacentes


        } else {
            if(!firstmove){
                maxRankRange = 1;
            } else {
                maxRankRange = 2;
            }
            //Vérification de l'existence de pièces adjacentes
        }

        //Piece exists
        //gauche rank+1 file-1
        //droite rank+1 file+1
        //color
        //gauche rank-1 file-1
        //droite rank-1 file+1
        ArrayList<String> catchList = new ArrayList<>();
        if(color){
            //Prise en diagonale
            catchList.add(convertIntToAlpha(file+1)+(rank+1));
            catchList.add(convertIntToAlpha(file-1)+(rank+1));
        } else {
            catchList.add(convertIntToAlpha(file-1)+(rank-1));
            catchList.add(convertIntToAlpha(file+1)+(rank-1));
        }
        for (String readablePos:catchList
             ) {
            Square square = GetSquareFromRankFile.getSquarePos(readablePos);
            if(square != null && square.getHasPiece()){
                Piece piece = square.getPiece();
                if(color == !piece.getColor()){
                    allowedMovesList.add(readablePos);
                }
            }
        }


        //Déplacements verticaux
        int diff = Math.abs(rank - (rank+maxRankRange));
        int j;
        for(int i = 1; i <= diff; i++){
            //Si la couleur est noire, on prend l'opposé de i pour le calcul
            j = (!color)?i*-1:i;
            if(inBoard(rank + j, newfile)){
                String s = convertIntToAlpha(newfile)+(rank + j);
                if(!GetSquareFromRankFile.getSquarePos(s).getHasPiece()){
                    allowedMovesList.add(s);
                }
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
        if((rank >= 1 && rank <= 8) && (file >= 1 && file <= 8)){
            return true;
        } else {
            return false;
        }
    }



}
