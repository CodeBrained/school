package application;

// get number from user
// prime algorithm
//

import java.util.Scanner;

public class Prime {
	
	public static void checkPrime(int num) {
		int i = 2;
		boolean isPrime = isPrime(num,i);
		if (!isPrime) {
			System.out.println(num + " is not a prime number");
		}
		else {
			System.out.println(num + " is a prime number");
		}
	}

	
	public static boolean isPrime(int num, int i) {
		boolean isPrime = true;
		while (i <= num / 2) {
			if (num % i == 0) {
				isPrime = false;
				break;
			}
			++i;
		}
		return isPrime;
	}
	
}