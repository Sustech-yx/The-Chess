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

    // TODO: 2021/1/1 fixing the rule of pawn move.
    @Override
    public boolean isValidMove (ChessBoardLocation src, ChessBoardLocation dest, ChessBoard model) {
        int srcColumn = src.getColumn(), srcRow = src.getRow(), destColumn = dest.getColumn(), destRow = dest.getRow();

        if (isFirstMove()) {
            if (getPlayer() == 1) { // white
                if (srcRow == destRow && srcColumn - destColumn == 1 && model.getChessPieceAt(dest) == null) {
                    this.isFirstMove = false;
                    return true;
                }
                else if (srcRow == destRow && srcColumn - destColumn == 2 &&
                        model.getChessPieceAt(dest) == null &&
                        model.getChessPieceAt(new ChessBoardLocation(srcRow, srcColumn - 1)) == null) {
                    this.isFirstMove = false;
                    return true;
                }
                else if (Math.abs(srcRow - destRow) == 1 && srcColumn - destColumn == 1 &&
                        model.getChessPieceAt(dest) != null &&
                        model.getChessPieceAt(dest).getPlayer() == 0) {
                    this.isFirstMove = false;
                    return true;
                }
                else return false;
            } else { // black
                if (srcRow == destRow && srcColumn - destColumn == -1 && model.getChessPieceAt(dest) == null) {
                    this.isFirstMove = false;
                    return true;
                }
                else if (srcRow == destRow && srcColumn - destColumn == -2 &&
                        model.getChessPieceAt(dest) == null &&
                        model.getChessPieceAt(new ChessBoardLocation(srcRow, srcColumn + 1)) == null) {
                    this.isFirstMove = false;
                    return true;
                }
                else if (Math.abs(srcRow - destRow) == 1 && srcColumn - destColumn == -1 &&
                        model.getChessPieceAt(dest) != null &&
                        model.getChessPieceAt(dest).getPlayer() == 1) {
                    this.isFirstMove = false;
                    return true;
                }
                else return false;
            }
        } else {
            check();
            if (getPlayer() == 1) { // white
                if (srcRow == destRow && srcColumn - destColumn == 1 && model.getChessPieceAt(dest) == null) {
                    this.isFirstMove = false;
                    return true;
                } else if (Math.abs(srcRow - destRow) == 1 && srcColumn - destColumn == 1 &&
                        model.getChessPieceAt(dest) != null &&
                        model.getChessPieceAt(dest).getPlayer() == 0) {
                    this.isFirstMove = false;
                    return true;
                }
                else return false;
            } else { // black
                if (srcRow == destRow && srcColumn - destColumn == -1 && model.getChessPieceAt(dest) == null) {
                    this.isFirstMove = false;
                    return true;
                } else if (Math.abs(srcRow - destRow) == 1 && srcColumn - destColumn == -1 &&
                        model.getChessPieceAt(dest) != null &&
                        model.getChessPieceAt(dest).getPlayer() == 1) {
                    this.isFirstMove = false;
                    return true;
                }
                else return false;
            }
        }
    }

    public boolean isFirstMove() {
        return isFirstMove;
    }

    private boolean check() {
        return false;
    }
}
