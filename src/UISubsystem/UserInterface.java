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
    private GameLogic theGame = new GameLogic(this);

    @FXML
    private Button gb0, gb1, gb2, gb3, gb4, gb5, gb6, gb7, gb8;
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
            pressed.setText(LocalDateTime.now().toString());
            gameButtonAction(pressed);
            pressed.setDisable(true);
        } else if (pressed.getId().matches("reset")) {
            resetButtonAction(pressed);
        }

    }

    private void resetButtonAction(Button pressed) {

    }
    
  
    @FXML
    private void gameButtonAction(Button pressed) {   //Position trims off the "gb" prefix in the button name 
        //and just gets the index number.
        int position = Integer.parseInt(pressed.getId().substring(2));
        System.out.println("Position: " + position);
        theGame.userMove(position);
        pressed.setDisable(true);
        System.out.println(pressed.disableProperty().toString());
        
        //Implement move below

    }

    public void updateBoard(int buttonIndex, GameBoard.State state) {
        Button toUpdate = getButton(buttonIndex);
        
        //To Implement:
        //check that button is blank and update if that is true
        //check if deathmatch and implement swap of buttons in that case
       //To Implement if (toUpdate.getText().equals("")) {
            
            toUpdate.setText(state.toString());
            toUpdate.setDisable(true);
        //}

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
                throw new RuntimeException("UserInterface:getButton: index out of range!");
        }

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

}
