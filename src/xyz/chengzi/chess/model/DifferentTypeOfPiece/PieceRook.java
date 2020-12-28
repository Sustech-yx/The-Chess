package xyz.chengzi.chess.model.DifferentTypeOfPiece;

import xyz.chengzi.chess.model.ChessPiece;
import xyz.chengzi.chess.model.Type;

public class PieceRook extends ChessPiece {
    public PieceRook(int player) {
        super(player);
        this.type = Type.Rook;
    }
}
