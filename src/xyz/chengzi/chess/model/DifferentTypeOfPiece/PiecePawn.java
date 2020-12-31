package xyz.chengzi.chess.model.DifferentTypeOfPiece;

import xyz.chengzi.chess.model.ChessBoard;
import xyz.chengzi.chess.model.ChessBoardLocation;
import xyz.chengzi.chess.model.ChessPiece;
import xyz.chengzi.chess.model.Type;

public class PiecePawn extends ChessPiece {
    private boolean isFirstMove;
    public PiecePawn(int player) {
        super(player);
        this.type = Type.Pawn;
        isFirstMove = true;
    }

    @Override
    public boolean isValidMove(ChessBoardLocation src, ChessBoardLocation dest, ChessBoard model) {
        if (isFirstMove) {
            isFirstMove = false;
        } else {

        }
        return false;
    }

    public boolean isFirstMove() {
        return isFirstMove;
    }
}
