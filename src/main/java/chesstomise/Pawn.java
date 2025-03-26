package chesstomise;

import java.util.Scanner;

public class Pawn extends Piece {

    private boolean justMovedTwoSquares;

    public Pawn(boolean isWhite) {
        super(isWhite);
        this.graphicNotation = this.isWhite ? " P " : " p ";
        this.relativeNotation = this.graphicNotation.toLowerCase().trim();
    }

    public void setJustMovedTwoSquares(boolean justMovedTwoSquares) {
        this.justMovedTwoSquares = justMovedTwoSquares;
    }

    @Override
    public boolean isValidRange(int position) {

        if (Board.getSquareByPosition(position) == null) {
            return false;
        }

        if (this.isWhite) {

            if (position - this.position == 10) {

                return Board.getSquareByPosition(position).isEmpty();
            }

            if (position - this.position == 20) {

                if (this.position < 21 || this.position > 28) {
                    return false;
                }

                if (Board.getSquareByPosition(position - 10) == null
                        ||
                        !Board.getSquareByPosition(position - 10).isEmpty()) {

                    return false;
                }

                return Board.getSquareByPosition(position).isEmpty();
            }

            if (position - this.position == 9
                    ||
                    position - this.position == 11) {

                if (!Board.getSquareByPosition(position).isEmpty()) {

                    if (Board.getPieceByPosition(position) != null
                            &&
                            !(Board.getPieceByPosition(position) instanceof Duck)) {

                        return Board.getPieceByPosition(position).isWhite != this.isWhite;
                    }

                } else if (this.position >= 51 && this.position <= 58) {

                    if (Board.getPieceByPosition(position - 10) != null
                            &&
                            ((Pawn) Board.getPieceByPosition(position - 10)).justMovedTwoSquares) {

                        return Board.getPieceByPosition(position - 10).isWhite != this.isWhite;
                    }
                }
            }

        } else {

            if (this.position - position == 10) {

                return Board.getSquareByPosition(position).isEmpty();
            }

            if (this.position - position == 20) {

                if (this.position < 71 || this.position > 78) {
                    return false;
                }

                if (Board.getSquareByPosition(position + 10) == null
                        ||
                        !Board.getSquareByPosition(position + 10).isEmpty()) {

                    return false;
                }

                return Board.getSquareByPosition(position).isEmpty();
            }

            if (this.position - position == 9
                    ||
                    this.position - position == 11) {

                if (!Board.getSquareByPosition(position).isEmpty()) {

                    if (Board.getPieceByPosition(position) != null
                            &&
                            !(Board.getPieceByPosition(position) instanceof Duck)) {

                        return Board.getPieceByPosition(position).isWhite != this.isWhite;
                    }

                } else if (this.position >= 41 && this.position <= 48) {

                    if (Board.getPieceByPosition(position + 10) != null
                            &&
                            ((Pawn) Board.getPieceByPosition(position + 10)).justMovedTwoSquares) {

                        return Board.getPieceByPosition(position + 10).isWhite != this.isWhite;
                    }
                }
            }
        }

        return false;
    }

    @Override
    public void moveTo(int position) {

        if (Math.abs(this.position - position) == 9
                ||
                Math.abs(this.position - position) == 11) {

            if (Board.getSquareByPosition(position).isEmpty()) {

                if (this.isWhite) {

                    Board.getPieceByPosition(position - 10).banish();

                } else {

                    Board.getPieceByPosition(position + 10).banish();
                }
            }
        }

        if (Math.abs(this.position - position) == 20) {

            super.moveTo(position);
            this.justMovedTwoSquares = true;

        } else {

            super.moveTo(position);
        }

        if (this.isWhite) {

            if (position >= 81 && position <= 88) {

                System.out.print("\nChoose a piece to promote to: ");
                String promoteTo = "undefined"; // useful note: this string having the value of null breaks the program!

                while (!promoteTo.equals("Q")
                        &&
                        !promoteTo.equals("R")
                        &&
                        !promoteTo.equals("B")
//                        &&
//                        !promoteTo.equals("A")
                        &&
                        !promoteTo.equals("N"))
                {

                    promoteTo = new Scanner(System.in).next();
                    promoteTo = promoteTo.toUpperCase().trim();

                    if (promoteTo.equals("Q")) {

                        Board.getPieces().add(new Queen(true));
                        this.banish();
                        Board.getPieceByPosition(0).setPosition(position);

                    } else if (promoteTo.equals("R")) {

                        Board.getPieces().add(new Rook(true));
                        this.banish();
                        Board.getPieceByPosition(0).setPosition(position);

                    } else if (promoteTo.equals("B")) {

                        Board.getPieces().add(new Bishop(true));
                        this.banish();
                        Board.getPieceByPosition(0).setPosition(position);

                    } else if (promoteTo.equals("N")) {

                        Board.getPieces().add(new Knight(true));
                        this.banish();
                        Board.getPieceByPosition(0).setPosition(position);

//                    } else if (promoteTo.equals("A")) {
//
//                        Board.getPieces().add(new Amazon(true));
//                        this.banish();
//                        Board.getPieceByPosition(0).setPosition(position);

                    } else {

                        System.out.println("\nInvalid piece type!");
                        System.out.print("Choose a valid piece type " +
                                         "('Q' - Queen, 'R' - Rook, 'B' - Bishop, 'N' - Knight): ");
                    }
                }
            }

        } else {

            if (position >= 11 && position <= 18) {

                System.out.print("Choose a piece to promote to: ");
                String promoteTo = "undefined"; // useful note: this string having the value of null breaks the program!

                while (!promoteTo.equals("Q")
                        &&
                        !promoteTo.equals("R")
                        &&
                        !promoteTo.equals("B")
//                        &&
//                        !promoteTo.equals("A")
                        &&
                        !promoteTo.equals("N")) {

                    promoteTo = new Scanner(System.in).next();
                    promoteTo = promoteTo.toUpperCase().trim();

                    if (promoteTo.equals("Q")) {

                        Board.getPieces().add(new Queen(false));
                        this.banish();
                        Board.getPieceByPosition(0).setPosition(position);

                    } else if (promoteTo.equals("R")) {

                        Board.getPieces().add(new Rook(false));
                        this.banish();
                        Board.getPieceByPosition(0).setPosition(position);

                    } else if (promoteTo.equals("B")) {

                        Board.getPieces().add(new Bishop(false));
                        this.banish();
                        Board.getPieceByPosition(0).setPosition(position);

                    } else if (promoteTo.equals("N")) {

                        Board.getPieces().add(new Knight(false));
                        this.banish();
                        Board.getPieceByPosition(0).setPosition(position);

//                    } else if (promoteTo.equals("A")) {
//
//                        Board.getPieces().add(new Amazon(true));
//                        this.banish();
//                        Board.getPieceByPosition(0).setPosition(position);

                    } else {

                        System.out.println("\nInvalid piece type!");
                        System.out.print("Choose a valid piece type " +
                                         "('Q' - Queen, 'R' - Rook, 'B' - Bishop, 'N' - Knight): ");
                    }
                }
            }
        }
    }
}
