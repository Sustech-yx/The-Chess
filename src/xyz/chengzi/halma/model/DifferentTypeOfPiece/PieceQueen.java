package xyz.chengzi.halma.model.DifferentTypeOfPiece;

import xyz.chengzi.halma.model.ChessPiece;
import xyz.chengzi.halma.model.Type;

public class PieceQueen extends ChessPiece {
    public PieceQueen(int player) {
        super(player);
        this.type = Type.Queen;
    }
}
