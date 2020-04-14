package application.model;
import java.util.NoSuchElementException;

/*
* ----------- Metodo fila --------------
*  - Utilizado para realizar operações
*    com filas de itens.
*
*
*/


public class Fila<Item>{
    private No<Item> primeiro;    // Primeiro item (no) da fila
    private No<Item> ultimo;     // Ultimo item (no) da fila
    private int N;             // Numero de elementos contidos na fila

    // helper linked list class
    private static class No<Item> {
        private Item item;
        private No<Item> proximo;
    }
    
    //Limpa a fila
    public void clear() {
        primeiro = null;
        ultimo = null;
        N= 0;
    }

    /*
     * Retorna true se a fila estiver vazia
     * Retorna false se tiver algum elemento nela.
     */
    public boolean filaVazia() {
        return primeiro == null;
    }

    /**
     * Retona o numero de itens na fila
     */
    public int tamanho() {
        return N; //Numero de itens
    }

 

    /**
     * Enfilera itens passados via parametro.
     * 
     * Coloca o ultimo atual em "anteriorAoUltimo" para nao perder referencia do pai do no atual.
     * 
     */
    public void enfilera(Item item) {

        No<Item> anteriorAoUltimo = ultimo; 
        ultimo = new No<Item>();
        ultimo.item = item;
        ultimo.proximo = null;
        if (filaVazia()) primeiro = ultimo;
        else anteriorAoUltimo.proximo = ultimo;
        N++;
    }

    /**
     * Remove e retorna o ultimo item adicionado na fila
     */
    public Item desenfilera() {
        if (filaVazia()) throw new NoSuchElementException("A fila esta vazia!"); //Verifica se a fila esta vazia
        Item item = primeiro.item; //Comeca a desenfileirar do primeiro
        primeiro = primeiro.proximo; //Em direcao ao ultimo item.
        N--; //Decrementa o numero de itens na fila (global)
        if (filaVazia()) primeiro = null;   // Otimizacao para diminuir tempo
        return item;
    }

    /**
     * Adiciona uma fila no inicio da fila atual
     */
    public void addQueue(Fila<Item> fila) {
        if (!fila.filaVazia()) { //Se a fila nao estiver vazia...
        	
            No<Item> antigoPrimeiro = primeiro;   
            if (filaVazia()) {
            	primeiro = fila.primeiro;
            	ultimo = fila.ultimo;
            } else {
            	primeiro = fila.primeiro;
            	fila.ultimo.proximo = antigoPrimeiro; //Proximo item apos o ultimo sera o item que era o primeiro
            }

            N = N + fila.tamanho(); //Incrementa o numero de itens na fila (global)
        }

    }

}
