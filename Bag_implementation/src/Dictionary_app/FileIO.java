package Dictionary_app;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileIO {
	
   public static void readFile(Text<Word> text, Dictionary<Word>dictionary) {
       try (BufferedReader reader = new BufferedReader(new FileReader("text.txt"))) {
           String line;
           while ((line = reader.readLine()) != null) {
           	  line = line.replaceAll("\\p{Punct}", "");
           	  String arr[] = line.split(" ");
           	  for(int i = 0 ;i<arr.length;i++) {
           		  Word word = new Word(arr[i]);
           		  text.add(word);
           		  word.setContent(word.getContent().toLowerCase().replaceAll("ı", "i"));
           		  dictionary.add(word);
           	  }
           }
       } catch (IOException e) {
           e.printStackTrace();
       }
	   
   }
}