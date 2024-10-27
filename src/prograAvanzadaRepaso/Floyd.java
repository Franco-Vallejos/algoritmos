package prograAvanzadaRepaso;

public class Floyd {
	private int costos[][];
	private int predecesor[][];
	
	public Floyd(int grafo[][]) {
		this.costos = new int [grafo.length][grafo.length];
		this.predecesor = new int [grafo.length][grafo.length];
		for (int i = 0; i < grafo.length; i++) {
		    for (int j = 0; j < grafo[i].length; j++) {
		    	this.costos[i][j] = grafo[i][j];
		    	this.predecesor[i][j] = i;
		    }
		}
		calcularMatriz();
	}

	private void calcularMatriz() {
		for(int i=0; i<costos.length; i++) {
			costos[i][i] = 0;
		}
		
		for(int k=0; k<costos.length; k++) {
			for(int i=0; i<costos.length; i++) {
				for(int j=0; j<costos.length; j++) {
					int aux = costos[i][k] + costos[k][j];
					if (costos[i][k] == Integer.MAX_VALUE || costos[k][j] == Integer.MAX_VALUE) {
						costos[i][j] = costos[i][j];
					}else if(costos[i][j] > aux) {
						costos[i][j] = aux;					
						predecesor[i][j] = k;
					}
				}
			}
		}		
	}
	
    public void imprimirMatriz() {
    	System.out.println("FLOYD");
    	System.out.println("costos");
        for (int i = 0; i < costos.length; i++) {
            for (int j = 0; j < costos[i].length; j++) {
                System.out.print(costos[i][j] + " ");
            }
            System.out.println();
        }
        
        System.out.println("predecesor");
        for (int i = 0; i < predecesor.length; i++) {
            for (int j = 0; j < predecesor[i].length; j++) {
                System.out.print(predecesor[i][j] + " ");
            }
            System.out.println();
        }
    }
	
	
}
