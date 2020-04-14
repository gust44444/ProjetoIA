package application.model;
import java.util.ArrayList;

public class No {
    private boolean Visitado;

    private String Estado;
    private ArrayList<No> Atual;
    private No Anterior;
    private int Profundidade;

   
    public No(String estado) {
        this.Estado = estado;
        Atual = new ArrayList<No>();
    }

    public String getEstado() {
        return Estado;
    }

    public ArrayList<No> getAtual() {
        return Atual;
    }

    public void addAtual(No atual) {
    	Atual.add(atual);
    }
    
    public int getProfundidade() {
        return Profundidade;
    }
    public void setProfundidade(int profundidade) {
        this.Profundidade = profundidade;
    }
    public boolean isVisitado() {
		return Visitado;
	}
	public void setVisitado(boolean visitado) {
        this.Visitado = visitado;
    }
    public No getAnterior() {
        return Anterior;
    }
    public void setAnterior(No anterior) {
        this.Anterior = anterior;
    }
}