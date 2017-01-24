/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import controller.MenuInicialController;
import java.io.File;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;

/**
 *
 * @author shadows
 */
public class ModelClasseComum {
    private File arquivo;
    private Media media;
    private MediaPlayer mediaPlayer;
    private MediaView mediaView = new MediaView();
    private Stage janela;
    private String caminhoAudio;

    public ModelClasseComum(Stage janela) {
        this.janela = janela;
    }
    
    public void play(String caminhoAudio){
        //cria um objeto arquivo que recebe o nome do arquivo como parâmetro
        arquivo = new File(caminhoAudio);
        //pega todo do caminho referente ao objeto File criado
        caminhoAudio = arquivo.getAbsolutePath();
        //troca todas as barras invertidas duplas ('\\') por '/'
        caminhoAudio = caminhoAudio.replace("\\", "/");
        //cria um objeto Media que recebe o objeto 'arquivo' como parâmetro
        media = new Media(new File(caminhoAudio).toURI().toString());
        //cria um objeto mediaPlayer que permite qua uma media possa ser reproduzida
        mediaPlayer = new MediaPlayer(media);
        //toca o audio automaticamente
        mediaPlayer.setAutoPlay(true);
        mediaView.setMediaPlayer(mediaPlayer);
    }
    
    public void pararAudio() {
        try{
            mediaPlayer.stop();
        }catch(Exception e){
            
        }
    }
    
    public void exibirCena(Parent proximaCena, Stage janela) {
        this.janela = janela;
        Scene cena = new Scene(proximaCena, 900, 700);
        janela.setTitle("Menu Inicial");//título da cena
        janela.setScene(cena);
        janela.show();//exibe a interface  
    }
   
    public void tocarAudioPalavraSelecionada(String palavraSelecionada) {
        switch(palavraSelecionada){
            case "VOVÔ":
                caminhoAudio = "src/audios/u01/l1p2a1.MP3";
                break;
            default:
                break;
        }
        play(caminhoAudio);
    }
    
    public void menuInicial(ActionEvent event) throws IOException {
        janela = (Stage) ((Button) event.getSource()).getScene().getWindow();
        FXMLLoader fxmloader = new FXMLLoader(getClass().getResource("/interfaces/menuInicial.fxml"));
        
        Parent proximaCena = (Parent) fxmloader.load();
        MenuInicialController miController = fxmloader.<MenuInicialController>getController();
        
        exibirCena(proximaCena, janela);
    }
}