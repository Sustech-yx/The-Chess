package xyz.chengzi.chess.model.DifferentTypeOfPiece;

import xyz.chengzi.chess.model.ChessBoard;
import xyz.chengzi.chess.model.ChessBoardLocation;
import xyz.chengzi.chess.model.ChessPiece;
import xyz.chengzi.chess.model.Type;

public class PieceKnight extends ChessPiece {
    public PieceKnight(int player) {
        super(player);
        this.type = Type.Knight;
    }

    @Override
    public boolean isValidMove(ChessBoardLocation src, ChessBoardLocation dest, ChessBoard model) {
        return false;
    }
}
