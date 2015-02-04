package queue;

public class PMinQueue {
	
	private int[] pri;
	
	private int size;

	public PMinQueue(int n){
		pri = new int[n];
		for (int i = 0; i < n; i ++){
			pri[i] = 0;
		}
		size = 0;
	}
	
	public boolean less(int p, int q){
		return pri[p] < pri[q];
	}
	
	//select implementation
	public void sinsert(int key){
		pri[size++] = key;
	}
	
	public int max(){
		
		return 0;
	}
	
	public void exch(int p, int q){
		int temp = 0;
		temp = pri[q];
		pri[q] = pri[p];
		pri[p] = temp;
	}
	
	public int reMax(){
		int max = 0;
		for (int i = 0; i < size; i++)
			if (less(max,i)) max = i;
		exch(max,size -1);
		return pri[--size];
	}
	
	public int size(){
		return size;
	}
	
	public boolean isEmpty(){
		return size == 0;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		PMinQueue pq= new PMinQueue(10);
		pq.sinsert(3);
		pq.sinsert(4);
		pq.sinsert(2);
		pq.sinsert(1);
		while(!pq.isEmpty())
			System.out.print(pq.reMax());
	}

}
