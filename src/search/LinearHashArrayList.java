package search;

public class LinearHashArrayList {
	
	private Node[] htable;
	private int capacity;
	private int size;
	
	public LinearHashArrayList(int capacity){
		this.capacity = capacity;
		htable = new Node[capacity];
		this.size = 0;
	}
	
	//return hashcode for indexing
	public int hash(String key){
		return (key.hashCode() & 0x7fffffff) % capacity;
	}
	
	public boolean put(String key, String value){
		int idx = hash(key);
		while(htable[idx] != null && !htable[idx].key().equals("del")){
			if(htable[idx].key().equals(key))
				return false;
			idx = (idx + 1) % capacity;
		}
		htable[idx] = new Node(key,value);
		size++;
		if(size == capacity) resize(); 
		return true;
	}
	
	public boolean delete(String key){
		int idx = hash(key);
		while(htable[idx] != null){
			if(htable[idx].key().equals(key)) {
				htable[idx] = new Node("del","null");
				size--;
				if(size * 4 == capacity) resize();
				return true;
			}
			idx = (idx + 1) % capacity;
		}
		return false;
	}
	
	public boolean contains(String key){
		
		return false;
	}
	
	public String find(String key){
		
		return null;
	}
	
	public void resize(){
		capacity = (size) * 2;
		Node[] tmp = new Node[capacity];
		for(Node n : htable){
			if(n != null && !n.key().equals("del")){
				int idx = hash(n.key());
				while(tmp[idx] != null){
					idx = (idx + 1) % capacity;
				}
				tmp[idx] = n;
			}
		}//当resize不管用的时候第一反应是，看看是不是忘了把临时数组考背回去了
		htable = tmp;
	}
	
	public void show(){
		for(Node n : htable){
			if( n!= null){
				System.out.print(n.toString() + " ");
			}
			else{
				System.out.print("em ");
			}
				
		}System.out.println();
	}
	
	public static void main(String[] args){
		LinearHashArrayList sc = new LinearHashArrayList(4);
		sc.put("newhua", new String("1"));
		sc.show();
		sc.put("huawei", new String("2"));
		sc.show();
		sc.put("haihai", new String("3"));
		sc.show();
		sc.put("haha", new String("4"));
		sc.show();
		sc.put("newhua1", new String("5"));
		sc.show();
		sc.put("huawei1", new String("6"));
		sc.show();
		sc.put("haihai1", new String("7"));
		sc.show();
		sc.put("haha1", new String("8"));
		sc.show();
		sc.delete("haha1");
		sc.show();
		sc.delete("haihai1");
		sc.show();
		sc.delete("huawei1");
		sc.show();
		sc.delete("newhua1");
		sc.show();
		sc.delete("haha");
		sc.show();
		sc.delete("haihai");
		sc.show();
		sc.delete("huawei");
		sc.show();
		sc.delete("newhua");
		sc.show();
		sc.put("haha", new String("hahah"));
		sc.show();
	}
}
