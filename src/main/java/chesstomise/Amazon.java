package chesstomise;

public class Amazon extends Piece {

    public Amazon(boolean isWhite) {
        super(isWhite);
        this.graphicNotation = this.isWhite ? " A " : " a ";
        this.relativeNotation = this.graphicNotation.toUpperCase().trim();
    }

    @Override
    public boolean isValidRange(int position) {

        if (Board.getSquareByPosition(position) == null) {
            return false;
        }

        if ((this.position - position) % 9 == 0
                &&
                this.position != position) {

            if (this.position < position) {

                for (int i = this.position + 9; i < position; i += 9) {

                    if (Board.getSquareByPosition(i) == null
                            ||
                            !Board.getSquareByPosition(i).isEmpty()) {

                        return false;
                    }
                }

            } else {

                for (int i = this.position - 9; i > position; i -= 9) {

                    if (Board.getSquareByPosition(i) == null
                            ||
                            !Board.getSquareByPosition(i).isEmpty()) {

                        return false;
                    }
                }
            }

        } else if ((this.position - position) % 10 == 0
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

        } else if ((this.position - position) % 11 == 0
                &&
                this.position != position) {

            if (this.position < position) {

                for (int i = this.position + 11; i < position; i += 11) {

                    if (Board.getSquareByPosition(i) == null
                            ||
                            !Board.getSquareByPosition(i).isEmpty()) {

                        return false;
                    }
                }

            } else {

                for (int i = this.position - 11; i > position; i -= 11) {

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
