package test;

public class SingleThread {
	public static void singleThread(int[] arr) {
		long start = System.currentTimeMillis();
		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			sum += arr[i];
		}
		long end = System.currentTimeMillis() - start;
		System.out.println("\nTest thread sum: " + sum + "Test thread time: " + end + "ms");
	}
}