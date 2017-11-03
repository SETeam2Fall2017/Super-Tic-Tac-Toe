
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
    public boolean debug = true;

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
        Os = true;
        gameOver = false;

        //Initialize result label
        result.setText("Play Tic-Tac-Toe: O's turn!");

        setVisible(true);
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
            for (int i = 0; i < 9; i++) {
                if (pressed.equals(cells[i])) {
                    index = i;
                    //DEBUG
                    if (debug) {
                        System.out.println("BUTTON INDEX IS: " + index);
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

                //Display player message
                if (Os) {
                    result.setText("O's Turn!");
                } else {
                    result.setText("X's Turn!");
                }
            }
            //Disable Pressed Button Unless it is the ResetButton
            if (!pressed.getText().equals("Reset")) {
                pressed.setEnabled(false);
            }
        }
    }
}
