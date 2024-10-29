package prograAvanzadaRepaso;
import java.util.Stack;

public class DFS {
	private int matriz[][];
	private int numNodos;
	public DFS(int matriz[][]) {
		this.matriz = matriz.clone();
		this.numNodos = matriz.length;
	}
	
    public int[][] calcularDFS(int nodoInicial) {
        Stack<Integer> pila = new Stack<>();
        int[][] matrizResultante = new int[numNodos][numNodos];
        boolean[] visitado = new boolean[numNodos];

        for (int i = 0; i < numNodos; i++) {
            for (int j = 0; j < numNodos; j++) {
                matrizResultante[i][j] = Integer.MAX_VALUE;
            }
        }

        pila.push(nodoInicial);
        visitado[nodoInicial] = true;

        while (!pila.isEmpty()) {
            int nodo = pila.pop();

            for (int i = 0; i < numNodos; i++) {
                if (matriz[nodo][i] != Integer.MAX_VALUE && !visitado[i]) {
                    pila.push(i);
                    visitado[i] = true;
                    matrizResultante[nodo][i] = matriz[nodo][i];
                }
            }
        }
        return matrizResultante;
    }
}
