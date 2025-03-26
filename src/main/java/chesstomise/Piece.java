package chesstomise;

public abstract class Piece {

    protected int position;
    protected boolean isWhite;
    protected String graphicNotation;
    protected String relativeNotation;

    public int getPosition() { // should I use this preventively?
        return position;
    }

    public void setPosition(int position) {

        this.position = position;

        if (this.position != -1) { // avoiding the default value of 0 for practical reasons
            this.relativeNotation = this.relativeNotation.charAt(0)
                    + Board.getSquareByPosition(position).getNotation();
        }
    }

    public boolean isWhite() {
        return isWhite;
    }

    public String getGraphicNotation() {
        return graphicNotation;
    }

    public String getRelativeNotation() {
        return relativeNotation;
    }

    public Piece(boolean isWhite) {
        this.isWhite = isWhite;
    }

    public Piece() {
    }

    protected boolean doesNotDiscoverCheckOnOwnKing(int position) {

        boolean oldVacancy = Board.getSquareByPosition(position).isEmpty(); // necessary because of en passant exception

        Board.getSquareByPosition(this.position).setEmpty(true);
        Board.getSquareByPosition(position).setEmpty(false);

        if (Board.getPieceByPosition(position) != null) {
            Board.getPieceByPosition(position).setPosition(-1);
        }

        for (int i = 0; i < Board.getPieces().size(); i++) {

            if (Board.getPieces().get(i) instanceof King
                    &&
                    Board.getPieces().get(i).isWhite == this.isWhite) {

                for (int j = 0; j < Board.getPieces().size(); j++) {

                    if (Board.getPieces().get(j).isValidRange((Board.getPieces().get(i)).position)) {

                        if (Board.getPieceByPosition(-1) != null) {
                            Board.getPieceByPosition(-1).setPosition(position);
                        }

                        Board.getSquareByPosition(position).setEmpty(oldVacancy);
                        Board.getSquareByPosition(this.position).setEmpty(false);

                        return false;
                    }
                }
            }
        }

        if (Board.getPieceByPosition(-1) != null) {
            Board.getPieceByPosition(-1).setPosition(position);
        }

        Board.getSquareByPosition(position).setEmpty(oldVacancy);
        Board.getSquareByPosition(this.position).setEmpty(false);

        return true;
    }

    protected boolean isValidRange(int position) {

        if (!Board.getSquareByPosition(position).isEmpty()) {

            if (Board.getPieceByPosition(position) != null
                    &&
                    !(Board.getPieceByPosition(position) instanceof Duck)) {

                return Board.getPieceByPosition(position).isWhite != this.isWhite;
            }
            return false;
        }
        return true;
    }

    protected boolean isLegalMove(int position) {

        if (this.isValidRange(position)) {
            return this.doesNotDiscoverCheckOnOwnKing(position);
        }

        return false;
    }

    protected void moveTo(int position) {

        this.position = position;
        this.relativeNotation = this.relativeNotation.charAt(0)
                                  + Board.getSquareByPosition(position).getNotation();
    }

    protected boolean isLegalBanish() { // will need this in the future

        if (this instanceof Duck
                ||
                this instanceof King) {

            return false;
        }

        return doesNotDiscoverCheckOnOwnKing(position);
    }

    protected void banish() {

        for (int i = 0; i < Board.getPieces().size(); i++) {

            if (Board.getPieces().get(i).position == this.position) {
                Board.getPieces().get(i).setPosition(-1); // again avoiding the default value of 0 for practical reasons
                Board.getPieces().remove(i);
            }
        }
    }
}
