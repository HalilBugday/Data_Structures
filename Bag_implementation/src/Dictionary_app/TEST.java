package Dictionary_app;

public class TEST {

	public static void main(String[] args) {
		
		
System.out.println(" @@@@@@@@@ BAG TEST @@@@@@@@@ ");
System.out.println(" @@@@@@@@@ BAG TEST @@@@@@@@@ ");
System.out.println(" @@@@@@@@@ BAG TEST @@@@@@@@@ ");
System.out.println(" @@@@@@@@@ BAG TEST @@@@@@@@@ ");
		
		
		Bag<Integer> bag = new Bag<>(2);
		System.out.println("Bag'in şu anki boyutu " + bag.getCurrentSize());
		System.out.println("Bag dolumu: "+ bag.isFull());
		System.out.println("Bag boşmu: "+ bag.isEmpty());
		System.out.println("Bag kapasite: "+bag.getBagSize());
		System.out.println("----------------------------------------------------");
		bag.add(1);
		System.out.println("Bag'in şu anki boyutu " + bag.getCurrentSize());
		System.out.println("Bag dolumu: "+ bag.isFull());
		System.out.println("Bag boşmu: "+ bag.isEmpty());
		System.out.println("Bag kapasite: "+bag.getBagSize());
		System.out.println("----------------------------------------------------");
		
		bag.add(2);
		System.out.println("Bag'in şu anki boyutu " + bag.getCurrentSize());
		System.out.println("Bag dolumu: "+ bag.isFull());
		System.out.println("Bag boşmu: "+ bag.isEmpty());
		System.out.println("Bag kapasite: "+bag.getBagSize());
		System.out.println("----------------------------------------------------");
		
		bag.add(3);
		System.out.println("Bag'in şu anki boyutu " + bag.getCurrentSize());
		System.out.println("Bag dolumu: "+ bag.isFull());
		System.out.println("Bag boşmu: "+ bag.isEmpty());
		System.out.println("Bag kapasite: "+bag.getBagSize());
		System.out.println("----------------------------------------------------");
		
		bag.add(4);
		System.out.println("Bag'in şu anki boyutu " + bag.getCurrentSize());
		System.out.println("Bag dolumu: "+ bag.isFull());
		System.out.println("Bag boşmu: "+ bag.isEmpty());
		System.out.println("Bag kapasite: "+bag.getBagSize());
		System.out.println("----------------------------------------------------");
		
		bag.add(4);
		System.out.println("Bag'in şu anki boyutu " + bag.getCurrentSize());
		System.out.println("Bag dolumu: "+ bag.isFull());
		System.out.println("Bag boşmu: "+ bag.isEmpty());
		System.out.println("Bag kapasite: "+bag.getBagSize());
		System.out.println("----------------------------------------------------");
		
		
		System.out.println("display items:");
		bag.displayItems();
		System.out.println("frequency of 4: " + bag.getFrequencyOf(4));
		System.out.println("frequency of 8: " + bag.getFrequencyOf(8));
		System.out.println("get index 1: "+bag.getIndexOf(1)); //1in indexi 0
		System.out.println("bag contains 2: " + bag.contains(2));
		System.out.println("bag contains 7: " + bag.contains(7));  

		System.out.println("----------------------------------------------------");
		
		bag.remove(); //remove last item
		System.out.println("last item removed: ");
		bag.displayItems();
		
		System.out.println("----------------------------------------------------");
		bag.removeByIndex(0);
		System.out.println("sıfırdaki index removed: ");
		bag.displayItems();
		
		System.out.println("----------------------------------------------------");
		bag.remove(3); //
		System.out.println("üç değerli removed: ");
		bag.displayItems();
		
		System.out.println("----------------------------------------------------");
		System.out.println("to Array: "+ bag.toArray());
		
		bag.clear();
		System.out.println("bag cleared: is bag empty: "+bag.isEmpty());
		

		System.out.println("----------------------------------------------------");
		System.out.println("toArray method test");
		Bag<String> bagStr = new Bag<>(4);
		
		bagStr.add("halil");
		bagStr.add("lil");
		bagStr.add("hail");
		bagStr.add("hall");
		
		 Object [] array = bagStr.toArray();
		 System.out.println(array);
	        for (Object item : array) {
	            System.out.println(item);
	            } 
	        
	   System.out.println(" @@@@@@@@@ WORD TEST @@@@@@@@@ ");
	   System.out.println(" @@@@@@@@@ WORD TEST @@@@@@@@@ ");
	   System.out.println(" @@@@@@@@@ WORD TEST @@@@@@@@@ ");
	   System.out.println(" @@@@@@@@@ WORD TEST @@@@@@@@@ ");
	   
	   Word word1 = new Word("hello");
	   Word word2 = new Word("hello2");
	   Word word3 = new Word("hello2");
       System.out.println("word1: " + word1.getContent() + ", Length: " + word1.getLength());
       System.out.println("word2: " + word2.getContent() + ", Length: " + word2.getLength());
       System.out.println("word2: " + word3.getContent() + ", Length: " + word3.getLength());

       System.out.println("word1 equals word2: " + word1.equals(word2));
       System.out.println("word2 equals word3: " + word2.equals(word3)); //"hello2 -> false"
       
       
	   System.out.println(" @@@@@@@@@ DICTIONARY, AND EXTENDS TEST @@@@@@@@@ ");
	   System.out.println(" @@@@@@@@@ DICTIONARY, AND EXTENDS TEST @@@@@@@@@ ");
	   System.out.println(" @@@@@@@@@ DICTIONARY, AND EXTENDS TEST @@@@@@@@@ ");
	   System.out.println(" @@@@@@@@@ DICTIONARY, AND EXTENDS TEST @@@@@@@@@ ");

	// RareWordsDictionary
       RareWordsDictionary<Word> rareWordsDictionary = new RareWordsDictionary<>(10);
       rareWordsDictionary.add(new Word("rare"));
       rareWordsDictionary.add(new Word("uncommon"));

       System.out.println("RareWordsDictionary testi:");
       System.out.println("Kelime sayısı: " + rareWordsDictionary.getCurrentSize());
       System.out.println("Kelime 'rare' sözlükte mi? " + rareWordsDictionary.contains(new Word("rare")));

       // FrequentWordsDictionary
       FrequentWordsDictionary<Word> frequentWordsDictionary = new FrequentWordsDictionary<>(10);
       frequentWordsDictionary.add(new Word("common"));
       frequentWordsDictionary.add(new Word("frequent"));

       System.out.println("\nFrequentWordsDictionary testi:");
       System.out.println("Kelime sayısı: " + frequentWordsDictionary.getCurrentSize());
       System.out.println("Kelime 'frequent' sözlükte mi? " + frequentWordsDictionary.contains(new Word("frequent")));

       // MostFrequentWordsDictionary
       MostFrequentWordsDictionary<Word> mostFrequentWordsDictionary = new MostFrequentWordsDictionary<>(10);

       mostFrequentWordsDictionary.add(new Word("common"));

       System.out.println("\nMostFrequentWordsDictionary testi:");
       System.out.println("Kelime sayısı: " + mostFrequentWordsDictionary.getCurrentSize());
       System.out.println("Kelime 'popular' sözlükte mi? " + mostFrequentWordsDictionary.contains(new Word("popular")));
   
       
	}
}


