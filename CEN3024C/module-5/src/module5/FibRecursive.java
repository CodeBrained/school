package module5;

public class FibRecursive {
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
		for (int i = 0; i <= 20; i++) {
			long startTime = System.nanoTime();
			int answer = fibonacci(i);
			long time = System.nanoTime() - startTime;
			System.out.println("n:" + answer + " in " + time + " ns");
		}
	}
}