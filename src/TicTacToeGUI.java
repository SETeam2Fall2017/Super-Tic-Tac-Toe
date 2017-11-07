
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TicTacToeGUI extends JFrame {

    private static final int WIDTH = 500;
    private static final int HEIGHT = 500;
    private int MOVES = 0;
    private boolean Os;
    private boolean gameOver;
    public GameBoard theGame = new GameBoard();
    public Board notMyGame = new Board();
    public boolean debug = true;
    public MiniMax Steven;

    private Container content;
    private JTextField result;
    private JButton[] cells;
    private JButton resetButton;
    //private JButton exitButton;
    private CellButtonHandler[] cellHandlers;
    private JPanel ButtonPanel = new JPanel();
    // private ExitButtonHandler exitHandler;
    // private InitButtonHandler initHandler;

    public TicTacToeGUI() {
        //Necessary initialization code
        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        //Get content pane
        content = getContentPane();

        //Set layout
        ButtonPanel.setLayout(new GridLayout(3, 3));
        content.add("Center", ButtonPanel);

        //Create cells and handlers
        cells = new JButton[9];
        cellHandlers = new CellButtonHandler[10];
        for (int i = 0; i < 9; i++) {
            cells[i] = new JButton();
            cells[i].setFont(new Font("Helvetica", Font.PLAIN, 40));
            cellHandlers[i] = new CellButtonHandler();
            cells[i].addActionListener(cellHandlers[i]);
        }
        // Create Reset Button
        resetButton = new JButton();
        resetButton.setFont(new Font("Helvetica", Font.PLAIN, 15));
        resetButton.setText("Reset");
        cellHandlers[9] = new CellButtonHandler();
        resetButton.addActionListener(cellHandlers[9]);

        //Create result label
        result = new JTextField("Play Tic-Tac-Toe: O's turn!");
        content.add("North", result);
        content.add(ButtonPanel, SwingConstants.CENTER);
        content.add("South", resetButton);
        //Add elements to the grid content pane
        for (int i = 0; i < 9; i++) {
            ButtonPanel.add(cells[i]);
        }
        //content.add(initButton);
        //content.add(exitButton);

        //Initialize
        init();
    }

    public void init() {
        //Initialize booleans
        Os = false;
        gameOver = false;

        //Initialize result label
        result.setText("Play Tic-Tac-Toe: O's turn!");

        setVisible(true);
    }

    public void gameOver() {
        if (checkWinner()) {
            //End of game
            gameOver = true;
            if (debug) {
                theGame.printBoard();
                System.out.println(notMyGame.toString());
            }
            //Display winner message need to negate 0s due to logic I don't understand because it's late
            if (!Os) {
                result.setText("Game Over: Os win!!");
            } else {
                result.setText("Game Over: Xs win!");
            }
        } //Check winner
        else if (MOVES == 9 && !gameOver) {
            gameOver = true;
            if (debug) {
                theGame.printBoard();
            }
            result.setText("Game Over: TIE");
            return;
        }

    }

    public boolean checkWinner() {
        if (cells[0].getText().equals("X") && cells[1].getText().equals("X") && cells[2].getText().equals("X")) {
            return true;
        } else if (cells[0].getText().equals("O") && cells[1].getText().equals("O") && cells[2].getText().equals("O")) {
            return true;
        } else if (cells[3].getText().equals("X") && cells[4].getText().equals("X") && cells[5].getText().equals("X")) {
            return true;
        } else if (cells[3].getText().equals("O") && cells[4].getText().equals("O") && cells[5].getText().equals("O")) {
            return true;
        } else if (cells[6].getText().equals("X") && cells[7].getText().equals("X") && cells[8].getText().equals("X")) {
            return true;
        } else if (cells[6].getText().equals("O") && cells[7].getText().equals("O") && cells[8].getText().equals("O")) {
            return true;
        } else if (cells[0].getText().equals("X") && cells[3].getText().equals("X") && cells[6].getText().equals("X")) {
            return true;
        } else if (cells[0].getText().equals("O") && cells[3].getText().equals("O") && cells[6].getText().equals("O")) {
            return true;
        } else if (cells[1].getText().equals("X") && cells[4].getText().equals("X") && cells[7].getText().equals("X")) {
            return true;
        } else if (cells[1].getText().equals("O") && cells[4].getText().equals("O") && cells[7].getText().equals("O")) {
            return true;
        } else if (cells[2].getText().equals("X") && cells[5].getText().equals("X") && cells[8].getText().equals("X")) {
            return true;
        } else if (cells[2].getText().equals("O") && cells[5].getText().equals("O") && cells[8].getText().equals("O")) {
            return true;
        } else if (cells[0].getText().equals("X") && cells[4].getText().equals("X") && cells[8].getText().equals("X")) {
            return true;
        } else if (cells[0].getText().equals("O") && cells[4].getText().equals("O") && cells[8].getText().equals("O")) {
            return true;
        } else if (cells[2].getText().equals("X") && cells[4].getText().equals("X") && cells[6].getText().equals("X")) {
            return true;
        } else if (cells[2].getText().equals("O") && cells[4].getText().equals("O") && cells[6].getText().equals("O")) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        //Create TicTacToe object
        TicTacToeGUI gui = new TicTacToeGUI();

    }

    public void reset() {
        System.out.println("Tried to reset!");
        Main.newGame();
        setVisible(false); //you can't see me!
        dispose(); //Destroy the JFrame object
    }

    public int getIndex(int x, int y) {
        int answer = -1;
        if (x == 0 && y == 0) {
            return 0;
        }
        if (x == 0 && y == 1) {
            return 1;
        }
        if (x == 0 && y == 2) {
            return 2;
        }
        if (x == 1 && y == 0) {
            return 3;
        }
        if (x == 1 && y == 1) {
            return 4;
        }
        if (x == 1 && y == 2) {
            return 5;
        }
        if (x == 2 && y == 0) {
            return 6;
        }
        if (x == 2 && y == 1) {
            return 7;
        }
        if (x == 2 && y == 2) {
            return 8;
        }
        return answer;

    }

    public int[] getCoordinates(int x) {
        int xandy[] = new int[2];
        switch (x) {
            case 0:
                xandy[0] = 0;
                xandy[1] = 0;
                break;
            case 1:
                xandy[0] = 0;
                xandy[1] = 1;
                break;
            case 2:
                xandy[0] = 0;
                xandy[1] = 2;
                break;
            case 3:
                xandy[0] = 1;
                xandy[1] = 0;
                break;
            case 4:
                xandy[0] = 1;
                xandy[1] = 1;
                break;
            case 5:
                xandy[0] = 1;
                xandy[1] = 2;
                break;
            case 6:
                xandy[0] = 2;
                xandy[1] = 0;
                break;
            case 7:
                xandy[0] = 2;
                xandy[1] = 1;
                break;
            case 8:
                xandy[0] = 2;
                xandy[1] = 2;
                break;
            default:
                throw new IllegalStateException("Help I've Escaped from Kevin Spacey's Basement!");
        }

        return xandy;

    }

    private void doAI() {
        if (Os) {
            Steven.run(notMyGame.getTurn(), notMyGame, 6);
            System.out.println(notMyGame.toString());
            MOVES++;
            theGame.matchBoard(notMyGame);
            Os = !Os;
            if(checkWinner()) gameOver();
        }
        Board.State[][] stevensMove = notMyGame.toArray();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (stevensMove[i][j] != Board.State.Blank) {
                    cells[getIndex(i, j)].setText(stevensMove[i][j].toString());
                    cells[getIndex(i, j)].setEnabled(false);
                }
            }
        }

    }

    private class CellButtonHandler implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            //Add To Move Counter
            MOVES++;

            //Get button pressed
            JButton pressed = (JButton) (e.getSource());

            //Get text of button
            String text = pressed.getText();

            //Check if Reset
            if (text.equals("Reset")) {
                System.out.println("I hear you!");
                reset();
                return;
            }

            //If game over, ignore
            if (gameOver) {
                return;
            }
            //Get Index of Button
            int index = -1;
            int xandy[] = new int[2];
            for (int i = 0; i < 9; i++) {
                if (pressed.equals(cells[i])) {
                    index = i;
                    xandy = getCoordinates(i);
                    if (!notMyGame.move(i)) {
                        System.out.println("Problem with Board.java!");
                    }
                    //DEBUG
                    if (debug) {
                        System.out.println("BUTTON INDEX IS: " + index);
                        System.out.println(notMyGame.toString());
                    }
                }
            }

            //If Os or Xs, ignore
            if (text.equals("O") || text.equals("X")) {
                return;
            }

            //Add nought or cross
            if (Os) {
                pressed.setText("O");
                theGame.setBoardAt(index, -1);
            } else {
                pressed.setText("X");
                theGame.setBoardAt(index, 1);
            }

            //Check winner
            if (checkWinner()) {
                //End of game
                gameOver = true;
                if (debug) {
                    theGame.printBoard();
                    System.out.println(notMyGame.toString());
                }
                //Display winner message
                if (Os) {
                    result.setText("Game Over: Os win!!");
                } else {
                    result.setText("Game Over: Xs win!");
                }
            } //Check winner
            else if (MOVES == 9 && !gameOver) {
                gameOver = true;
                if (debug) {
                    theGame.printBoard();
                }
                result.setText("Game Over: TIE");
                return;
            } else {
                //Change player
                Os = !Os;

                //Display player message need to negate 0s due to logic I don't understand because it's late
                if (!Os) {
                    result.setText("O's Turn!");
                } else {
                    result.setText("X's Turn!");
                }
            }
            //Disable Pressed Button Unless it is the ResetButton
            if (!pressed.getText().equals("Reset")) {
                pressed.setEnabled(false);
            }
            doAI();
            if (checkWinner()) {
                gameOver();
            }
        }
    }
}
