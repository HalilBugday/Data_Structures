package Dictionary_app;

import java.util.StringTokenizer;

public class Text extends Bag<Word> {
    private String content;

    public Text(int capacity) {
        super(capacity);
    }

    public void setContent(String content) {
        this.content = content;
    }
    
    public void separate(Dictionary<Word> dictionary, RareWordsDictionary<Word> rareWordsDictionary, FrequentWordsDictionary<Word> frequentWordsDictionary, MostFrequentWordsDictionary<Word> mostFrequentWordsDictionary) {
        if (content == null) {
            return; 
        }

        String[] words = extractWords();
        int index = 0;
        
        while (index < words.length) {
            String wordStr = words[index];
            Word wordObj = new Word(wordStr);
            add(wordObj);
            
            if (!frequentWordsDictionary.contains(wordObj) && !mostFrequentWordsDictionary.contains(wordObj)) {
                int totalFrequency = getTotalFrequency(words, wordStr);
                if (totalFrequency < 5) {
                    rareWordsDictionary.add(wordObj);
                } else if (totalFrequency >= 5 && totalFrequency <= 8) {
                    frequentWordsDictionary.add(wordObj);
                } else if (totalFrequency >= 9) {
                    mostFrequentWordsDictionary.add(wordObj);
                }
            }
            
            index++;
        }
    }


    private int getTotalFrequency(String[] words, String targetWord) {
        int totalFrequency = 0;
        for (String word : words) {
            if (word.equals(targetWord)) {
                totalFrequency++;
            }
        }
        return totalFrequency;
    }

    private String[] extractWords() {
        StringTokenizer tokenizer = new StringTokenizer(content);
        String[] words = new String[tokenizer.countTokens()];
        int index = 0;
        while (tokenizer.hasMoreTokens()) {
            words[index++] = tokenizer.nextToken().replaceAll("ı", "i");
        }
        return words;
    }

    public String getContent() {
        return content;
    }
    

}
