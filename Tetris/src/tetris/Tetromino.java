package tetris;
import java.awt.Color;
import java.awt.Image;
import javax.swing.*;

/**
 * Class for creating tetris blocks: tetriminos.  
 * @author Mswig
 * @since 12/18/2017
 * @see Tetris.java
 */
public class Tetromino{
    
    private int x, y, dx, dy;
    private Image image;
    
    /*
    array that stores the shape of the block, used for creating new shapes
    */
    public boolean[][] layout;
    
    /*
    integer value that stores the color of the block
    */
    public Color color;
    
    public void tetromino(){
        layout = new boolean[4][2];
        color = new Color(0, 0, 0);
    }
    
    private void initTetromino(){
        ImageIcon ii = new ImageIcon("redBlock.jpeg");
        image = ii.getImage();
        
        for(int i = 0; i < 2; i++){
            for(int j = 0; j < 4; j++){
                if(layout[j][i]){
                    x = j * 30;
                    y = i * 30;
                }
            }
        }   
    }
    
    public void move() {
        x += dx;
        y += dy;
    }
    
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Image getImage() {
        return image;
    }
    
    public void tetromino(int shape){
        switch(shape){
            // "I" piece
            case 1: layout = new boolean[][] { 
                                              {false, false, false, false},
                                              {true, true, true, true},
                                              };
                    color = Color.CYAN;
            // "J" piece
            case 2: layout = new boolean[][] { 
                                              {false, true, false, false},
                                              {false, true, true, true},
                                              };
                    color = Color.BLUE;
            // "L" piece
            case 3: layout = new boolean[][] { 
                                              {false, false, false, true},
                                              {false, true, true, true},
                                              };
                    color = Color.ORANGE;
            // "O" piece
            case 4: layout = new boolean[][] { 
                                              {false, true, true, false},
                                              {false, true, true, false},
                                              };
                    color = Color.YELLOW;
            // "S" piece
            case 5: layout = new boolean[][] { 
                                              {false, true, true, false},
                                              {true, true, false, false},
                                              };
                    color = Color.GREEN;
            // "T" piece
            case 6: layout = new boolean[][] { 
                                              {false, false, true, false},
                                              {false, true, true, true},
                                              };
                    color = Color.MAGENTA;
            // "Z" piece
            case 7: layout = new boolean[][] { 
                                              {true, true, false, false},
                                              {false, true, true, false},
                                              };
                    color = Color.RED;       
            default: tetromino();
            
            initTetromino();
        }
    }
    
}
