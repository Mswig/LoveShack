
package tetris;

import java.awt.Color;
import javax.swing.*;

/**
 * Tetris Game by the Love Shack.
 * @author Mswig
 * @since 12/20/2017
 */
public class Tetris {
    //creates the game
    private static void initializeTetris(){
        JFrame base = new JFrame("Love Shack Tetris");
        base.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        base.setSize(500, 500); //JFrame base size
        base.setVisible(true);
    }
    public void displayPiece(Tetromino p){
        for(int i = 0; i < 2; i++){
            for(int j = 0; j < 4; j++){
                if(p.layout[j][i]){
                    
                }
            }
        }
    }
    public static void main(String[] args) {
        initializeTetris();
    }
}
