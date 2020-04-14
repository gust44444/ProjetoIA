package application;

import java.net.URL;
import java.util.ResourceBundle;
import application.model.Linha;
import application.model.No;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.TextFieldTableCell;

public class MainController implements Initializable {
	
	@FXML
	private TextArea txtSaida;
	
    @FXML private TableView<Linha> tblOr;
    @FXML private TableView<Linha> tblMod;

    @FXML private TableColumn<Linha, String> col_1Or; 
    @FXML private TableColumn<Linha, String> col_2Or;
    @FXML private TableColumn<Linha, String> col_3Or;
    
    @FXML private TableColumn<Linha, String> col_1Mod;
    @FXML private TableColumn<Linha, String> col_2Mod;
    @FXML private TableColumn<Linha, String> col_3Mod;
    

    
    private void listDefaultValues() {
    	String col1 = String.valueOf(1);
    	String col2 = String.valueOf(2);
    	String col3 = String.valueOf(3);
    	Linha linha1Or = new Linha(col1, col2, col3);
    	Linha linha1Mod = new Linha(col1, col2, col3);
    	col1 = String.valueOf(4);
    	col2 = String.valueOf(5);
    	col3 = String.valueOf(6);
    	Linha linha2Or = new Linha(col1, col2, col3);
    	Linha linha2Mod = new Linha(col1, col2, col3);
    	col1 = String.valueOf(7);
    	col2 = String.valueOf(8);
    	col3 = String.valueOf(0);
    	Linha linha3Or = new Linha(col1, col2, col3);
    	Linha linha3Mod = new Linha(col1, col2, col3);
    	tblOr.getItems().addAll(linha1Or, linha2Or, linha3Or);
    	tblMod.getItems().addAll(linha1Mod, linha2Mod, linha3Mod);
    }
	
	public void inicializaTbl() {
		 initCols();
	   }

	private void initCols() {
		col_1Or.setCellValueFactory(cellData -> cellData.getValue().col1Property());
		col_2Or.setCellValueFactory(cellData -> cellData.getValue().col2Property());
		col_3Or.setCellValueFactory(cellData -> cellData.getValue().col3Property());
		col_1Mod.setCellValueFactory(cellData -> cellData.getValue().col1Property());
		col_2Mod.setCellValueFactory(cellData -> cellData.getValue().col2Property());
		col_3Mod.setCellValueFactory(cellData -> cellData.getValue().col3Property());
		editableCols();
	}

	private void editableCols() {
		col_1Or.setCellFactory(TextFieldTableCell.forTableColumn());
		col_1Or.setOnEditCommit(e -> {
			e.getTableView().getItems().get(e.getTablePosition().getRow()).setCol1(e.getNewValue());;
		});
		col_2Or.setCellFactory(TextFieldTableCell.forTableColumn());
		col_2Or.setOnEditCommit(e -> {
			e.getTableView().getItems().get(e.getTablePosition().getRow()).setCol2(e.getNewValue());;
		});
		col_3Or.setCellFactory(TextFieldTableCell.forTableColumn());
		col_3Or.setOnEditCommit(e -> {
			e.getTableView().getItems().get(e.getTablePosition().getRow()).setCol3(e.getNewValue());;
		});
		col_1Mod.setCellFactory(TextFieldTableCell.forTableColumn());
		col_1Mod.setOnEditCommit(e -> {
			e.getTableView().getItems().get(e.getTablePosition().getRow()).setCol1(e.getNewValue());;
		});
		col_2Mod.setCellFactory(TextFieldTableCell.forTableColumn());
		col_2Mod.setOnEditCommit(e -> {
			e.getTableView().getItems().get(e.getTablePosition().getRow()).setCol2(e.getNewValue());;
		});
		col_3Mod.setCellFactory(TextFieldTableCell.forTableColumn());
		col_3Mod.setOnEditCommit(e -> {
			e.getTableView().getItems().get(e.getTablePosition().getRow()).setCol3(e.getNewValue());;
		});
		
		tblOr.setEditable(true);
		tblMod.setEditable(true);
	}


	@Override
	public void initialize(URL location, ResourceBundle resources) {
		inicializaTbl();
		listDefaultValues();
	}
	
	
	@FXML
	public void buscaCegaIterativa() {
		long startTime = System.currentTimeMillis(); //Pega hora inicial
    	
    	String original = 	col_1Or.getCellData(0)+
    					  	col_2Or.getCellData(0)+
    					  	col_3Or.getCellData(0)+
    					  
    					  	col_1Or.getCellData(1)+
    					  	col_2Or.getCellData(1)+
    					  	col_3Or.getCellData(1)+
    					  
    					  	col_1Or.getCellData(2)+
						  	col_2Or.getCellData(2)+
						  	col_3Or.getCellData(2);
    	
    	
    	String modificado = col_1Mod.getCellData(0)+
    						col_2Mod.getCellData(0)+
    						col_3Mod.getCellData(0)+
				  
    						col_1Mod.getCellData(1)+
    						col_2Mod.getCellData(1)+
    						col_3Mod.getCellData(1)+
				  
    						col_1Mod.getCellData(2)+
    						col_2Mod.getCellData(2)+
    						col_3Mod.getCellData(2);
    	
    	System.out.println(original);
    	System.out.println(modificado);
    	
    	BuscaCegaArvore busca = new BuscaCegaArvore(new No(original), modificado);
        String txt = busca.buscaCegaIterativa(1000); //No maximo 10 interacoes.
        
        busca.buscaCegaIterativa(10); //No maximo 10 interacoes.
        long finishTime = System.currentTimeMillis(); 
        
        long totalTime = finishTime - startTime; //Horario da finalizacao
        txt += ("\n** Tempo decorrido: " + totalTime + " milisegundos.\n");
        txt += ("=====================================================================");
        
        txtSaida.setText(txt);
	}
}
