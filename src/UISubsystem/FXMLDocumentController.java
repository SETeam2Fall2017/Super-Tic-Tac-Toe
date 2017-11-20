
package UISubsystem;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javax.swing.JButton;

/**
 *
 * @author elchapo
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private Label label;
    
    /**
     * Delegates button input from the user to the correct class.
     * JButton input from the tic-tac-toe Game field should be sent to the gameMove function.
     * @param event Click event that is handled by the 
     */
    @FXML
    private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
        label.setText("Hello World!");
    }
    
    private void gameButtonAction(JButton pressed)
    {   //Position trims off the "gb" prefix in the button name 
        //and just gets the index number.
        int position = Integer.parseInt(pressed.getName().substring(2));
        
        //Implement move below
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
