package FinalWork;

public class Searching<T> {

	public static void main(String[] args) {
		
	}
	
	
	// Iterative Sequential Search of an Unsorted Array (baştan-sona sırayla)
	public static <T> boolean inArrayIt(T[] anArray, T anEntry) {
		boolean found = false;
		int index = 0;
		while(!found && (index<anArray.length)) {
			if(anEntry.equals(anArray[index]))
				found = true;
			index++;
		}
		return found;
	}
	
	// Recursive Sequential Search of an Unsorted Array (baştan-sona sırayla)
	public static <T> boolean inArrayRec(T[] anArray, T anEntry) {
		return search(anArray, 0, anArray.length -1, anEntry);
	}
	
	private static <T> boolean search(T[] anArray, int first, int last, T desiredItem) {
		boolean found = false;
		if(first > last)
			found = false;
		else if (desiredItem.equals(anArray[first]))
			found = true;
		else
			found = search(anArray, first +1, last, desiredItem);
		return found;
	}
	
	//Binary Search of a Sorted Array (yarısına bölüp arama)
	public static <T extends Comparable <? super T>> boolean binarySearch(T[] anArray, int first, int last, T desiredItem) {
		boolean found;
		int mid = first + (last-first) /2;
		if(first > last)
			found = false;
		else if(desiredItem.equals(anArray[mid]))
			found= true;
		else if(desiredItem.compareTo(anArray[mid]) < 0)
			found = binarySearch(anArray, first, mid-1, desiredItem);
		else
			found = binarySearch(anArray, mid+1, last, desiredItem);
		return found;
		
	}
	
	
	

}
