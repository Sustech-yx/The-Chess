package xyz.chengzi.halma.model.DifferentTypeOfPiece;

import xyz.chengzi.halma.model.ChessPiece;
import xyz.chengzi.halma.model.Type;

public class PieceKnight extends ChessPiece {
    public PieceKnight(int player) {
        super(player);
        this.type = Type.Knight;
    }
}
