package graph;

public class UnionFind {
	
	private int[] uni;
	
	private int size;
	
	private int[] wei;

	
	public UnionFind(int n) {
		uni = new int[n];
		wei = new int[n];
		size = n;
		for (int i = 0; i < n; i++) {
			uni[i] = i;
			wei[i] = 1;
		}
	}
	
	public int wroot (int p){
		while (uni[p] != p) p = uni[p];
		return p;
	}
	
	public boolean wfind(int p, int q){
		return wroot(p) == wroot(q);
	}
	
	
	/*
	 * Weighted-Q-Union
	 * 
	 * 0: 
	 *    0  1  2  3  4  5  6  7  8  9  
	 * 1: union(4,3)			            [4]->3     4-3
	 *    0  1  2  3  3  5  6  7  8  9  	
	 * 2: union(3,8)			        	[3]->8	  4-3-8
	 *    0  1  2  8  3  5  6  7  8  9  	
	 * 3: union(6,5)                    	[6]->5     6-5
	 *    0  1  2  8  3  5  5  7  8  9  
	 * 4: union(9,4)                    	[9]->4    4-3-8
	 *    0  1  2  8  3  5  5  7  8  8 					9/
	 * 5: union(2,1)                    	[2]->1     2-1
	 *    0  1  1  8  3  5  5  7  8  8  			   
	 * 6: union(5,0)                    	[5]->0     6-5-0
	 *    0  1  1  8  3  0  5  7  8  8 						\
	 * 7: union(7,2)                    	[7]->1         2-1
	 *    0  1  1  8  3  0  5  1  8  8  				    /
	 * 8: union(6,1)                    	[6]->1     	   7
	 *    0  1  1  8  3  0  1  1  8  8   
	 */	
	
	public void wqunion(int p, int q) {
		
		if (!wfind(p,q)){                
			int pr = wroot(p);
			int qr = wroot(q);
			if (wei[pr] < wei[qr]){
				uni[pr] = qr;
				wei[qr] = wei[pr] + wei[qr];
			}
			else{
				uni[qr] = pr;
				wei[pr] = wei[qr] + wei[pr];
			}
			
		}		
			for (int i = 0; i < size; i++) {
				System.out.print(uni[i]);
			}
			System.out.print("        ");
			for (int i = 0; i < size; i++) {
				System.out.print(wei[i]);
			}
		    System.out.println();
	}
	
	
	
	/* Quick-Union
	 * 0: 
	 *    0  1  2  3  4  5  6  7  8  9  
	 * 1: union(4,3)			            [4]->3     4-3
	 *    0  1  2  3  3  5  6  7  8  9  	
	 * 2: union(3,8)			        	[3]->8	  4-3-8
	 *    0  1  2  8  3  5  6  7  8  9  	
	 * 3: union(6,5)                    	[6]->5     6-5
	 *    0  1  2  8  3  5  5  7  8  9  
	 * 4: union(9,4)                    	[9]->4    4-3-8
	 *    0  1  2  8  3  5  5  7  8  8 					9/
	 * 5: union(2,1)                    	[2]->1     2-1
	 *    0  1  1  8  3  5  5  7  8  8  			   
	 * 6: union(5,0)                    	[5]->0     6-5-0
	 *    0  1  1  8  3  0  5  7  8  8 						\
	 * 7: union(7,2)                    	[7]->1         2-1
	 *    0  1  1  8  3  0  5  1  8  8  				    /
	 * 8: union(6,1)                    	[6]->1     	   7
	 *    0  1  1  8  3  0  1  1  8  8   
	 */	
	
	public int root(int p){
		if(uni[uni[p]]!=uni[p]) root(uni[p]);
		return uni[uni[p]];
	}
	
	public boolean qconnected(int p, int q){
		return root(p) == root (q);
	}

	public void qunion(int p, int q) {
		
		if (!qconnected(p,q)){
			int pr = root(p);
			int qr = root(q);
			uni[pr] = qr;
		}		
			for (int i = 0; i < size; i++) {
				System.out.print(uni[i]);
			}
		System.out.println();
	}
	
	/* Quick-Find
	 * 0: 
	 *    0  1  2  3  4  5  6  7  8  9 
	 * 1: union(0,5)
	 *    0  1  2  3  4  0  6  7  8  9
	 * 2: union(5,6)
	 *    0  1  2  3  4  0  0  7  8  9
	 * 3: union(1,2)
	 * 	  0  1  1  3  4  0  0  7  8  9
	 * 4: union(2,7)
	 * 	  0  1  1  3  4  0  0  1  8  9
	 * 5: union(3,8)
	 *    0  1  1  3  4  0  0  1  3  9
	 * 6: union(3,4)
	 *    0  1  1  3  3  0  0  1  3  9
	 * 7: union(4,9)
	 *    0  1  1  3  3  0  0  1  3  3
	 */
	
	public void qfind(int p, int q) {
		// Big Mistake!!
		// Remember to Store the Variable First
		// StupidMistake!
		// Declare outside the loop;
		int vq = uni[q];
		int vp = uni[p];

		for (int i = 0; i < size; i++) {

			if (uni[i] == vq)
				uni[i] = vp;
		}

		for (int i = 0; i < size; i++) {
			System.out.print(uni[i]);
		}
		System.out.println();
	}
	
	public boolean fconnected(int p, int q){
		return uni[p] == uni[q] ;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*
		 *  0   1 - 2  3 - 4
		 *  |       |  |   |
		 *  5 - 6   7  8   9
		 */
		
	
		UnionFind uf = new UnionFind(10);
		uf.wqunion(4,3);	
		uf.wqunion(3,8);	
		uf.wqunion(6,5);  
		uf.wqunion(9,4);  
		uf.wqunion(2,1);  
		uf.wqunion(5,0);  
		uf.wqunion(7,2);  
		uf.wqunion(6,1);  

		
		
	}

}
