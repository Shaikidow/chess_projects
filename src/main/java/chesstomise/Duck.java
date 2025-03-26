package chesstomise;

public class Duck extends Piece {

    public Duck() {
        super();
        this.graphicNotation = " D ";
        this.relativeNotation = this.graphicNotation.trim();
    }

    @Override
    public boolean isValidRange(int position) {

//        if (!this.doesNotDiscoverCheckOnOwnKing()) { // I might need this for a variant Duck Chess ruleset sometime...
//            return false;
//        }

        if (Board.getSquareByPosition(position) != null
                &&
            Board.getSquareByPosition(position).isEmpty()) {

            return true;
        }

        return false;
    }
}
