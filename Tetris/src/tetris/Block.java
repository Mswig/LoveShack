
package tetris;
import java.awt.*;
import java.awt.event.KeyEvent;
import javax.swing.*;
/**
 *
 * @author mvstu
 */
public class Block {
    private int dx;
    private int dy;
    private int x;
    private int y;
    private int r;
    private Image image;
    
    public Block() {
        initBlock();
    }
    
    public Block(int x, int y, int c) {
        initBlock(x,y,c);
    }
    
    private void initBlock() {
        ImageIcon ii = new ImageIcon("redBlock.jpg");
        image = ii.getImage();
        x = 0;
        y = 0;        
    }
    
    private void initBlock(int x, int y, int c) {
        ImageIcon ii;
        switch(c){
            // "I" piece
            case 1: ii = new ImageIcon("cyanBlock.jpg");
                    image = ii.getImage();
                    break;
            // "J" piece
            case 2: ii = new ImageIcon("blueBlock.jpg");
                    image = ii.getImage();
                    break;
            // "L" piece
            case 3: ii = new ImageIcon("orangeBlock.jpg");
                    image = ii.getImage();
                    break;
            // "O" piece
            case 4: ii = new ImageIcon("yellowBlock.jpg");
                    image = ii.getImage();
                    break;
            // "S" piece
            case 5: ii = new ImageIcon("greenBlock.jpg");
                    image = ii.getImage();
                    break;
            // "T" piece
            case 6: ii = new ImageIcon("purpleBlock.jpg");
                    image = ii.getImage();
                    break;
            // "Z" piece
            case 7: ii = new ImageIcon("redBlock.jpg");
                    image = ii.getImage();
                    break;
        }
        this.x = x;
        this.y = y;        
    }

    public void move() {
        x += dx;
        y += dy;
    }
    
    public int getX() {
        return x;
    }
    
    public int getDX() {
        return dx;
    }
    
    public void drop() {
        y += 5;
    }
    
    public int getY() {
        return y;
    }
    
    public void setDX(int i){
        dx = i;
    }
    
    public void setX(int i){
        x = i;
    }
    
    public void setY(int i){
        y = i;
    }
    
    public Image getImage() {
        return image;
    }
    
}


