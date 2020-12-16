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
        piece.setFile(Math.abs(file-9));
        PiecePos.setupPieceFromPos(square.getReadablePos(), piece);
    }

    private void createChessboard(){
        for(int rank = 8; rank > 0; rank--){
            for(int file = 8; file > 0; file--) {
                Square square = new Square();
                //Transformation des iterateur en position lisible a1, a2... -> h8
                String readableLocation = square.getReadableLocation(rank, file);

                //Alimentation d'un tableau qui indexe les case avec des position
                GetSquareFromRankFile.setSquarePos(readableLocation, square);

                //Ajout des square au tableau de square en vue de sont parcours dans
                //l'interface Diplay
                squares.add(square);

                //Placement des pièce
                //Les pions
                if(rank == 2 || rank == 7){
                    square.setHasPiece(true);
                    if (rank == 2) {
                        feedPiece(square, new Pawn(readableLocation), ColorInterface.Light, rank, file);
                    } else {
                        feedPiece(square, new Pawn(readableLocation), ColorInterface.Dark, rank, file);
                    }
                }
                //Les autres pièces
                if(rank == 1 || rank == 8) {
                    square.setHasPiece(true);
                    boolean color = ColorInterface.Dark;
                    if (rank%2 == 0) {
                        color = ColorInterface.Dark;
                    } else {
                        color = ColorInterface.Light;
                    }

                    switch (file) {
                        case 1, 8 -> {
                            feedPiece(square, new Rook(readableLocation), color, rank, file);
                        }
                        case 2, 7 -> {
                            feedPiece(square, new Knight(readableLocation), color, rank, file);
                        }
                        case 3, 6 -> {
                            feedPiece(square, new Bishop(readableLocation), color, rank, file);
                        }
                        case 4 -> {
                            feedPiece(square, new Queen(readableLocation), color, rank, file);
                        }
                        case 5 -> {
                            feedPiece(square, new King(readableLocation), color, rank, file);
                        }
                        default -> throw new IllegalStateException(
                                "This square is not allowed");
                    }
                }
                //Fin Placement des pièce
            }
        }
    }
}