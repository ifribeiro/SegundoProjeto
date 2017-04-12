package model;

import controller.Gui_JogoPrincipalController;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;
import javafx.util.Duration;
import javax.sound.sampled.Clip;

/**
 *
 * @author shadows
 */
public class Model_SequenciaCenas {

    @FXML
    private ImageView imgView;
    private File arquivoImagem;
    private EventHandler<ActionEvent> c1, c2, c3, c4, c5;
    private TextArea textoAudio;
    private String caminhoAudio;
    private File arquivo;
    private Media media;
    private MediaPlayer mediaPlayer;
    private MediaView mediaView = new MediaView();
    private Stage janela;
    private int faseAtual;
    String caminho1, caminho2, caminho3, caminho4, caminho5 = "";
    private File arquivoImagemPB;
    int faseTempAtual = 0;
    
    Gui_JogoPrincipalController jogoPrincipalController = null;
    private File soundFile;
    private Clip clip;
    private ImageView imagemFundo;

    public Model_SequenciaCenas(ImageView imagem, ImageView imagemFundo) {
        imgView = imagem;
        faseAtual = 1;
        faseTempAtual = 0;
        this.imagemFundo = imagemFundo;
    }

    public void iniciarCenas() {
        caminho1 = caminho2 = caminho3 = caminho4 = caminho5 = "";
        switch (getFaseAtual()) {
            case 1:
                System.out.println("Unidade 1");
                caminho1 = "fase1/img1";
                caminho2 = "fase1/img2";
                caminho3 = "fase1/img3";
                caminho4 = "fase1/img4";
                caminho5 = "fase1/img5";
                break;
            case 2:
                System.out.println("Unidade 2");
                caminho1 = "fase2/img1";
                caminho2 = "fase2/img2";
                caminho3 = "fase2/img3";
                caminho4 = "fase2/img4";
                caminho5 = "fase2/img5";
                break;
            case 3:
                System.out.println("Unidade 3");
                caminho1 = "fase3/img1";
                caminho2 = "fase3/img2";
                caminho3 = "fase3/img3";
                caminho4 = "fase3/img4";
                caminho5 = "fase3/img5";
                break;
            case 4:
                caminho1 = "fase4/img1";
                caminho2 = "fase4/img2";
                caminho3 = "fase4/img3";
                caminho4 = "fase4/img4";
                caminho5 = "fase4/img5";
                break;
            case 5:
                caminho1 = "fase5/img1";
                caminho2 = "fase5/img2";
                caminho3 = "fase5/img3";
                caminho4 = "fase5/img4";
                caminho5 = "fase5/img5";
                break;
            case 6:
                caminho1 = "fase5/img1";
                caminho2 = "fase5/img2";
                caminho3 = "fase5/img3";
                caminho4 = "fase5/img4";
                caminho5 = "fase5/img5";
                break;
            case 7:
                caminho1 = "fase5/img1";
                caminho2 = "fase5/img2";
                caminho3 = "fase5/img3";
                caminho4 = "fase5/img4";
                caminho5 = "fase5/img5";
                break;
        }

        //evento que represanta a primeira cena do acerto
        c1 = (ActionEvent event) -> {
            URL arquivoImg = getClass().getResource("Imagens/"+caminho1+".png");
            imgView.setImage(new Image(arquivoImg.toString()));
            caminhoAudio = "audiosEfeitosSonoros/espada.mp3";
            tocarAudio(caminhoAudio);
        };

        //evento que representa a ação a ser feita depois da 
        //animação de acerto
        c2 = (ActionEvent event) -> {
            URL arquivoImg = getClass().getResource("Imagens/"+caminho2+".png");
            imgView.setImage(new Image(arquivoImg.toString()));
            caminhoAudio = "audiosEfeitosSonoros/espada2.mp3";
            tocarAudio(caminhoAudio);            
        };

        c3 = (ActionEvent event) -> {
            System.out.println("Terceiro");
            caminhoAudio = "audiosEfeitosSonoros/espada2.mp3";
            tocarAudio(caminhoAudio);
            URL arquivoImg = getClass().getResource("Imagens/"+caminho3+".png");
            imgView.setImage(new Image(arquivoImg.toString()));
        };

        c4 = (ActionEvent event) -> {
            System.out.println("quarto");
            URL arquivoImg = getClass().getResource("Imagens/"+caminho4+".png");
            imgView.setImage(new Image(arquivoImg.toString()));
            caminhoAudio = "audiosEfeitosSonoros/espada.mp3";
            tocarAudio(caminhoAudio);
            
        };

        c5 = (ActionEvent event) -> {
            System.out.println("Quinto");
            URL arquivoImg = getClass().getResource("Imagens/"+caminho5+".png");
            imgView.setImage(new Image(arquivoImg.toString()));
            caminhoAudio = "audiosEfeitosSonoros/espada.mp3";
            tocarAudio(caminhoAudio);            
        };
        new Timeline(
                new KeyFrame(Duration.seconds(0), c1),
                new KeyFrame(Duration.seconds(2), c2),
                new KeyFrame(Duration.seconds(4), c3),
                new KeyFrame(Duration.seconds(6), c4),
                new KeyFrame(Duration.seconds(8), c5)).play();

    }

    public void executarCenaInicial() {
        
        caminho1 = caminho2 = caminho3 = "";

        switch (getFaseAtual()) {
            case 1:
                //System.out.println("SDs");
                caminho1 = "Imagens/fase1/fe";
                caminho2 = "Imagens/fase1/fepb";
                caminho3 = "audios_vogais/frase1";
                break;
            case 2:
                System.out.println("Entrou aqui");
                caminho1 = "Imagens/fase2/inicioFase2";
                caminho2 = "Imagens/fase2/inicioFase2pb";
                caminho3 = "audios_vogais/frase1";
                break;
            case 3:
                caminho1 = "Imagens/fase3/inicioFase3";
                caminho2 = "Imagens/fase3/inicioFase3pb";
                caminho3 = "audios_vogais/frase1";
                break;
            case 4:
                caminho1 = "Imagens/fase4/inicioFase3";
                caminho2 = "Imagens/fase4/inicioFase3pb";
                caminho3 = "audios_vogais/frase1";
                break;
            case 5:
                caminho1 = "Imagens/fase5/inicioFase3";
                caminho2 = "Imagens/fase5/inicioFase3pb";
                caminho3 = "audios_vogais/frase1";
                break;
            case 6:
                caminho1 = "Imagens/fase6/inicioFase3";
                caminho2 = "Imagens/fase6/inicioFase3pb";
                caminho3 = "audios_vogais/frase1";
                break;
            case 7:
                caminho1 = "Imagens/fase7/inicioFase3";
                caminho2 = "Imagens/fase7/inicioFase3pb";
                caminho3 = "audios_vogais/frase1";
                break;
            default:
                break;
        }

        c1 = (ActionEvent event) -> {
            URL arquivoImg = getClass().getResource(caminho1+".jpg");
            imgView.setImage(new Image(arquivoImg.toString()));
            caminhoAudio = caminho3 + ".mp3";
            tocarAudio(caminhoAudio);

        };

        c2 = (ActionEvent event) -> {
            URL arquivoImgPB = getClass().getResource(caminho2+".jpg");
            imgView.setImage(new Image(arquivoImgPB.toString()));

        };

        c3 = (ActionEvent event) -> {
            janela = (Stage) imgView.getScene().getWindow();
            Parent cenaPrincipal = null;

            FXMLLoader fxmloader = new FXMLLoader(getClass().getResource("/interfaces/Gui_JogoPrincipal.fxml"));
            try {
                cenaPrincipal = (Parent) fxmloader.load();
            } catch (IOException ex) {
                Logger.getLogger(Model_SequenciaCenas.class.getName()).log(Level.SEVERE, null, ex);
            }
            jogoPrincipalController = fxmloader.<Gui_JogoPrincipalController>getController();
            jogoPrincipalController.definirImagemFundo();

            Scene scene = new Scene(cenaPrincipal, 1200, 700);
            janela.setTitle("Grafonema");
            janela.setScene(scene);
            janela.show();

        };
        
        c4 = (ActionEvent event) -> {
            System.out.println("O metodo vem aqui");
            jogoPrincipalController.iniciarJogo();
        };
        
        new Timeline(
                new KeyFrame(Duration.seconds(0), c1),
                new KeyFrame(Duration.seconds(10), c2),
                new KeyFrame(Duration.seconds(20), c3),
                new KeyFrame(Duration.seconds(21), c4)).play();

    }

    public void executarCenaFimDaFase() {
        int valorRetorno = 0;
        //System.out.println("ExecutarCenaFimDaFase");
        caminho1 = caminho2 = caminho3 = "";
        System.out.println(getFaseAtual());
        switch (getFaseAtual()) {
            case 1:
                caminho1 = "Imagens/fase1/fim";
                caminho3 = "audios_vogais/frase1.mp3";
                setFaseAtual(2);
                break;
            case 2:
                caminho1 = "Imagens/fase2/fim";
                caminho3 = "audios_vogais/frase1.mp3";
                setFaseAtual(3);
                break;
            case 3:
                caminho1 = "Imagens/fase3/fim";
                caminho3 = "audios_vogais/frase1.mp3";
                setFaseAtual(4);
                break;
            case 4:
                caminho1 = "Imagens/fase4/fim";
                caminho3 = "audios_vogais/frase1.mp3";
                setFaseAtual(5);
                break;
            case 5:
                caminho1 = "Imagens/fase5/fim";
                caminho3 = "audios_vogais/frase1.mp3";
                setFaseAtual(6);
                break;
            case 6:
                caminho1 = "Imagens/fase6/fim";
                caminho3 = "audios_vogais/frase1.mp3";
                setFaseAtual(7);
                break;
            case 7:
                caminho1 = "Imagens/fase2/fim";
                caminho3 = "audios_vogais/frase1.mp3";
                setFaseAtual(8);
                break;
            default:
                break;

        }
        URL arquivoImg = getClass().getResource(caminho1+".jpg");
        imgView.setImage(new Image(arquivoImg.toString()));
        tocarAudio(caminho3);

    }

    public void executarCenaMeioFase(){
        caminho1 = caminho2 = caminho3 = "";
        System.out.println("Executando cena meio fase ");

        switch (getFaseAtual()) {
            case 1:
                caminho1 = "Imagens/fase1/fe";
                caminho2 = "Imagens/fase1/fepb";
                caminho3 = "audios_vogais/frase1";
                break;
            case 2:
                System.out.println("Entrou aqui");
                caminho1 = "Imagens/fase2/inicioFase2";
                caminho2 = "Imagens/fase2/inicioFase2pb";
                caminho3 = "audios_vogais/frase1";
                break;
            case 3:
                caminho1 = "Imagens/fase3/inicioFase03";
                caminho2 = "Imagens/fase3/inicioFase03pb";
                caminho3 = "audios_vogais/frase1";
                break;
            case 4:
                caminho1 = "Imagens/fase4/inicioFase04";
                caminho2 = "Imagens/fase4/inicioFase04pb";
                caminho3 = "audios_vogais/frase1";                
                break;
            case 5:
                caminho1 = "Imagens/fase5/inicioFase05";
                caminho2 = "Imagens/fase5/inicioFase05pb";
                caminho3 = "audios_vogais/frase1";
                break;
            case 6:
                caminho1 = "Imagens/fase6/inicioFase06";
                caminho2 = "Imagens/fase6/inicioFase06pb";
                caminho3 = "audios_vogais/frase1";
                break;
            case 7:
                caminho1 = "Imagens/fase7/inicioFase07";
                caminho2 = "Imagens/fase7/inicioFase07pb";
                caminho3 = "audios_vogais/frase1";
        }

        c1 = (ActionEvent event) -> {
            URL arquivoImg = getClass().getResource(caminho1+".jpg");
            imgView.setImage(new Image(arquivoImg.toString()));
            caminhoAudio = caminho3 + ".mp3";
            tocarAudio(caminhoAudio);

        };

        c2 = (ActionEvent event) -> {
            URL arquivoImgPB = getClass().getResource(caminho2+".jpg");
            imgView.setImage(new Image(arquivoImgPB.toString()));

        };

        
        new Timeline(
                new KeyFrame(Duration.seconds(0), c1),
                new KeyFrame(Duration.seconds(10), c2)).play();
    }
    
    public void tocarAudio(String caminhoAudio) {        
        URL file = getClass().getResource(caminhoAudio);
        media = new Media(file.toString());
        mediaPlayer = new MediaPlayer(media);
        mediaPlayer.play();
    }

    public void setFaseAtual(int faseAtual) {
        this.faseAtual = faseAtual;
    }

    public int getFaseAtual() {
        return faseAtual;
    }
    
    public void executarCenaIntermediaria() {
        
        caminho1 = caminho2 = caminho3 = "";

        switch (getFaseAtual()) {
            case 1:
                //System.out.println("SDs");
                caminho1 = "Imagens/fase1/fe";
                caminho2 = "Imagens/fase1/fepb";
                caminho3 = "audios_vogais/frase1";
                break;
            case 2:
                System.out.println("Entrou aqui");
                caminho1 = "Imagens/fase2/inicioFase2";
                caminho2 = "Imagens/fase2/inicioFase2pb";
                caminho3 = "audios_vogais/frase1";
                break;
            case 3:
                caminho1 = "Imagens/fase3/inicioFase03";
                caminho2 = "Imagens/fase3/inicioFase03pb";
                caminho3 = "audios_vogais/frase1";
                break;
            case 4:
                caminho1 = "Imagens/fase4/inicioFase04";
                caminho2 = "Imagens/fase4/inicioFase04pb";
                caminho3 = "audios_vogais/frase1";
                break;
            case 5:
                caminho1 = "Imagens/fase5/inicioFase05";
                caminho2 = "Imagens/fase5/inicioFase05pb";
                caminho3 = "audios_vogais/frase1";
                break;
            case 6:
                caminho1 = "Imagens/fase6/inicioFase06";
                caminho2 = "Imagens/fase6/inicioFase06pb";
                caminho3 = "audios_vogais/frase1";
                break;
            case 7:
                caminho1 = "Imagens/fase7/inicioFase07";
                caminho2 = "Imagens/fase7/inicioFase07pb";
                caminho3 = "audios_vogais/frase1";
                break;
            default:
                break;
        }

        c1 = (ActionEvent event) -> {
            URL arquivoImg = getClass().getResource(caminho1+".jpg");
            imgView.setImage(new Image(arquivoImg.toString()));
            caminhoAudio = caminho3 + ".mp3";
            tocarAudio(caminhoAudio);
            

        };

        c2 = (ActionEvent event) -> {
            URL arquivoImgPB = getClass().getResource(caminho2+".jpg");
            imgView.setImage(new Image(arquivoImgPB.toString()));

        };

        c3 = (ActionEvent event) -> {
            janela = (Stage) imgView.getScene().getWindow();
            Parent cenaPrincipal = null;

            FXMLLoader fxmloader = new FXMLLoader(getClass().getResource("/interfaces/Gui_JogoPrincipal.fxml"));
            try {
                cenaPrincipal = (Parent) fxmloader.load();
            } catch (IOException ex) {
                Logger.getLogger(Model_SequenciaCenas.class.getName()).log(Level.SEVERE, null, ex);
            }
            jogoPrincipalController = fxmloader.<Gui_JogoPrincipalController>getController();
            jogoPrincipalController.setFaseAtual(getFaseAtual());
        };
        
        new Timeline(
                new KeyFrame(Duration.seconds(0), c1),
                new KeyFrame(Duration.seconds(10), c2),
                new KeyFrame(Duration.seconds(15), c3)).play();

    }

    public void definirImagemFundo() {
        URL arqImg = null;
        switch(getFaseAtual()){
            case 1:
                System.out.println("Entrou aqui case 1");
                arqImg = getClass().getResource("Imagens/Gerais/fundo_fase1.jpg");                
                break;
            case 2:
                arqImg = getClass().getResource("Imagens/Gerais/fundo_fase2.jpg");                
                break;
            case 3:
                arqImg = getClass().getResource("Imagens/Gerais/fundo_fase3.jpg");                
                break;
            case 4:
                arqImg = getClass().getResource("Imagens/Gerais/fundo_fase4.jpg");                
                break;
            case 5:
                arqImg = getClass().getResource("Imagens/Gerais/fundo_fase5.jpg");
                break;
            case 6:
                arqImg = getClass().getResource("Imagens/Gerais/fundo_fase6.jpg");
                break;
            case 7:
                arqImg = getClass().getResource("Imagens/Gerais/fundo_fase7.jpg");
                break;
            default:  
                break;
        }
        imagemFundo.setImage(new Image(arqImg.toString()));
    }
}