package Dictionary_app;

@SuppressWarnings("hiding")
public class RareWordsDictionary<Word> extends Bag<Word> {
    
    public RareWordsDictionary(int capacity) {
        super(capacity);
    }
    
    @Override
    public boolean add(Word newEntry) {
    	checkInitialization();
    	if(isFull()) {
    		doubleCapacity();
    	}
    	if(!contains(newEntry)) {
    		super.add(newEntry);
    		return true;
    	}
    	return false;	
    }
}

