package xyz.chengzi.chess.model.DifferentTypeOfPiece;

import xyz.chengzi.chess.model.ChessPiece;
import xyz.chengzi.chess.model.Type;

public class PieceKing extends ChessPiece {
    public PieceKing(int player) {
        super(player);
        this.type = Type.King;
    }
}
