package UISubsystem;

import GameplayLogicSubsystem.GameBoard;
import GameplayLogicSubsystem.GameLogic;
import java.awt.Checkbox;
import java.net.URL;
import java.time.LocalDateTime;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;

/**
 *
 * @author elchapo
 */
public class UserInterface implements Initializable {

    private boolean localMatch, aiFirstMove, isDeathMatch;
    private GameLogic theGame;

    @FXML
    private Label topLabel;
    @FXML
    private RadioButton humanFirst;
    @FXML
    private RadioButton aiFirst;
    @FXML
    private Label bottomLabel;
    @FXML
    private Button gb0;
    @FXML
    private Button gb1;
    @FXML
    private Button gb2;
    @FXML
    private Button gb3;
    @FXML
    private Button gb4;
    @FXML
    private Button gb5;
    @FXML
    private Button gb6;
    @FXML
    private Button gb7;
    @FXML
    private Button gb8;
    @FXML
    private Button playLocalButton, playServerButton, restartButton;
    @FXML
    private Checkbox firstMoveCheck;
    @FXML
    private CheckBox deathMatchCheck;
    @FXML
    private TextField serverAddress;
    @FXML
    private TextField portNumber;
    @FXML
    private TextField timeout;
    @FXML
    private TextField teamID;

    @FXML
    /**
     * Delegates button input from the user to the correct class. Button input
     * from the tic-tac-toe Game field should be sent to the gameMove function.
     * Reset button is sent to resetButtonAction
     *
     * @param event Click event that is handled by the
     */
    private void handleButtonAction(ActionEvent event) {
        Button pressed = (Button) event.getSource();
        System.out.println(pressed.getId() + ": You clicked me!");
        if (pressed.getId().matches("gb[0-9]")) {
            System.out.println("regex l33t god");
            // pressed.setText(LocalDateTime.now().toString());
            gameButtonAction(pressed);
            //pressed.setDisable(true);
        } else if (pressed.getId().matches("restartButton")) {
            resetButtonAction(pressed);
        } else if (pressed.getId().matches("playLocalButton")) {
            System.out.println("Play Local");
            localMatch = true;
            startGame();
        }

    }

    @FXML
    private void handleCheckAction(ActionEvent event) {
        CheckBox checked = (CheckBox) event.getSource();
        if (checked.getId().matches("firstMoveCheck")) {
            System.out.println("I heard firstMoveCheck");
            aiFirstMove = true;
        } else if (checked.getId().matches("deathMatchCheck")) {
            System.out.println("I heard deathMatchCheck:" + isDeathMatch);
            isDeathMatch = (isDeathMatch) ? false : true;
            System.out.println("deathMatchCheck After:" + isDeathMatch);
        }

    }

    @FXML
    private void handleRadioButton(ActionEvent event) {
        RadioButton clicked = (RadioButton) event.getSource();
        if (clicked.getText().matches("AI First")) {
            aiFirstMove = true;
            System.out.println("aiFirstMove: " + aiFirstMove);
        } else {
            aiFirstMove = false;
            System.out.println("aiFirstMove: " + aiFirstMove);
        }

    }

    @FXML
    private void resetButtonAction(Button pressed) {
        System.out.println("ResetButtonAction: I Ran!");
        theGame = new GameLogic(this);
        for (int i = 0; i < 9; i++) {
            Button toReset = getButton(i);
            getButton(i).setDisable(false);
            getButton(i).setText("");

        }

    }

    /**
     * To Document
     *
     * @param pressed
     */
    private void gameButtonAction(Button pressed) {
        //Position trims off the "gb" prefix in the button name
        //and just gets the index number.
        int position = Integer.parseInt(pressed.getId().substring(2));
        System.out.println("Position: " + position);
        //  pressed.setText(theGame.getCurrentPlayer().toString());
        this.theGame.userMove(position);
        //pressed.setDisable(true);
        theGame.aiMove();

        //Implement move below
    }

    @FXML
    public void updateBoard(int buttonIndex, GameBoard.State state) {
        setButton(buttonIndex, state.toString());
        System.out.println("USERINTERFACE:updateBoard  " + buttonIndex + ": " + state.toString());
        //To Implement:
        //check that button is blank and update if that is true
        //check if deathmatch and implement swap of buttons in that case
        //To Implement if (toUpdate.getText().equals("")) {
        //toUpdate.setText(state.toString());
        //toUpdate.setDisable(true);
        //}

    }

    @FXML
    private void setButton(int index, String S) {
        switch (index) {
            case 0:
                gb0.setText(theGame.getCurrentPlayer().toString());
                gb0.setDisable(true);
                break;
            case 1:
                this.gb1.setText(S);
                this.gb1.setDisable(true);
                break;
            case 2:
                this.gb2.setText(S);
                this.gb2.setDisable(true);
                break;
            case 3:
                this.gb3.setText(S);
                this.gb3.setDisable(true);
                break;
            case 4:
                this.gb4.setText(S);
                this.gb4.setDisable(true);
                break;
            case 5:
                this.gb5.setText(S);
                this.gb5.setDisable(true);
                break;
            case 6:
                this.gb6.setText(S);
                this.gb6.setDisable(true);
                break;
            case 7:
                this.gb7.setText(S);
                this.gb7.setDisable(true);
                break;
            case 8:
                this.gb8.setText(S);
                this.gb8.setDisable(true);
                break;
            default:
                System.out.println("USERINTERFACE:setButton " + index);
                throw new RuntimeException("UserInterface:getButton: index out of range!");
        }

    }

    private Button getButton(int index) {
        switch (index) {
            case 0:
                return gb0;
            case 1:
                return gb1;
            case 2:
                return gb2;
            case 3:
                return gb3;
            case 4:
                return gb4;
            case 5:
                return gb5;
            case 6:
                return gb6;
            case 7:
                return gb7;
            case 8:
                return gb8;
            default:
                System.out.println("USERINTERFACE:setButton " + index);
                throw new RuntimeException("UserInterface:getButton: index out of range!");
        }

    }

    public void setMessage(String s) {
        topLabel.setText(s);

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        theGame = new GameLogic(this);
        setMessage("Select a Game to Begin!");
        for (int i = 0; i < 9; i++) {
            Button toDisable = getButton(i);
            toDisable.setDisable(true);
        }

    }

    private void startGame() {
        System.out.println("StartGame: ");
        theGame = new GameLogic(this);
        if (localMatch) {//Play Locally
                    System.out.println("StartGame: Local Match ");
            for (int i = 0; i < 9; i++) {
                Button toReset = getButton(i);
                getButton(i).setDisable(false);
                getButton(i).setText("");

            }
            if (aiFirstMove) {
                theGame.aiMove();
            }

        }else{  //Play Server Game
        
        
        
        }
    }

    public void gameOver(String Message) {
        for (int i = 0; i < 9; i++) {
            Button toDisable = getButton(i);
            toDisable.setDisable(true);
        }
        topLabel.setText(Message);
        bottomLabel.setText("Game Over");

    }

}
