package sort;
public class Quick{
    
	private int[] cmp;
	private int cap;
	private int indx;

	   public int partition(int s, int e){
		//revise it sometime
		if(s == e) return s;//pay attention to the stop condition   
    	int p = s;
    	int i = p + 1;
    	int j = e + 1;
    	
    	while(true){
         	 while(i < j && cmp[i] < cmp[p]){
    			if (i == e){
    				exh(e, p);
    				p = e ;
    				return p;
    			}else 
    				i++;
    		}
    		if(i < j) j--;
    		while(i < j && cmp[j] > cmp[p]){
    			if (j == s + 1){
    				return p ;
    			}else
    				j--;
    		}
    		if(i<j)
            	exh(i, j);
        	else
        	{
        		exh(p, i - 1);
        		p = i - 1;
        		return p;
        	}
    	}
	}
	   
	   
	public void triquick(int s,int e){
		
		
	}
	   
	public void quicki(int s, int e){
		if (e <= s) return;
		int i = s - 1;
		int p = e;
		int j = e;
		
		while(true){
			while(cmp[++i] < cmp[p]);
			while(cmp[p] < cmp[--j]) if(j == s) break;
			if(i >= j) break;
			exh(i, j);
		} 
		exh(i, e);
		quicki(s, i - 1);// use i - 1 cause index point to s - 1 for the first element causing the s less then e, so it cloud stop the partition early
		quicki(i + 1, e);// use i + 1 cause index point to e + 1 for the last element causing the s less then e, so it cloud stop the partition early
		
		for (int k = 0; k < cap; k++) {
			System.out.print(cmp[k]);
		}System.out.println();
	}

	public void quick(int s, int e) {
		int p;
		

		for (int k = 0; k < cap; k++) {
			System.out.print(cmp[k]);
		}
		System.out.println();
		if (s >= e) //pay attention to the stop condition 
			return;
		else
			{p = partition(s, e);
		
			quick(s, p);
			
			quick(p + 1, e);
			
		}
		
	
		
	}

	public void exh(int p, int q){
    	int tmp;
    	tmp = cmp[p];
    	cmp[p] = cmp[q];
    	cmp[q] = tmp;
	}
	public void insert(int p){
    	cmp[indx++] = p;
	}
    
	public boolean less(int p, int q){
    	return p < q;
	}
    
	public Quick(int n){
    	cap = n;
    	cmp = new int[cap];
    	indx = 0;
	}
    

	public  static void main(String[] args){
    	Quick s = new Quick(10);
    /*	s.insert(9);
    	s.insert(7);
    	s.insert(5);
    	s.insert(3);
    	s.insert(1);
    	s.insert(0);
    	s.insert(8);
    	s.insert(6);
    	s.insert(4);
    	s.insert(2);
 	//   s.selection();
    	s.quick(0,9);
  	//  s.insertiona();
    	*/
    	s = new Quick(10);
    	s.insert(0);
    	s.insert(1);
    	s.insert(2);
    	s.insert(3);
    	s.insert(4);
    	s.insert(5);
    	s.insert(6);
    	s.insert(7);
    	s.insert(8);
    	s.insert(9);
    	
 	//   s.selection();
    	s.quicki(0,9);
    	
    	
    	s = new Quick(10);
    	
    	s.insert(9);
    	s.insert(8);
    	s.insert(7);
    	s.insert(6);
    	s.insert(5);
    	s.insert(4);
    	s.insert(3);
    	s.insert(2);
    	s.insert(1);
    	s.insert(0);
 	//   s.selection();
    	s.quicki(0,9);
	}
	
}











