package cop2805;
import java.util.*;

public class HW6 {

	public static void main(String[] args) {
		//obtaining n and printing n to console
		System.out.println("Enter n:");
		Scanner scan = new Scanner(System.in);
		Integer n = scan.nextInt();
		System.out.println("n = " + n);	
		
		//creating a list to hold the factors of n
		ArrayList<Integer> fl = new ArrayList<Integer>();
		//calling returnFactors
		fl = returnFactors(n);
		//printing factors list
		System.out.print("Factors: ");
		HW6.printList(fl);	
		
		//creating a list to hold the smallest factors of n
		ArrayList<Integer> sfl = new ArrayList<Integer>();
		//calling returnSmallestFactors
		sfl = returnSmallestFactors(fl, n);
		//printing smallest factors list
		System.out.print("\nSmallest Factors: ");
		HW6.printList(sfl);
		
		//closing scanner resource
		scan.close();
	}
	
	//method that returns an ArrayList of factors of n
	public static ArrayList<Integer> returnFactors(int n) {
		int number = n;
		ArrayList<Integer> list = new ArrayList<Integer>();
		for(int i = 1; i <= number; i++) {
			if(number % i == 0) {
				list.add(i);
			}
		}
		return list;
	}
	
	//method that returns an ArrayList of smallest factors of n
	public static ArrayList<Integer> returnSmallestFactors(ArrayList<Integer> fl, int n) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		//psuedocode translated
		boolean nextDivFound;
		while (n != 1) {
			int i = 1;
			nextDivFound = false;
			while(nextDivFound == false) {
				if (n % fl.get(i) == 0) {
					nextDivFound = true;
					list.add(fl.get(i));
					n = n / fl.get(i);
				}
				else i++;
			}
		}
		return list;
	}
	
	//method that prints lists to keep the main method clean
	public static void printList(ArrayList<Integer> list) {
		ArrayList<Integer> thisList = new ArrayList<Integer>(list);
		for (int i = 0; i < thisList.size(); i++)
			System.out.print(thisList.get(i) + " ");
	}
}