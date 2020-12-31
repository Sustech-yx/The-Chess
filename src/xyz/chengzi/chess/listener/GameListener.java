package xyz.chengzi.chess.listener;

import xyz.chengzi.chess.model.ChessBoardLocation;
import xyz.chengzi.chess.view.ChessComponent;
import xyz.chengzi.chess.view.SquareComponent;

public interface GameListener {
    void onPlayerClickSquare(ChessBoardLocation location, SquareComponent component);

    void onPlayerClickChessPiece(ChessBoardLocation location, ChessComponent component1, SquareComponent component2);
}
