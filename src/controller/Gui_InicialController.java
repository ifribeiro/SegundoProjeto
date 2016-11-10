package controller;

import model.Model_Inicial;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * FXML Controller class
 *
 * @author jonas
 */
public class Gui_InicialController implements Initializable {    
    @FXML
    private Button iniciar;
    
    private Model_Inicial modelInical = new Model_Inicial();
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Image image = new Image(getClass().getResourceAsStream("play.png"));
        iniciar.setGraphic(new ImageView(image));
    }
    @FXML
    private void handleComecar(ActionEvent event) throws IOException {       
        modelInical.iniciar(event);        
    }
}