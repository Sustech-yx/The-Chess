package xyz.chengzi.halma.model.DifferentTypeOfPiece;

import xyz.chengzi.halma.model.ChessPiece;
import xyz.chengzi.halma.model.Type;

public class PieceRook extends ChessPiece {
    public PieceRook(int player) {
        super(player);
        this.type = Type.Rook;
    }
}
