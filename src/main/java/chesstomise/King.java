package chesstomise;

public class King extends Piece {

    private boolean hasMoved;

    public boolean hasMoved() {
        return hasMoved;
    }

    public King(boolean isWhite) {
        super(isWhite);
        this.graphicNotation = this.isWhite ? " K " : " k ";
        this.relativeNotation = this.graphicNotation.toUpperCase().trim();
    }

    public boolean isInCheckOnPosition(int position) {

        for (int i = 0; i < Board.getPieces().size(); i++) {

            if (Board.getPieces().get(i).isWhite != this.isWhite) {

                if (this.isWhite) { // necessary for pawn checks due to range vacancies

                    if (Board.getPieces().get(i).position - position == 9
                            ||
                            Board.getPieces().get(i).position - position == 11) {

                        if (Board.getPieces().get(i) instanceof Pawn) {
                            return true;
                        }
                    }

                } else {

                    if (position - Board.getPieces().get(i).position == 9
                            ||
                            position - Board.getPieces().get(i).position == 11) {

                        if (Board.getPieces().get(i) instanceof Pawn) {
                            return true;
                        }
                    }
                }

                boolean oldVacancy = Board.getSquareByPosition(position).isEmpty();

                Board.getSquareByPosition(position).setEmpty(true);
                Board.getSquareByPosition(this.position).setEmpty(true);

                if (!(Board.getPieces().get(i) instanceof Duck)
                        &&
                        !(Board.getPieces().get(i) instanceof Pawn)
                        &&
                        Board.getPieces().get(i).isValidRange(position)) {

                    Board.getSquareByPosition(this.position).setEmpty(false);
                    Board.getSquareByPosition(position).setEmpty(oldVacancy);

                    return true;
                }

                Board.getSquareByPosition(this.position).setEmpty(false);
                Board.getSquareByPosition(position).setEmpty(oldVacancy);
            }
        }

        return false;
    }

    @Override
    public boolean isValidRange(int position) {

        if (Board.getSquareByPosition(position) == null) {
            return false;
        }

        if (Math.abs(this.position - position) != 1
                &&
                Math.abs(this.position - position) != 9
                &&
                Math.abs(this.position - position) != 10
                &&
                Math.abs(this.position - position) != 11) {

            return false;
        }

        return super.isValidRange(position);
    }

    @Override
    public boolean isLegalMove(int position) {

        if (this.isValidRange(position)) {

            return !this.isInCheckOnPosition(position);
        }
        return false;
    }

    @Override
    public void moveTo(int position) {
        super.moveTo(position);
        this.hasMoved = true;
    }
}
