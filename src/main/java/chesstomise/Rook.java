package chesstomise;

public class Rook extends Piece {

    private boolean hasMoved;

    public boolean hasMoved() {
        return hasMoved;
    }

    public Rook(boolean isWhite) {
        super(isWhite);
        this.graphicNotation = this.isWhite ? " R " : " r ";
        this.relativeNotation = this.graphicNotation.toUpperCase().trim();
    }

    @Override
    public boolean isValidRange(int position) {

        if (Board.getSquareByPosition(position) == null) {
            return false;
        }

        if ((this.position - position) % 10 == 0
                &&
                this.position != position) {

            if (this.position < position) {

                for (int i = this.position + 10; i < position; i += 10) {

                    if (Board.getSquareByPosition(i) == null
                            ||
                            !Board.getSquareByPosition(i).isEmpty()) {

                        return false;
                    }
                }

            } else {

                for (int i = this.position - 10; i > position; i -= 10) {

                    if (Board.getSquareByPosition(i) == null
                            ||
                            !Board.getSquareByPosition(i).isEmpty()) {

                        return false;
                    }
                }
            }

        } else if (this.position < position) {

            for (int i = this.position + 1; i < position; i++) {

                if (Board.getSquareByPosition(i) == null
                        ||
                        !Board.getSquareByPosition(i).isEmpty()) {

                    return false;
                }
            }

        } else if (this.position > position) {

            for (int i = this.position - 1; i > position; i--) {

                if (Board.getSquareByPosition(i) == null
                        ||
                        !Board.getSquareByPosition(i).isEmpty()) {

                    return false;
                }
            }

        } else {
            return false;
        }

        return super.isValidRange(position);
    }

    @Override
    public void moveTo(int position) {
        super.moveTo(position);
        this.hasMoved = true;
    }
}
