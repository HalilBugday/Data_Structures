package Dictionary_app;

public class WordFrequencyCounter {
    public static void main(String[] args) {
        Text text = new Text(100);
        Dictionary<Word> dictionary = new Dictionary<>(100);
        RareWordsDictionary<Word> rareWordsDictionary = new RareWordsDictionary<>(100);
        FrequentWordsDictionary<Word> frequentWordsDictionary = new FrequentWordsDictionary<>(100);
        MostFrequentWordsDictionary<Word> mostFrequentWordsDictionary = new MostFrequentWordsDictionary<>(100);

        String filePath = "text";
        String fileContent = FileIO.readTextFromFile(filePath);
        text.setContent(fileContent);
        text.separate(dictionary, rareWordsDictionary, frequentWordsDictionary, mostFrequentWordsDictionary);

        System.out.println("Text:");
        System.out.println("Number of words: " + text.getCurrentSize());
        System.out.print("Content: " + text.getContent());

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
