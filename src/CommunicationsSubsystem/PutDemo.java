package CommunicationsSubsystem;

import static CommunicationsSubsystem.Methods.GetMethod;
import static CommunicationsSubsystem.Methods.PutMethod;

public class PutDemo {

    
    public static void main(String[] args) {
        char arr[] = new char[9];
        PutMethod(2); //Put X in index 2
        PutMethod(8); //Put O in index 8
        PutMethod(0); //Put X in index 0
        PutMethod(3); //Put O in index 3
        PutMethod(1); //Put X in index 1
        PutMethod(4); //Put O in index 4
        PutMethod(6); //Put X in index 6
        PutMethod(7); //Put O in index 7
        PutMethod(5); //Put X in index 5
        GetMethod(arr); //Get Tic-Tac-Toe board
        for (int i = 0; i < 9; i++) {
        System.out.println(arr[i]); //Print Tic-Tac-Toe Board
        }
    }
    
}
