package graph;

import java.util.Iterator;
import java.util.LinkedList;

public class AdjGraph {

	private LinkedList<Integer>[] edges;

	private int[] marked;//一开始犯了个错误，把这个放到DFS里面去了，结果每一层递归一个实例，无限循环
	
	public AdjGraph(int size){
		edges = (LinkedList<Integer>[]) new LinkedList<?>[size];
		for (int i = 0; i < edges.length; i++){
			edges[i] = new LinkedList<Integer>();
		}
	}
	
	public void add(int v, int w){
		edges[v].add(w);
	}
	
	public void show(){
		int j = 0; 
		for (LinkedList<Integer> i : edges){
			Iterator<Integer> it = i.iterator();
			System.out.print(j + ": ");
			while(it.hasNext()){
				System.out.print(it.next()+" ,");
			}
			System.out.println();j++;
		}
	}
	
	public void clearMark(){
		marked =new int[edges.length];
	}
	
	public void DFS(int v){
		marked[v] = 1;
		System.out.println("visit: "+v);
		Iterator<Integer> it = edges[v].iterator();
		while(it.hasNext()){
			int tv = it.next();
			if (marked[tv] != 1){
				DFS(tv);
			}
		}
		System.out.println("done" + v);
		return;
	}
	
	
	//注意marked的时机，避免出现下面情况
	
	/*
	 *       o --o
	 *      / \   \
	 *     o   o  /
	 *      \  \ /
	 *       \- o  第二层多个三个node会同时添加第三层的node，导致它被输出3次。
	 *       		解决办法，不要在输出的时候再mark节点，一定要在加node的时候mark
	 *       同时要注意写好伪代码，用良好的结构，命名简化的分析、思考过程。
	 */
	
	public void BFS(int v){
		marked[v] = 1;
		LinkedList<Integer> tier = new LinkedList<Integer>();
		tier.add(v);
		LinkedList<Integer> nxit;
		do{
			
			nxit = new LinkedList<Integer>();
			Iterator<Integer> itTier = tier.iterator();
			while(itTier.hasNext()){
				int tv = itTier.next();
				System.out.println("visit: " + tv);
				Iterator<Integer> conit = edges[tv].iterator();
				while(conit.hasNext()){
					int nxtv = conit.next();
					if(marked[nxtv] != 1){
						marked[nxtv] = 1;
						nxit.add(nxtv);//很有意思的bug啊，导致4输出3次
					}
						
				}
				
			}
			tier = nxit;
		}while(nxit.size() != 0);
	}
	
	
	public static void main(String[] args){
		
		
		AdjGraph ag = new AdjGraph(7);
		ag.add(0, 1);
		ag.add(0, 2);
		ag.add(0, 5);
		ag.add(0, 6);
		ag.add(3, 4);
		ag.add(3, 5);
		ag.add(4, 5);
		ag.add(4, 6);
		ag.add(5, 0);
		ag.add(5, 3);
		ag.add(5, 4);
		ag.add(6, 0);
		ag.add(6, 4);
		ag.show();
		ag.clearMark();
		ag.DFS(0);
		ag.clearMark();
		ag.BFS(0);
	}
}
