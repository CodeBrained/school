package module8;

import java.util.concurrent.ThreadLocalRandom;

public class RandomNumArray {
	
	public static int getRandomValue(int Min, int Max) {
		return ThreadLocalRandom
				.current().nextInt(Min, Max + 1);
	}
	
	public static int[] randomNumArray(int n) {
		
		int min = 1, max = 10;
		int[] arr = new int[n];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = getRandomValue(min, max);
			System.out.println(arr[i]);
		}
		return arr;
	}
}
