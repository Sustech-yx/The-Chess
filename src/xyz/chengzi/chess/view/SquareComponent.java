package xyz.chengzi.chess.view;

import javax.swing.*;
import java.awt.*;

public class SquareComponent extends JPanel {

    private static final Color BOARD_COLOR_1 = new Color(252, 230, 201);
    private static final Color BOARD_COLOR_2 = new Color(239, 125, 45);

    private int i;
    private Color color;
    private boolean hasText;
    private String text;

    public SquareComponent(int size, int i) {
        setLayout(new GridLayout(1, 1)); // Use 1x1 grid layout.
        setSize(size, size);
        this.i = i;
        color = i == 0 ? BOARD_COLOR_1 : BOARD_COLOR_2;
        hasText = false;
    }

    public SquareComponent(int size, int i, String text) {
        this(size, i);
        this.hasText = true;
        this.text = text;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        paintSquare(g);
        if (hasText) paintText(g);
    }

    private void paintSquare(Graphics g) {
        g.setColor(color);
        g.fillRect(0, 0, getWidth(), getHeight());
        g.setColor(Color.BLACK);
        g.drawRect(0, 0, getWidth(), getHeight());
    }

    private void paintText (Graphics g) {
        g.setColor(i == 1 ? BOARD_COLOR_1 : BOARD_COLOR_2);
        Font font = new Font( "AGaramondPro-Regular", Font.BOLD, 22);
        g.setFont(font);

        char[] arr = text.toCharArray();
        for (char c : arr) {
            if (Character.isDigit(c)) {
                g.drawString(String.valueOf(c), 5, 20);
            } else {
                g.drawString(String.valueOf(c), getWidth() - 20, getHeight() - 5);
            }
        }
    }
}
