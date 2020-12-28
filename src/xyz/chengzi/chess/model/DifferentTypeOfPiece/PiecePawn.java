package xyz.chengzi.chess.model.DifferentTypeOfPiece;

import xyz.chengzi.chess.model.ChessPiece;
import xyz.chengzi.chess.model.Type;

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
