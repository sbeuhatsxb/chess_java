package Board;
import Pieces.*;


import java.util.ArrayList;

public class Chessboard {

    ArrayList<Square> squares = new ArrayList<>();

    public Chessboard(){
        createChessboard();
    }

    public ArrayList<Square> getSquares() {
        return squares;
    }

    private void feedPiece(Square square, Piece piece, boolean color, int rank, int file){
        square.setPiece(piece);
        piece.setColor(color);
        piece.setSquare(square);
        piece.setRank(rank);
        piece.setFile(Math.abs(file-7));
        PiecePos.setupPieceFromPos(square.getReadablePos(), piece);
    }

    private void createChessboard(){
        for(int rank = 7; rank > -1; rank--){
            for(int file = 7; file > -1; file--) {
                Square square = new Square();
                //Transformation des iterateur en position lisible a1, a2... -> h8
                String readableLocation = square.getReadableLocation(rank, file);

                //Alimentation d'un tableau en vue du futur déplacement des pièces
                //DEPRECATED
                //PiecePos.setupConvertMap(readableLocation);

                //Alimentation d'un tableau qui indexe les case avec des position
                GetSquareFromRankFile.setSquarePos(readableLocation, square);

                //Ajout des square au tableau de square en vue de sont parcours dans
                //l'interface Diplay
                squares.add(square);

                //Placement des pièce
                //Les pions
                if(rank == 1 || rank == 6){
                    square.setHasPiece(true);
                    if (rank == 1) {
                        feedPiece(square, new Pawn(readableLocation), ColorInterface.Light, rank, file);
                    } else {
                        feedPiece(square, new Pawn(readableLocation), ColorInterface.Dark, rank, file);
                    }
                }
                //Les autres pièces
                if(rank == 0 || rank == 7) {
                    square.setHasPiece(true);
                    boolean color = ColorInterface.Dark;
                    if (rank%2 == 0) {
                        color = ColorInterface.Light;
                    } else {
                        color = ColorInterface.Dark;
                    }

                    switch (file) {
                        case 0, 7 -> {
                            feedPiece(square, new Rook(readableLocation), color, rank, file);
                        }
                        case 1, 6 -> {
                            feedPiece(square, new Knight(readableLocation), color, rank, file);
                        }
                        case 2, 5 -> {
                            feedPiece(square, new Bishop(readableLocation), color, rank, file);
                        }
                        case 3 -> {
                            feedPiece(square, new Queen(readableLocation), color, rank, file);
                        }
                        case 4 -> {
                            feedPiece(square, new King(readableLocation), color, rank, file);
                        }
                        default -> throw new IllegalStateException(
                                "This piece is not allowed");
                    }
                }
                //Fin Placement des pièce
            }
        }
    }
}