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
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Label;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JPanel;
import javax.swing.JLabel;
import org.w3c.dom.css.Counter;

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
    public int[] king = {0, 0};
    public boolean flag = false;
    // Setup Position for KING
    public int[] kingRed = {9, 4};  
    public int[] kingGreen = {0, 4};
    public static Piece[][] Pieces = new Piece[10][9];
    public static ArrayList<Piece> APiece;
    
    public String Base_Source(String name) {
        return "./" + name + ".gif";

    }

    public String Base_Sources(String name) {
        return "./" + name + ".png";

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
        Image img5 = new_image("player1");
        Image img6 = new_image("player2");
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

    public void init(){

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
    
    public Board(){
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
                //if (Pieces[i][j] instanceof King && Pieces[i][j].getName().equals(name)) {
              //      king[0] = i;
               //     king[1] = j;
              //  }
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

    public boolean CheckMateRed(){
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
    
    public boolean CheckMateBlack(){
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
    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
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
                label.setBackground(Color.yellow);
                label.setForeground(Color.red);
                System.out.printf("Red Lose");
                panel.add(label);

                panel.setSize(100, 100);
                panel.setLocationRelativeTo(null);
                panel.setVisible(true);
            }
            if (turn == 0) {
                JFrame panel = new JFrame();
                panel.setLayout(new GridBagLayout());
                JLabel label = new JLabel(" Green Lose");
                label.setForeground(Color.green);
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
            //repaint();    
        }
        if (e.getSource() == btnBackMenu) {
            board.dispose();
            new ChineseChessLayout();
        }
    }
}
