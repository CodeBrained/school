package module8;

public class SingleThread {
	public static void arraySum(int[] arr) {
		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			sum += arr[i];
		}
		System.out.println("\nThe sum of the Array is " + sum);
	}
}