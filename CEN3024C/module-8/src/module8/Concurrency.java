package module8;
/* Cristian King - CEN3024C Software Development 1
 * Implement a parallel array sum, and compare performance with single thread sum.
 * Make an array of 200 million random numbers between 1 and 10.
 * Compute the sum in parallel using multiple threads.
 * Compute the sum with only one thread
 * Display the sum and times for both cases
 */

public class Concurrency {
	private static int sum = 0;
	public static int sumSingleThread = 0;
	
	public static synchronized void sum(int n) {
		sum += n;
	}
	
	public static void sumSingleThread(int n) {
		sumSingleThread += n;
	}

	public static void main(String[] args) {
		//This statement returns a random array of the chosen size.
		int[] arr = RandomNumArray.randomNumArray(200000000);
		
		// This thread will iterate through the first half of the array
		Thread t1 = new Thread (new Runnable() {
			
			@Override
			public void run() {
				for (int i = 0; i < (arr.length / 2); i++) {
					sum(arr[i]);
				}
			}
		});
		
		// This thread will iterate through the second half of the array
		Thread t2 = new Thread (new Runnable() {
			
			@Override
			public void run() {
				for (int i = arr.length / 2; i < arr.length; i++) {
					sum(arr[i]);
				}
			}
		});
		
		// This thread will use single threading to compute the sum.
		Thread t3 = new Thread (new Runnable() {
			
			@Override
			public void run() {
				for (int i = 0; i < (arr.length); i++) {
					sumSingleThread(arr[i]);
				}
			}
		});
		
		// Creates a variable to store the start time of the multithreaded process
		long startMultiThread = System.currentTimeMillis();
		
		// Begins the multithreaded process
		t1.start();
		t2.start();
		
		try {
			t1.join();
			t2.join();
		} catch(InterruptedException e) {
			e.printStackTrace();
		}
		
		// Creates a variable to store the total time of the multithreaded process
		long endMultiThread = System.currentTimeMillis() - startMultiThread;
		
		System.out.println("Multithread sum: " + sum + "\n" + "Multithread time: " + endMultiThread + "ms");
		
		// Creates a variable to store the starting time of the single threaded process
		long startSingleThread = System.currentTimeMillis();
		
		// Begins the single thread process
		t3.start();
		
		try {
			t3.join();
		} catch(InterruptedException e) {
			e.printStackTrace();
		}
		long endSingleThread = System.currentTimeMillis() - startSingleThread;
		
		System.out.println("Single thread sum: " + sumSingleThread + "\n" + "Single thread time: " + endSingleThread + "ms");
		
	}
	
}