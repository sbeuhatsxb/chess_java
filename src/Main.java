import Board.Chessboard;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Chessboard chessboard = new Chessboard();

        Display.displayChessBoard(chessboard);

        Player player1 = new Player();
        Scanner scan = new Scanner(System.in);
        System.out.println("Quelle pièce souhaitez-vous bouger ?");
        String pieceToMove = scan.next();
        player1.movePiece(pieceToMove);

        System.out.println("Sur quelle case ?");
        String nextPosition = scan.next();

        player1.movePieceTo(pieceToMove, nextPosition);

        Display.displayChessBoard(chessboard);

    }

}

