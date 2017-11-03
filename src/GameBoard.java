/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Jon
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class GameBoard {

    private int[] board = new int[9];
    public boolean aiWin = false;
    public boolean opponentWin = false;
    public int AI = 1;
    public int opponent = -1;

    public int getBoardAt(int x) {
        return board[x];
    }

    public void setBoardAt(int index, int value) {
        if(value == AI || value == opponent){
        board[index] = value;}
        else throw new RuntimeException("GAMEBOARD CAN ONLY BE SET TO -1 OR 1");

    }

    public List<Integer> getBlanks() {
        List<Integer> blanks = new ArrayList<Integer>();
        for (int i = 0; i < 9; i++) {
            if(board[i] == 0){
                blanks.add(i);
            }
        }
        return blanks;
    }
    
    public void printBoard()
    {
        StringBuilder message = new StringBuilder();
        for(int i=0;i<board.length;i++)
        {   if(board[i] == 0) message.append(" ");
            if(board[i] == AI) message.append("X");
            else if(board[i] == opponent) message.append("O");
            if(i==2 || i==5 || i==8) message.append(" ");
            else message.append(" | ");
            if(i == 2 || i==5 || i == 8){
                System.out.println(message.toString());
                if(i!=8)System.out.println("- - - - -");
                message.setLength(0);
            }

                
        }
    
    }

    //Default Constructor
    public GameBoard() {
        for (int i = 0; i < 9; i++) {
            board[i] = 0;
        }

    }

    //Use this constructor if you need a copy of a current Gameboard.
    public GameBoard(int[] boardToCopy) {
        if (boardToCopy.length != 9) {
            System.out.println("YOU PASSED AN ARRAY THAT IS THE WRONG SIZE");

        } else {
            for (int i = 0; i < 9; i++) {
                board[i] = boardToCopy[i];
            }

        }

    }

}
