/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chinesechess;

/**
 *
 * @author Sonhungel
 */
import Piece.*;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public final class Board extends JPanel implements MouseListener, ActionListener {

    JFrame board = new JFrame("Chinese Chess");

    public int Counter = 0;
    public int timeCounter = 12;
    public int secondpass = 0;
    public int Row;
    public int turn = 1;
    public int Column;

    JButton btnNewGame;
    JButton btnBackMenu;
    JButton btnSurrender;

    public Piece Active_Piece = null;
    public Piece Click = null;
    // Lưu vị trí của King
    public int[] king = { 0, 0 };
    // cờ kiểm tra ký hiệu quân đc chọn
    public boolean flag = false;
    // Setup Position for KING
    public int[] kingRed = { 9, 4 };
    public int[] kingGreen = { 0, 4 };
    public static Piece[][] Pieces = new Piece[10][9];

    public String Base_Source(String name) {
        return "./Image/" + name + ".gif";
    }

    public String Base_Sources(String name) {
        return "./Image/" + name + ".png";
    }

    public Image new_image(String y) {
        Image img = Toolkit.getDefaultToolkit().getImage(Base_Sources(y));
        return img;
    }

    public void paint(Graphics g) {
        super.paint(g);
        Image img1 = Toolkit.getDefaultToolkit().getImage(Base_Source("board"));
        g.drawImage(img1, 0, 0 + 60, board);
        Image img2 = new_image("Choose");
        Image img5 = new_image("GreenPlayer");
        Image img6 = new_image("RedPlayer");
        Image img7 = new_image("dao");
        Image img8 = new_image("redturn");
        Image img9 = new_image("greenturn");
        if (flag) {
            g.drawImage(img2, 25 + 60 * Column, 25 + 60 * Row + 60, board);
        }
        g.drawImage(img5, 60 * 10 - 13, 60 * 0 + 60, board);
        g.drawImage(img6, 60 * 10 - 13, 60 * 6 - 10 + 60, board);
        g.drawImage(img7, 60 * 12 + 10, 60 * 6 - 60 + 60, board);
        if (turn == 1) {
            g.drawImage(img8, 60 * 10 - 11, 60 * 6 - 60 + 60, board);
        }
        if (turn == 0) {
            g.drawImage(img9, 60 * 12 + 53, 60 * 6 - 60 + 60, board);
        }
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 9; j++) {
                if (Pieces[i][j] != null) {
                    Image image = Toolkit.getDefaultToolkit().getImage(Base_Source(Pieces[i][j].getName()));
                    g.drawImage(image, Pieces[i][j].getX() * 60 + 25, Pieces[i][j].getY() * 60 + 25 + 60, this);
                }
            }
        }
    }

    // Initialize for all Chess Pieces
    public void init() {
        Counter = 0;
        turn = 1;
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 9; j++) {
                Pieces[i][j] = null;
            }
        }
        Pieces[0][0] = PieceFactory.getPiece(PieceType.CHARIOT, PlayerType.GREEN,this);//new Chariot("GChariot", 1, this);
        Pieces[0][1] = PieceFactory.getPiece(PieceType.HORSE, PlayerType.GREEN,this);//new Horse("GHorse", 1, this);
        Pieces[0][2] = PieceFactory.getPiece(PieceType.ELEPHANT, PlayerType.GREEN,this);//new Elephant("GElephant", 1, this);
        Pieces[0][3] = PieceFactory.getPiece(PieceType.ADVISOR, PlayerType.GREEN,this);//new Advisor("GAdvisor", 1, this);
        Pieces[0][4] = PieceFactory.getPiece(PieceType.KING, PlayerType.GREEN,this);//new King("King_Green", 1, this);
        Pieces[0][5] = PieceFactory.getPiece(PieceType.ADVISOR, PlayerType.GREEN,this);//new Advisor("GAdvisor", 1, this);
        Pieces[0][6] = PieceFactory.getPiece(PieceType.ELEPHANT, PlayerType.GREEN,this);//new Elephant("GElephant", 1, this);
        Pieces[0][7] = PieceFactory.getPiece(PieceType.HORSE, PlayerType.GREEN,this);//new Horse("GHorse", 1, this);
        Pieces[0][8] = PieceFactory.getPiece(PieceType.CHARIOT, PlayerType.GREEN,this);//new Chariot("GChariot", 1, this);
        Pieces[2][1] = PieceFactory.getPiece(PieceType.CANNON, PlayerType.GREEN,this);//new Cannon("GCannon", 1, this);
        Pieces[2][7] = PieceFactory.getPiece(PieceType.CANNON, PlayerType.GREEN,this);//new Cannon("GCannon", 1, this);
        Pieces[3][0] = PieceFactory.getPiece(PieceType.PAWN, PlayerType.GREEN,this);//new Pawn("GPawn", 1, this);
        Pieces[3][2] = PieceFactory.getPiece(PieceType.PAWN, PlayerType.GREEN,this);//new Pawn("GPawn", 1, this);
        Pieces[3][4] = PieceFactory.getPiece(PieceType.PAWN, PlayerType.GREEN,this);//new Pawn("GPawn", 1, this);
        Pieces[3][6] = PieceFactory.getPiece(PieceType.PAWN, PlayerType.GREEN,this);//new Pawn("GPawn", 1, this);
        Pieces[3][8] = PieceFactory.getPiece(PieceType.PAWN, PlayerType.GREEN,this);//new Pawn("GPawn", 1, this);

        Pieces[9][0] = PieceFactory.getPiece(PieceType.CHARIOT, PlayerType.RED,this);//new Chariot("RChariot", 0, this);
        Pieces[9][1] = PieceFactory.getPiece(PieceType.HORSE, PlayerType.RED,this);//new Horse("RHorse", 0, this);
        Pieces[9][2] = PieceFactory.getPiece(PieceType.ELEPHANT, PlayerType.RED,this);//new Elephant("RElephant", 0, this);
        Pieces[9][3] = PieceFactory.getPiece(PieceType.ADVISOR, PlayerType.RED,this);//new Advisor("RAdvisor", 0, this);
        Pieces[9][4] = PieceFactory.getPiece(PieceType.KING, PlayerType.RED,this);//new King("King_Red", 0, this);
        Pieces[9][5] = PieceFactory.getPiece(PieceType.ADVISOR, PlayerType.RED,this);//new Advisor("RAdvisor", 0, this);
        Pieces[9][6] = PieceFactory.getPiece(PieceType.ELEPHANT, PlayerType.RED,this);//new Elephant("RElephant", 0, this);
        Pieces[9][7] = PieceFactory.getPiece(PieceType.HORSE, PlayerType.RED,this);//new Horse("RHorse", 0, this);
        Pieces[9][8] = PieceFactory.getPiece(PieceType.CHARIOT, PlayerType.RED,this);//new Chariot("RChariot", 0, this);
        Pieces[7][1] = PieceFactory.getPiece(PieceType.CANNON, PlayerType.RED,this);//new Cannon("RCannon", 0, this);
        Pieces[7][7] = PieceFactory.getPiece(PieceType.CANNON, PlayerType.RED,this);//new Cannon("RCannon", 0, this);
        Pieces[6][0] = PieceFactory.getPiece(PieceType.PAWN, PlayerType.RED,this);//new Pawn("RPawn", 0, this);
        Pieces[6][2] = PieceFactory.getPiece(PieceType.PAWN, PlayerType.RED,this);//new Pawn("RPawn", 0, this);
        Pieces[6][4] = PieceFactory.getPiece(PieceType.PAWN, PlayerType.RED,this);//new Pawn("RPawn", 0, this);
        Pieces[6][6] = PieceFactory.getPiece(PieceType.PAWN, PlayerType.RED,this);//new Pawn("RPawn", 0, this);
        Pieces[6][8] = PieceFactory.getPiece(PieceType.PAWN, PlayerType.RED,this);//new Pawn("RPawn", 0, this);

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 9; j++) {
                if (Pieces[i][j] != null) {
                    Pieces[i][j].setY(i);
                    Pieces[i][j].setX(j);
                }
            }
        }
    }

    public void DrawBoard() {
        btnNewGame = new JButton("New Game");
        btnNewGame.setBackground(Color.green);
        btnNewGame.setForeground(Color.red);
        btnNewGame.addActionListener(this);

        btnBackMenu = new JButton("Back To Menu");
        btnBackMenu.setBackground(Color.blue);
        btnBackMenu.setForeground(Color.orange);
        btnBackMenu.addActionListener(this);

        btnSurrender = new JButton("Surrender");
        btnSurrender.setBackground(Color.orange);
        btnSurrender.addActionListener(this);
        this.add(btnNewGame);
        this.add(btnBackMenu);
        this.add(btnSurrender);
        board.getContentPane().add(this);
        board.setSize(930, 750);
        board.setLocationRelativeTo(null);
        this.repaint();
    }

    public Piece GetPiece(int Row, int Column) {
        if (Pieces[Row][Column] != null) {
            return Pieces[Row][Column];
        }
        return null;
    }

    public Board() {
        init();
        DrawBoard();
        board.addMouseListener(this);
        board.setBackground(Color.WHITE);
        board.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        board.setVisible(true);
    }

    public void CheckLocalKing(String name) {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 9; j++) {
                if (Pieces[i][j] instanceof King && Pieces[i][j].getName().equals(name)) {
                    king[0] = i;
                    king[1] = j;
                }
            }
        }
    }

    public boolean checkTwoKing() {
        CheckLocalKing("King_Red");
        int rowRed = king[0], columnRed = king[1];
        CheckLocalKing("King_Green");
        int rowGreen = king[0], columnGreen = king[1];
        if (columnRed == columnGreen) {
            for (int i = rowRed - 1; i >= rowGreen; i--) {
                if (Pieces[i][columnRed] != null) {
                    if (i == rowGreen) {
                        return true;
                    }
                    return false;
                }
            }
        }
        return false;
    }

    public boolean CheckMateRed() {
        CheckLocalKing("King_Red");
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 9; j++) {
                Piece desPiece = GetPiece(i, j);
                if (desPiece != null) {
                    if (desPiece.getColor() == 1) {
                        if (desPiece.Move(king[0], king[1])) {
                            return true;
                        }
                    }
                }
            }
        }

        return false;
    }

    public boolean CheckMateBlack() {
        CheckLocalKing("King_Green");
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 9; j++) {
                Piece desPiece = GetPiece(i, j);
                if (desPiece != null) {
                    if (desPiece.getColor() == 0) {
                        if (desPiece.Move(king[0], king[1])) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    public static void infoBox(String infoMessage, String titleBar) {
        JOptionPane.showMessageDialog(null, infoMessage, "Warning : " + titleBar, JOptionPane.INFORMATION_MESSAGE);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
        // xác định vị trí con trỏ
        Row = (int) ((e.getY() - 25 - 60) / 60.0 - 0.5);
        Column = (int) ((e.getX() - 25) / 60.0);
        int color = 0;
        if (Counter % 2 == 1) {
            color = 1;
        }
        if (Row >= 0 && Row <= 9 && Column >= 0 && Column <= 8) {
            if (Active_Piece == null && Pieces[Row][Column] != null && color == Pieces[Row][Column].getColor()) {
                Active_Piece = Pieces[Row][Column];
                flag = true;
            } else if (Active_Piece != null && color == Active_Piece.getColor()
                    && Active_Piece.Move(Row, Column) == true) {
                if (Counter % 2 == 1) {
                    color = 1;
                    turn = 1;
                } else {
                    turn = 0;
                }
                int Current_X = Active_Piece.getX();
                int Current_Y = Active_Piece.getY();
                Piece pieceXoa = Pieces[Row][Column];
                Piece pieceDiChuyen = Pieces[Current_Y][Current_X];
                if (Pieces[Row][Column] != null) {
                    Pieces[Row][Column] = null;
                }
                Active_Piece.setX(Column);
                Active_Piece.setY(Row);
                Pieces[Row][Column] = Active_Piece;

                Pieces[Current_Y][Current_X] = null;
                Active_Piece = null;
                Counter++;
                flag = false;
                if ("King_Red".equals(Pieces[Row][Column].getName())) {
                    kingRed[0] = Row;
                    kingRed[1] = Column;
                }
                if ("King_Green".equals(Pieces[Row][Column].getName())) {
                    kingGreen[0] = Row;
                    kingGreen[1] = Column;
                }
              
                if (Pieces[Row][Column] != null && Pieces[Row][Column].getColor() == 0) {
                    if (CheckMateRed()) {
                        pieceDiChuyen.setY(Current_Y);
                        pieceDiChuyen.setX(Current_X);
                        Pieces[Current_Y][Current_X] = pieceDiChuyen;
                        Pieces[Row][Column] = pieceXoa;
                        Active_Piece = null;
                        Counter = 0;
                        turn = 1;
                    }
                }
                if (Pieces[Row][Column] != null && Pieces[Row][Column].getColor() == 1) {
                    if (CheckMateBlack()) {
                        pieceDiChuyen.setY(Current_Y);
                        pieceDiChuyen.setX(Current_X);
                        Pieces[Current_Y][Current_X] = pieceDiChuyen;
                        Pieces[Row][Column] = pieceXoa;
                        Active_Piece = null;
                        Counter = 1;
                        turn = 0;
                    }
                }
            } else {
                Active_Piece = null;
                flag = false;
            }
            repaint();
            
            if (Pieces[Row][Column].getColor() == 1) {
                if (CheckMateRed()) {
                    System.out.println("Chieu tuong do");
                    infoBox("Checkmate Red", "CHECKMATE");
                }
            }
            if (Pieces[Row][Column].getColor() == 0) {
                if (CheckMateBlack()) {
                    System.out.println("Chieu tuong den");
                    infoBox("Checkmate Green", "CHECKMATE");
                }
            }
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnSurrender) {
            if (turn == 1) {
                JFrame panel = new JFrame();
                panel.setLayout(new GridBagLayout());
                JLabel label = new JLabel(" Red Lose");
                label.setBackground(Color.black);
                //label.setForeground(Color.red);
                System.out.printf("Red Lose");
                panel.add(label);

                panel.setSize(100, 100);
                panel.setLocationRelativeTo(null);
                panel.setVisible(true);
            } else if (turn == 0) {
                JFrame panel = new JFrame();
                panel.setLayout(new GridBagLayout());
                JLabel label = new JLabel(" Green Lose");
                label.setForeground(Color.black);
                //label.setForeground(Color.green);
                panel.setSize(100, 100);
                panel.setLocationRelativeTo(null);
                panel.setVisible(true);
                panel.add(label);
                panel.setVisible(true);
            }
        }

        if (e.getSource() == btnNewGame) {
            board.dispose();
            new Board();
        }
        if (e.getSource() == btnBackMenu) {
            board.dispose();
            new ChineseChessLayout();
        }
    }
}
