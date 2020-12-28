package xyz.chengzi.chess.model.DifferentTypeOfPiece;

import xyz.chengzi.chess.model.ChessPiece;
import xyz.chengzi.chess.model.Type;

public class PieceQueen extends ChessPiece {
    public PieceQueen(int player) {
        super(player);
        this.type = Type.Queen;
    }
}
