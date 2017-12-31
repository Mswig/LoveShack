/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tetris;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 *
 * @author mvstu
 */
public class Board extends JPanel implements ActionListener { 
    
    private Timer timer;
    private Block block;
    private final int DELAY = 10;
    
    public Board() {
        initBoard();
    }
    
    private void initBoard() {
        
        addKeyListener(new TAdapter());
        setFocusable(true);
        setBackground(Color.BLACK);

        block = new Block();

        timer = new Timer(DELAY, this);
        timer.start();        
    }
    
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        doDrawing(g);

        Toolkit.getDefaultToolkit().sync();
    }

    private void doDrawing(Graphics g) {
        
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawImage(block.getImage(), block.getX(), block.getY(), this);        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        block.move();
        repaint();  
    }

    private class TAdapter extends KeyAdapter {

        @Override
        public void keyReleased(KeyEvent e) {
            block.keyReleased(e);
        }

        @Override
        public void keyPressed(KeyEvent e) {
            block.keyPressed(e);
        }
    }
}

