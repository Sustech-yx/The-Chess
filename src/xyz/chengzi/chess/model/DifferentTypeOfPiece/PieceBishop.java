package xyz.chengzi.chess.model.DifferentTypeOfPiece;

import xyz.chengzi.chess.model.ChessPiece;
import xyz.chengzi.chess.model.Type;

public class PieceBishop extends ChessPiece {
    public PieceBishop(int player) {
        super(player);
        this.type = Type.Bishop;
    }
}
