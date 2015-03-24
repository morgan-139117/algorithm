package search;

import java.util.Iterator;
import java.util.LinkedList;

public class SeperateChaining {

	private int n;
	private LinkedList<Integer>[] htable;
	private int m;
	
	public int hash(Integer key){
		return key.hashCode() % m;
	}
	
	public SeperateChaining(int m){
		this.m = m;
		htable = (LinkedList<Integer>[]) new LinkedList<?>[m];
	}
	//return the value associated with the hashkey
	public int value(int key){
		for (int i = 0; i < htable.length; i++){
			if (htable[i].contains(key));
			return htable[i].get(key);
		}
		return 0;
	}
	
	public boolean put(int key, int value){ 
		if(contains(key)) return false;
		if(htable[hash(key)] != null){
			htable[hash(key)].add(value);//why always forget to close the if-else condition
		}else{
			htable[hash(key)] = new LinkedList<Integer>();
			htable[hash(key)].add(value);
		}
			
		display();
		return true;
	}
	
	public boolean delete(int key){
		
		Iterator<Integer> it = htable[hash(key)].iterator();
			
		while (it.hasNext()){
			if (it.next().equals(key))
			it.remove();
			display();
			return true;
		}
		return false;
	}
	
	public boolean contains(int key){
		if(htable[hash(key)] != null)
		for(Integer i: htable[hash(key)])
			if (i.equals(key))
				return true;
		return false;
	}
	
	public void display(){
		Iterator<Integer> it;
		for(int i = 0; i < htable.length; i++){
			if (htable[i] == null) continue;
			it = htable[i].iterator();
			System.out.println("hlist" + i);

			while(it.hasNext())
				System.out.print(it.next()+" ");
			System.out.println();
		}
	}
	
	public static void main(String[] args){
		SeperateChaining sc = new SeperateChaining(4);
		sc.put(1, 199);
		sc.put(2, 299);
		sc.put(3, 399);
		sc.put(4, 499);
		
		sc.put(5, 119);
		sc.put(6, 219);
		sc.put(7, 319);
		sc.put(8, 419);
		
		
	}
}
