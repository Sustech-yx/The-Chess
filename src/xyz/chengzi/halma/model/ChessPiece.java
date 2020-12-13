package xyz.chengzi.halma.model;

public abstract class ChessPiece {
    private final int player; // 0 for black, 1 for white
    private final Type type;
    public ChessPiece(int player, Type type) {
        this.player = player;
        this.type = type;
    }
    public Type getType () {
        return type;
    }
    public int getPlayer () {
        return player;
    }
}
