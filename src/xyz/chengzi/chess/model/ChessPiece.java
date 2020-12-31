package xyz.chengzi.chess.model;

public abstract class ChessPiece {
    private final int player; // 0 for black, 1 for white
    protected Type type;
    public ChessPiece(int player) {
        this.player = player;
    }
    public Type getType () {
        return type;
    }
    public int getPlayer () {
        return player;
    }

    public abstract boolean isValidMove (ChessBoardLocation src, ChessBoardLocation dest, ChessBoard model);
}
