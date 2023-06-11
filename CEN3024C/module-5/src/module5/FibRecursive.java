package module5;

public class FibRecursive extends Thread {
	public static int fibonacci(int n) {
		if (n == 0) {
			return 0;
		}
		else if (n == 1) {
			return 1;
		}
		return fibonacci(n - 1) + fibonacci(n - 2);
	}
	
	public void run() {		
		System.out.println("Recursion");
		for (int i = 0; i <= 15; i++) {
			long time = System.nanoTime();
			int answer = fibonacci(i);
			time = System.nanoTime() - time;
			System.out.println("n:" + answer + " in " + time + " ns");
		}
	}
	
/*	public void run() {
		long time = System.nanoTime();
		int answer = fibonacci(10);
		time = System.nanoTime() - time;
		System.out.println("Recursion: " + answer + " in " + time + " ns");
	} */
}
