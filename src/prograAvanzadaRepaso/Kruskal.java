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
	
	public MST calcularKruskal() throws Exception {
		MST mst = new MST(numeroNodos);
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
				mst.addVertice(ver);
				k++;
			}
		}
		return mst;		
	}
}
