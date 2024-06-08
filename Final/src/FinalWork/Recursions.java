package FinalWork;

public class Recursions {

	public static void main(String[] args) {
		
		countDown(5);
		int aSum = sumOf(9);
		System.out.println("--------");
		System.out.println(aSum);
		fibonocci(10);
		
		
		

	}
	
	//Also tail recursion
	public static void countDown(int integer) {
		System.out.println(integer);
		
		if(integer > 1)
			countDown(integer - 1);
	}
	
	public static int sumOf(int n) {
		int sum;
		if(n==1)
			sum = 1;
		else
			sum = n + sumOf(n -1);
		return sum;
	}
	
	//starting with array[fist]
	public static void displayArrayFirst(int array[], int first, int last) {
		System.out.println(array[first] + " ");
		if(first < last)
			displayArrayFirst(array, first + 1, last);
	}
	
	//starting with array[last]
	public static void displayArrayLast(int array[], int first, int last) {
		if(first <= last) {
			displayArrayLast(array, first, last -1);
			System.out.println();
		}
	}
	
	//processing array from middle
	public static void displayArrayMid(int array[], int first, int last) {
		if(first == last)
			System.out.println(array[first] +  " ");
		else {
			int mid = (first + last)/2;
			displayArrayMid(array, first, mid);
			displayArrayMid(array, mid + 1, last);
		}
	}
	
	//ADT display
	public static void display() {
		int numberOfEntries =  5; //assume
		displayBag(0, numberOfEntries - 1);
	}
	
	@SuppressWarnings("null")
	private static void displayBag(int first, int last) {
		int bag[] = null; //assume
		System.out.println(bag[first]);
		if(first < last)
			displayBag(first + 1, last);
	}
	
	private static int fibonocci(int n) {
		int result = 0;
		if(n <= 1)
			return 1;
		else
			result = fibonocci(n-1) + fibonocci(n-2);
		return result;
	}

}
