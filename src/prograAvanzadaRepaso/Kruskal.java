package prograAvanzadaRepaso;

public class Kruskal {
	private int[][] matrizAdyacencia;
	private int numeroNodos;
	private int numeroAristas;
	
	
	public Kruskal(int [][]matriz) {
		matrizAdyacencia = matriz.clone();
		numeroNodos = matriz.length;
		numeroAristas = numeroNodos*numeroNodos;
	}
	
	public int[] calcularKruskal() throws Exception {
		int []predecesor = new int[numeroNodos];
		UnionFind uf = new UnionFind(numeroNodos);
		ColaPrioridad<Vertice> pq = new ColaPrioridad<Vertice>(numeroAristas);
		
		for(int i=0; i<numeroNodos; i++) {
			for(int j=0; j<numeroNodos; j++) {
				if(matrizAdyacencia[i][j] != Integer.MAX_VALUE) {
					pq.push(new Vertice(i, j, matrizAdyacencia[i][j]));					
				}
			}
		}
		
		int k=0;
		while(!pq.estaVacia() && k<numeroNodos) {
			Vertice ver = pq.poll();
			if(!uf.find(ver.nodoPartida, ver.nodoDestino)) {
				uf.union(ver.nodoPartida, ver.nodoDestino);
				predecesor[ver.nodoDestino] = ver.nodoPartida;
				k++;
			}
		}
		return predecesor;		
	}
	
	
	
	public int[][] getMST() {
		return matrizAdyacencia;
	}

    public void showGraph(int predecesor[]) {
        System.out.println("KRUSKAL");
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
