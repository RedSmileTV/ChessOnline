package de.redsmiletv.pieces;

public class Bishop extends Piece {
    public Bishop(boolean white) {
        super(white);
    }

    @Override
    public boolean isValidMove(int startX, int startY, int endX, int endY) {
        return false;
    }


}
