/*
 * Model da página 2
 */
package model;

import controller.Pag01Controller;
import controller.Pag02Controller;
import controller.Pag02cController;
import controller.Pag03Controller;
import java.io.File;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

/**
 *
 * @author shadows
 */
public class ModelPag02b {

    private int unidadeAtual;
    private Pag02Controller pg02;
    private String caminhoAudio;

    private File arquivo;
    private ModelClasseComum mCC;

    private Stage janela;

    @FXML
    private ListView<String> listaPalavras;

    @FXML
    private Label palavraAtual;

    private String textoDaUnidade[] = {"VOVÔ", "POVO", "TATO", "UVA", "VIVA", "LUVA",
        "LATA", "BEBÊ", "DOCE","","","","","","","","","RATO","","","","","","","SUCESSO",
        "", "","","","","","","","","","","","","","","","","","","","","TOQUES", "",
        "", "", "RIQUEZA"
};//29

    public ModelPag02b(ListView<String> listaPalavras, Label palavraAtual) {
        this.unidadeAtual = 0;
        this.listaPalavras = listaPalavras;
        this.palavraAtual = palavraAtual;
        mCC = new ModelClasseComum(janela, this.listaPalavras);
    }

    /**
     * Pega a unidade atual em execução
     *
     * @return string com o valor da unidade atual
     */
    public int getUnidadeAtual() {
        return unidadeAtual;
    }

    /**
     * Define a unidade em que o software se encontra
     *
     * @param unidadeAtual unidade atual da execução
     */
    public void setUnidadeAtual(int unidadeAtual) {
        palavraAtual.setText(textoDaUnidade[unidadeAtual - 1]);
        this.unidadeAtual = unidadeAtual;
    }

    /**
     * Executa o audio 1 da página
     */
    public void tocarAudio1() {
        switch (getUnidadeAtual()) {
            case 1:
                caminhoAudio = "audios/u01/l1p2a1.mp3";
                break;
            case 2:
                caminhoAudio = "audios/u02/l2p2a1.mp3";
                break;
            case 3:
                caminhoAudio = "audios/u03/l3p2a1.mp3";
                break;
            case 4:
                caminhoAudio = "audios/u4/l4p2a1.mp3";
                break;
            default:
                caminhoAudio = "audios/u" + unidadeAtual + "b/l" + unidadeAtual + "p2a1.mp3";
                break;
        }

        mCC.play(caminhoAudio);
    }

    /**
     * Executa o audio 2 da página
     */
    public void tocarAudio2() {
        switch (getUnidadeAtual()) {
            case 1:
                caminhoAudio = "audios/u01/l1p2a2.mp3";
                break;
            case 2:
                caminhoAudio = "audios/u02/l2p2a2.mp3";
                break;
            case 3:
                caminhoAudio = "audios/u03/l3p2a2.mp3";
                break;
            case 4:
                caminhoAudio = "audios/u4/l4p2a2.mp3";
                break;
            default:
                caminhoAudio = "audios/u" + unidadeAtual + "b/l" + unidadeAtual + "p2a2.mp3";
                break;
        }

        mCC.play(caminhoAudio);
    }

    /**
     * Executa o audio 3 da pagina
     */
    public void tocarAudio3() {
        switch (getUnidadeAtual()) {
            case 1:
                caminhoAudio = "audios/u01/l1p2a3.mp3";
                break;
            case 2:
                caminhoAudio = "audios/u02/l2p2a3.mp3";
                break;
            case 3:
                caminhoAudio = "audios/u03/l3p2a3.mp3";
                break;
            case 4:
                caminhoAudio = "audios/u4/l4p2a3.mp3";
                break;
            default:
                caminhoAudio = "audios/u" + unidadeAtual + "b/l" + unidadeAtual + "p2a3.mp3";
                break;
        }

        mCC.play(caminhoAudio);
    }

    /**
     * Carrega a próxima página na tela
     *
     * @param event disparado pelo método avancar do controller
     * @throws IOException
     */
    public void proximaPagina(ActionEvent event) throws IOException {
        int u = getUnidadeAtual();
        if (u == 9) {
            System.out.println("ModelPag02a");
            janela = (Stage) ((Button) event.getSource()).getScene().getWindow(); //pega a cena em que o botão que gerou o evento estava
            FXMLLoader fxmloader = new FXMLLoader(getClass().getResource("/interfaces/pag03.fxml"));

            //cria a próxima cena chamando a inteface dos avatares        
            Parent proximaCena = (Parent) fxmloader.load();
            Pag03Controller pg03Cont = fxmloader.<Pag03Controller>getController();
            pg03Cont.setUnidadeAtual(getUnidadeAtual());
            pg03Cont.audioInicial();
            pg03Cont.setImagens(getUnidadeAtual());
            mCC.exibirCena(proximaCena, janela);

        }else if(u == 51){
            janela = (Stage) ((Button) event.getSource()).getScene().getWindow(); //pega a cena em que o botão que gerou o evento estava
            FXMLLoader fxmloader = new FXMLLoader(getClass().getResource("/interfaces/pag02c.fxml"));
            //cria a próxima cena chamando a inteface dos avatares        
            Parent proximaCena = (Parent) fxmloader.load();
            Pag02cController pg02cCont = fxmloader.<Pag02cController>getController();
            pg02cCont.setUnidadeAtual(getUnidadeAtual());            
            mCC.exibirCena(proximaCena, janela);
        }        
        else {            
            janela = (Stage) ((Button) event.getSource()).getScene().getWindow(); //pega a cena em que o botão que gerou o evento estava
            FXMLLoader fxmloader = new FXMLLoader(getClass().getResource("/interfaces/pag03.fxml"));

            //cria a próxima cena chamando a inteface dos avatares        
            Parent proximaCena = (Parent) fxmloader.load();
            Pag03Controller pg03Cont = fxmloader.<Pag03Controller>getController();
            pg03Cont.setUnidadeAtual(getUnidadeAtual());
            pg03Cont.audioInicial();
            pg03Cont.setImagens(getUnidadeAtual());
            mCC.exibirCena(proximaCena, janela);
            

        }
    }

    /**
     * Carrega a página anterior
     *
     * @param event disparado pelo método voltar do controller
     * @throws IOException
     */
    public void paginaAnterior(ActionEvent event) throws IOException {
        int u = getUnidadeAtual();
            janela = (Stage) ((Button) event.getSource()).getScene().getWindow(); //pega a cena em que o botão que gerou o evento estava
            FXMLLoader fxmloader = new FXMLLoader(getClass().getResource("/interfaces/pag01.fxml"));
            //cria a próxima cena chamando a inteface dos avatares        
            Parent proximaCena = (Parent) fxmloader.load();
            Pag01Controller pg01Cont = fxmloader.<Pag01Controller>getController();

            mCC.exibirCena(proximaCena, janela);
            pg01Cont.setUnidadeAtual(getUnidadeAtual());
            pg01Cont.setImagemTexto();
            pg01Cont.tocarAudio();
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

    /**
     * Carrega a interface do manual do software
     *
     * @param event disparado pelo método
     * @param pagina pagina de onde o manual foi chamado
     * @throws IOException
     */
    public void abrirManual(ActionEvent event, int pagina, String subPagina) throws IOException {
        mCC.pararAudio();
        mCC.setUnidadeAtual(getUnidadeAtual());
        mCC.abrirManual(event, pagina, "b");
    }

    /**
     * Carrega a interface do ABC
     *
     * @param event disparado pelo método ABCJanela do controller
     * @param pagina
     * @throws IOException
     */
    public void abrirABC(ActionEvent event, int pagina) throws IOException {
        mCC.setUnidadeAtual(getUnidadeAtual());
        mCC.abrirABC(event, pagina,"b");
    }

    public void atualizarListView() {
        mCC.atualizarListView(listaPalavras, getUnidadeAtual());
    }

    public void sugestaoAtividade(ActionEvent event, int pagina) throws IOException {
        mCC.sugestaoAtividades(event, pagina,"b");
    }
}
