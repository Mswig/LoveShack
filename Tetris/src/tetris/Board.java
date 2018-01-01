/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tetris;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Random;

/**
 *
 * @author mvstu
 */
public class Board extends JPanel implements ActionListener { 
    
    final public static Random RAND = new Random();
    
    private Timer timer;
    private Block block;
    public Tetromino tetro;
    private final int DELAY = 50;
    
    public Board() {
        initBoard();
    }
    
    private void initBoard() {
        
        addKeyListener(new TAdapter());
        setFocusable(true);
        setBackground(Color.BLACK);

        generatePiece();
        
        timer = new Timer(DELAY, this);
        timer.start();        
    }
    
    public void generatePiece(){
        int r = RAND.nextInt(7)+1;
        tetro = new Tetromino(r);
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
        tetro.drop();
        repaint();  
    }

    private class TAdapter extends KeyAdapter {

        @Override
        public void keyReleased(KeyEvent e) {
                tetro.keyReleased(e);
        }

        @Override
        public void keyPressed(KeyEvent e) {
                tetro.keyPressed(e);
        }
    }
}

