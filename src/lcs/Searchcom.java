package lcs;

public class Searchcom {

	public void subs(String s1) {

		char[] t1 = s1.toCharArray();

		for (int i = 0; i <= t1.length - 1; i++) {
			for (int j = t1.length - 1; j >= 0; j--) {
				for (int m = i; m <= j; m++)
					System.out.print(t1[m]);
				System.out.println();
				
			}
			System.out.println();
		}
	}

	public void search(String s1, String s2) {

		char[] t1 = s1.toCharArray();
		char[] t2 = s2.toCharArray();
		int maxl = 0;

		for (int i = 0; i <= t1.length - 1; i++)
			// length - 1 is the ending index,
			// the cursor can travel to the ending index
			for (int j = 0; j <= t2.length - 1; j++)
				if (t1[i] == t2[j]) {
					{
						maxl = 1;// k means the
						for (int k = 1; k + i <= t1.length - 1
								&& k + j <= t2.length - 1; k++)
							if (t1[i + k] == t2[j + k]) {
								maxl += 1;// k means the
							} else
								break;

					}
					System.out.println("max common:" + (maxl));
					int h, t;

					h = i;
					t = i + maxl - 1;

					for (int m = h; m <= t; m++)
						System.out.print(t1[m]);
					System.out.println();
				}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Searchcom c = new Searchcom();
		// c.search("abcde", "abcde");
		
		String a;
		
		c.subs("fabcde");
	}

}
