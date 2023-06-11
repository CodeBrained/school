package module5;

public class FibIterative extends Thread {
	public static int fibonacci(int n) {
		int num1, num2 = 0, numCurrent = 1;
		
		for (int i = 1; i < n ; i++) {
			num1 = num2;
			num2 = numCurrent;
			numCurrent = num1 + num2;
		}
		return numCurrent;
	}
	
	public void run() {		
		System.out.println("Iteration");
		for (int i = 0; i <= 15; i++) {
			long time = System.nanoTime();
			int answer = fibonacci(i);
			time = System.nanoTime() - time;
			System.out.println("n:" + answer + " in " + time + " ns");
		}
	}
}
