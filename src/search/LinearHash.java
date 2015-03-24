package search;
public class LinearHash {
	
	private int m;
	private int c;
	private Node[] htable;
	
	public int hash(String key){
		System.out.println((key.hashCode() & 0x7fffffff) % c);
		return (key.hashCode() & 0x7fffffff) % (c );
	}
	
	public LinearHash(int c){
		this.m = 0;
		this.c = c;
		htable = new Node[c];
	}
	
	public void resize(){
		c = m * 2;
		Node[] tmp = new Node[c];
		for(int i = 0; i < htable.length; i++){
			if (htable[i] != null && !htable[i].key().equals("del")){
				Node n = htable[i];
				int ct = hash(htable[i].key());
				while(tmp[ct]!=null)
					ct = (ct + 1) % c;
				tmp[ct] = n;
			}
		}
		htable = tmp;
	}
	
	public boolean put(String key, String value){
		int ct;
		for(ct = hash(key); (htable[ct]) != null && !htable[ct].key().equals("del"); ct = (ct + 1) % c )
		{//a fast way to judge how many right Brackets do you need,  just first count the left most, then count how many 
			//brackets in the middle 
			if(((Node)htable[ct]).key().equals(key)) {
				System.out.println("exist");
				return false;
	
			}		}
		//if(ct == htable.length) resize();
		htable[ct] = new Node(key,value);
		m++;
		if(m == c){
			resize();
		}
		return true;
	}
	
	public boolean delete(String key){
		int ct = hash(key);
		while(htable[ct] != null)
		{
			if(htable[ct].key().equals(key)){
				htable[ct] = new Node("del","null");
				m--;
				if(m * 4 == c) resize();
				return true;
			}
			ct = (ct + 1) % (c); 
		}
		return false;
	}
	
	public String value(String key){
		int ct = hash(key);
		while(htable[ct]!=null){
			if(((Node)htable[ct]).key().equals(key)){
				return ((Node)htable[ct]).toString();
			}
		}
		return null;
	}
	
	public void show(){
		for (Node n: htable){
			if(n != null)
			System.out.print(n.toString()+" ");
			else
				System.out.print("empty,");

		}
		System.out.println();
	}
	
	public boolean contains(String key){
		
		return false;
	}

	public static void main(String[] args){
		LinearHash sc = new LinearHash(4);
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
