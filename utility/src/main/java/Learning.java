/**
 * 
 */

/**
 * @author anupam babar
 *
 */
public class Learning {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		int a = 0;
		int b = 1;
		int c = 10;
		int d = 0;
		
		for(int i=0; i<10; i++){
			System.out.println(a);
			d = a;
			a = b;
			b = b + d;
		}
	}
}
