/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Jon
 */
public class DeathMatch extends Board {

    private Board theGame;

    DeathMatch(Board B) {
        if (!B.deathMatch) {
            throw new RuntimeException("Death match not true!");
        } else {
            this.theGame = B.getDeepCopy();
        }
        

}

}
