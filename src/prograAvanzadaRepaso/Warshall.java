package prograAvanzadaRepaso;

public class Warshall {
	private boolean adyacencia[][];
	
	public Warshall(int grafo[][]) {
		this.adyacencia = new boolean [grafo.length][grafo.length];
		for (int i = 0; i < grafo.length; i++) {
		    for (int j = 0; j < grafo[i].length; j++) {
	    		this.adyacencia[i][j] = grafo[i][j] < Integer.MAX_VALUE ? true: false;		    		
		    }
		}
		calcularMatriz();
	}
	
	private void calcularMatriz() {
		for(int i=0; i<adyacencia.length; i++) {
			adyacencia[i][i] = true;
		}
		for(int k=0; k<adyacencia.length; k++) {
			for(int i=0; i<adyacencia.length; i++) {
				for(int j=0; j<adyacencia.length; j++) {
					adyacencia[i][j] = adyacencia[i][j] || (adyacencia[i][k] && adyacencia[k][j]);
				}
			}
		}	
	}
	
	public void imprimirMatriz() {
    	System.out.println("WARSHALL");
		for (int i = 0; i < adyacencia.length; i++) {
		    for (int j = 0; j < adyacencia[i].length; j++) {
		        System.out.print(adyacencia[i][j] ? "1"+ " ":"0" + " ");
		    }
		    System.out.println();
		}
	}
}

