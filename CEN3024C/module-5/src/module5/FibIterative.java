package module5;

/**
 * This class will go through the Fibonacci sequence up to the 21st position using an iterative approach.
 * @author Cristian King
 *
 */
public class FibIterative {
	
	/**
	 * This method is used to implement the Fibonacci sequence in an iterative manner.
	 * @param n n is the current position of the Fibonacci sequence. This is received from the run() method. 
	 * @return Returns the value for the current position(n) in the fibonacci sequence.
	 */
	public static int fibonacci(int n) {
		int v1 = 0, v2 = 1, v3 = 0;
		if (n == 0) return 0;
		if (n == 1) return 1;
		for(int i = 2; i <= n; i++) {
			v3 = v1 + v2;
			v1 = v2;
			v2 = v3;
		}
		return v3;
	}
	
	/**
	 * This method is used to run the program.
	 * After this method is called in the Main class, the program will calculate the value of the Fibonacci sequence at the nth position.
	 * This method also displays the time it took to calculate the position for the nth position. 
	 * This method does not return a value. It is used to calculate and print the desired Fibonacci information. 
	 */
	public void run() {		
		System.out.println("\nIteration");
		for (int i = 0; i <= 20; i++) {
			long startTime = System.nanoTime();
			int answer = fibonacci(i);
			long time = System.nanoTime() - startTime;
			System.out.println("n:" + answer + " in " + time + " ns");
		}
	}
}