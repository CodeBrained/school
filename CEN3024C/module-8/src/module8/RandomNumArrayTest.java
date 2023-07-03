package module8;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class RandomNumArrayTest {

	// In order to determine that the array is the correct size and filled with random numbers, I can run this unit test multiple times. 
	// Every time the numbers should be different, and this is much easier to check with a small array of 4.
	@Test
	void randomNumArrayTest() {
		int[] arr = RandomNumArray.randomNumArray(4);
		
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
		if (arr.length > 4) {
			fail("The array is longer than 4");
		}
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] > 10 || arr[i] < 0) {
				fail("The value of this element" + arr[i] + "is out of range");
			}
		}
	}
}