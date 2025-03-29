package chesstomise;

import java.util.ArrayList;
import java.util.Scanner;

public class Board {

    private static boolean whiteToMove = true;

    private static ArrayList<Square> squares;

    private static ArrayList<Piece> pieces;

    private static ArrayList<String> graphics;

    private static ArrayList<ArrayList<String>> savedPositions = new ArrayList<>();

    private static String player1Name;

    private static String player2Name;

    private static boolean resultAgreed;

    public static String getPlayer1Name() {
        return player1Name;
    }

    public static String getPlayer2Name() {
        return player2Name;
    }

    public static void setPlayer1(String name) {
        player1Name = name;
    }

    public static void setPlayer2(String name) {
        player2Name = name;
    }

    public static boolean getResultAgreed() {
        return resultAgreed;
    }

    public static boolean getWhiteToMove() {
        return whiteToMove;
    }

    public static ArrayList<Piece> getPieces() {
        return pieces;
    }

    public static Piece getPieceBySquare(String notation) {

        for (int i = 0; i < pieces.size(); i++) {

            if (pieces.get(i).getRelativeNotation().substring(1).equals(notation)) {
                return pieces.get(i);
            }
        }
        return null;
    }

    public static Square getSquareByNotation(String notation) {

        for (int i = 0; i < squares.size(); i++) {

            if (squares.get(i).getNotation().equals(notation)) {
                return squares.get(i);
            }
        }
        return null;
    }

    public static Piece getPieceByNotation(String notation) {

        for (int i = 0; i < pieces.size(); i++) {

            if (pieces.get(i).getRelativeNotation().equals(notation)) {
                return pieces.get(i);
            }
        }
        return null;
    }

    public static Square getSquareByPosition(int position) {

        for (int i = 0; i < squares.size(); i++) {

            if (squares.get(i).getPosition() == position) {
                return squares.get(i);
            }
        }
        return null;
    } // is this ever used or not?

    public static Piece getPieceByPosition(int position) {

        for (int i = 0; i < pieces.size(); i++) {

            if (pieces.get(i).getPosition() == position) {
                return pieces.get(i);
            }
        }
        return null;
    }

    public static void createSquares() {

        squares = new ArrayList<>();

        String notationList = "a1,b1,c1,d1,e1,f1,g1,h1," +
                              "a2,b2,c2,d2,e2,f2,g2,h2," +
                              "a3,b3,c3,d3,e3,f3,g3,h3," +
                              "a4,b4,c4,d4,e4,f4,g4,h4," +
                              "a5,b5,c5,d5,e5,f5,g5,h5," +
                              "a6,b6,c6,d6,e6,f6,g6,h6," +
                              "a7,b7,c7,d7,e7,f7,g7,h7," +
                              "a8,b8,c8,d8,e8,f8,g8,h8";

        ArrayList<String> notations = new ArrayList<>();

        for (int i = 0; i < notationList.length(); i += 3) {
            notations.add(notationList.substring(i, i + 2));
        }

        int rankNumber = 0;
        int squareNumber = 0;

        for (int i = 11; i <= 88; i += 10) {

            ++rankNumber;

            if (rankNumber % 2 != 0) {

                for (int j = i; j <= i + 7; j++) {
                    if (j % 2 == 0) {
                        squares.add(new Square(j, notations.get(squareNumber), true));
                    } else {
                        squares.add(new Square(j, notations.get(squareNumber), false));
                    }
                    ++squareNumber;
                }

            } else {

                for (int j = i; j <= i + 7; j++) {
                    if (j % 2 == 0) {
                        squares.add(new Square(j, notations.get(squareNumber), false));
                    } else {
                        squares.add(new Square(j, notations.get(squareNumber), true));
                    }
                    ++squareNumber;
                }
            }
        }
    }

    public static void createGraphics() {

        graphics = new ArrayList<>();

        graphics.add(  " _______ _______ _______ _______ _______ _______ _______ _______ ");
        graphics.add(  "|@@@@@@@|       |@@@@@@@|       |@@@@@@@|       |@@@@@@@|       |");
        graphics.add(  "|@@ s @@|   s   |@@ s @@|   s   |@@ s @@|   s   |@@ s @@|   s   |");
        graphics.add(  "|@@@@@@@|_______|@@@@@@@|_______|@@@@@@@|_______|@@@@@@@|_______|");
        graphics.add(  "|       |@@@@@@@|       |@@@@@@@|       |@@@@@@@|       |@@@@@@@|");
        graphics.add(  "|   s   |@@ s @@|   s   |@@ s @@|   s   |@@ s @@|   s   |@@ s @@|");
        graphics.add(  "|_______|@@@@@@@|_______|@@@@@@@|_______|@@@@@@@|_______|@@@@@@@|");
        graphics.add(  "|@@@@@@@|       |@@@@@@@|       |@@@@@@@|       |@@@@@@@|       |");
        graphics.add(  "|@@ s @@|   s   |@@ s @@|   s   |@@ s @@|   s   |@@ s @@|   s   |");
        graphics.add(  "|@@@@@@@|_______|@@@@@@@|_______|@@@@@@@|_______|@@@@@@@|_______|");
        graphics.add(  "|       |@@@@@@@|       |@@@@@@@|       |@@@@@@@|       |@@@@@@@|");
        graphics.add(  "|   s   |@@ s @@|   s   |@@ s @@|   s   |@@ s @@|   s   |@@ s @@|");
        graphics.add(  "|_______|@@@@@@@|_______|@@@@@@@|_______|@@@@@@@|_______|@@@@@@@|");
        graphics.add(  "|@@@@@@@|       |@@@@@@@|       |@@@@@@@|       |@@@@@@@|       |");
        graphics.add(  "|@@ s @@|   s   |@@ s @@|   s   |@@ s @@|   s   |@@ s @@|   s   |");
        graphics.add(  "|@@@@@@@|_______|@@@@@@@|_______|@@@@@@@|_______|@@@@@@@|_______|");
        graphics.add(  "|       |@@@@@@@|       |@@@@@@@|       |@@@@@@@|       |@@@@@@@|");
        graphics.add(  "|   s   |@@ s @@|   s   |@@ s @@|   s   |@@ s @@|   s   |@@ s @@|");
        graphics.add(  "|_______|@@@@@@@|_______|@@@@@@@|_______|@@@@@@@|_______|@@@@@@@|");
        graphics.add(  "|@@@@@@@|       |@@@@@@@|       |@@@@@@@|       |@@@@@@@|       |");
        graphics.add(  "|@@ s @@|   s   |@@ s @@|   s   |@@ s @@|   s   |@@ s @@|   s   |");
        graphics.add(  "|@@@@@@@|_______|@@@@@@@|_______|@@@@@@@|_______|@@@@@@@|_______|");
        graphics.add(  "|       |@@@@@@@|       |@@@@@@@|       |@@@@@@@|       |@@@@@@@|");
        graphics.add(  "|   s   |@@ s @@|   s   |@@ s @@|   s   |@@ s @@|   s   |@@ s @@|");
        graphics.add(  "|_______|@@@@@@@|_______|@@@@@@@|_______|@@@@@@@|_______|@@@@@@@|");

    } // 1

    public static void createPieces() {

        pieces = new ArrayList<>();
        pieces.add(new King(true));
        pieces.add(new King(false));
        pieces.add(new Queen(true));
        pieces.add(new Queen(false));

        for (int i = 0; i < 2; i++) {
            pieces.add(new Rook(true));
            pieces.add(new Rook(false));
            pieces.add(new Bishop(true));
            pieces.add(new Bishop(false));
            pieces.add(new Knight(true));
            pieces.add(new Knight(false));
        }
        for (int i = 0; i < 8; i++) {
            pieces.add(new Pawn(true));
            pieces.add(new Pawn(false));
        }
    }

    public static void setPieces() {

        for (int i = 0; i < 2; i++) {

            int filePosition = 5;

            for (int j = 0; j < pieces.size(); j++) {

                if (pieces.get(j) instanceof King) {

                    if (pieces.get(j).isWhite()) {

                        pieces.get(j).setPosition(10 + filePosition);

                        if (getSquareByPosition(10 + filePosition) != null) {
                            getSquareByPosition(10 + filePosition).setEmpty(false);
                        }

                    } else {

                        pieces.get(j).setPosition(80 + filePosition);

                        if (getSquareByPosition(80 + filePosition) != null) {
                            getSquareByPosition(80 + filePosition).setEmpty(false);
                        }
                    }
                }
            }
        }

        for (int i = 0; i < 2; i++) {

            int filePosition = 4;

            for (int j = 0; j < pieces.size(); j++) {

                if (pieces.get(j) instanceof Queen) {

                    if (pieces.get(j).isWhite()) {

                        pieces.get(j).setPosition(10 + filePosition);

                        if (getSquareByPosition(10 + filePosition) != null) {
                            getSquareByPosition(10 + filePosition).setEmpty(false);
                        }

                    } else {

                        pieces.get(j).setPosition(80 + filePosition);

                        if (getSquareByPosition(80 + filePosition) != null) {
                            getSquareByPosition(80 + filePosition).setEmpty(false);
                        }
                    }
                }
            }
        }

        for (int i = 0; i < 2; i++) {

            int filePosition1 = 1;
            int filePosition2 = 8;

            for (int j = 0; j < pieces.size(); j++) {

                if (pieces.get(j) instanceof Rook) {

                    if (pieces.get(j).isWhite()) {

                        if (getPieceByPosition(10 + filePosition1) != null) {

                            pieces.get(j).setPosition(10 + filePosition2);

                            if (getSquareByPosition(10 + filePosition2) != null) {
                                getSquareByPosition(10 + filePosition2).setEmpty(false);
                            }

                        } else {

                            pieces.get(j).setPosition(10 + filePosition1);

                            if (getSquareByPosition(10 + filePosition1) != null) {
                                getSquareByPosition(10 + filePosition1).setEmpty(false);
                            }
                        }

                    } else {

                        if (getPieceByPosition(80 + filePosition1) != null) {

                            pieces.get(j).setPosition(80 + filePosition2);

                            if (getSquareByPosition(80 + filePosition2) != null) {
                                getSquareByPosition(80 + filePosition2).setEmpty(false);
                            }

                        } else {

                            pieces.get(j).setPosition(80 + filePosition1);

                            if (getSquareByPosition(80 + filePosition1) != null) {
                                getSquareByPosition(80 + filePosition1).setEmpty(false);
                            }
                        }
                    }
                }
            }
        }

        for (int i = 0; i < 2; i++) {

            int filePosition1 = 3;
            int filePosition2 = 6;

            for (int j = 0; j < pieces.size(); j++) {

                if (pieces.get(j) instanceof Bishop) {

                    if (pieces.get(j).isWhite()) {

                        if (getPieceByPosition(10 + filePosition1) != null) {

                            pieces.get(j).setPosition(10 + filePosition2);

                            if (getSquareByPosition(10 + filePosition2) != null) {
                                getSquareByPosition(10 + filePosition2).setEmpty(false);
                            }

                        } else {

                            pieces.get(j).setPosition(10 + filePosition1);

                            if (getSquareByPosition(10 + filePosition1) != null) {
                                getSquareByPosition(10 + filePosition1).setEmpty(false);
                            }
                        }

                    } else {

                        if (getPieceByPosition(80 + filePosition1) != null) {

                            pieces.get(j).setPosition(80 + filePosition2);

                            if (getSquareByPosition(80 + filePosition2) != null) {
                                getSquareByPosition(80 + filePosition2).setEmpty(false);
                            }

                        } else {

                            pieces.get(j).setPosition(80 + filePosition1);

                            if (getSquareByPosition(80 + filePosition1) != null) {
                                getSquareByPosition(80 + filePosition1).setEmpty(false);
                            }
                        }
                    }
                }
            }
        }

        for (int i = 0; i < 2; i++) {

            int filePosition1 = 2;
            int filePosition2 = 7;

            for (int j = 0; j < pieces.size(); j++) {

                if (pieces.get(j) instanceof Knight) {

                    if (pieces.get(j).isWhite()) {

                        if (getPieceByPosition(10 + filePosition1) != null) {

                            pieces.get(j).setPosition(10 + filePosition2);

                            if (getSquareByPosition(10 + filePosition2) != null) {
                                getSquareByPosition(10 + filePosition2).setEmpty(false);
                            }

                        } else {

                            pieces.get(j).setPosition(10 + filePosition1);

                            if (getSquareByPosition(10 + filePosition1) != null) {
                                getSquareByPosition(10 + filePosition1).setEmpty(false);
                            }
                        }

                    } else {

                        if (getPieceByPosition(80 + filePosition1) != null) {

                            pieces.get(j).setPosition(80 + filePosition2);

                            if (getSquareByPosition(80 + filePosition2) != null) {
                                getSquareByPosition(80 + filePosition2).setEmpty(false);
                            }

                        } else {

                            pieces.get(j).setPosition(80 + filePosition1);

                            if (getSquareByPosition(80 + filePosition1) != null) {
                                getSquareByPosition(80 + filePosition1).setEmpty(false);
                            }
                        }
                    }
                }
            }
        }

        for (int i = 0; i < 16; i++) {

            int filePosition1 = 1;
            int filePosition2 = 1;

            for (int j = 0; j < pieces.size(); j++) {

                if (pieces.get(j) instanceof Pawn) {

                    if (pieces.get(j).isWhite()) {

                        pieces.get(j).setPosition(20 + filePosition1);

                        if (getSquareByPosition(20 + filePosition1) != null) {
                            getSquareByPosition(20 + filePosition1).setEmpty(false);
                        }

                        if (getSquareByPosition(70 + filePosition1) != null
                                &&
                            !getSquareByPosition(70 + filePosition1).isEmpty()) {

                            ++filePosition1;
                        }

                    } else {

                        pieces.get(j).setPosition(70 + filePosition2);

                        if (getSquareByPosition(70 + filePosition2) != null) {
                            getSquareByPosition(70 + filePosition2).setEmpty(false);
                        }

                        if (getSquareByPosition(20 + filePosition2) != null
                                &&
                            !getSquareByPosition(20 + filePosition2).isEmpty()) {

                            ++filePosition2;
                        }
                    }
                }
            }
        }
    }

    public static void fillSquares() {

        for (int i = 0; i < squares.size(); i++) {

            squares.get(i).setEmpty(true); // could've been switched through moveTo() instead, but this worked out, too!

            for (int j = 0; j < pieces.size(); j++) {

                if (squares.get(i).getPosition() == pieces.get(j).getPosition()) {
                    squares.get(i).setEmpty(false);
                }
            }
        }

        int rankStart = 0;
        int rankEnd = 8;

        for (int i = graphics.size() - 2; i >= 2; i -= 3) {

            for (int j = rankStart; j < rankEnd; j++) {

                if (squares.get(j).isEmpty()) {

                    if (squares.get(j).isWhite()) {
                        graphics.set(i, graphics.get(i).replaceFirst(" s ", "@@@"));
                    } else {
                        graphics.set(i, graphics.get(i).replaceFirst(" s ", "   "));
                    }
                }

                else {

                    for (int k = 0; k < pieces.size(); k++) {
                        if (squares.get(j).getPosition() == pieces.get(k).getPosition()) {
                            graphics.set(i,
                                    graphics.get(i).replaceFirst
                                            (" s ", pieces.get(k).getGraphicNotation()));
                        }
                    }
                }
            }

            rankStart += 8;
            rankEnd += 8;
        }
    } // 2

    public static void renderGraphics() {

        for (int i = 0; i < graphics.size(); i++) {
            System.out.println(graphics.get(i));
        }

        System.out.println(); // helps with the spacing

    } // 3

    public static void playMove() {

        if (whiteToMove) {
            System.out.print("White to move: ");
        } else {
            System.out.print("Black to move: ");
        }

        String pieceNotation = null;
        String squareNotation = null;

        while (getPieceByNotation(pieceNotation) == null
                ||
                getPieceByNotation(pieceNotation).isWhite != whiteToMove
                ||
                (!getPieceByNotation(pieceNotation).isLegalMove(getSquareByNotation(squareNotation).getPosition())
//                &&
//                !getPieceByNotation(squareNotation).isLegalBanish() // why did I write this? unsure if I'll need it...
                )) {

            String fullNotation = new Scanner(System.in).nextLine().trim();

            if (fullNotation.equals("resign")) {

                renderGraphics();

                if (whiteToMove) {
                    System.out.print("White resigns! Black wins.\nCongratulations, " + player2Name + "!");

                } else {
                    System.out.print("Black resigns! White wins.\nCongratulations, " + player1Name + "!");
                }

                resultAgreed = true;
                break;
            }

            if (fullNotation.equals("draw")) {

                determineDraw();

                if (resultAgreed) {

                    renderGraphics();

                    System.out.print("Draw accepted!\nGame drawn by mutual agreement");
                    break;
                }

                if (whiteToMove) {
                    System.out.print("White to move: ");
                } else {
                    System.out.print("Black to move: ");
                }

                continue;
            }

            if (fullNotation.equals("list")) {

                System.out.println("\nNon-move commands:\ndraw - offer a draw\nresign - resign the game");
                System.out.println();

                if (whiteToMove) {
                    System.out.print("White to move: ");
                } else {
                    System.out.print("Black to move: ");
                }

                continue;
            }

            if (fullNotation.equals("0-0") || fullNotation.equals("O-O")) {

                if (isLegalCastling("short")) {

                    castleShort();
                    savePosition();
                    break;
                }
            }

            if (fullNotation.equals("0-0-0") || fullNotation.equals("O-O-O")) {

                if (isLegalCastling("long")) {

                    castleLong();
                    savePosition();
                    break;
                }
            }

            if (fullNotation.contains("-")) {
                pieceNotation = fullNotation.substring(0, fullNotation.indexOf("-")).trim();
                squareNotation = fullNotation.substring(fullNotation.indexOf("-") + 1).trim();
            }

            if (getPieceByNotation(pieceNotation) != null
                    &&
                    getSquareByNotation(squareNotation) != null
                    &&
                    getPieceByNotation(pieceNotation).isWhite == whiteToMove // maybe rework banishment option from here
                    &&
                    getPieceByNotation(pieceNotation).isLegalMove(getSquareByNotation(squareNotation).getPosition())) {

                for (int i = 0; i < pieces.size(); i++) {

                    if (pieces.get(i) instanceof Pawn) {
                        ((Pawn) pieces.get(i)).setJustMovedTwoSquares(false); // just fixed en passant, holy hell!
                    }
                }

                if (getPieceBySquare(squareNotation) != null) {
                    getPieceBySquare(squareNotation).banish();
                }

                getPieceByNotation(pieceNotation).moveTo(getSquareByNotation(squareNotation).getPosition());
                savePosition();

//            } else if (pieceNotation.equals("")
//                    &&
//                    getPieceByNotation(squareNotation) != null
//                    &&
//                    getPieceByNotation(squareNotation).isLegalBanish()) {
//
//                getPieceByNotation(squareNotation).banish(); // for Rain Chess variants

                break;
            }

                System.out.println("\nInvalid or illegal move!");
                System.out.print("Type \"list\" for a list of commands, or play a different move" +
                                 "\n(format = piece notation + hyphen + square notation): ");
        }

        if (whiteToMove) {
            whiteToMove = false;
        } else {
            whiteToMove = true;
        }
    } // should have additional comments

    public static void determineDraw() {

        if (whiteToMove) {
            System.out.print("\nWhite offers a draw!\nDoes Black accept? ");

        } else {
            System.out.print("\nBlack offers a draw!\nDoes White accept? ");
        }

        Scanner drawOffer = new Scanner(System.in);
        String reply = "undefined";

        while (!reply.equals("y")
                &&
                !reply.equals("yes")
                &&
                !reply.equals("n")
                &&
                !reply.equals("no")) {

            reply = drawOffer.nextLine().toLowerCase().trim();

            if (reply.equals("y")
                    ||
                    reply.equals("yes")) {

                resultAgreed = true;

            } else if (reply.equals("n")
                    ||
                    reply.equals("no")) {

                System.out.print("\nDraw declined!\n");

            } else {

                System.out.print("\nInvalid reply!\nUse a valid reply - Y(es) or N(o): ");
            }
        }
    }

    public static void savePosition() {

        ArrayList<String> savedPosition = new ArrayList<>();

        for (int i = 0; i < pieces.size(); i++) {

            String pieceInfo = pieces.get(i).toString() + ", "
                             + pieces.get(i).relativeNotation + ", "
                             + (pieces.get(i).isWhite ? "white" : "black");

            savedPosition.add(pieceInfo);
        }

        savedPosition.add(whiteToMove ? "White to move" : "Black to move");
        savedPositions.add(savedPosition);
    }

    public static void castleShort() {

        for (int i = 0; i < pieces.size(); i++) {

            if (pieces.get(i) instanceof King
                    &&
                    pieces.get(i).isWhite == whiteToMove) {

                int startingKingPosition = pieces.get(i).position;
                pieces.get(i).moveTo(pieces.get(i).position / 10 * 10 + 7);

                for (int j = 0; j < pieces.size(); j++) {

                    if (pieces.get(j) instanceof Rook
                            &&
                            pieces.get(j).isWhite == whiteToMove
                            &&
                            pieces.get(j).position > startingKingPosition) {

                        pieces.get(j).moveTo(pieces.get(j).position / 10 * 10 + 6);
                        break;
                    }
                }

                break;
            }
        }
    } // needs more comments

    public static void castleLong() {

        for (int i = 0; i < pieces.size(); i++) {

            if (pieces.get(i) instanceof King
                    &&
                    pieces.get(i).isWhite == whiteToMove) {

                int startingKingPosition = pieces.get(i).position;
                pieces.get(i).moveTo(pieces.get(i).position / 10 * 10 + 3);

                for (int j = 0; j < pieces.size(); j++) {

                    if (pieces.get(j) instanceof Rook
                            &&
                            pieces.get(j).isWhite == whiteToMove
                            &&
                            pieces.get(j).position < startingKingPosition) {

                        pieces.get(j).moveTo(pieces.get(j).position / 10 * 10 + 4);
                        break;
                    }
                }

                break;
            }
        }
    } // needs more comments

    public static boolean isLegalCastling(String side) {

        for (int i = 0; i < pieces.size(); i++) {

            if (pieces.get(i).isWhite == whiteToMove
                    &&
                    pieces.get(i) instanceof King) {

                if (((King) pieces.get(i)).hasMoved()) {
                    return false;
                }

                if (side.equals("short")) {

                    for (int j = pieces.get(i).position; j <= pieces.get(i).position / 10 * 10 + 7; j++) {

                        if (!((King) pieces.get(i)).notInCheckOnPosition(j)) {
                            return false;
                        }

                        if (!getSquareByPosition(j).isEmpty()) {

                            if (getPieceByPosition(j) == pieces.get(i)
                                    ||
                                    (getPieceByPosition(j).isWhite == whiteToMove
                                            &&
                                            getPieceByPosition(j) instanceof Rook
                                            &&
                                            !((Rook) getPieceByPosition(j)).hasMoved())) {

                                continue;
                            }

                            return false;
                        }
                    }

                    for (int j = 0; j < pieces.size(); j++) {

                        if (pieces.get(j).isWhite == whiteToMove
                                &&
                                pieces.get(j).position > pieces.get(i).position
                                &&
                                pieces.get(j) instanceof Rook
                                &&
                                !((Rook) pieces.get(j)).hasMoved()) {

                            if (pieces.get(j).position >= pieces.get(j).position / 10 * 10 + 6) {

                                for (int k = pieces.get(j).position;
                                     k >= pieces.get(j).position / 10 * 10 + 6;
                                     k--) {

                                    if (!getSquareByPosition(k).isEmpty()) {

                                        if (getPieceByPosition(k) == pieces.get(j)) {
                                            continue;
                                        }

                                        return false;
                                    }
                                }

                            } else if (pieces.get(j).position <= pieces.get(j).position / 10 * 10 + 6) {

                                for (int k = pieces.get(j).position;
                                     k <= pieces.get(j).position / 10 * 10 + 6;
                                     k++) {

                                    if (!getSquareByPosition(k).isEmpty()) {

                                        if (getPieceByPosition(k) == pieces.get(j)) {
                                            continue;
                                        }

                                        return false;
                                    }
                                }
                            }

                            return true;
                        }
                    }

                } else if (side.equals("long")) {

                    for (int j = pieces.get(i).position; j >= pieces.get(i).position / 10 * 10 + 3; j--) {

                        if (!((King) pieces.get(i)).notInCheckOnPosition(j)) {
                            return false;
                        }

                        if (!getSquareByPosition(j).isEmpty()) {

                            if (getPieceByPosition(j) == pieces.get(i)
                                    ||
                                    (getPieceByPosition(j).isWhite == whiteToMove
                                            &&
                                            getPieceByPosition(j) instanceof Rook
                                            &&
                                            !((Rook) getPieceByPosition(j)).hasMoved())) {

                                continue;
                            }

                            return false;
                        }
                    }

                    for (int j = 0; j < pieces.size(); j++) {

                        if (pieces.get(j).isWhite == whiteToMove
                                &&
                                pieces.get(j).position < pieces.get(i).position
                                &&
                                pieces.get(j) instanceof Rook
                                &&
                                !((Rook) pieces.get(j)).hasMoved()) {

                            if (pieces.get(j).position <= pieces.get(j).position / 10 * 10 + 4) {

                                for (int k = pieces.get(j).position;
                                     k <= pieces.get(j).position / 10 * 10 + 4;
                                     k++) {

                                    if (!getSquareByPosition(k).isEmpty()) {

                                        if (getPieceByPosition(k) == pieces.get(j)) {
                                            continue;
                                        }

                                        return false;
                                    }
                                }

                            } else if (pieces.get(j).position >= pieces.get(j).position / 10 * 10 + 4) {

                                for (int k = pieces.get(j).position;
                                     k >= pieces.get(j).position / 10 * 10 + 4;
                                     k--) {

                                    if (!getSquareByPosition(k).isEmpty()) {

                                        if (getPieceByPosition(k) == pieces.get(j)) {
                                            continue;
                                        }

                                        return false;
                                    }
                                }
                            }

                            return true;
                        }
                    }
                }
            }
        }

        return false;
    } // could use more comments

    public static boolean anyLegalMoves() {

        for (int i = 0; i < pieces.size(); i++) {

            for (int j = 0; j < squares.size(); j++) {

                if (pieces.get(i).isWhite == whiteToMove) {

                    if (pieces.get(i).isLegalMove(squares.get(j).getPosition())) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    public static boolean isCheck() {

        for (int i = 0; i < pieces.size(); i++) {

            if ((pieces.get(i) instanceof King)
                    &&
                    pieces.get(i).isWhite == whiteToMove) {

                return (!((King) pieces.get(i)).notInCheckOnPosition(pieces.get(i).position)); // only works with 1 King
            }
        }

        return false;
    }

    public static boolean isFiftyMoveRule() {

        int samePiecesCounter = 1;

        for (int i = savedPositions.size() - 2; i >= 0; i--) {

            if (savedPositions.get(savedPositions.size() - 1).size() != savedPositions.get(i).size()) {
                return false;
            }

            samePiecesCounter++;

            if (samePiecesCounter == 100) {
                return true;
            }
        }

        return false;
    }

    public static boolean isThreefoldRepetition() {

        int repetitionCounter = 1;

        for (int i = 0; i < savedPositions.size() - 1; i++) {

            if (savedPositions.get(savedPositions.size() - 1).equals(savedPositions.get(i))) {
                repetitionCounter++;
            }

            if (repetitionCounter == 3) {
                return true;
            }
        }

        return false;
    }

    public static boolean isInsufficientMatingMaterial() {

        int whiteMinorPieceCounter = 0;
        int blackMinorPieceCounter = 0;

        for (int i = 0; i < pieces.size(); i++) {

            if (pieces.get(i) instanceof Pawn
                    ||
                    pieces.get(i) instanceof Rook
                    ||
                    pieces.get(i) instanceof Queen
                    ||
                    pieces.get(i) instanceof Amazon) {

                return false;
            }

            if (pieces.get(i) instanceof Knight
                    ||
                    pieces.get(i) instanceof Bishop) {

                if (pieces.get(i).isWhite) {
                    whiteMinorPieceCounter++;

                } else {
                    blackMinorPieceCounter++;
                }
            }

            if (whiteMinorPieceCounter == 2
                    ||
                    blackMinorPieceCounter == 2) {

                return false; // does not apply in the unlikely K+B+B(+B etc.) vs. K scenario with same-squared Bishops!
            }
        }

        return true;
    }

    public static void clear() {

        for (int i = 0; i < pieces.size(); i++) {
            pieces.get(i).position = 0;
        }
        pieces.clear(); // I don't think I'll be needing the three below
//        squares.clear();
//        graphics.clear();
//        savedPosition.clear();
    } // maybe I'll need this for the rematch function
}