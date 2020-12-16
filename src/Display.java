import Board.Chessboard;
import Board.Square;

public interface Display {
    static final String ANSI_RESET = "\u001B[0m";
    static final String ANSI_BLACK = "\u001B[30m";
    static final String ANSI_RED = "\u001B[31m";
    static final String ANSI_GREEN = "\u001B[32m";
    static final String ANSI_YELLOW = "\u001B[33m";
    static final String ANSI_BLUE = "\u001B[34m";
    static final String ANSI_PURPLE = "\u001B[35m";
    static final String ANSI_CYAN = "\u001B[36m";
    static final String ANSI_WHITE = "\u001B[37m";


    static void displayChessBoard(Chessboard chessboard){
        int fullTabsize = 43;
        System.out.println(
                "\n" + Pad.padHyphen("-", fullTabsize)
        );
        int i = 0;
        for (Square square : chessboard.getSquares()) {
            String pieceName = "";
            String shortName = "  ";
            String pieceColor = "";
            String displayPieceColor = "";
            if(square.getHasPiece()){
                pieceName = square.getPiece().getName();
                if(square.getPiece().getColor()){
                    pieceColor = "White";
                } else {
                    pieceColor = "Black";
                }
                shortName = square.getPiece().getShortname();
                displayPieceColor = pieceColor.substring(0, 1).toLowerCase();
            }
            i++;

            if(pieceColor == "Black"){
                System.out.print(
                        " | " + ANSI_RED + shortName + displayPieceColor + ANSI_RESET
                );
            } else {
                System.out.print(
                        " | " + ANSI_YELLOW + shortName + displayPieceColor + ANSI_RESET
                );
            }
            if(i%8 == 0){
                System.out.print(
                        " | "
                );
                System.out.println(
                        "\n" + Pad.padHyphen("-", fullTabsize)
                );
            }
        }
    }


    //DEBUG CHESSBOARD
    static void displayChessBoard2(Chessboard chessboard){
        int fullTabsize = 43;
        System.out.println(
                "\n" + Pad.padHyphen("-", fullTabsize)
        );
        int i = 0;
        for (Square square : chessboard.getSquares()) {
            String pieceName = "";
            String shortName = "  ";
            String pieceColor = "";
            String displayPieceColor = "";
            if(square.getHasPiece()){
                pieceName = square.getPiece().getName();
                if(square.getPiece().getColor()){
                    pieceColor = "White";
                } else {
                    pieceColor = "Black";
                }
                shortName = square.getPiece().getShortname();
                displayPieceColor = pieceColor.substring(0, 1).toLowerCase();
            }
            i++;

            if(pieceColor == "Black"){
                System.out.print(
                        " | " + ANSI_RED + /* square.getId() + " * " + square.getLocation()[0] + square.getLocation()[1] + " * " + */ square.getReadablePos() +ANSI_RESET
                );
            } else {
                System.out.print(
                        " | " + ANSI_YELLOW + /* square.getId() + " * " + square.getLocation()[0] + square.getLocation()[1] + " * " + */ square.getReadablePos() + ANSI_RESET
                );
            }
            if(i%8 == 0){
                System.out.print(
                        " | "
                );
                System.out.println(
                        "\n" + Pad.padHyphen("-", fullTabsize)
                );
            }
        }
    }

    //DEBUG PIECES
    static void displayChessBoard3(Chessboard chessboard){
        int fullTabsize = 43;
        System.out.println(
                "\n" + Pad.padHyphen("-", fullTabsize)
        );
        int i = 0;
        for (Square square : chessboard.getSquares()) {
            String pieceName = "";
            String shortName = "  ";
            String pieceColor = "";
            String displayPieceColor = "";
            if(square.getHasPiece()){
                pieceName = square.getPiece().getName();
                if(square.getPiece().getColor()){
                    pieceColor = "White";
                } else {
                    pieceColor = "Black";
                }
                shortName = square.getPiece().getShortname();
                displayPieceColor = pieceColor.substring(0, 1).toLowerCase();
            }
            i++;

            if(pieceColor == "Black"){
                System.out.print(
                        " | " + ANSI_RED + square.getPiece().getPosition() +ANSI_RESET
                );
            } else {
                if(square.getPiece() != null){
                    System.out.print(
                            " | " + ANSI_YELLOW + square.getPiece().getPosition() + ANSI_RESET
                    );
                }
            }
            if(i%8 == 0){
                System.out.print(
                        " | "
                );
                System.out.println(
                        "\n" + Pad.padHyphen("-", fullTabsize)
                );
            }
        }
    }
}
