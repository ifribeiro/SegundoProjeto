package controller;

import java.io.IOException;
import model.ModelPag07;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.Tooltip;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author shadows
 */
public class Pag07Controller implements Initializable {

    @FXML
    private Label tituloUnidade;

    private ModelPag07 modelPag07;
    @FXML
    private ListView<String> listaPalavras;
    ObservableList<String> items = FXCollections.observableArrayList();
    @FXML
    private Button abc;
    @FXML
    private Button manual;
    @FXML
    private Button voltar;
    @FXML
    private Button avancar;
    @FXML
    private Label palavrasEstudadas;

    private final int pagina = 7;
    @FXML
    private Button atividades;

    @FXML
    private ImageView imagemTexto;

    public Pag07Controller() {
        listaPalavras = new ListView<>();
    }

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        modelPag07 = new ModelPag07(imagemTexto, listaPalavras);
        Tooltip ouvirPalavras = new Tooltip("Clique em uma palavra para ouvir");
        listaPalavras.setTooltip(ouvirPalavras);
        abc.setTooltip(new Tooltip("Clique para ouvir os sons das letras"));
        atividades.setTooltip(new Tooltip("Clique para ver as atividades para imprimir"));
        manual.setTooltip(new Tooltip("Clique para ler o manual do programa "));
    }

    public void tocarAudio() {
        modelPag07.tocarAudio();
    }

    public int getUnidadeAtual() {
        return modelPag07.getUnidadeAtual();
    }

    /**
     * Define a unidade atual
     *
     * @param unidadeAtual o novo valor da unidade
     * @throws IOException
     */
    public void setUnidadeAtual(int unidadeAtual) throws IOException {
        atualizarListView(unidadeAtual);
        modelPag07.setUnidadeAtual(unidadeAtual, tituloUnidade);
    }

    /**
     * Avança para a proxima pagina
     *
     * @param event
     * @throws IOException
     */
    @FXML
    private void avancar(ActionEvent event) throws IOException {
        modelPag07.pararAudio();
        modelPag07.proximaPagina(event);
    }

    /**
     * Volta para a pagina anterior
     *
     * @param event
     * @throws IOException
     */
    @FXML
    private void voltar(ActionEvent event) throws IOException {
        modelPag07.pararAudio();
        modelPag07.paginaAnterior(event);
    }

    /**
     * Leva o usuário para o menu inicial
     *
     * @param event clique no botão "Menu Inicial"
     * @throws IOException
     */
    @FXML
    private void menuInicial(ActionEvent event) throws IOException {
        modelPag07.menuInicial(event);
        modelPag07.pararAudio();
    }

    /**
     * Trata o evento de quando o mouse é clicado na lista de palavras
     *
     * @param event mouse é pressionado
     */
    @FXML
    private void mouseClicado(MouseEvent event) {
        String palavraSelecionada = listaPalavras.getSelectionModel().getSelectedItem();
        modelPag07.tocarAudioPalavraSelecionada(palavraSelecionada);
    }

    /**
     * Realiza o efeito de sombrear o botão quando o mouse passar por cima dele
     *
     * @param event movimentação do mouse sobre os componentes
     */
    @FXML
    private void sombrearBotao(MouseEvent event) {
        DropShadow sombras = new DropShadow();
        ((Button) ((event)).getSource()).setEffect(sombras);
    }

    /**
     * Realiza o efeito de dessombrear o botão quando o mouse for retirado de
     * cima dele
     *
     * @param event movimentação do mouse para fora do botão
     */
    @FXML
    private void retirarSombraBotao(MouseEvent event) {
        ((Button) ((event)).getSource()).setEffect(null);
    }

    @FXML
    private void abrirABC(ActionEvent event) throws IOException {
        modelPag07.abrirABC(event, pagina);
        modelPag07.pararAudio();
    }

    /**
     * Abre o manual do software
     *
     * @param event clique no botão
     * @throws IOException
     */
    @FXML
    private void abrirManual(ActionEvent event) throws IOException {
        modelPag07.abrirManual(event, pagina, "");
    }

    @FXML
    private void sugestaoAtividades(ActionEvent event) throws IOException {
        modelPag07.sugestaoAtividade(event, pagina);
    }

    public void atualizarListView(int unidade) {
        modelPag07.atualizarListView(unidade);
    }

    public void setImagemTexto(int unidadeAtual) {
        modelPag07.setImagemTexto(unidadeAtual);
    }

}
