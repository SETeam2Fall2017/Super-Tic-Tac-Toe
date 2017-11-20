package GameplayLogicSubsystem;

import java.util.HashSet;

/**
 * This class represents a 3*3 tic-tac-toe game board. It includes functions for
 * minimax algorithm use.
 *
 * @author elchapo
 */
public class GameBoard {

    public enum State {
        Blank, X, O
    }
    public static int BOARD_SIZE = 3;
    public boolean deathMatch = false;
    private State[] board = new State[9];
    private State playersTurn;
    private State winner;
    private HashSet<Integer> movesAvailable;
    private int moveCount;
    private boolean gameOver;

    GameBoard() {

    }

    /**
     * Function returns a new instance of the current GameBoard
     *
     * @return Get a copy of the gameBoard
     */
    public GameBoard getDeepCopy() {
        GameBoard newBoard = new GameBoard();

        for (int i = 0; i < newBoard.board.length; i++) {
            newBoard.board[i] = this.board[i];
        }

        newBoard.playersTurn = this.playersTurn;
        newBoard.winner = this.winner;
        newBoard.movesAvailable = new HashSet<>();
        newBoard.movesAvailable.addAll(this.movesAvailable);
        newBoard.moveCount = this.moveCount;
        newBoard.gameOver = this.gameOver;
        return newBoard;

    }
    /**
     * Prints a copy of the game board to standard output
     * @return 
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (int y = 0; y < board.length; y++) {

            if (board[y] == State.Blank) {
                sb.append("-");
            } else {
                sb.append(board[y].name());
            }
            sb.append(" ");

            if (y == 2 || y == 5 || y == 8) {
                sb.append("\n");
            }
        }

        return new String(sb);
    }

}
