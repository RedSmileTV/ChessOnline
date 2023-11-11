package de.redsmiletv;


import de.redsmiletv.pieces.*;

public class Board {
    Piece[][] board;

    public Board() {
        board = new Piece[8][8];
        init();
    }
    public void init() {
        for (int i = 0; i < 8; i++) {
            board[i][1] = new Pawn(true);
            board[i][6] = new Pawn(false);
        }
        board[0][0] = new Rook(true);
        board[7][0] = new Rook(true);
        board[0][7] = new Rook(false);
        board[7][7] = new Rook(false);

        board[1][0] = new Knight(true);
        board[6][0] = new Knight(true);
        board[1][7] = new Knight(false);
        board[6][7] = new Knight(false);

        board[2][0] = new Bishop(true);
        board[5][0] = new Bishop(true);
        board[2][7] = new Bishop(false);
        board[5][7] = new Bishop(false);

        board[3][0] = new Queen(true);
        board[3][7] = new Queen(false);

        board[4][0] = new King(true);
        board[4][7] = new King(false);
    }

    public Piece getPiece(int x, int y) {
        return board[x][y];
    }
    public void setPiece(int x, int y, Piece piece) {
        board[x][y] = piece;
    }
}
