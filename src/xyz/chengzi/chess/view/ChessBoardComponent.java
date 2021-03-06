package xyz.chengzi.chess.view;

import xyz.chengzi.chess.listener.GameListener;
import xyz.chengzi.chess.model.ChessBoardLocation;
import xyz.chengzi.chess.model.Type;

import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import java.awt.*;

public class ChessBoardComponent extends JComponent {

    private List<GameListener> listenerList = new ArrayList<>();
    private SquareComponent[][] gridComponents;
    private int dimension;
    private int gridSize;

    public ChessBoardComponent(int size, int dimension) {
        enableEvents(AWTEvent.MOUSE_EVENT_MASK);
        setLayout(null); // Use absolute layout.
        setSize(size, size);

        this.gridComponents = new SquareComponent[dimension][dimension];
        this.dimension = dimension;
        this.gridSize = size / dimension;
        initGridComponents();
    }
    private String[] list = {"B", "C", "D", "E", "F", "G", "H"};
    private void initGridComponents() {
        for (int row = 0; row < dimension; row++) {
            for (int col = 0; col < dimension; col++) {
                if (row == 0 && col == dimension - 1) {
                    gridComponents[row][col] = new SquareComponent(gridSize, (row + col) % 2 == 0 ? 0 : 1, "8A");
                } else if (row == 0) {
                    gridComponents[row][col] = new SquareComponent(gridSize, (row + col) % 2 == 0 ? 0 : 1, String.valueOf(col + 1));
                } else if (col == dimension - 1) {
                    gridComponents[row][col] = new SquareComponent(gridSize, (row + col) % 2 == 0 ? 0 : 1, list[row - 1]);
                } else {
                    gridComponents[row][col] = new SquareComponent(gridSize, (row + col) % 2 == 0 ? 0 : 1);
                }
                gridComponents[row][col].setLocation(row * gridSize, col * gridSize);
                add(gridComponents[row][col]);
            }
        }
    }

    public SquareComponent getGridAt(ChessBoardLocation location) {
        return gridComponents[location.getRow()][location.getColumn()];
    }

    public void setChessAtGrid(ChessBoardLocation location, int player, Type type) {
        removeChessAtGrid(location);
        getGridAt(location).add(new ChessComponent(player, type));
    }

    public void removeChessAtGrid(ChessBoardLocation location) {
        // Note re-validation is required after remove / removeAll.
        getGridAt(location).removeAll();
        getGridAt(location).revalidate();
    }

    private ChessBoardLocation getLocationByPosition(int x, int y) {
        return new ChessBoardLocation(x / gridSize, y / gridSize);
    }

    @Override
    protected void processMouseEvent(MouseEvent e) {
        super.processMouseEvent(e);

        if (e.getID() == MouseEvent.MOUSE_PRESSED) {
            JComponent clickedComponent = (JComponent) getComponentAt(e.getX(), e.getY());
            ChessBoardLocation location = getLocationByPosition(e.getX(), e.getY());
            for (GameListener listener : listenerList) {
                if (clickedComponent.getComponentCount() == 0) {
                    listener.onPlayerClickSquare(location, (SquareComponent) clickedComponent);
                } else {
                    listener.onPlayerClickChessPiece(location, (ChessComponent) clickedComponent.getComponent(0), (SquareComponent) clickedComponent);
                }
            }
        }
    }

    public void registerListener(GameListener listener) {
        listenerList.add(listener);
    }

    public void unregisterListener(GameListener listener) {
        listenerList.remove(listener);
    }
}