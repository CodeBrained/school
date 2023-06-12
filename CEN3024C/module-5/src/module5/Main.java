package module5;

/**
 * This is the Main class.
 * This class is used to compare the efficiency of recursive and iterative Fibonacci methods. 
 * The class will create objects for iterative and recursive Fibonacci.
 * After the objects are created, they will call the run method that calculates the fibonacci sequence and the time it took to do so. 
 * @author Cristian King
 *
 */
public class Main {
	
	/**
	 *  This is the main method. 
	 *  First the method will create an object of the FibRecursive/FibIterative class
	 *  Then it will call the run method located within its respective class.
	 *  The run method retrieves the Fibonacci sequence to the 20th place and the time it took to calculate each place in the sequence
	 *  
	 * @param args the main method is used to start the program.
	 */
	public static void main(String[] args) {
		FibRecursive recursive = new FibRecursive();
		recursive.run();
		
		FibIterative iterative = new FibIterative();
		iterative.run();

	}
}
