package Dictionary_app;

@SuppressWarnings("hiding")
public class Text <Word> extends Bag<Word> {

	public void separate(Dictionary<Word> dictionary, RareWordsDictionary<Word> rareWordsDictionary, FrequentWordsDictionary<Word> frequentWordsDictionary, MostFrequentWordsDictionary<Word> mostFrequentWordsDictionary) {
		while(!dictionary.isEmpty()) {
			Word word = dictionary.remove();
			int frequency = dictionary.getFrequencyOf(word) + 1;
			if(frequency<5) {
				
				if(!frequentWordsDictionary.contains(word) && !mostFrequentWordsDictionary.contains(word)) {
					rareWordsDictionary.add(word);
				}
				
			}else if (frequency <= 8) {
				if(!mostFrequentWordsDictionary.contains(word)) {
					frequentWordsDictionary.add(word);
				}
			}else {
				mostFrequentWordsDictionary.add(word);
			}
		}
    }
    

}
