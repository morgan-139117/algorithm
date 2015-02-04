package sort;
public class Sort{
    
	private int[] cmp;
	private int cap;
	private int indx;

	   public int partition(int s, int e){
		
		if(s == e) return s;	   
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

	public void quick(int s, int e) {
		int p;
		if (s >= e)
			return;
		else
			{p = partition(s, e);
	
			for (int k = s; k <= p; k++) {
				System.out.print(cmp[k]);
			}System.out.println();
			
			quick(s, p);
			
			quick(p + 1, e);
			for (int k = p + 1; k <= e; k++) {
				System.out.print(cmp[k]);
			}
			System.out.println();
		}
		
		for (int k = 0; k < cap; k++) {
			System.out.print(cmp[k]);
		}
		System.out.println();
	}

	public void merge(int s, int e){
    	int mid = 0;
    	if (s == e){
        	return;}
    	else
        	{
            	mid = (s + e)/2;
            	merge(s, mid);
            	merge(mid + 1, e);
            	positive_insertion(s, e);
        	}
     	for(int i = 0; i < cap; i++){
        	System.out.print(cmp[i]);
    	}   System.out.println(); //print out 2^n + 1 n is the height of the tree
	}

	public void insertionf(){
    	int tmp;
   	 
    	for(int i = 0; i < cap - 1; i++){
        	int j = i;
        	tmp = cmp[j];
        	while(j>= 0 && less(cmp[j+1],cmp[j]))
            	exh(j, j+1);
            	j--;
          	 
    	}
     	 
    	for(int i = 0; i < cap; i++){
        	System.out.print(cmp[i]);
    	}
	}
    
	public void shell(){
    	int fact = 5;
    	while(fact > 0){
        	negtive_insertion(fact);
            	System.out.println();
        	fact -=2;
    	}
	}
    
    
	public void negtive_insertion(int fact){
    	int min;
    	for(int i = fact; i < cap; i+=fact){
        	int j = i;
        	for(min = cmp[j]; j >= fact && less(min, cmp[j - fact]); j-=fact){
            	cmp[j] = cmp[j - fact];
        	}
        	cmp[j] = min;
       	 
         	for (int k = 0; k < cap; k++){
            	System.out.print(cmp[k]);
        	}        	System.out.println();
    	}
   	 
	 
	}
    
	public void negtive_insertion(int s, int e){
    	int min;
    	for(int i = 1; i <= e; i ++){
        	int j = i;
        	for(min = cmp[j]; j > 0 && less(min, cmp[j - 1]); j--){// j >=1 make more sense
            	cmp[j] = cmp[j - 1];
        	}
        	cmp[j] = min;
    	}
   	 
  	for (int k = 0; k < cap; k++){
            	System.out.print(cmp[k]);
        	}        	System.out.println();
	}
    
	public void positive_insertion(int s, int e){
    	int min;
    	for(int i = 1; i <= e; i++){
        	int j = i - 1;
        	for(min = cmp[i]; j >= 0 && (cmp[j] > min); j--){
            	cmp[j + 1] = cmp[j];
        	}
        	cmp[j + 1] = min;
       	 
    	}
         	 
	}
    
	public void insertiona(){
    	int tmp;
   	 
    	for(int i = 0; i < cap - 1; i++){
        	int j = i;
        	tmp = cmp[j];
        	while(j>= 0 && less(cmp[j+1],cmp[j]))
            	exh(j, j+1);
            	j--; cmp[j+1] = tmp;
                	for (int k = 0; k < cap; k++){
                        	System.out.print(cmp[k]);
                    	}        	System.out.println();

    	}
     	 
    	 
	}
    
	public void exh(int p, int q){
    	int tmp;
    	tmp = cmp[p];
    	cmp[p] = cmp[q];
    	cmp[q] = tmp;
	}
    
	public void bubble(){
    	//exam on each element to find the last smallest exchange it with the current element and shuffle all the rest to the right
    	for(int i = 0; i < cap - 1; i++)
        	for(int j = i + 1; j > 0; j--)
            	if(less(cmp[j],cmp[j-1]))
                	exh(j, j - 1);
       	 
             	for (int k = 0; k < cap; k++){
        	System.out.print(cmp[k]);
    	}        	System.out.println();

	}
    
	public void bselection(){
    	int max = 0;
    	int counter =0 ;
    	//exam on each element to find the largest put it at the end
    	for (int i = 0; i < cap - 1; i++){
        	max = cap - i - 1;
        	for (int j = cap - i - 1; j >= 0; j--){
            	if(less(cmp[max],cmp[j]))
                	max = j;
                	counter++;
        	}   exh(max,cap - i - 1);
         	for (int k = 0; k < cap; k++){
        	System.out.print(cmp[k]);
    	}        	System.out.println();
    	}
  	 
      	 

        	System.out.println(counter);
	}
    
	public void selection(){
    	//exam on each element to find the smallest to put at the beginning
    	int min;
    	int counter = 0;
    	for (int i = 0; i < cap - 1; i++){
        	min = i;
        	for (int j = i; j < cap; j++){//be VERY careful here, cause it needs go through
        	//the entire array other than cap - 1 like the outer loop does
            	if (less(cmp[j],cmp[min]))   
                	min = j;
                 	counter++;
        	}
            	exh(min,i);
             	for (int k = 0; k < cap; k++){
        	System.out.print(cmp[k]);
    	}        	System.out.println();

    	}
      	 
        	System.out.println(counter);
	}
    
	public void insert(int p){
    	cmp[indx++] = p;
	}
    
	public boolean less(int p, int q){
    	return p < q;
	}
    
	public Sort(int n){
    	cap = n;
    	cmp = new int[cap];
    	indx = 0;
	}
    

	public  static void main(String[] args){
    	Sort s = new Sort(10);
    	s.insert(9);
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
    	
    	s = new Sort(10);
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
    	s.quick(0,9);
    	
    	
    	s = new Sort(10);
    	
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
    	s.quick(0,9);
	}
	
}











