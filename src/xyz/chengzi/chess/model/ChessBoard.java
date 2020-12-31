package xyz.chengzi.chess.model;

import xyz.chengzi.chess.model.DifferentTypeOfPiece.*;

public class ChessBoard {
    private Square[][] grid;
    private int dimension;

    public ChessBoard(int dimension) {
        this.grid = new Square[dimension][dimension];
        this.dimension = dimension;

        initGrid();
        initPieces();
    }

    private void initGrid() {
        for (int i = 0; i < dimension; i++) {
            for (int j = 0; j < dimension; j++) {
                grid[i][j] = new Square(new ChessBoardLocation(i, j));
            }
        }
    }

    private void initPieces() {
        // TODO: This is only a demo implementation.
        for (int i = 0; i < dimension; i ++) {
            grid[i][1].setPiece(new PiecePawn(0));
        }
        for (int i = 0; i < dimension; i ++) {
            grid[i][6].setPiece(new PiecePawn(1));
        }

        grid            [0][0].setPiece(new PieceRook(0));
        grid[dimension - 1][0].setPiece(new PieceRook(0));
        grid            [1][0].setPiece(new PieceKnight(0));
        grid[dimension - 2][0].setPiece(new PieceKnight(0));
        grid            [2][0].setPiece(new PieceBishop(0));
        grid[dimension - 3][0].setPiece(new PieceBishop(0));
        grid            [3][0].setPiece(new PieceQueen(0));
        grid[dimension - 4][0].setPiece(new PieceKing(0));

        grid            [0][dimension - 1].setPiece(new PieceRook(1));
        grid[dimension - 1][dimension - 1].setPiece(new PieceRook(1));
        grid            [1][dimension - 1].setPiece(new PieceKnight(1));
        grid[dimension - 2][dimension - 1].setPiece(new PieceKnight(1));
        grid            [2][dimension - 1].setPiece(new PieceBishop(1));
        grid[dimension - 3][dimension - 1].setPiece(new PieceBishop(1));
        grid            [3][dimension - 1].setPiece(new PieceQueen(1));
        grid[dimension - 4][dimension - 1].setPiece(new PieceKing(1));
        // initial operation has been complete!
    }

    public Square getGridAt(ChessBoardLocation location) {
        return grid[location.getRow()][location.getColumn()];
    }

    public ChessPiece getChessPieceAt(ChessBoardLocation location) {
        return getGridAt(location).getPiece();
    }

    public void setChessPieceAt(ChessBoardLocation location, ChessPiece piece) {
        getGridAt(location).setPiece(piece);
    }

    public ChessPiece removeChessPieceAt(ChessBoardLocation location) {
        ChessPiece piece = getGridAt(location).getPiece();
        getGridAt(location).setPiece(null);
        return piece;
    }

    public void moveChessPiece(ChessBoardLocation src, ChessBoardLocation dest) {
//        if (!isValidMove(src, dest)) {
//            throw new IllegalArgumentException("Illegal chessPiece move");
//        }
        setChessPieceAt(dest, removeChessPieceAt(src));
    }

    public int getDimension() {
        return dimension;
    }

    public boolean isValidMove(ChessBoardLocation src, ChessBoardLocation dest) {
        if (getChessPieceAt(src) == null || getChessPieceAt(dest) != null) {
            return false;
        }
        int srcRow = src.getRow(), srcCol = src.getColumn(), destRow = dest.getRow(), destCol = dest.getColumn();
        int rowDistance = destRow - srcRow, colDistance = destCol - srcCol;
        if (rowDistance != 0 && colDistance != 0 && Math.abs((double) rowDistance / colDistance) != 1.0) {
            return false;
        }
        if (Math.abs(rowDistance) <= 1 && Math.abs(colDistance) <= 1) {
            return true;
        }
        return false;
    }
}
