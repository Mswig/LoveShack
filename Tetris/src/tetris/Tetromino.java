package tetris;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.*;

/**
 * Class for creating tetris blocks: tetriminos.  
 * @author Mswig
 * @since 12/18/2017
 * @see Tetris.java
 */
public class Tetromino{
    
    /*
    array that stores the shape of the block, used for creating new shapes
    */
    public boolean[][] layout;
    
    /*
    integer value that stores the color of the block
    */
    public int color;
    public int centerX;
    public int centerY;
    public ArrayList<Block> blockList = new ArrayList<>();
    
    
    private Block block;
    
    public Tetromino(){
        layout = new boolean[4][2];
        color = 1;
        centerX = 0;
        centerY = 0;
    }
    
    private void initTetromino(){
        for(int i = 0; i < 2; i++){
            for(int j = 0; j < 4; j++){
                if(layout[i][j]){
                    blockList.add(new Block(j*30, i*30, color));
                }
            }
        }
        centerX = 0;
        centerY = 0;
    } 
    
    public void rotateRight() {
        int rX;
        for(int i = 1; i < blockList.size(); i++){
            blockList.get(i).setY(blockList.get(i).getY() - (blockList.get(i).getX() - centerX) + 30);
            blockList.get(i).setX(blockList.get(i).getX() - (blockList.get(i).getX() - centerX) - 30);
        }
    }
    
    public void move() {
       for(int i = 0; i < blockList.size(); i++){
           blockList.get(i).move();
       }
       if(blockList.get(0).getDX() == 30){
           centerX += 30;
       } else if(blockList.get(0).getDX() == -30){
           centerX += -30;
       }
    }
    
    public void drop() {
       for(int i = 0; i < blockList.size(); i++){
           blockList.get(i).drop();
       }
       centerY += 5;
    }
    
    public Tetromino(int shape){
        switch(shape){
            // "I" piece
            case 1: layout = new boolean[][] { 
                                              {true, true, true, true},
                                              {false, false, false, false},
                                              };
                    color = 1;
                    break;
            // "J" piece
            case 2: layout = new boolean[][] { 
                                              {false, true, false, false},
                                              {false, true, true, true},
                                              };
                    color = 2;
                    break;
            // "L" piece
            case 3: layout = new boolean[][] { 
                                              {false, false, false, true},
                                              {false, true, true, true},
                                              };
                    color = 3;
                    break;
            // "O" piece
            case 4: layout = new boolean[][] { 
                                              {false, true, true, false},
                                              {false, true, true, false},
                                              };
                    color = 4;
                    break;
            // "S" piece
            case 5: layout = new boolean[][] { 
                                              {false, true, true, false},
                                              {true, true, false, false},
                                              };
                    color = 5;
                    break;
            // "T" piece
            case 6: layout = new boolean[][] { 
                                              {false, false, true, false},
                                              {false, true, true, true},
                                              };
                    color = 6;
                    break;
            // "Z" piece
            case 7: layout = new boolean[][] { 
                                              {true, true, false, false},
                                              {false, true, true, false},
                                              };
                    color = 7;
                    break;
        }
        initTetromino();
    }
    
    public void keyPressed(KeyEvent e) {

        int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT) {
            for(int i = 0; i < blockList.size(); i++){
                blockList.get(i).setDX(-30);
            }
        }

        if (key == KeyEvent.VK_RIGHT) {
            for(int i = 0; i < blockList.size(); i++){
                blockList.get(i).setDX(30);
            }
        }

        if (key == KeyEvent.VK_UP) {
            rotateRight();
        }

        if (key == KeyEvent.VK_DOWN) {
            rotateRight();
        }
    }

    public void keyReleased(KeyEvent e) {
        
        int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT) {
            for(int i = 0; i < blockList.size(); i++){
                blockList.get(i).setDX(0);
            }
        }

        if (key == KeyEvent.VK_RIGHT) {
            for(int i = 0; i < blockList.size(); i++){
                blockList.get(i).setDX(0);
            }
        }

        if (key == KeyEvent.VK_UP) {
  
        }

        if (key == KeyEvent.VK_DOWN) {

        }
    }
    
}
