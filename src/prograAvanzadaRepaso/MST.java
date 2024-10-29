package prograAvanzadaRepaso;

public class MST {
	private int [][] matriz;
	private int costo;
	
	public MST(int cantNodos) {
		matriz= new int [cantNodos][cantNodos];
		costo=0;
	   for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz.length; j++) {
            	matriz[i][j] = i == j ? 0 : Integer.MAX_VALUE; 
            }
        }
	}
	
	public void addVertice(Vertice ver) {
		costo+=ver.key;
		matriz[ver.nodoDestino][ver.nodoPartida] = ver.key;
		matriz[ver.nodoPartida][ver.nodoDestino] = ver.key;
	}
	
	public int[][] getMST(){
		return matriz;
	}
	
	public int getCosto() {
		return costo;
	}
	
	public void showMST() {
    	System.out.println("MST");
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz.length; j++) {
            	System.out.print(matriz[i][j] == Integer.MAX_VALUE ? "INF " :  matriz[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("Costo: " + costo);
    }
}
