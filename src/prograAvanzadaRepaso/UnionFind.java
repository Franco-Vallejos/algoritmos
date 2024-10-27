package prograAvanzadaRepaso;

public class UnionFind {
	int[]matrizUF;
	
	public UnionFind(int cantNodos) {
		matrizUF = new int[cantNodos];
		for(int i=0; i<cantNodos; i++) {
			matrizUF[i] = i;
		}
	}
	
	public boolean find(int nodoPartida, int nodoDestino) {
		if(nodoPartida != matrizUF[nodoPartida]) {
			while(matrizUF[nodoPartida]!=nodoPartida) {
				nodoPartida = matrizUF[nodoPartida];
			}
		}
		
		if(nodoDestino != matrizUF[nodoDestino]) {
			while(matrizUF[nodoDestino]!=nodoDestino) {
				nodoDestino = matrizUF[nodoDestino];
			}
		}
		
		return nodoPartida==nodoDestino;
	}
	
	public void union(int nodoPartida, int nodoDestino) {	
		if(nodoPartida != matrizUF[nodoPartida]) {
			while(matrizUF[nodoPartida]!=nodoPartida) {
				nodoPartida = matrizUF[nodoPartida];
			}
		}
		
		if(nodoDestino != matrizUF[nodoDestino]) {
			while(matrizUF[nodoDestino]!=nodoDestino) {
				nodoDestino = matrizUF[nodoDestino];
			}
		}
		
		if(nodoPartida < nodoDestino) {
			matrizUF[nodoDestino] = nodoPartida; 
		}else {
			matrizUF[nodoPartida] = nodoDestino; 
		}
	}
}
