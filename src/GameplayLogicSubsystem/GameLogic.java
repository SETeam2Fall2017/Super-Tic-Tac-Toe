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
    
    /**
     *Pass the UserInterface to the logic subsystem so the Logic system can 
     *update the user interface;
     * @param U the UserInterface to be associated with the GameLogic system.
     */
    public GameLogic(UserInterface U){
        UI = U;
    }
    
    public void aiMove(){
        miniMax.run(theGame.getTurn(), theGame, 6);
    
    }
    
    public void userMove(int index){
        theGame.move(index);
        aiMove();
        System.out.println("GAMELOGIC:USER MOVE: " + index);
    }
    
    public void updateUI(int Index){
        UI.updateBoard(Index, theGame.getTurn());
    
    }
    
}
