package application;

// get number from user
// prime algorithm
//



public class Prime {
	
	public static String checkPrime(int num) {
		int i = 2;
		String text = new String();
		
		boolean isPrime = isPrime(num,i);
		if (!isPrime) {
			//System.out.println(num + " is not a prime number");
			text = (" is not a prime number");
		}
		else {
			//System.out.println(num + " is a prime number");
			text = (" is a prime number");
		}
		return text;
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