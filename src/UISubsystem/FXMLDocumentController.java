
package UISubsystem;

import java.net.URL;
import java.time.LocalDateTime;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javax.swing.JButton;

/**
 *
 * @author elchapo
 */
public class FXMLDocumentController implements Initializable {
    
    private Label label;
    
    @FXML
    private Button  gb0,gb1,gb2,gb3,gb4,gb5,gb6,gb7,gb8;
    @FXML
    /**
     * Delegates button input from the user to the correct class.
     * JButton input from the tic-tac-toe Game field should be sent to the gameMove function.
     * @param event Click event that is handled by the 
     */
    private void handleButtonAction(ActionEvent event) {
        Button pressed = (Button) event.getSource();
        pressed.setText(LocalDateTime.now().toString());
        System.out.println(pressed.getId()+"You clicked me!");

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
