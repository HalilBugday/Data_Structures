package Dictionary_app;

public class WordFrequencyCounter {
    public static void main(String[] args) {
        Text<Word> text = new Text<Word>();
        Dictionary<Word> dictionary = new Dictionary<>(10);
        RareWordsDictionary<Word> rareWordsDictionary = new RareWordsDictionary<>(10);
        FrequentWordsDictionary<Word> frequentWordsDictionary = new FrequentWordsDictionary<>(10);
        MostFrequentWordsDictionary<Word> mostFrequentWordsDictionary = new MostFrequentWordsDictionary<>(10);
        FileIO.readFile(text, dictionary);
        text.separate(dictionary, rareWordsDictionary, frequentWordsDictionary, mostFrequentWordsDictionary);

        System.out.println("Text:");
        System.out.println("Text number of words: " + text.getCurrentSize());
        System.out.print("Contnet: ");
        text.displayItems();
        
        System.out.println();
        System.out.println("\nRare Words Dictionary:");
        System.out.println("Number of words: " + rareWordsDictionary.getCurrentSize());
        System.out.print("Content: ");
        rareWordsDictionary.displayItems();
        
        System.out.println();
        System.out.println("\nFrequent Words Dictionary:");
        System.out.println("Number of words: " +frequentWordsDictionary.getCurrentSize());
        System.out.print("Content: " );
        frequentWordsDictionary.displayItems();
        
        System.out.println();
        System.out.println("\nMost Frequent Words Dictionary:");
        System.out.println("Number of words: " + mostFrequentWordsDictionary.getCurrentSize());
        System.out.print("Content: " );
        mostFrequentWordsDictionary.displayItems();
        
       
 
    }
}