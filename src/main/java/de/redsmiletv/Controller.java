package de.redsmiletv;

import de.redsmiletv.db.Data;
import de.redsmiletv.pieces.Piece;
import de.redsmiletv.ui.GUI;

public class Controller {
    private GUI gui;
    private Board board;
    Player white, black;
    boolean isFirstMove = true;
    int startX, startY;
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
        // TODO move method
        Piece startPiece = null;

        if (isFirstMove) {
            if (board.getPiece(x, y) == null) return;
            startX = x;
            startY = y;
            startPiece = board.getPiece(startX, startY);
            System.out.println(startPiece);
            isFirstMove = false;
        }
        // TODO fix NullPointerException
        else if (startPiece.isValidMove(startX, startY, x, y)) {
            System.out.println("SIUUUU");
            isFirstMove = true;
        }



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
