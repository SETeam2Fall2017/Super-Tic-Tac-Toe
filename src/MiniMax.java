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
    
        private static double maxPly;

    /**
     * MiniMax cannot be instantiated.
     */
    MiniMax() {}

    /**
     * Execute the algorithm.
     * @param player        the player that the AI will identify as
     * @param board         the Tic Tac Toe board to play on
     * @param maxPly        the maximum depth
     */
    public static void run (Board.State player, Board board, double maxPly) {
        if (maxPly < 1) {
            throw new IllegalArgumentException("Maximum depth must be greater than 0.");
        }

        MiniMax.maxPly = maxPly;
        miniMax(player, board, 0);
    }

    /**
     * The meat of the algorithm.
     * @param player        the player that the AI will identify as
     * @param board         the Tic Tac Toe board to play on
     * @param currentPly    the current depth
     * @return              the score of the board
     */
    private static int miniMax (Board.State player, Board board, int currentPly) {
        if (currentPly++ == maxPly || board.isGameOver()) {
            return score(player, board);
        }

        if (board.getTurn() == player) {
            return getMax(player, board, currentPly);
        } else {
            return getMin(player, board, currentPly);
        }

    }

    /**
     * Play the move with the highest score.
     * @param player        the player that the AI will identify as
     * @param board         the Tic Tac Toe board to play on
     * @param currentPly    the current depth
     * @return              the score of the board
     */
    private static int getMax (Board.State player, Board board, int currentPly) {
        double bestScore = Double.NEGATIVE_INFINITY;
        int indexOfBestMove = -1;

        for (Integer theMove : board.getAvailableMoves()) {

            Board modifiedBoard = board.getDeepCopy();
            modifiedBoard.move(theMove);

            int score = miniMax(player, modifiedBoard, currentPly);

            if (score >= bestScore) {
                bestScore = score;
                indexOfBestMove = theMove;
            }

        }

        board.move(indexOfBestMove);
        return (int)bestScore;
    }

    /**
     * Play the move with the lowest score.
     * @param player        the player that the AI will identify as
     * @param board         the Tic Tac Toe board to play on
     * @param currentPly    the current depth
     * @return              the score of the board
     */
    private static int getMin (Board.State player, Board board, int currentPly) {
        double bestScore = Double.POSITIVE_INFINITY;
        int indexOfBestMove = -1;

        for (Integer theMove : board.getAvailableMoves()) {

            Board modifiedBoard = board.getDeepCopy();
            modifiedBoard.move(theMove);

            int score = miniMax(player, modifiedBoard, currentPly);

            if (score <= bestScore) {
                bestScore = score;
                indexOfBestMove = theMove;
            }

        }

        board.move(indexOfBestMove);
        return (int)bestScore;
    }

    /**
     * Get the score of the board.
     * @param player        the play that the AI will identify as
     * @param board         the Tic Tac Toe board to play on
     * @return              the score of the board
     */
    private static int score (Board.State player, Board board) {
        if (player == Board.State.Blank) {
            throw new IllegalArgumentException("Player must be X or O.");
        }

        Board.State opponent = (player == Board.State.X) ? Board.State.O : Board.State.X;

        if (board.isGameOver() && board.getWinner() == player) {
            return 10;
        } else if (board.isGameOver() && board.getWinner() == opponent) {
            return -10;
        } else {
            return 0;
        }
    }
    
    
    
}
