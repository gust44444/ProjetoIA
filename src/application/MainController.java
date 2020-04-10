package application;

import java.net.URL;
import java.util.ResourceBundle;

import application.model.Linha;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.TextFieldTableCell;

public class MainController implements Initializable {
	
    @FXML
    private TableView<Linha> tblOr;

    @FXML
    private TableColumn<Linha, String> col_1Or;

    @FXML
    private TableColumn<Linha, String> col_2Or;

    @FXML
    private TableColumn<Linha, String> col_3Or;

    @FXML
    private TableView<Linha> tblMod;

    @FXML
    private TableColumn<Linha, String> col_1Mod;

    @FXML
    private TableColumn<Linha, String> col_2Mod;

    @FXML
    private TableColumn<Linha, String> col_3Mod;
    
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
    	Linha linha3Or = new Linha(col1, col2, null);
    	Linha linha3Mod = new Linha(col1, col2, null);
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
	
}
