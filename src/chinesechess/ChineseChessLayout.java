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

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class ChineseChessLayout extends JFrame implements ActionListener {
    
    private final JButton btnPlay;
    private JLabel lb;
    
    private JButton createJButton(String title) {
        JButton btn = new JButton(title);
        // add action for JButton
        btn.addActionListener(this);
        return btn;
    }
    
    public ChineseChessLayout() {
        // create JFrame
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 400);
        GridBagLayout layout = new GridBagLayout();
        setLayout(layout);
        // add JFrame content
        GridBagConstraints gbc = new GridBagConstraints();
        btnPlay = createJButton("Start");
        btnPlay.setBackground(Color.orange);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.ipady = 20;
        gbc.gridx = 0;
        gbc.gridy = 0;

        JLabel panel = new JLabel("Welcom To Our Chess");
        panel.setFont(new Font("Serif", Font.PLAIN, 30));
        add(panel, gbc);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.ipady = 20;
        gbc.gridx = 0;
        gbc.gridy = 1;
        add(btnPlay, gbc);

        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.ipady = 20;
        gbc.gridx = 0;
        gbc.gridy = 2;
        
        setLocationRelativeTo(null);
        setVisible(true);
    }

     // change text and background of JLabel when click button
    private void changeBackgroundJLabel(Color bgcolor, String nameBgcolor) {
        lb.setBackground(bgcolor);
        lb.setText("Background is " + nameBgcolor);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnPlay) {
            //new Board();
            System.out.println("Tapped button START");
        }
        //this.dispose();
    }
    
    public static void main(String[] args) {
        new ChineseChessLayout();
    }
}
