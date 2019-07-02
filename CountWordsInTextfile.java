//Christian Lockley
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class CountWordsInTextfile {
    static private class WordOccurrence implements Comparable<WordOccurrence> {
        public WordOccurrence(String w, int c) {
            count = c;
            word = w;
        }
        public int count;
        public String word;
        public int compareTo(WordOccurrence a) {
            return this.word.compareToIgnoreCase(a.word);
        }
    }
    public static void main(String[] args) {
        ArrayList<WordOccurrence> WordOccurrenceArray = new ArrayList<WordOccurrence>();
        Collections.sort(WordOccurrenceArray);

        File file = new File(args[0]);
        Scanner sc = null;
        Map<String, Integer> map = null;
        try {
            sc = new Scanner(file);
        } catch (FileNotFoundException e) {
            return;
        }

// Create a TreeMap to hold words as key and count as value
        map = new TreeMap<>();
        while (sc.hasNextLine()) {
            String[] words = sc.nextLine().split("[\\p{Punct}\\s]+");
            for (int i = 0; i < words.length; i++) {
                String key = words[i].toLowerCase();
                if (key.length() > 0) {
                    if (!map.containsKey(key)) {
                        map.put(key, 1);
                    } else {
                        int value = map.get(key);
                        value++;
                        map.put(key, value);
                    }
                }
            }
        }
        Set<Map.Entry<String, Integer>> entrySet = map.entrySet();
        for (Map.Entry<String, Integer> entry: entrySet) {
                WordOccurrenceArray.add(new WordOccurrence(entry.getKey(), entry.getValue()));
        }
        Collections.sort(WordOccurrenceArray);
        for (WordOccurrence item : WordOccurrenceArray) {
            if (Character.isLetter(item.word.charAt(0)))
                System.out.println( item.count + "\t" + item.word);
        }
    }

}

