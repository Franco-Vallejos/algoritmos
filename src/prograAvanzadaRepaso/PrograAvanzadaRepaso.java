package prograAvanzadaRepaso;

public class PrograAvanzadaRepaso {

	private static final int INF = Integer.MAX_VALUE;  // Usamos INF para conexiones inexistentes
	public static void main(String[] args) {
		int matriz1[][] = {
				{1,2,3},
				{4,8,2},
				{1,5,3}
		};
		
		int matriz2[][] = {
				{0,4,INF,INF},
				{4,0,2,INF},
				{1,INF,0,2},
				{INF,3,2,0}
		};
		
        int[][] matriz3 = {
                {0, 1, INF, 1, INF, INF, INF},
                {INF, 0, 1, INF, INF, INF, INF},
                {INF, INF, 0, INF, INF, 1, INF},
                {INF, 1, INF, 0, 1, INF, INF},
                {INF, INF, INF, INF, 0, 1, INF},
                {INF, INF, INF, INF, INF, 0, INF},
                {1, INF, INF, INF, INF, INF, 0}
            };
        
            int[][] matriz4 = {
                {0, 2, INF, 6, INF, INF, INF},
                {2, 0, 3, 8, 5, INF, INF},
                {INF, 3, 0, INF, 7, INF, INF},
                {6, 8, INF, 0, 9, INF, INF},
                {INF, 5, 7, 9, 0, 4, INF},
                {INF, INF, INF, INF, 4, 0, 1},
                {INF, INF, INF, INF, INF, 1, 0}
            };
            
            int[][] matriz5 = {
                    {0, 2, INF, 4, INF, 5, INF},  
                    {2, 0, 7, 1, 3, 8, 4},        
                    {INF, 7, 0, INF, 10, INF, 6}, 
                    {4, 1, INF, 0, 2, INF, INF},  
                    {INF, 3, 10, 2, 0, INF, INF}, 
                    {5, 8, INF, INF, INF, 0, 1}, 
                    {INF, 4, 6, INF, INF, 1, 0}   
                };

		
		Floyd grafoFloyd = new Floyd(matriz2);
		
		Warshall grafoWarshall = new Warshall(matriz3);
		
		PrimMST grafoPrimMST = new PrimMST(matriz4);
		
		Kruskal grafoKruskal = new Kruskal(matriz5);
		
		try {
			int camino1[] = grafoPrimMST.calcularPrim(0);
			grafoPrimMST.showGraph(camino1);
			
			int camino2[] =  grafoKruskal.calcularKruskal();
			grafoKruskal.showGraph(camino2);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		grafoFloyd.imprimirMatriz();
		grafoWarshall.imprimirMatriz();
		
		//System.out.println(menorCostoPD(matriz1));
		
	}
	
	public static int menorCostoPD(int matriz[][]) {
		int maux[][] = new int[matriz.length][matriz[0].length];
		
		maux[0][0] = matriz[0][0];
		
		for(int i=1; i<matriz.length; i++) {
			maux[i][0] = maux[i-1][0] + matriz[i][0];
		}
		
		for(int j=1; j<matriz.length; j++) {
			maux[0][j] = maux[0][j-1] + matriz[0][j];
		}
		
		for(int i=1; i<matriz.length; i++) {
			for(int j=1; j<matriz[0].length; j++) {
				maux[i][j] = minimo(maux[i-1][j-1], maux[i-1][j], maux[i][j-1]) + matriz[i][j];
			}
		}
		
		return maux[matriz.length-1][matriz[0].length-1];
	}
	
	public static int minimo(int aux1, int aux2, int aux3) {
		if(aux1 > aux2) {
			return aux2 > aux3 ? aux3 : aux2; 
		}
		return aux1 > aux3 ? aux3 : aux1;
	}

}
