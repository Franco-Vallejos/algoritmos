package prograAvanzadaRepaso;
import java.util.LinkedList;
import java.util.Queue;

public class BFS {
	private int matriz[][];
	private int numNodos;
	public BFS(int matriz[][]) {
		this.matriz = matriz.clone();
		this.numNodos = matriz.length;
	}
	
    public int[] calcularBFS(int nodoInicial) {
        Queue<Integer> cola = new LinkedList<Integer>();
        int [] vecProfundidad = new int[numNodos];
        int profundidad = 1;
        int[][] matrizResultante = new int[numNodos][numNodos];
        boolean[] visitado = new boolean[numNodos];

        for (int i = 0; i < numNodos; i++) {
            for (int j = 0; j < numNodos; j++) {
                matrizResultante[i][j] = Integer.MAX_VALUE;
            }
        }

        cola.add(nodoInicial);
        visitado[nodoInicial] = true;

        while (!cola.isEmpty()) {
            int nodo = cola.poll();

            for (int i = 0; i < numNodos; i++, profundidad++){
                if (matriz[nodo][i] != Integer.MAX_VALUE && !visitado[i]) {
                	vecProfundidad[i] = profundidad;
                	cola.add(i);
                    visitado[i] = true;
                    matrizResultante[nodo][i] = matriz[nodo][i];
                }
            }
        }
        return vecProfundidad;
    }
}
