package application.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.Stack;

import application.model.No;


/*
* ----------- Metodo NoUtil --------------
*  - Utilizado para realizar operações em nos
*    Pode ser usada tambem para pegar alguma propriedade de algum nó.
*/


public class NoUtil {
    public static List<String> getSucessores(String state) {
        List<String> sucessores = new ArrayList<String>();

        switch (state.indexOf("0")) {
            case 0: { //Primeiro da fila
            	sucessores.add(state.replace(state.charAt(0), '*').replace(state.charAt(1), state.charAt(0)).replace('*', state.charAt(1)));
            	sucessores.add(state.replace(state.charAt(0), '*').replace(state.charAt(3), state.charAt(0)).replace('*', state.charAt(3)));
                break;
            }
            case 1: {
            	sucessores.add(state.replace(state.charAt(1), '*').replace(state.charAt(0), state.charAt(1)).replace('*', state.charAt(0)));
            	sucessores.add(state.replace(state.charAt(1), '*').replace(state.charAt(2), state.charAt(1)).replace('*', state.charAt(2)));
            	sucessores.add(state.replace(state.charAt(1), '*').replace(state.charAt(4), state.charAt(1)).replace('*', state.charAt(4)));
                break;
            }
            case 2: {

            	sucessores.add(state.replace(state.charAt(2), '*').replace(state.charAt(1), state.charAt(2)).replace('*', state.charAt(1)));
            	sucessores.add(state.replace(state.charAt(2), '*').replace(state.charAt(5), state.charAt(2)).replace('*', state.charAt(5)));
                break;
            }
            case 3: {
            	sucessores.add(state.replace(state.charAt(3), '*').replace(state.charAt(0), state.charAt(3)).replace('*', state.charAt(0)));
            	sucessores.add(state.replace(state.charAt(3), '*').replace(state.charAt(4), state.charAt(3)).replace('*', state.charAt(4)));
            	sucessores.add(state.replace(state.charAt(3), '*').replace(state.charAt(6), state.charAt(3)).replace('*', state.charAt(6)));
                break;
            }
            case 4: {
            	sucessores.add(state.replace(state.charAt(4), '*').replace(state.charAt(1), state.charAt(4)).replace('*', state.charAt(1)));
            	sucessores.add(state.replace(state.charAt(4), '*').replace(state.charAt(3), state.charAt(4)).replace('*', state.charAt(3)));
            	sucessores.add(state.replace(state.charAt(4), '*').replace(state.charAt(5), state.charAt(4)).replace('*', state.charAt(5)));
            	sucessores.add(state.replace(state.charAt(4), '*').replace(state.charAt(7), state.charAt(4)).replace('*', state.charAt(7)));
                break;
            }
            case 5: {
            	sucessores.add(state.replace(state.charAt(5), '*').replace(state.charAt(2), state.charAt(5)).replace('*', state.charAt(2)));
            	sucessores.add(state.replace(state.charAt(5), '*').replace(state.charAt(4), state.charAt(5)).replace('*', state.charAt(4)));
                sucessores.add(state.replace(state.charAt(5), '*').replace(state.charAt(8), state.charAt(5)).replace('*', state.charAt(8)));
                break;
            }
            case 6: {
            	sucessores.add(state.replace(state.charAt(6), '*').replace(state.charAt(3), state.charAt(6)).replace('*', state.charAt(3)));
            	sucessores.add(state.replace(state.charAt(6), '*').replace(state.charAt(7), state.charAt(6)).replace('*', state.charAt(7)));
                break;

            }
            case 7: {
            	sucessores.add(state.replace(state.charAt(7), '*').replace(state.charAt(4), state.charAt(7)).replace('*', state.charAt(4)));
            	sucessores.add(state.replace(state.charAt(7), '*').replace(state.charAt(6), state.charAt(7)).replace('*', state.charAt(6)));
            	sucessores.add(state.replace(state.charAt(7), '*').replace(state.charAt(8), state.charAt(7)).replace('*', state.charAt(8)));
                break;
            }
            case 8: {
            	sucessores.add(state.replace(state.charAt(8), '*').replace(state.charAt(5), state.charAt(8)).replace('*', state.charAt(5)));
            	sucessores.add(state.replace(state.charAt(8), '*').replace(state.charAt(7), state.charAt(8)).replace('*', state.charAt(7)));
                break;
            }
        }

        return sucessores;


    }



    /**
     *Imprime na tela as solucoes e estados tomados desde o primeiro ate o ultimo estado.
     *
     */
    public static String mostrarSolucao(No goalNode, Set<String> visitedNodes, No root, int time) {

        int totalCost = 0;
        
        String res = "";

        Stack<No> solutionStack = new Stack<No>();
        solutionStack.push(goalNode);
        while (!goalNode.getEstado().equals(root.getEstado())) {
            solutionStack.push(goalNode.getAnterior());
            goalNode = goalNode.getAnterior();
        }
        String sourceState = root.getEstado();
        String destinationState;
        int cost = 0;
        for (int i = solutionStack.size() - 1; i >= 0; i--) {
            System.out.println("==========================================================");
            destinationState = solutionStack.get(i).getEstado();
            if (!sourceState.equals(destinationState)) {
                System.out.println("O espaço foi: "+findTransition(sourceState, destinationState)+" e tomou o lugar do numero: "+destinationState.charAt(sourceState.indexOf('0')));
                res += ("O espaço foi: "+findTransition(sourceState, destinationState)+" e tomou o lugar do numero: "+destinationState.charAt(sourceState.indexOf('0')));
            	cost = Character.getNumericValue(destinationState.charAt(sourceState.indexOf('0')));
                totalCost += cost;
            }

            sourceState = destinationState;
            System.out.println("Custo do movimento: " + cost);
            System.out.println("*******");
            System.out.println("* " + solutionStack.get(i).getEstado().substring(0, 3)+" *");
            System.out.println("* " + solutionStack.get(i).getEstado().substring(3, 6)+" *");
            System.out.println("* " + solutionStack.get(i).getEstado().substring(6, 9)+" *");
            System.out.println("*******");
            
            
            
            //res += ("Custo do movimento: " + cost+"\n");
            res += ("*******\n");
            res += ("* " + solutionStack.get(i).getEstado().substring(0, 3)+" *\n");
            res += ("* " + solutionStack.get(i).getEstado().substring(3, 6)+" *\n");
            res += ("* " + solutionStack.get(i).getEstado().substring(6, 9)+" *\n");
            res += ("*******\n");
            

        }
        System.out.println("=====================================================================");
        System.out.println("** Numero de mudanças realizadas para chegar ao estado final:  " + (solutionStack.size() - 1)+"\n");
        System.out.println("** Numero de estados visitados:  " + (visitedNodes.size())+"\n");
        System.out.println("** Custo total: " + totalCost+"\n");
        System.out.println("** Numero de nós retirados da fila: " + time+"\n");
        
        res += ("=====================================================================\n");
        res += ("** Numero de mudanças realizadas para chegar ao estado final:  " + (solutionStack.size() - 1)+"\n");
        res += ("** Numero de estados visitados:  " + (visitedNodes.size())+"\n");
        res += ("** Custo total: " + totalCost+"\n");
        res += ("** Numero de nós retirados da fila: " + time+"\n");
        
        
        
       return res; 

    }

    
    /**
     * Metodo que retorna tipo de transição entre dois elementos
     */
    public static TipoMovimento findTransition(String source, String destination) {
        int difPosEspaco = destination.indexOf('0') - source.indexOf('0');
        switch (difPosEspaco) {
            case -3:
                return TipoMovimento.ParaCima;
            case 3:
                return TipoMovimento.ParaBaixo;
            case 1:
                return TipoMovimento.ParaEsquerda;
            case -1:
                return TipoMovimento.ParaDireita;
        }
        return null;
    }
}



