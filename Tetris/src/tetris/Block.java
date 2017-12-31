
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
    private Image image;
    
    public Block() {
        initBlock();
    }
    
    public Block(int x, int y) {
        initBlock(x,y);
    }
    
    private void initBlock() {
        ImageIcon ii = new ImageIcon("redBlock.jpg");
        image = ii.getImage();
        x = 0;
        y = 0;        
    }
    
    private void initBlock(int x, int y) {
        ImageIcon ii = new ImageIcon("redBlock.jpg");
        image = ii.getImage();
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
    
    public void drop() {
        y += 30;
    }
    
    public int getY() {
        return y;
    }
    
    public Image getImage() {
        return image;
    }
    
    public void keyPressed(KeyEvent e) {

        int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT) {
            dx = -30;
        }

        if (key == KeyEvent.VK_RIGHT) {
            dx = 30;
        }

        if (key == KeyEvent.VK_UP) {
            dy = -1;
        }

        if (key == KeyEvent.VK_DOWN) {
            dy = 1;
        }
    }

    public void keyReleased(KeyEvent e) {
        
        int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT) {
            dx = 0;
        }

        if (key == KeyEvent.VK_RIGHT) {
            dx = 0;
        }

        if (key == KeyEvent.VK_UP) {
            dy = 0;
        }

        if (key == KeyEvent.VK_DOWN) {
            dy = 0;
        }
    }
}


