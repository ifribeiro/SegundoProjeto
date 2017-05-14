/*
 * Model da página 6
 */
package model;

import controller.Pag05Controller;
import controller.Pag05aController;
import controller.Pag07Controller;
import java.io.IOException;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 *
 * @author shadows
 */
public class ModelPag06 {
    
    private int unidadeAtual;
    private Stage janela;
    private String caminhoAudio;
    
    private Label p1, p2;
    private ModelClasseComum mCC;
    
    @FXML
    private Text instrucao;
    private EventHandler<ActionEvent> primeiroAudio;
    private EventHandler<ActionEvent> segundoAudio;
    private ListView<String> listaPalavras;
    private String respostasCorretas[] = {" ","VOVÔ", "POVO","TATO","UVA","VIVA"};
    
    public ModelPag06(Label p1, Label p2, Text instrucao1, ListView<String> listaPalavras) {
        this.p1 = p1;
        this.p2 = p2;
        this.unidadeAtual = 0;
        this.listaPalavras = listaPalavras;
        mCC = new ModelClasseComum(janela, this.listaPalavras);
        this.instrucao = instrucao1;
    }

    /**
     * Define a unidade em que o software se encontra
     *
     * @param unidade
     */
    public void setUnidadeAtual(int unidade) {
        this.unidadeAtual = unidade;
        switch (getUnidadeAtual()) {
            case 1:
                definirLabels();
                break;
            case 2:
                definirLabels();
                break;
            default:
                break;
        }
        
    }

    /**
     * Carrega a próxima página na tela
     *
     * @param event disparado pelo método avancar do controller
     * @throws IOException
     */
    public void proximaPagina(ActionEvent event) throws IOException {
        janela = (Stage) ((Button) event.getSource()).getScene().getWindow(); //pega a cena em que o botão que gerou o evento estava
        FXMLLoader fxmloader = new FXMLLoader(getClass().getResource("/interfaces/pag07.fxml"));

        //cria a próxima cena chamando a inteface dos avatares        
        Parent proximaCena = (Parent) fxmloader.load();
        Pag07Controller pg07Cont = fxmloader.<Pag07Controller>getController();
        System.out.println("Pag 6 " + getUnidadeAtual());
        pg07Cont.setUnidadeAtual(getUnidadeAtual());
        
        mCC.exibirCena(proximaCena, janela);
        pg07Cont.tocarAudio();
        pg07Cont.setImagemTexto(getUnidadeAtual());
        
    }

    /**
     * Carrega a página anterior
     *
     * @param event disparado pelo método voltar do controller
     * @throws IOException
     */
    public void paginaAnterior(ActionEvent event) throws IOException {
        if (getUnidadeAtual() == 3) {
            janela = (Stage) ((Button) event.getSource()).getScene().getWindow(); //pega a cena em que o botão que gerou o evento estava
            FXMLLoader fxmloader = new FXMLLoader(getClass().getResource("/interfaces/pag05a.fxml"));
            //cria a próxima cena chamando a inteface dos avatares        
            Parent proximaCena = (Parent) fxmloader.load();
            Pag05aController pg05aCont = fxmloader.<Pag05aController>getController();
            
            mCC.exibirCena(proximaCena, janela);
            pg05aCont.setUnidadeAtual(getUnidadeAtual());
            pg05aCont.tocarAudio();
            pg05aCont.setInstrucao(getUnidadeAtual());
        } else {
            janela = (Stage) ((Button) event.getSource()).getScene().getWindow(); //pega a cena em que o botão que gerou o evento estava
            FXMLLoader fxmloader = new FXMLLoader(getClass().getResource("/interfaces/pag05.fxml"));
            //cria a próxima cena chamando a inteface dos avatares        
            Parent proximaCena = (Parent) fxmloader.load();
            Pag05Controller pg05Cont = fxmloader.<Pag05Controller>getController();
            
            mCC.exibirCena(proximaCena, janela);
            pg05Cont.setUnidadeAtual(getUnidadeAtual());
            pg05Cont.tocarAudio();
        }
    }

    /**
     * Pega a unidade atual em execução
     *
     * @return string com o valor da unidade atual
     */
    public int getUnidadeAtual() {
        return this.unidadeAtual;
    }

    /**
     * Verifica se a resposta digita pelo usuário é a resposta correta
     *
     * @param resposta string digitada pela pessoa
     * @return
     */
    public boolean verificarResposta(String resposta) {
        boolean respostaCorreta = false;
        respostaCorreta = resposta.toUpperCase().equals(respostasCorretas[getUnidadeAtual()]);
        /**
        switch (getUnidadeAtual()) {
            case 1:
                if (resposta.toUpperCase().equals("VOVÔ")) {
                    respostaCorreta = true;
                }
                break;
            case 2:
                if (resposta.toUpperCase().equals("POVO")) {
                    respostaCorreta = true;
                }
                break;
            case 3:
                respostaCorreta = resposta.toUpperCase().equals("TATO");
                break;
            case 4:
                respostaCorreta = resposta.toUpperCase().equals("UVA");
            default:
                respostaCorreta = resposta.toUpperCase().equals(respostasCorretas[getUnidadeAtual()]);
                break;
        }
        * **/
        return respostaCorreta;
    }

    /**
     * Executa o áudio da página
     */
    public void tocarAudio() {
        switch (getUnidadeAtual()) {
            case 1:
                caminhoAudio = "audios/u01/l1p6.mp3";
                break;
            case 2:
                caminhoAudio = "audios/u02/l2p6.mp3";
                break;
            case 3:
                caminhoAudio = "audios/u03/l3p6.mp3";
                break;
            default:
                caminhoAudio = "audios/u" + unidadeAtual + "/l" + unidadeAtual + "p6.mp3";
                break;
        }
        mCC.play(caminhoAudio);
    }

    /**
     * Define as labels que serão utilizadas na página baseado na unidade atual
     */
    public void definirLabels() {
        switch (getUnidadeAtual()) {
            case 1:
                p1.setText("O");
                p2.setText("É MEU AMIGO");
                break;
            case 2:                
                p1.setText("O");
                p2.setText("DA FESTA ESTÁ ANIMADO");
                break;
            case 3:
                p1.setText("O");
                p2.setText("SERVE PARA NOS PROTEGER");
                break;
            case 4:
                p1.setText("MEU PAI GOSTA DE");
                break;
            case 5:
                p2.setText("A VIDA COM AMOR.");
                break;
            default:
                break;
        }
    }

    /**
     * Para o audio em execução
     */
    public void pararAudio() {
        mCC.pararAudio();
    }

    /**
     * Carrega o menu inicial
     *
     * @param event disparado pelo método "menuInicial" do controller
     * @throws IOException
     */
    public void menuInicial(ActionEvent event) throws IOException {
        mCC.menuInicial(event);
    }

    /**
     * Executa o audio da palavra clicada
     *
     * @param palavraSelecionada string que representa a palavra selecionada
     */
    public void tocarAudioPalavraSelecionada(String palavraSelecionada) {
        mCC.tocarAudioPalavraSelecionada(palavraSelecionada);
    }
    
    public void executarAudioFrase() {
        switch (getUnidadeAtual()) {
            case 1:
                caminhoAudio = "audios/u01/frase.mp3";
                break;
            case 2:
                caminhoAudio = "audios/u02/frase.mp3";
                break;
            case 3:
                caminhoAudio = "audios/u03/frase.mp3";
                break;
            default:
                caminhoAudio = "audios/u" + unidadeAtual + "/frase.mp3";
                break;
        }
        mCC.play(caminhoAudio);
    }

    /**
     * Carrega a interface do manual do software
     *
     * @param event disparado pelo método
     * @param pagina pagina de onde o manual foi chamado
     * @throws IOException
     */
    public void abrirManual(ActionEvent event, int pagina) throws IOException {
        mCC.pararAudio();
        mCC.setUnidadeAtual(getUnidadeAtual());
        mCC.abrirManual(event, pagina);
    }

    /**
     * Abre o função "ABC" do programa
     *
     * @param event disparado quando o botão "ABC" é clicado
     * @param pagina pagina de onde a função "ABC" foi chamada
     * @throws IOException
     */
    public void abrirABC(ActionEvent event, int pagina) throws IOException {
        mCC.setUnidadeAtual(getUnidadeAtual());
        mCC.abrirABC(event, pagina);
    }

    //faz exibir a instrução da atividade atual na tela
    public void definirInstrucao(int unidadeAtual) {
        String instrucaoTexto = "";
        switch (unidadeAtual) {
            case 1:
                instrucao.setText("Digite a palavra que você aprendeu para formar a frase:\n \"o vovô é meu amigo\"");
                break;
            case 2:
                instrucao.setText("Digite a palavra que você aprendeu para formar a frase:\n \"o povo da festa está animado\"");
                break;
            case 3:
                instrucao.setText("Digite a palavra que você aprendeu para formar a frase:\n \"o tato serve para nos proteger\"");
                break;
            case 4:
                instrucaoTexto = "Digite a palavra que você aprendeu para formar a frase:\n \"Meu pai gosta de uva\"";
                instrucao.setText(instrucaoTexto);
                break;
            case 5:
                instrucao.setText("Digite a palavra que você aprendeu para formar a frase:\n \"viva a vida com amor\"");
                break;
                    
        }
    }
    
    private void tocarAudioParabens() throws InterruptedException {
        Random indiceParabens = new Random();
        int numeroAudio = indiceParabens.nextInt(3);
        caminhoAudio = "audios/acerto/" + numeroAudio + ".mp3";
        mCC.play(caminhoAudio);
        
    }
    
    public void audioAcerto() {
        //evento que represanta a ação do acerto
        primeiroAudio = (ActionEvent event) -> {
            try {
                tocarAudioParabens();
            } catch (InterruptedException ex) {
                Logger.getLogger(ModelPag04.class.getName()).log(Level.SEVERE, null, ex);
            }
        };

        //evento que representa o audio a ser executado depois o
        segundoAudio = (ActionEvent event) -> {
            executarAudioFrase();
        };
        new Timeline(
                new KeyFrame(Duration.seconds(0), primeiroAudio),
                new KeyFrame(Duration.seconds(3), segundoAudio)).play();
    }
    
    public void audioErro() {
        Random indiceErro = new Random();
        int numeroAudio = indiceErro.nextInt(3);
        caminhoAudio = "audios/erro/" + numeroAudio + ".mp3";
        mCC.play(caminhoAudio);
    }
    
    public void atualizarListView() {
        mCC.atualizarListView(listaPalavras, getUnidadeAtual());
    }
    
}
