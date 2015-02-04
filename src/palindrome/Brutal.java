package palindrome;

public class Brutal {

	
	static char[] str;
	
	

	public static void outPalin(int a, int b){

		for ( int n = b - 1, i = a ; i <= n/2 ; i++ ){
			System.out.println(str[i] +"<>" + str[n - i]);
		}
		
	}
	
	public static boolean isPalin(int a, int b){

		for ( int n = b - 1, i = a ; i <= n/2 ; i++ ){
			if ( str[i] != str [n - i])
				return false;
		}
		return true;
	}
	
	public static void print(int a, int b){
		
		for (int i = a; i <= b ; i ++){
			System.out.print(str[i]);
		}
		System.out.print(",");

	}
		
	public static void main(String[] args) {
		
		
		    str = new String("abcdef").toCharArray();
			for ( int i = 0 ; i <= str.length - 1; i++ ){
				for ( int n = str.length - 1; n >= i ; n --){
					print(i,n);
				}
				System.out.println();
			}
			
			
				System.out.println();
				System.out.println();
				
		    
	}

}
