package GameplayLogicSubsystem;

import java.util.HashSet;

/**
 * Represents the Tic Tac Toe board.
 */
public class GameBoard {

    static final int BOARD_WIDTH = 3;

    public enum State {
        Blank, X, O
    }
    private boolean deathMatch;
    private State[][] board;
    private State playersTurn;
    private State winner;
    private HashSet<Integer> movesAvailable;
    private HashSet<Integer> deathMatchMovesAvailable;
    private int moveCount;
    public int theBlank;
    private boolean gameOver;
    private GameLogic parent = null;

    /**
     * Construct the Tic Tac Toe board.
     */
    GameBoard(GameLogic p) {
        board = new State[BOARD_WIDTH][BOARD_WIDTH];
        movesAvailable = new HashSet<>();
        deathMatchMovesAvailable = new HashSet<>();
        parent = p;
        deathMatch = false;
        theBlank = -1;
        reset();
    }

    public GameBoard() {
        board = new State[BOARD_WIDTH][BOARD_WIDTH];
        movesAvailable = new HashSet<>();
        deathMatchMovesAvailable = new HashSet<>();
        deathMatch = false;
        theBlank = -1;
        reset();
    }

    /*   GameBoard() {
        board = new State[BOARD_WIDTH][BOARD_WIDTH];
        movesAvailable = new HashSet<>();
        reset();
     /* }

    /**
     * Set the cells to be blank and load the available moves (all the moves are
     * available at the start of the game).
     */
    private void initialize() {
        for (int row = 0; row < BOARD_WIDTH; row++) {
            for (int col = 0; col < BOARD_WIDTH; col++) {
                board[row][col] = State.Blank;
            }
        }

        movesAvailable.clear();

        for (int i = 0; i < BOARD_WIDTH * BOARD_WIDTH; i++) {
            movesAvailable.add(i);
        }
    }

    public void setDeathMatch(boolean val) {
        deathMatch = val;
    }

    /**
     * Restart the game with a new blank board.
     */
    void reset() {
        moveCount = 0;
        gameOver = false;
        playersTurn = State.X;
        winner = State.Blank;
        initialize();
    }

    /**
     * Places an X or an O on the specified index depending on whose turn it is.
     *
     * @param index the position on the board (example: index 4 is location (0,
     * 1))
     * @return true if the move has not already been played
     */
    public boolean move(int index) {
        if (parent != null) {
            parent.updateUI(index);
        }
        return move(index % BOARD_WIDTH, index / BOARD_WIDTH);

    }

    /**
     * Places an X or an O on the specified location depending on who turn it
     * is.
     *
     * @param x the x coordinate of the location
     * @param y the y coordinate of the location
     * @return true if the move has not already been played
     */
    private boolean move(int x, int y) {

        if (gameOver) {
            throw new IllegalStateException("TicTacToe is over. No moves can be played.");
        }

        if (board[y][x] == State.Blank) {
            board[y][x] = playersTurn;
        } else {
            throw new IllegalStateException("Cannot move on non blank tile.");
            // return false;
        }

        moveCount++;
        movesAvailable.remove(y * BOARD_WIDTH + x);

        // The game is a draw.
        if (moveCount == BOARD_WIDTH * BOARD_WIDTH) {
            winner = State.Blank;
            gameOver = true;
            if (parent != null) {
                parent.gameTie();
            }
        }

        // Check for a winner.
        checkRow(y);
        checkColumn(x);
        checkDiagonalFromTopLeft(x, y);
        checkDiagonalFromTopRight(x, y);

        playersTurn = (playersTurn == State.X) ? State.O : State.X;
        return true;
    }

    /**
     * Check to see if the game is over (if there is a winner or a draw).
     *
     * @return true if the game is over
     */
    public boolean isGameOver() {
        return gameOver;
    }

    /**
     * Get a copy of the array that represents the board.
     *
     * @return the board array
     */
    State[][] toArray() {
        return board.clone();
    }

    /**
     * Check to see who's turn it is.
     *
     * @return the player who's turn it is
     */
    public State getTurn() {
        return playersTurn;
    }

    /**
     * Check to see who won.
     *
     * @return the player who won (or Blank if the game is a draw)
     */
    public State getWinner() {
        if (!gameOver) {
            throw new IllegalStateException("TicTacToe is not over yet.");
        }
        return winner;
    }

    /**
     * Get the indexes of all the positions on the board that are empty.
     *
     * @return the empty cells
     */
    public HashSet<Integer> getAvailableMoves() {
        return movesAvailable;
    }

    /**
     * Checks the specified row to see if there is a winner.
     *
     * @param row the row to check
     */
    private void checkRow(int row) {
        for (int i = 1; i < BOARD_WIDTH; i++) {
            if (board[row][i] != board[row][i - 1]) {
                break;
            }
            if (i == BOARD_WIDTH - 1) {
                winner = playersTurn;
                gameOver = true;
                if (parent != null) {
                    parent.gameOver(winner.toString());
                }
            }
        }
    }

    /**
     * Checks the specified column to see if there is a winner.
     *
     * @param column the column to check
     */
    private void checkColumn(int column) {
        for (int i = 1; i < BOARD_WIDTH; i++) {
            if (board[i][column] != board[i - 1][column]) {
                break;
            }
            if (i == BOARD_WIDTH - 1) {
                winner = playersTurn;
                gameOver = true;
                if (parent != null) {
                    parent.gameOver(winner.toString());
                }
            }
        }
    }

    /**
     * Check the left diagonal to see if there is a winner.
     *
     * @param x the x coordinate of the most recently played move
     * @param y the y coordinate of the most recently played move
     */
    private void checkDiagonalFromTopLeft(int x, int y) {
        if (x == y) {
            for (int i = 1; i < BOARD_WIDTH; i++) {
                if (board[i][i] != board[i - 1][i - 1]) {
                    break;
                }
                if (i == BOARD_WIDTH - 1) {
                    winner = playersTurn;
                    gameOver = true;
                    if (parent != null) {
                        parent.gameOver(winner.toString());
                    }
                }
            }
        }
    }

    /**
     * Check the right diagonal to see if there is a winner.
     *
     * @param x the x coordinate of the most recently played move
     * @param y the y coordinate of the most recently played move
     */
    private void checkDiagonalFromTopRight(int x, int y) {
        if (BOARD_WIDTH - 1 - x == y) {
            for (int i = 1; i < BOARD_WIDTH; i++) {
                if (board[BOARD_WIDTH - 1 - i][i] != board[BOARD_WIDTH - i][i - 1]) {
                    break;
                }
                if (i == BOARD_WIDTH - 1) {
                    winner = playersTurn;
                    gameOver = true;
                    if (parent != null) {
                        parent.gameOver(winner.toString());
                    }
                }
            }
        }
    }

    /**
     * Get a deep copy of the Tic Tac Toe board.
     *
     * @return an identical copy of the board
     */
    public GameBoard getDeepCopy() {
        GameBoard newBoard = new GameBoard();

        for (int i = 0; i < newBoard.board.length; i++) {
            newBoard.board[i] = this.board[i].clone();
        }

        newBoard.playersTurn = this.playersTurn;
        newBoard.winner = this.winner;
        newBoard.movesAvailable = new HashSet<>();
        newBoard.movesAvailable.addAll(this.movesAvailable);
        newBoard.moveCount = this.moveCount;
        newBoard.gameOver = this.gameOver;
        newBoard.theBlank = this.theBlank;
        newBoard.deathMatch = this.deathMatch;
        return newBoard;
    }

    @Override
    /**
     * Returns a string object that represents the gameboard.
     */
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (int y = 0; y < BOARD_WIDTH; y++) {
            for (int x = 0; x < BOARD_WIDTH; x++) {

                if (board[y][x] == State.Blank) {
                    sb.append("-");
                } else {
                    sb.append(board[y][x].name());
                }
                sb.append(" ");

            }
            if (y != BOARD_WIDTH - 1) {
                sb.append("\n");
            }
        }

        return new String(sb);
    }

    public void shift(int blank, int pos) {

        if (parent != null) {
            System.out.println("Before Shift: ");
            System.out.println(this.toString());
        }
        State Holder = State.Blank;
        board[blank / BOARD_WIDTH][blank % BOARD_WIDTH] = board[pos / BOARD_WIDTH][pos % BOARD_WIDTH];
        board[pos / BOARD_WIDTH][pos % BOARD_WIDTH] = Holder;
        theBlank = pos;
        if (parent != null) {
            parent.shift(pos, blank);
            System.out.println("After Shift: ");
            System.out.println(this.toString());
        }

        moveCount++;

        // Check for a winner.
        checkRow(blank / BOARD_WIDTH);
        checkColumn(blank % BOARD_WIDTH);
        checkDiagonalFromTopLeft(blank % BOARD_WIDTH, blank / BOARD_WIDTH);
        checkDiagonalFromTopRight(blank % BOARD_WIDTH, blank / BOARD_WIDTH);

        playersTurn = (playersTurn == State.X) ? State.O : State.X;

    }

    public State playerAt(int i) {
        State p = State.Blank;

        switch (i) {
            case 0:
                p = this.board[0][0];
                break;
            case 1:
                p = this.board[0][1];
                break;
            case 2:
                p = this.board[0][2];
                break;
            case 3:
                p = this.board[1][0];
                break;
            case 4:
                p = this.board[1][1];
                break;
            case 5:
                p = this.board[1][2];
                break;
            case 6:
                p = this.board[2][0];
                break;
            case 7:
                p = this.board[2][1];
                break;
            case 8:
                p = this.board[2][2];
                break;
            default:
                throw new IllegalStateException("Problem in Player At!");
        }

        return p;

    }

    public int getBlank() {
        int temp = -1;
        for (int y = 0; y < BOARD_WIDTH; y++) {
            for (int x = 0; x < BOARD_WIDTH; x++) {
                if (board[y][x] == State.Blank) {
                    if (temp != -1) {
                        throw new IllegalStateException("Problem in getBlank!");
                    }
                    temp = y * BOARD_WIDTH + x;
                }
            }
        }

        return temp;
    }

    public HashSet<Integer> deathMatchMoves() {
        HashSet<Integer> adjacent = new HashSet<>();
        adjacent.clear();
        int blank = this.getBlank();
        theBlank = this.getBlank();
        if (!deathMatch) {
            throw new IllegalStateException("Problem in Deathmatch Moves!");
        }

        switch (blank) {
            case 0:
                if (this.getTurn() == this.playerAt(1)) {
                    adjacent.add(1);
                }
                if (this.getTurn() == this.playerAt(3)) {
                    adjacent.add(3);
                }
                if (this.getTurn() == this.playerAt(4)) {
                    adjacent.add(4);
                }
                break;
            case 1:
                if (this.getTurn() == this.playerAt(0)) {
                    adjacent.add(0);
                }
                if (this.getTurn() == this.playerAt(2)) {
                    adjacent.add(2);
                }
                if (this.getTurn() == this.playerAt(4)) {
                    adjacent.add(4);
                }
                break;
            case 2:
                if (this.getTurn() == this.playerAt(1)) {
                    adjacent.add(1);
                }
                if (this.getTurn() == this.playerAt(4)) {
                    adjacent.add(4);
                }
                if (this.getTurn() == this.playerAt(5)) {
                    adjacent.add(5);
                }
                break;
            case 3:
                if (this.getTurn() == this.playerAt(0)) {
                    adjacent.add(0);
                }
                if (this.getTurn() == this.playerAt(4)) {
                    adjacent.add(4);
                }
                if (this.getTurn() == this.playerAt(6)) {
                    adjacent.add(6);
                }
                break;
            case 4:if (this.getTurn() == this.playerAt(0)) {
                adjacent.add(0);}
            if (this.getTurn() == this.playerAt(1)) {
                adjacent.add(1);}
            if (this.getTurn() == this.playerAt(2)) {
                adjacent.add(2);}
            if (this.getTurn() == this.playerAt(3)) {
                adjacent.add(3);}
            if (this.getTurn() == this.playerAt(5)) {
                adjacent.add(5);}
            if (this.getTurn() == this.playerAt(6)) {
                adjacent.add(6);}
            if (this.getTurn() == this.playerAt(7)) {
                adjacent.add(7);}
            if (this.getTurn() == this.playerAt(8)) {
                adjacent.add(8);}
                break;
            case 5:
                if (this.getTurn() == this.playerAt(2)) {
                adjacent.add(2);}
                if (this.getTurn() == this.playerAt(4)) {
                adjacent.add(4);}
                if (this.getTurn() == this.playerAt(8)) {
                adjacent.add(8);}
                break;
            case 6:
                if (this.getTurn() == this.playerAt(3)) {
                adjacent.add(3);}
                if (this.getTurn() == this.playerAt(4)) {
                adjacent.add(4);}
                if (this.getTurn() == this.playerAt(7)) {
                adjacent.add(7);}
                break;
            case 7:
                if (this.getTurn() == this.playerAt(6)) {
                adjacent.add(6);}
                if (this.getTurn() == this.playerAt(4)) {
                adjacent.add(4);}
                if (this.getTurn() == this.playerAt(8)) {
                adjacent.add(8);}
                break;
            case 8:
                if (this.getTurn() == this.playerAt(4)) {
                adjacent.add(4);}
                if (this.getTurn() == this.playerAt(5)) {
                adjacent.add(5);}
                if (this.getTurn() == this.playerAt(7)) {
                adjacent.add(7);}
                break;
            default:
                throw new IllegalStateException("Problem in Deathmatch Moves!");

        }

        return adjacent;

    }

}
