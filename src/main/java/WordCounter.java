import java.util.HashMap;
import java.util.Map;

public class WordCounter {
    private Map<String, Integer> dictionary;
    private final char[] separators=  {' ', ',', '.', '!', '?','"', ';', ':', '[', ']', '(', ')', '\n',
            '\r', '\t'};

    public WordCounter() {
        this.dictionary = new HashMap<String, Integer>();
    }

    public Map<String, Integer> getDictionary() {
        return dictionary;
    }

    public void setDictionary(Map<String, Integer> dictionary) {
        this.dictionary = dictionary;
    }

    public void Calc(String text){
        for (char separator : separators) {
            text = text.replace(separator, ' ');
        }
        String[] words = text.split(" ");

        for (String word : words) {
            if (dictionary.containsKey(word)) {
                dictionary.put(word, dictionary.get(word) + 1);
            } else {
                dictionary.put(word, 1);
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        for (Map.Entry<String, Integer> item: dictionary.entrySet()
             ) {
            res.append(item.getKey()).append(" - ").append(item.getValue()).append("\r\n");
        }
        return res.toString();
    }
}
