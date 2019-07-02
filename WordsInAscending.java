//Christian Lockley
import java.util.*;

public class WordsInAscending {
    static private class WordOccurrence implements  Comparable<WordOccurrence> {
        public WordOccurrence(String w, int c) {
            count = c;
            word = w;
        }
        public int count;
        public String word;
        public int compareTo(WordOccurrence a) {
            return Integer.compare(this.count, a.count);
        }
    }
    public static void main(String[] args) {
        ArrayList<WordOccurrence> WordOccurrenceArray = new ArrayList<WordOccurrence>();
        Collections.sort(WordOccurrenceArray);
// Set text in a string
        String text = "Good morning. Have a good class. " +
                "Have a good visit. Have fun!";
// Create a TreeMap to hold words as key and count as value
        Map<String, Integer> map = new TreeMap<>();
        String[] words = text.split("[\\p{Punct}\\s]+");
        for (int i = 0; i < words.length; i++) {
            String key = words[i].toLowerCase();
            if (key.length() > 0) {
                if (!map.containsKey(key)) {
                    map.put(key, 1);
                }
                else {
                    int value = map.get(key);
                    value++;
                    map.put(key, value);
                }
            }
        }
        Set<Map.Entry<String, Integer>> entrySet = map.entrySet();
        for (Map.Entry<String, Integer> entry: entrySet) {
            WordOccurrenceArray.add(new WordOccurrence(entry.getKey(), entry.getValue()));
        }
        Collections.sort(WordOccurrenceArray);
        for (int i = 0; i < WordOccurrenceArray.size(); ++i) {
            System.out.println(WordOccurrenceArray.get(i).word + "\t" + WordOccurrenceArray.get(i).count);
        }
    }
}

