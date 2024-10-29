package prograAvanzadaRepaso;

import java.util.Arrays;

public class PrimMST {
	private int [][] matrizAdyacencia;
	private int numeroNodos;
	
	public PrimMST(int [][] matriz){
		matrizAdyacencia = matriz.clone();
		numeroNodos = matriz.length;
	}
	
	public MST calcularPrim(int nodoInicial) throws Exception {
		MST mst = new MST(numeroNodos);
		int[] key = new int [this.numeroNodos];
		boolean[] nodoVisitado = new boolean[this.numeroNodos];
		
		Arrays.fill(key, Integer.MAX_VALUE);
		
		key[nodoInicial]=0;
		ColaPrioridad<Vertice> pq = new ColaPrioridad<Vertice>(this.numeroNodos);
		pq.push(new Vertice(nodoInicial, nodoInicial, 0));
		
		while(!pq.estaVacia()) {
			Vertice ver = pq.poll();
	    	int u = ver.nodoDestino;
	
	       nodoVisitado[u] = true;
	       for (int v = 0; v < this.numeroNodos; v++) {
	            if (matrizAdyacencia[u][v] != 0 && !nodoVisitado[v]) {
	                if (matrizAdyacencia[u][v] < key[v]) {
	                    key[v] = matrizAdyacencia[u][v];
	                    mst.addVertice(ver);
	                    pq.push(new Vertice(u, v, key[v]));
	                }
	            }
	        }
		}
		return mst;
    }
}