/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.ModelPag02;
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
import javafx.scene.control.Label;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author shadows
 */
public class Pag02Controller implements Initializable {
    @FXML
    private Label palavraAtual;
    
    
    
    private ModelPag02 modelPag02 = new ModelPag02();
    
    private String unidadeAtual;
    
    public Pag02Controller() {
        unidadeAtual = "u00";
        
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    

    @FXML
    private void avancar(ActionEvent event) throws IOException {
        modelPag02.proximaPagina(event);
    }

    @FXML
    private void audio1(ActionEvent event) {
        modelPag02.tocarAudio1();
    }

    @FXML
    private void audio2(ActionEvent event) {
        modelPag02.tocarAudio2();
    }

    @FXML
    private void audio3(ActionEvent event) {
        modelPag02.tocarAudio3();
    }

    @FXML
    private void voltar(ActionEvent event) throws IOException {
        modelPag02.paginaAnterior(event);        
    }

    public String getUnidadeAtual() {
        return modelPag02.getUnidadeAtual();
    }

    public void setUnidadeAtual(String unidade) {
        modelPag02.setUnidadeAtual(unidade);
    }
    
    
    
    
    
}
