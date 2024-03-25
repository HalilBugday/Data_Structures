package Dictionary_app;

@SuppressWarnings("hiding")
public class Dictionary<Word> extends Bag<Word> {
    public Dictionary(int capacity) {
        super(capacity);
    }

    public void addWord(Word word) {
        add(word);
    }

    public boolean containsWord(Word word) {
        return contains(word);
    }

    public void displayContent() {
        displayItems();
    }
    
    public int size() {
        return getCurrentSize();
    }

    public int getFrequency(Word word) {
        return getFrequencyOf(word);
    }
    public boolean remove(Word anEntry) {
    	return remove(anEntry);
    }
}

