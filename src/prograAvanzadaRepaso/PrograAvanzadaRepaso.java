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
			MST mstPrim = grafoPrimMST.calcularPrim(0);
			System.out.println("PRIM");
			mstPrim.showMST();
			
			MST mstKruskal =  grafoKruskal.calcularKruskal();
			System.out.println("KRUSKAL");
			mstKruskal.showMST();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		grafoFloyd.imprimirMatriz();
		grafoWarshall.imprimirMatriz();		
	}

}
