package chesstomise;

public class Square {

    private final int position;
    private final String notation;
    private final boolean isWhite;
    private boolean isEmpty = true;

    public int getPosition() {
        return position;
    }

    public String getNotation() {
        return notation;
    }

    public boolean isWhite() {
        return isWhite;
    }

    public boolean isEmpty() {
        return isEmpty;
    }

    public void setEmpty(boolean empty) {
        isEmpty = empty;
    }

    public Square(int position, String notation, boolean isWhite) {
        this.position = position;
        this.notation = notation;
        this.isWhite = isWhite;
    }

}
