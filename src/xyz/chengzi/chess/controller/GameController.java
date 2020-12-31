package xyz.chengzi.chess.controller;

import xyz.chengzi.chess.listener.GameListener;
import xyz.chengzi.chess.model.ChessBoard;
import xyz.chengzi.chess.model.ChessBoardLocation;
import xyz.chengzi.chess.model.ChessPiece;
import xyz.chengzi.chess.view.ChessBoardComponent;
import xyz.chengzi.chess.view.ChessComponent;
import xyz.chengzi.chess.view.SquareComponent;

public class GameController implements GameListener {
    private ChessBoardComponent view;
    private ChessBoard model;

    private int currentPlayer;
    private ChessPiece selectedPiece;
    private ChessBoardLocation selectedLocation;

    public GameController(ChessBoardComponent boardComponent, ChessBoard chessBoard) {
        this.view = boardComponent;
        this.model = chessBoard;

        this.currentPlayer = 1;
        view.registerListener(this);
        initGameState();
    }

    public void initGameState() {
        for (int row = 0; row < model.getDimension(); row++) {
            for (int col = 0; col < model.getDimension(); col++) {
                ChessBoardLocation location = new ChessBoardLocation(row, col);
                ChessPiece piece = model.getChessPieceAt(location);
                if (piece != null) {
                    view.setChessAtGrid(location, piece.getPlayer(), piece.getType());
                }
            }
        }
        view.repaint();
    }

    public int nextPlayer() {
        return currentPlayer = currentPlayer == 0 ? 1 : 0;
    }

    private final String[] LIST = {"A", "B", "C", "D", "E", "F", "G", "H"};
    @Override
    public void onPlayerClickSquare(ChessBoardLocation location, SquareComponent component) {
        int row_in_message = location.getRow();
        int column_in_message = location.getColumn();
        String message = "On Player" + (currentPlayer == 1 ? " white" : " black") + " click at " + LIST[row_in_message]
                + (column_in_message + 1) + ", an empty grid. ";
        System.out.print(message);

        if (selectedLocation != null && model.getChessPieceAt(selectedLocation).isValidMove(selectedLocation, location, model)) {
            System.out.println("It's a valid move.");
            model.moveChessPiece(selectedLocation, location);
            view.setChessAtGrid(location, selectedPiece.getPlayer(), selectedPiece.getType());
            view.removeChessAtGrid(selectedLocation);
            view.repaint();
            selectedPiece = null;
            selectedLocation = null;
            nextPlayer();
        } else {
            if (selectedPiece == null) System.out.println("Have not choose the piece.");
            else System.out.println("But it is not a valid move.");
        }
    }

    @Override
    public void onPlayerClickChessPiece(ChessBoardLocation location, ChessComponent component) {
        int row_in_message = location.getRow();
        int column_in_message = location.getColumn();
        String message = "On Player" + (currentPlayer == 1 ? " white" : " black") + " click at " + LIST[row_in_message]
                + (column_in_message + 1) + " , an gird with " + component.getType().toString() + ".";
        System.out.println(message);

        ChessPiece piece = model.getChessPieceAt(location);
        if (piece.getPlayer() == currentPlayer && (selectedPiece == piece || selectedPiece == null)) {
            if (selectedPiece == null) {
                selectedPiece = piece;
                selectedLocation = location;
            } else {
                selectedPiece = null;
                selectedLocation = null;
            }
            component.setSelected(!component.isSelected());
            component.repaint();
        }
    }
}
