package chesstomise;

import java.util.Scanner;

public class Chess {

    public static void main(String[] args) {

        System.out.println("NEW GAME");

        Board.createPieces();
        Board.createSquares();
        Board.createGraphics(); // 1

        Board.setPieces();
        Board.fillSquares(); // 2
        Board.renderGraphics(); // 3

        // the above code sets the board up for playing

        Scanner playerName = new Scanner(System.in);

        System.out.print("Enter name for Player 1: ");

        String p1 = "";

        while (p1.length() < 1 || p1.length() > 40) {

            p1 = playerName.nextLine().trim();

            if (p1.length() < 1 || p1.length() > 40) {
                System.out.print("\nInvalid name length!\nEnter a valid name (1-40 characters): ");
            }
        }

        Board.setPlayer1(p1);

        System.out.print("Enter name for Player 2: ");

        String p2 = "";

        while (p2.length() < 1 || p2.length() > 40 || p2.equals(p1)) {

            p2 = playerName.nextLine().trim();

            if (p2.length() < 1 || p2.length() > 40) {
                System.out.print("\nInvalid name length!\nEnter a valid name (1-40 characters): ");

            } else if (p2.equals(p1)) {
                System.out.print("\nName already taken!\nEnter a different name: ");
            }
        }

        Board.setPlayer2(p2);
        System.out.println();

        System.out.println("GAME START");
        Board.renderGraphics();

        // Alright, let's begin the game!

        while (Board.anyLegalMoves()) {

            if (Board.isCheck()) {
                System.out.println("Check!");
            }

            Board.playMove();

            if (Board.getResultAgreed()) {
                break;
            }

            Board.createGraphics();
            Board.fillSquares();
            Board.renderGraphics();

            if (Board.isThreefoldRepetition()) {
                System.out.print("Threefold repetition!\nGame drawn");
                break;
            }

            if (Board.isInsufficientMatingMaterial()) {
                System.out.print("Insufficient mating material!\nGame drawn");
                break;
            }

            if (Board.isFiftyMoveRule() && Board.anyLegalMoves()) {
                System.out.print("50-move rule!\nGame drawn");
                break;
            }
        }

        if (!Board.anyLegalMoves()) {

            if (!Board.isCheck()) {
                System.out.print("Stalemate!\nGame drawn");

            } else {
                System.out.print("Checkmate! ");

                if (!Board.getWhiteToMove()) {
                    System.out.print("White wins.\nCongratulations, " + Board.getPlayer1Name() + "!");

                } else {
                    System.out.print("Black wins.\nCongratulations, " + Board.getPlayer2Name() + "!");
                }
            }
        }
    }
}
