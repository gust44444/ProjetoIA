package application;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import application.model.Fila;
import application.model.No;
import application.util.NoUtil;

public class BuscaCegaArvore {
    private No estadoInicial;
    private String estadoEsperado;

    public BuscaCegaArvore(No estadoInicial, String estadoEsperado) {
        this.estadoInicial = estadoInicial;
        this.estadoEsperado = estadoEsperado;
    }


    /** 
     * ======= Função principal ======
     * 
     * ->  Chegar ao estado desejado através de busca cega de profundidade iterativa.
     * ->  O limite de profundidade começa em 1 e aumenta ate o valor definido pelo usuário.
     */
    //*****************************************************************************************************
    public String buscaCegaIterativa(int limiteProfundidade) {
    	
    	String txt = "";
    	
        No noAtual = new No(estadoInicial.getEstado());
        boolean solucaoEncontrada = false;
        Set<String> nosVisitados = new HashSet<String>(); //Lista no formato HashSet de nós já visitados.
        Set<String> totalNosVisitados = new HashSet<>(); //Lista de TODOS os nos visitados
        int contador = 0;
        for (int profundidadeAtual = 1; profundidadeAtual < limiteProfundidade; profundidadeAtual++) {
        	
        	nosVisitados.clear(); //Necessario limpar lista de visitados a cada iteracao
            
            Fila<No> filaPrincipal = new Fila<>(); //Fila principal, a qual armazena os nós que vamos expandir
            Fila<No> filaSucessores = new Fila<>(); //Fila que armazena os sucessores de um nó já expandido
            
            No no = new No(estadoInicial.getEstado());//Cria um nó raiz com o estado inicial passado na interface.
            
            filaPrincipal.enfilera(no); //Joga o nó na fila
            noAtual = no;
            List<String> nosSucessores = null;
            nosVisitados.add(noAtual.getEstado()); //Marca como visitado, jogando na lista de nós visitados
            
            while (!filaPrincipal.filaVazia()) { //Enquanto a fila principal nao estiver vazia...
            	noAtual = filaPrincipal.desenfilera(); //Desenfilera itens
            	contador += 1; //Acrescenta +1 no contador
                if (noAtual.getEstado().equals(estadoEsperado)) { 
                    solucaoEncontrada = true;
                    break;
                }
                if (noAtual.getProfundidade() < profundidadeAtual) {
                	nosSucessores = NoUtil.getSucessores(noAtual.getEstado());
                    for (String n : nosSucessores) {
                        if (nosVisitados.contains(n))
                            continue;

                        nosVisitados.add(n);
                        No child = new No(n);
                        noAtual.addAtual(child);
                        child.setAnterior(noAtual);
                        child.setVisitado(true);
                        child.setProfundidade(noAtual.getProfundidade() + 1);
                        filaSucessores.enfilera(child);

                    }
                    //we add the queue that contains the successors of the visted node to the beginning of the main queue
                    filaPrincipal.addQueue(filaSucessores);
                    //successors queue should be cleared in order to store the next expaneded's successors
                    filaSucessores.clear(); //Chama metodo que limpa fila
                }
            }

            if (solucaoEncontrada)
                break;
            totalNosVisitados.addAll(nosVisitados);
        }
        if (!solucaoEncontrada)
            System.out.println("Solucao nao encontrada!");
        else {
            txt += NoUtil.mostrarSolucao(noAtual, totalNosVisitados, estadoInicial, contador);
            
        }
        return txt;
    }
   
}