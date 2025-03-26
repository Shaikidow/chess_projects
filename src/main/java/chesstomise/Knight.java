package chesstomise;

public class Knight extends Piece {

    public Knight(boolean isWhite) {
        super(isWhite);
        this.graphicNotation = this.isWhite ? " N " : " n ";
        this.relativeNotation = this.graphicNotation.toUpperCase().trim();
    }

    @Override
    public boolean isValidRange(int position) {

        if (Board.getSquareByPosition(position) == null) {
            return false;
        }

        if (Math.abs(this.position - position) != 8
                &&
                Math.abs(this.position - position) != 12
                &&
                Math.abs(this.position - position) != 19
                &&
                Math.abs(this.position - position) != 21) {

            return false;
        }

        return super.isValidRange(position);
    }
}
