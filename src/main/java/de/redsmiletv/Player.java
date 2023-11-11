package de.redsmiletv;

public class Player {
    private boolean isWhite;
    private boolean isTurn;
    private String username;

    public Player(boolean isWhite) {
        this.isWhite = isWhite;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public void setTurn(boolean turn) {
        isTurn = turn;
    }
    public String getUsername() {
        return username;
    }
    public boolean isTurn() {
        return isTurn;
    }
}
