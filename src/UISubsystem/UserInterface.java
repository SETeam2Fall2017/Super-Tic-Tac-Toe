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

/**
 *
 * @author elchapo
 */
public class UserInterface implements Initializable {

    private Label label;
    private GameLogic theGame;

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
        }

    }

    @FXML
    private void resetButtonAction(Button pressed) {
        System.out.println("I Ran!");
        theGame = new GameLogic(this);
        for (int i = 0; i < 9; i++) {
            //   getButton(i).setDisable(false);
            // getButton(i).setText("");

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

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        theGame = new GameLogic(this);
      /*  gb0 = new Button();
        gb1 = new Button();
        gb2 = new Button();
        gb3 = new Button();
        gb4 = new Button();
        gb5 = new Button();
        gb6 = new Button();
        gb7 = new Button();
        gb8 = new Button();*/

    }

}
