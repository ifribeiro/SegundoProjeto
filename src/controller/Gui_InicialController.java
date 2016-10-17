/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author jonas
 */
public class Gui_InicialController implements Initializable {

    @FXML
    private Stage window;
    @FXML
    private Button iniciar;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO

    }

    @FXML
    private void handleComecar(ActionEvent event) throws IOException {

        window = (Stage) ((Button) event.getSource()).getScene().getWindow();
        Parent cenaPrincipal = FXMLLoader.load(getClass().getResource("/interfaces/Gui_avatares.fxml"));
        Scene scene = new Scene(cenaPrincipal, 900, 700);
        window.setTitle("Grafonema");
        window.setScene(scene);
        window.show();

    }
}
