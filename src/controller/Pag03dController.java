package controller;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import model.ModelPag03d;
import model.ModelPag03b;
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
import javafx.scene.text.Text;

/**
 * FXML Controller class
 *
 * @author shadows
 */
public class Pag03dController implements Initializable {

    
    
    @FXML
    private ImageView img1;
    @FXML
    private ImageView img2;
    @FXML
    private ImageView img3;
    @FXML
    private ImageView img6;
    @FXML
    private ImageView img5;
    @FXML
    private ImageView img4;
    
    private ModelPag03d modelPag03d;
    @FXML
    private ListView<String> listaPalavras;   
    ObservableList<String> items = FXCollections.observableArrayList();
    @FXML
    private Button abc;
    @FXML
    private Button manual;
    @FXML
    private Text instrucao;
    
    private final int pagina = 3;
    @FXML
    private Button atividades;
    @FXML
    private ImageView imagemFundo;
    @FXML
    private Label palavrasEstudadas;
    @FXML
    private Button avancar;
    @FXML
    private Button voltar;
    
    public Pag03dController() {
        listaPalavras = new ListView<String>();       
    }
       
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        modelPag03d = new ModelPag03d(img1,img2,img3,img4,img5,img6,instrucao,listaPalavras);
        Tooltip ouvirPalavras = new Tooltip("Clique em uma palavra para ouvir");
        listaPalavras.setTooltip(ouvirPalavras);
        abc.setTooltip(new Tooltip("Clique para ouvir os sons das letras"));
        atividades.setTooltip(new Tooltip("Clique para ver as atividades para imprimir"));
        manual.setTooltip(new Tooltip("Clique para ler o manual do programa "));
    }    
    public void audioInicial() throws MalformedURLException{
        modelPag03d.tocarAudioInicial();
        setInstrucao(modelPag03d.getUnidadeAtual());
    }
    /**
     * Define a unidade atual
     * @param unidade valor da unidade atual
     * @throws IOException 
     */
    public void setUnidadeAtual(int unidade) throws IOException {
        atualizarListView();
        modelPag03d.setUnidadeAtual(unidade);
    }
    /**
     * Avança para a proxima pagina
     * @param event
     * @throws IOException 
     */
    @FXML
    private void avancar(ActionEvent event) throws IOException {
        modelPag03d.pararAudio();
        modelPag03d.proximaPagina(event);    
        
    }
    /**
     * Volta para a pagina anterior
     * @param event
     * @throws IOException 
     */
    @FXML
    private void voltar(ActionEvent event) throws IOException {
        modelPag03d.pararAudio();
        modelPag03d.paginaAnterior(event);
    }

    //redireciona para o método definir instrução do model que irá imprimir a instrução na tela
    public void setInstrucao(int unidadeAtual)    {
        modelPag03d.definirInstrucao(unidadeAtual);
    }
    
    public void setImagens(int unidadeAtual) {
        modelPag03d.definirImagens(unidadeAtual);
    }

    @FXML
    private void verificarImagem(MouseEvent event) {
        modelPag03d.verificarImagem(event);
    }
    /**
     * Leva o usuário para o menu inicial
     * @param event clique no botão "Menu Inicial"
     * @throws IOException 
     */
    @FXML
    private void menuInicial(ActionEvent event) throws IOException{
        modelPag03d.menuInicial(event);
        modelPag03d.pararAudio();
    }
    /**
     * Trata o evento de quando o mouse é clicado na lista de palavras
     * @param event mouse é pressionado
     */
    @FXML
    private void mouseClicado(MouseEvent event) {
        String palavraSelecionada = listaPalavras.getSelectionModel().getSelectedItem();
        modelPag03d.tocarAudioPalavraSelecionada(palavraSelecionada);
    }
    /**
     * Atualiza a lista de palavras estudadas
     * @throws FileNotFoundException
     * @throws IOException 
     */
    private void atualizarListaPalavras() throws FileNotFoundException, IOException {
        //controlerComum.atualizarListaPalavras(listaPalavras);

    }
    /**
     * Realiza o efeito de sombrear o botão quando o mouse passar por cima dele
     * @param event movimentação do mouse sobre os componentes
     */
    @FXML
    private void sombrearBotao(MouseEvent event) {
        DropShadow sombras = new DropShadow();
        ((Button)((event)).getSource()).setEffect(sombras);
    }
    /**
     * Realiza o efeito de dessombrear o botão quando o mouse for retirado de cima dele
     * @param event movimentação do mouse para fora do botão
     */
    @FXML
    private void retirarSombraBotao(MouseEvent event) {        
        ((Button)((event)).getSource()).setEffect(null);
    }

    @FXML
    private void executarAudioImagem(MouseEvent event) {
        modelPag03d.executarAudioImagem(event);
        
    }
    /**
     * Abre o manual do software
     * @param event clique no botão
     * @throws IOException 
     */
    @FXML
    private void abrirManual(ActionEvent event) throws IOException {
        modelPag03d.abrirManual(event, pagina, "d");
    }
    /**
     * Abre a função ABC do software
     * @param event clique no botão "ABC"
     * @throws IOException 
     */
    @FXML
    private void abrirABC(ActionEvent event) throws IOException {
        modelPag03d.abrirABC(event, pagina);
        modelPag03d.pararAudio();
    }

    private void atualizarListView() {
        modelPag03d.atualizarListView();
    }

    @FXML
    private void sugestaoAtividades(ActionEvent event) throws IOException {
        modelPag03d.sugestaoAtividade(event, pagina);
    }
}
