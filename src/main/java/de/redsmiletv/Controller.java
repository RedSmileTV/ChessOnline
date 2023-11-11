package de.redsmiletv;

import de.redsmiletv.db.Data;
import de.redsmiletv.pieces.Pawn;
import de.redsmiletv.pieces.Piece;
import de.redsmiletv.ui.GUI;

public class Controller {
    private GUI gui;
    private Board board;
    Player white, black;

    public Controller(GUI gui) {
        this.gui = gui;
        Data data = new Data();

        white = new Player(true);
        black = new Player(false);

        board = new Board();
        board.init();
        updateBoard();

    }

    public void move(int x, int y) {
        int startX, startY;
        Piece startPiece, endPiece;
        y = (y - 7) * -1; // Flips the y axis


        

    }

    private void updateBoard() {
        Piece piece;
        for (int y = 0; y < 8; y++) {
            for (int x = 0; x < 8; x++) {
                piece = board.getPiece(x, y);
                y = (y - 7) * -1; // Flips the y axis

                if (piece != null) {
                    gui.setPiece(x, y, piece.getIcon());
                    piece.moveTo(x, y);
                }
                else gui.setPiece(x, y, null);
            }
        }


    }

}
