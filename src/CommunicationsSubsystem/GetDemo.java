package CommunicationsSubsystem;

import static CommunicationsSubsystem.Methods.GetMethod;

public class GetDemo {

    public static void main(String[] args) {
        char arr[] = new char[9];
        GetMethod(arr); //Get Tic-Tac-Toe Board
        for (int i = 0; i < 9; i++) {
        System.out.println(arr[i]); //Print Tic-Tac-Toe Board
        }
    }
    
}
