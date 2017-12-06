/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GameplayLogicSubsystem;

import UISubsystem.UserInterface;

/**
 *
 * @author Jon
 */
public class GameLogic {
    GameBoard theGameBoard;
    MiniMax miniMax;
    MiniMaxDeathMatch miniDeath;
    UserInterface UI;
    Boolean isDeathMatch;
    int moveCount;
    
    /**
     *Pass the UserInterface to the logic subsystem so the Logic system can 
     *update the user interface;
     * @param U the UserInterface to be associated with the GameLogic system.
     */
    public GameLogic(UserInterface U){
        UI = U;
        theGameBoard = new GameBoard(this);
        moveCount =0;
        isDeathMatch = false;
        miniDeath = new   MiniMaxDeathMatch();
        miniMax = new MiniMax();
        
    }
    
    public void aiMove(){
        System.out.println("GAMELOGIC:aiMove");
        if(isDeathMatch && moveCount == 0){
         theGameBoard.move(4);
        }
        else{
        miniMax.run(theGameBoard.getTurn(), theGameBoard, 6);
        }
    moveCount++;
    }
    public void aiDeathMove(){
        System.out.println("GAMELOGIC:aiDeathMove");
        miniDeath.run(theGameBoard.getTurn(), theGameBoard, 2);
       // System.out.println(theGameBoard.toString());
        moveCount++;
    }
    
    public boolean checkWin(){
        if(theGameBoard.isGameOver()){
            UI.setMessage("GAME OVER");
            UI.disableField(true);
            return true;
        }
        else return false;
    }
    
    public GameBoard.State getCurrentPlayer(){
        return theGameBoard.getTurn();
    }
    
    public void userMove(int index){
        updateUI(index);
        theGameBoard.move(index);
        System.out.println("GAMELOGIC:USER MOVE: " + index);
        System.out.print(theGameBoard.toString());
        this.checkWin();
        moveCount++;

        
    }
    
    public void updateUI(int Index){
        UI.updateBoard(Index, this.theGameBoard.getTurn());
    
    }
    
    public int getMoveCount(){return moveCount;}
    
    public void shift(int current, int empty){
        UI.swapButtons(current, empty);
        
    }
    public void humanShift(int current, int empty){
        this.theGameBoard.shift(empty, current);
        //UI.swapButtons(current, empty);
    }
    
    public void gameOver(String player){
        
        UI.gameOver("Winner is " + player);
    }
    
    public void gameTie(){
        UI.gameOver("Game is a tie!");
    
    }
    public void SetDeathMatch(boolean val){
        theGameBoard.setDeathMatch(val);
        isDeathMatch = val;
    
    }
    public int getBlank(){
        return theGameBoard.getBlank();
    }
    
}
