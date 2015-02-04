package graph;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

public class Search {

	public void addE(List<Integer>[] g, int s, int e) {
		g[s - 1].add(e - 1);
	}

	public void delE(List<Integer>[] g, int s, int e) {

		Iterator<Integer> it = g[s - 1].iterator();
		while (it.hasNext()) {
			if (it.next() == (e - 1)) {
				System.out.println("Removing " + (s) + " - " + (e));
				it.remove();
			}
		}

	}

	public boolean hasE(List<Integer>[] g, int s, int e) {

		return g[s - 1].contains(e - 1);
	}

	public void outE(List<Integer>[] g, int s) {
		Iterator<Integer> it = g[s - 1].iterator();
		while (it.hasNext()) {
			System.out.println((s) + " - " + (it.next() + 1));
		}
	}

	/*
	 * public void inE(int s) { for ( int i = 0 ; i < g.length ; i ++ ){ if ( s
	 * != (i + 1)){ Iterator<Integer> it = g[i].iterator(); while(
	 * it.hasNext()){ if ( it.next() == (s - 1)){ System.out.println( ( i + 1 )
	 * + " - " + s); } } } } }
	 */

	public void dS(List<Integer>[] g, Stack<Integer> p, int[] marked) {

		// iterate on all adjacent vertices
		Iterator<Integer> it = g[p.pop()].iterator();
		while ( it.hasNext() ){
			int tmp = it.next();
			if ( marked[tmp] != 1){	// if marked as visited ignore
				marked[tmp] = 1;
				p.push(tmp);
				// else call dS to search on that vertex
				System.out.println("-> "+(tmp+1));
				dS(g , p , marked);
			}		
		}
		// if no vertices left return
		return;
	}
	
	
	
	public void BFSn(List<Integer>[] g) {

		// initialize the mark array
		ArrayList<Integer> result = new ArrayList<Integer>();

		// initialize the root array
		int[] marked = new int[g.length];
		for (int i = 0; i < g.length; i++) {
			marked[i] = 0;
		}
		// call dS to search on the first root
		result.add(0);
		marked[0] = 1;
		
		while (result.size() != 0) {
			// iterate on all adjacent vertices
			int temp = result.remove(0);
			Iterator<Integer> it = g[temp].iterator();
			System.out.println("-> " + (temp + 1));
		
			while (it.hasNext()) {
				
				int tmp = it.next();
				if (marked[tmp] != 1) { // if marked as visited ignore
					marked[tmp] = 1;

					result.add(tmp);
					// else call dS to search on that vertex
				}
			}
			
		}
		
		// if no vertices left return
	}
	
	public void DFSn(List<Integer>[] g) {

		// initialize the mark array
		ArrayList<Integer> result = new ArrayList<Integer>();

		// initialize the root array
		int[] marked = new int[g.length];
		for (int i = 0; i < g.length; i++) {
			marked[i] = 0;
		}
		// call dS to search on the first root
		result.add(0);
		marked[0] = 1;
		
		while (result.size() != 0) {
			// iterate on all adjacent vertices
			int temp = result.remove(0);
			Iterator<Integer> it = g[temp].iterator();
			System.out.println("-> " + (temp + 1));

			ArrayList<Integer> tempList = new ArrayList<Integer>();
			ArrayList<Integer> newList = new ArrayList<Integer>();
			
			while (it.hasNext()) {

				tempList = result;
				int tmp = it.next();
				if (marked[tmp] != 1) { // if marked as visited ignore
					marked[tmp] = 1;

					newList.add(tmp);

					// else call dS to search on that vertex
				}
			}
			newList.addAll(tempList);
			result = newList;
		}
		
		// if no vertices left return
	}

	public void DFS(List<Integer>[] g) {

		// initialize the mark array
		Stack<Integer> rStack = new Stack<Integer>();

		// initialize the root array
		int[] marked = new int[g.length];
		for (int i = 0; i < g.length; i++) {
			marked[i] = 0;
		}
		// call dS to search on the first root
		rStack.push(0);
		marked[0] = 1;
		System.out.println(1);
		dS(g , rStack , marked);
	}
	
	public void bS(List<Integer>[] g , ArrayList<Integer> r, int[] marked, int dep){
		
		// iterate through all adjacent vertices

		Iterator<Integer> rit = r.iterator();
		ArrayList<Integer> nr = new ArrayList<Integer>();
		System.out.println("level " + dep + " :");
		while (rit.hasNext()) {
		
			int tmp = rit.next();
			Iterator<Integer> vit = g[tmp].iterator();
			while (vit.hasNext()) {
				int vmp = vit.next();
				if (marked[vmp] != 1) { // if marked ignore
					marked[vmp] = 1;
					System.out.print((vmp + 1) + ",");
					nr.add(vmp); // add all vertices to the adjArray
				}
			}
		}
		System.out.println();
		// if no vertices left, go to the next level
		if (nr.size() > 0)
		bS(g, nr, marked, ++dep);
	}
	
	
	public void BFS(List<Integer>[] g){
		
		//initialize marked array
		int[] marked = new int[g.length];
		for ( int i = 0 ; i < g.length ; i ++ ){
			marked[i] = 0;
		}
		//initialize root array
		ArrayList<Integer> r = new ArrayList<Integer>();
		r.add(0);
		marked[0] = 1;
		//search root vertex
		bS(g, r, marked, 1);
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Search s = new Search();

		/*
		 *             1 - 4 - 5
		 *            / \
		 *           2 - 3 
		 *          /    \ 
		 *          6     8
		 *         /       \
		 *        7		    9
		 */
		// num of vertices 5

		List<Integer>[] g = new List[9];

		for (int i = 0; i < 9; i++) {
			g[i] = new ArrayList<Integer>();
		}
		// vertex 1
		g[0].add(1);
		g[0].add(2);
		g[0].add(3);
		// vertex 2
		g[1].add(0);
		g[1].add(1);
		g[1].add(5);
		// vertex 3
		g[2].add(0);
		g[2].add(1);
		g[2].add(7);		
		// vertex 4
		g[3].add(0);
		g[3].add(4);
		// vertex 5
		g[4].add(3);
		// vertex 6
		g[5].add(1);
		g[5].add(6);	
		// vertex 7
		g[6].add(5);
		// vertex 8
		g[7].add(2);			
		g[7].add(8);		
		// vertex 9
		g[8].add(7);
		System.out.println(s.hasE(g, 3, 4));
		s.addE(g, 3, 4);
		s.outE(g, 3);
		System.out.println(s.hasE(g, 3, 4));
		s.delE(g, 3, 4);
		s.outE(g, 3);
		System.out.println(s.hasE(g, 3, 4));
		s.DFS(g);
		s.DFSn(g);
		s.BFS(g);
		s.BFSn(g);
	}

}
