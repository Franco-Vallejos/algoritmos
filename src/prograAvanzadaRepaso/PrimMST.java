package prograAvanzadaRepaso;

import java.util.Arrays;

public class PrimMST {
	private int [][] matrizAdyacencia;
	private int numeroNodos;
	
	public PrimMST(int [][] matriz){
		matrizAdyacencia = matriz.clone();
		numeroNodos = matriz.length;
	}
	
	public int[] calcularPrim(int nodoInicial) throws Exception {
		int []predecesor = new int[numeroNodos];
		Arrays.fill(predecesor, -1);
		int[] key = new int [this.numeroNodos];
		boolean[] nodoVisitado = new boolean[this.numeroNodos];
		
		Arrays.fill(key, Integer.MAX_VALUE);
		
		key[nodoInicial]=0;
		ColaPrioridad<Vertice> pq = new ColaPrioridad<Vertice>(this.numeroNodos);
		pq.push(new Vertice(0, 0, 0));
		
		while(!pq.estaVacia()) {
			Vertice nodo = pq.poll();
	    	int u = nodo.nodoDestino;
	
	       nodoVisitado[u] = true;
	       for (int v = 0; v < this.numeroNodos; v++) {
	            if (matrizAdyacencia[u][v] != 0 && !nodoVisitado[v]) {
	                if (matrizAdyacencia[u][v] < key[v]) {
	                    key[v] = matrizAdyacencia[u][v];
	                    predecesor[v] = u;
	                    pq.push(new Vertice(u, v, key[v]));
	                }
	            }
	        }
		}
		return predecesor;
    }

	
	public int[][] getMST() {
		return matrizAdyacencia;
	}

    public void showGraph(int predecesor[]) {
        System.out.println("PRIM");
        System.out.println("Arista \tPeso");
        for (int i = 1; i < matrizAdyacencia.length; i++) {
            System.out.println(predecesor[i] + " - " + i + "\t" + matrizAdyacencia[i][predecesor[i]]);
        }
    }
    
    public int getCosto(int predecesor[]) {
    	int costo=0;
    	for(int i=0; i<predecesor.length; i++) {
    		costo+=predecesor[i];
    	}
    	return costo;
    }
    
    public void showMatriz() {
        for (int i = 0; i < matrizAdyacencia.length; i++) {
            for (int j = 0; j < matrizAdyacencia.length; j++) {
            	System.out.print(matrizAdyacencia[i][j]);
            }
            System.out.println();
        }
    }
}
