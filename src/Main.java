
import java.util.List;
import javax.swing.JFrame;

public class Main {
public static void newGame(){
       String windowTitle = "SuperTicTacToe";
        TicTacToeGUI win = new TicTacToeGUI();
        win.setTitle(windowTitle);
        win.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        win.setVisible(true);
}
    public static void main(String[] args) {
        newGame();
       /*
       GameBoard newGame = new GameBoard();
       MiniMax AI = new MiniMax();
       newGame.setBoardAt(0, -1);
       newGame.setBoardAt(1, -1);
       newGame.setBoardAt(2, -1);
       newGame.setBoardAt(6, 1);
       newGame.printBoard();
       List<Integer> blanks = newGame.getBlanks();
       int score = AI.evaluateBoard(newGame);
       System.out.println("The Score Is: "+score);
       for(Integer i : blanks){
           System.out.println(i);
           
       
       }*/
    }
}
