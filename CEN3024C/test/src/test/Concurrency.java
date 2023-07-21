package test;

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
		int[] arr1 = new int[arr.length / 2];
		int[] arr2 = new int[arr.length / 2];
		
		for(int i = 0; i < arr1.length; i++) {
			arr1[i] = arr[i];
		}
		
		int j = 0;
		for(int i = 0; i < arr2.length; i++) {
			arr2[i] = arr[i + arr2.length];
		}
		
		// This thread will iterate through the first half of the array
		Thread t1 = new Thread (new Runnable() {
			
			@Override
			public void run() {
				for (int i = 0; i < (arr.length / 2); i++) {
					sum(arr1[i]);
				}
			}
		});
		
		// This thread will iterate through the second half of the array
		Thread t2 = new Thread (new Runnable() {
			
			@Override
			public void run() {
				for (int i = 0; i < arr2.length; i++) {
					sum(arr2[i]);
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
		
		System.out.println("Multithread sum:   " + sum + "\n" + "Multithread time:  " + endMultiThread + "ms");
		
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