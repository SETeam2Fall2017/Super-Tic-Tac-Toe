/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Jon
 */
import java.lang.String;

public class MiniMax {
    
    /*Declare Scores:
        These scores will be used to evaluation options of the MiniMax Algorithm;
    */
    private final int threeInARow = 100;
    private final int twoInARow = 10;
    private final int oneInARow = 1;
    private final int threeInARowOP = -100;
    private final int twoInARowOP = -10;
    private final int oneInARowOP = -1;
    
    //Debug Game String
    public String gameState = "Newly Initialized!";
    
    public int evaluateBoard(GameBoard G){
        //Horizontal Loss
        if(G.getBoardAt(0) == -1 && G.getBoardAt(1) == -1 && G.getBoardAt(2) == -1){return threeInARowOP;}
        if(G.getBoardAt(3) == -1 && G.getBoardAt(4) == -1 && G.getBoardAt(5) == -1){return threeInARowOP;}
        if(G.getBoardAt(6) == -1 && G.getBoardAt(7) == -1 && G.getBoardAt(8) == -1){return threeInARowOP;}
        //Horizontal Win
        if(G.getBoardAt(0) == 1 && G.getBoardAt(1) == 1 && G.getBoardAt(2) == 1){return threeInARow;}
        if(G.getBoardAt(3) == 1 && G.getBoardAt(4) == 1 && G.getBoardAt(5) == 1){return threeInARow;}
        if(G.getBoardAt(6) == 1 && G.getBoardAt(7) == 1 && G.getBoardAt(8) == 1){return threeInARow;}
        //Vertical Loss
        if(G.getBoardAt(0) == -1 && G.getBoardAt(3) == -1 && G.getBoardAt(6) == -1){return threeInARowOP;}
        if(G.getBoardAt(1) == -1 && G.getBoardAt(4) == -1 && G.getBoardAt(7) == -1){return threeInARowOP;}
        if(G.getBoardAt(2) == -1 && G.getBoardAt(5) == -1 && G.getBoardAt(8) == -1){return threeInARowOP;}
        //Vertical Win
        if(G.getBoardAt(0) == 1 && G.getBoardAt(3) == 1 && G.getBoardAt(6) == 1){return threeInARow;}
        if(G.getBoardAt(1) == 1 && G.getBoardAt(4) == 1 && G.getBoardAt(7) == 1){return threeInARow;}
        if(G.getBoardAt(2) == 1 && G.getBoardAt(5) == 1 && G.getBoardAt(8) == 1){return threeInARow;}
        //Oblique Loss
        if(G.getBoardAt(0) == -1 && G.getBoardAt(4) == -1 && G.getBoardAt(8) == -1){return threeInARowOP;}
        if(G.getBoardAt(2) == -1 && G.getBoardAt(4) == -1 && G.getBoardAt(6) == -1){return threeInARowOP;}
        //Oblique Win
        if(G.getBoardAt(0) == 1 && G.getBoardAt(4) == 1 && G.getBoardAt(8) == 1){return threeInARow;}
        if(G.getBoardAt(2) == 1 && G.getBoardAt(4) == 1 && G.getBoardAt(6) == 1){return threeInARow;}
        //Parital Cases
        
        else return 0;
    }
    
    
    
    
    
}
