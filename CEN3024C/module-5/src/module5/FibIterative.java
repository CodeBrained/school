package module5;

public class FibIterative {
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