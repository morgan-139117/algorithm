package search;

import java.util.Iterator;
import java.util.LinkedList;

class Node{
	private String key;
	private Object value;
	
	public String toString(){
		return key +","+ value.toString();
	}
	
	public Node(String key, Object value){
		this.key = key;
		this.value = value;
	}
	
	public String key(){
		return key;
	}
	
}

public class SeperateChainingPair {
	/*
	private int n;
	private int m;
	private LinkedList<Node>[] htable;
	
	public SeperateChainingPair(int m){
		this.m = m;
		htable = (LinkedList<Node>[]) new LinkedList<?>[m];
	}
	
	public int hash(String key){
		return (key.hashCode()& 0x7fffffff) % m;
	}
	
	public Object find(String key){
		
		return null;
	}
	
	public boolean contains(String key){
		if(htable[hash(key)] != null) {
			Iterator<Node> it = htable[hash(key)].iterator();
			while(it.hasNext()){
				if(((Node)it.next()).key().equals(key))
					return true;
			}
		}
		return false;
	}
	
	public boolean put(String key, Object value){
		if(contains(key)) return false;
		if(htable[hash(key)] != null) {
			htable[hash(key)].add(new Node(key,value));
		}else{
			htable[hash(key)] = new LinkedList<Node>();
			htable[hash(key)].add(new Node(key,value));
		}
		return true;
	}
	
	public boolean delete(String key){
		if(htable[hash(key)] == null) return false;
		Iterator<Node> it = htable[hash(key)].iterator();
		while(it.hasNext()){
			if (((Node)it.next()).key().equals(key))
				it.remove();
			return true;
		}
		return false;
	}
	
	public void show(){

		Iterator<Node> it;
		for(int i = 0; i < htable.length; i++){
			if (htable[i] == null) continue;
			it = htable[i].iterator();
			System.out.println("hlist" + i);

			while(it.hasNext())
				System.out.print(((Node)it.next()).toString()+" ");
			System.out.println();
		}
	}
	*/


	private int m;
	private LinkedList<Node>[] htable;
	
	public boolean contains(String key){
		return false;
	}
	
	public int hash(String key){
		return (key.hashCode() & 0x7fffffff) % m;
	}
	
	public boolean put(String key, String value){
		if(contains(key)) return false;
		if(htable[hash(key)] != null)
		{
			 htable[hash(key)].add(new Node(key,value));
		}
		else{
			htable[hash(key)] = new LinkedList<Node>();
			htable[hash(key)].add(new Node(key,value));
		}
		return true;
	}
	
	public String value(String key){
		if(htable[hash(key)] != null){
			Iterator<Node> it = htable[hash(key)].iterator();
			while(it.hasNext()){
				if(((Node)it.next()).key().equals(key))
					return it.toString();
			}
		}	
		return null;
	}
	
	public SeperateChainingPair(int m){
		this.m = m;
		htable = (LinkedList<Node>[]) new LinkedList<?>[m];
	}
	
	public boolean delete(String key){
		
		if(htable[hash(key)] != null){
			Iterator<Node> it = htable[hash(key)].iterator();
			while(it.hasNext())
			{
				if(((Node)it.next()).key().equals(key))
					it.remove();
				return true;
			}
		} 
		return false;
	}
	
	public void show(){
		for(LinkedList<Node> l : htable){
			if(l != null){
				Iterator<Node> it = l.iterator();
				while(it.hasNext()){
					System.out.print(((Node)it.next()).toString());
				}	
				System.out.println();
			}
		}
		System.out.println("=============");
	}

	public static void main(String[] args){
		SeperateChainingPair sc = new SeperateChainingPair(4);
		sc.put("newhua", new String("newhuahua"));
		sc.put("huawei", new String("huaweiwei"));
		sc.put("haihai", new String("haihaihai"));
		sc.put("haha", new String("hahah"));
		sc.put("newhua1", new String("newhuahua2"));
		sc.put("huawei1", new String("huaweiwei2"));
		sc.put("haihai1", new String("haihaihai2"));
		sc.put("haha1", new String("hahah2"));
		sc.show();
		sc.delete("haha");
		sc.show();
		sc.delete("huawei1");
		sc.show();
		sc.put("haha", new String("hahah"));
		sc.show();
	}
}
