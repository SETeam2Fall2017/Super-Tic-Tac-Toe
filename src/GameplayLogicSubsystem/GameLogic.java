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
    GameBoard theGame;
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
        theGame = new GameBoard(this);
        moveCount =0;
        
    }
    
    public void aiMove(){
        System.out.println("GAMELOGIC:aiMove");
        if(moveCount == 0){
            theGame.move(4);
        }
        else{
        MiniMax.run(theGame.getTurn(), theGame, 6);
        }
    moveCount++;
    }
    public void aiDeathMove(){
        System.out.println("GAMELOGIC:aiDeathMove");
        MiniMaxDeathMatch.run(theGame.getTurn(), theGame, 6);
        moveCount++;
    }
    
    public GameBoard.State getCurrentPlayer(){
        return theGame.getTurn();
    }
    
    public void userMove(int index){
        updateUI(index);
        theGame.move(index);
        System.out.println("GAMELOGIC:USER MOVE: " + index);
        System.out.print(theGame.toString());
        moveCount++;

        
    }
    
    public void updateUI(int Index){
        UI.updateBoard(Index, this.theGame.getTurn());
    
    }
    
    public int getMoveCount(){return moveCount;}
    
    public void shift(int current, int empty){
        UI.swapButtons(current, empty);
    }
    
    public void gameOver(String player){
        
        UI.gameOver("Winner is " + player);
    }
    
    public void gameTie(){
        UI.gameOver("Game is a tie!");
    
    }
    public void SetDeathMatch(){
        theGame.setDeathMatch(true);
    
    }
    public int getBlank(){
        return theGame.getBlank();
    }
    
}
