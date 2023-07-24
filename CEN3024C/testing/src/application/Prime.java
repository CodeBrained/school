package application;

// get number from user
// prime algorithm
//



public class Prime {
	
	public static int checkPrime(int num) {
		int i = 2;
		int endNum;
		
		boolean isPrime = isPrime(num,i);
		if (!isPrime) {
			endNum = 1;
		}
		else {
			endNum = 2;
		}
		return endNum;
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