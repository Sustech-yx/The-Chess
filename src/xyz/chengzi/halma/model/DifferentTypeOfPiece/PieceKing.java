package xyz.chengzi.halma.model.DifferentTypeOfPiece;

import xyz.chengzi.halma.model.ChessPiece;
import xyz.chengzi.halma.model.Type;

public class PieceKing extends ChessPiece {
    public PieceKing(int player) {
        super(player);
        this.type = Type.King;
    }
}
