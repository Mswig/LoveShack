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
    private Tetromino tetro;
    private final int DELAY = 50;
    
    public Board() {
        initBoard();
    }
    
    private void initBoard() {
        
        addKeyListener(new TAdapter());
        setFocusable(true);
        setBackground(Color.BLACK);

        tetro = new Tetromino(1);
        //block = new Block();
        //Block block2 = new Block(60,60);
        
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
        for(int i = 0; i < tetro.blockList.size(); i++){
            g2d.drawImage(tetro.blockList.get(i).getImage(), tetro.blockList.get(i).getX(), tetro.blockList.get(i).getY(), this);    
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) { 
        tetro.move();
        //block.drop();
        repaint();  
    }

    private class TAdapter extends KeyAdapter {

        @Override
        public void keyReleased(KeyEvent e) {
            for(int i = 0; i < tetro.blockList.size(); i++){
                tetro.blockList.get(i).keyReleased(e);
            }
        }

        @Override
        public void keyPressed(KeyEvent e) {
            for(int i = 0; i < tetro.blockList.size(); i++){
                tetro.blockList.get(i).keyPressed(e);
            }
        }
    }
}

