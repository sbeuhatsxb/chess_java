import Board.Chessboard;
import Pieces.PiecePos;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Chessboard chessboard = new Chessboard();
        Rules rules = new Rules();
        Display.displayChessBoard(chessboard);

        Player player1 = new Player("Adalbéron");
        Player player2 = new Player("Osburge");
        boolean switchPlayer = true;
        do {
            Player player = (switchPlayer)?player1:player2;
            Scanner scan = new Scanner(System.in);
            System.out.println(player.getName() + " : Quelle pièce souhaitez-vous bouger ?");
            String pieceToMove = scan.next();
            player1.movePiece(pieceToMove);

            System.out.println("Sur quelle case ?");
            String nextPosition = scan.next();

            player1.movePieceTo(pieceToMove, nextPosition);


            Display.displayChessBoard(chessboard);

            switchPlayer=!switchPlayer;
        } while (!rules.isEndGames());

    }

}

