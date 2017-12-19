package tetris;

/**
 * Class for creating tetris blocks: tetriminos.  
 * @author Mswig
 * @since 12/18/2017
 * @see Tetris.java
 */
public class Tetromino {
    
    /*
    array that stores the shape of the block, used for creating new shapes
    */
    public boolean[][] layout;
    
    /*
    integer value that stores the color of the block
    */
    public int color;
    
    public void tetromino(){
        layout = new boolean[5][5];
        color = 1;
    }
    
    public void tetromino(int shape){
        switch(shape){
            case 1:  layout = {
        }
    }
    
}
