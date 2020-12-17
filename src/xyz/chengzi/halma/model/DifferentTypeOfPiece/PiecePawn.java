package xyz.chengzi.halma.model.DifferentTypeOfPiece;

import xyz.chengzi.halma.model.ChessPiece;
import xyz.chengzi.halma.model.Type;

public class PiecePawn extends ChessPiece {
    private boolean isFirstMove;
    public PiecePawn(int player) {
        super(player);
        this.type = Type.Pawn;
    }
    public boolean isFirstMove() {
        return isFirstMove;
    }
}
