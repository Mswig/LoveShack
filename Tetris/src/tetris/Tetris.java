
package tetris;

import java.awt.*;
import javax.swing.*;

/**
 * Tetris Game by the Love Shack.
 * @author Mswig
 * @since 12/20/2017
 */
public class Tetris extends JFrame {

    public Tetris(){
        initializeTetris();
    }
    
    private void initializeTetris(){      
        add(new Board());
        
        setSize(400, 300);
        setResizable(false);
        
        setTitle("Love Shack Tetris");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    public static void main(String[] args) {
        Tetris tetris = new Tetris();
        tetris.setVisible(true);
    }
}
