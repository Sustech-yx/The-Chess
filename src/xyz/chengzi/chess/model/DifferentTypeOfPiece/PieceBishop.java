package xyz.chengzi.chess.model.DifferentTypeOfPiece;

import xyz.chengzi.chess.model.ChessBoard;
import xyz.chengzi.chess.model.ChessBoardLocation;
import xyz.chengzi.chess.model.ChessPiece;
import xyz.chengzi.chess.model.Type;

public class PieceBishop extends ChessPiece {
    public PieceBishop(int player) {
        super(player);
        this.type = Type.Bishop;
    }

    @Override
    public boolean isValidMove(ChessBoardLocation src, ChessBoardLocation dest, ChessBoard model) {
        return false;
    }
}
