package xyz.chengzi.chess;

import xyz.chengzi.chess.controller.GameController;
import xyz.chengzi.chess.model.ChessBoard;
import xyz.chengzi.chess.view.ChessBoardComponent;
import xyz.chengzi.chess.view.GameFrame;

import javax.swing.*;

public class Game {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ChessBoardComponent chessBoardComponent = new ChessBoardComponent(760, 8);
            ChessBoard chessBoard = new ChessBoard(8);
            GameController controller = new GameController(chessBoardComponent, chessBoard);

            GameFrame mainFrame = new GameFrame();
            mainFrame.add(chessBoardComponent);
            mainFrame.setVisible(true);
        });
    }
}
