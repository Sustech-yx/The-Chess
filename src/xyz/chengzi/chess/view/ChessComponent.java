package xyz.chengzi.chess.view;

import xyz.chengzi.chess.model.Type;

import javax.swing.*;
import java.awt.*;

public class ChessComponent extends JComponent {
    private int player;
    private Type type;
    private boolean selected;

    private Image white_pawn;
    private Image white_rook;
    private Image white_king;
    private Image white_queen;
    private Image white_knight;
    private Image white_bishop;

    private Image black_pawn;
    private Image black_rook;
    private Image black_king;
    private Image black_queen;
    private Image black_knight;
    private Image black_bishop;

    public ChessComponent(int Player, Type type) {
        this.player = Player;
        this.type = type;
        initialImg();
    }

    private void initialImg() {
        Toolkit toolkit = this.getToolkit();
        white_pawn = toolkit.getImage("D:\\学习\\课程\\2020-2021年度上学期（大二上）\\java\\Chess\\src\\xyz\\chengzi\\chess\\view\\chessImgs\\baibing.png");
        white_rook = toolkit.getImage("D:\\学习\\课程\\2020-2021年度上学期（大二上）\\java\\Chess\\src\\xyz\\chengzi\\chess\\view\\chessImgs\\baiche.png");
        white_king = toolkit.getImage("D:\\学习\\课程\\2020-2021年度上学期（大二上）\\java\\Chess\\src\\xyz\\chengzi\\chess\\view\\chessImgs\\baiwang.png");
        white_queen = toolkit.getImage("D:\\学习\\课程\\2020-2021年度上学期（大二上）\\java\\Chess\\src\\xyz\\chengzi\\chess\\view\\chessImgs\\baihou.png");
        white_knight = toolkit.getImage("D:\\学习\\课程\\2020-2021年度上学期（大二上）\\java\\Chess\\src\\xyz\\chengzi\\chess\\view\\chessImgs\\baima.png");
        white_bishop = toolkit.getImage("D:\\学习\\课程\\2020-2021年度上学期（大二上）\\java\\Chess\\src\\xyz\\chengzi\\chess\\view\\chessImgs\\baixiang.png");

        black_pawn = toolkit.getImage("D:\\学习\\课程\\2020-2021年度上学期（大二上）\\java\\Chess\\src\\xyz\\chengzi\\chess\\view\\chessImgs\\heibing.png");
        black_rook = toolkit.getImage("D:\\学习\\课程\\2020-2021年度上学期（大二上）\\java\\Chess\\src\\xyz\\chengzi\\chess\\view\\chessImgs\\heiche.png");
        black_king = toolkit.getImage("D:\\学习\\课程\\2020-2021年度上学期（大二上）\\java\\Chess\\src\\xyz\\chengzi\\chess\\view\\chessImgs\\heiwang.png");
        black_queen = toolkit.getImage("D:\\学习\\课程\\2020-2021年度上学期（大二上）\\java\\Chess\\src\\xyz\\chengzi\\chess\\view\\chessImgs\\heihou.png");
        black_knight = toolkit.getImage("D:\\学习\\课程\\2020-2021年度上学期（大二上）\\java\\Chess\\src\\xyz\\chengzi\\chess\\view\\chessImgs\\heima.png");
        black_bishop = toolkit.getImage("D:\\学习\\课程\\2020-2021年度上学期（大二上）\\java\\Chess\\src\\xyz\\chengzi\\chess\\view\\chessImgs\\heixiang.png");

    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        paintChess(g);
    }

    private void paintChess(Graphics g) {
        ((Graphics2D) g).setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        int spacing = (int) (getWidth() * 0.05);
        if (player == 1) {
            switch (type) {
                case Pawn:g.drawImage(white_pawn, spacing, spacing, getWidth() - 2 * spacing, getHeight() - 2 * spacing, this);
                    break;
                case Rook:g.drawImage(white_rook, spacing, spacing, getWidth() - 2 * spacing, getHeight() - 2 * spacing, this);
                    break;
                case King:g.drawImage(white_king, spacing, spacing, getWidth() - 2 * spacing, getHeight() - 2 * spacing, this);
                    break;
                case Queen:g.drawImage(white_queen, spacing, spacing, getWidth() - 2 * spacing, getHeight() - 2 * spacing, this);
                    break;
                case Bishop:g.drawImage(white_bishop, spacing, spacing, getWidth() - 2 * spacing, getHeight() - 2 * spacing, this);
                    break;
                case Knight:g.drawImage(white_knight, spacing, spacing, getWidth() - 2 * spacing, getHeight() - 2 * spacing, this);
                    break;
            }
        } else {
            switch (type) {
                case Pawn:g.drawImage(black_pawn, spacing, spacing, getWidth() - 2 * spacing, getHeight() - 2 * spacing, this);
                    break;
                case Rook:g.drawImage(black_rook, spacing, spacing, getWidth() - 2 * spacing, getHeight() - 2 * spacing, this);
                    break;
                case King:g.drawImage(black_king, spacing, spacing, getWidth() - 2 * spacing, getHeight() - 2 * spacing, this);
                    break;
                case Queen:g.drawImage(black_queen, spacing, spacing, getWidth() - 2 * spacing, getHeight() - 2 * spacing, this);
                    break;
                case Bishop:g.drawImage(black_bishop, spacing, spacing, getWidth() - 2 * spacing, getHeight() - 2 * spacing, this);
                    break;
                case Knight:g.drawImage(black_knight, spacing, spacing, getWidth() - 2 * spacing, getHeight() - 2 * spacing, this);
                    break;
        }
    }
}
}
