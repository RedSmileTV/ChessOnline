package de.redsmiletv.pieces;

public class Pawn extends Piece {
    public Pawn(boolean isWhite) {
        super(isWhite);
    }

    @Override
    public boolean isValidMove(int startX, int startY, int endX, int endY) {
        if (isWhite()) return startX == endX && startY == endY - 1;
        else return startX == endX && startY == endY + 1;
    }

}
