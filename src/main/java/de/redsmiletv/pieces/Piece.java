package de.redsmiletv.pieces;

import de.redsmiletv.Main;

import javax.swing.*;
import java.util.Objects;

public abstract class Piece {
    private boolean isWhite;
    private ImageIcon icon;
    private boolean isSelected;
    private String iconPath;
    private int x;
    private int y;

    public Piece(boolean isWhite) {
        this.isWhite = isWhite;
        String pieceType = getClass().getTypeName().toLowerCase().replace("de.redsmiletv.pieces.", "");

        iconPath = isWhite ? "/white/" + pieceType + ".png" : "/black/" + pieceType + ".png";
        icon = new ImageIcon(Objects.requireNonNull(Main.class.getResource(iconPath)));
    }

    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
    public void setSelected(boolean selected) {
        isSelected = selected;
    }
    public boolean isWhite() {
        return isWhite;
    }
    public boolean isSelected() {
        return isSelected;
    }
    public ImageIcon getIcon() {
        return icon;
    }


    public abstract boolean isValidMove(int startX, int startY, int endX, int endY);

    public void moveTo(int x, int y) {
        this.x = x;
        this.y = y;
    }


}
