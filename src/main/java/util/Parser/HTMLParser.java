package util.Parser;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.HashMap;
import java.util.Map;

public class HTMLParser {

    private Document HTMLDoc;

    public HTMLParser(Document document) {
        this.HTMLDoc = document;
    }

    public HashMap<String, Integer> parseTags(){
        HashMap<String, Integer> uniqueWords = new HashMap<String, Integer>();
        for (HTMLTags tag : HTMLTags.values()) {
            HashMap<String, Integer> temp = parseTag(tag.getName());
            if (temp == null)
                continue;
            for (Map.Entry<String, Integer> word : temp.entrySet()) {
                if (uniqueWords.containsKey(word.getKey())) {
                    uniqueWords.put(word.getKey(), word.getValue() + uniqueWords.get(word.getKey()));
                } else {
                    uniqueWords.put(word.getKey(), word.getValue());
                }
            }
        }
        return uniqueWords;
    }

    private HashMap<String, Integer> parseTag(String tag){
        HashMap<String, Integer> uniqueWords = new HashMap<String, Integer>();
        Elements tags = HTMLDoc.select(tag);
        if(tags == null)
            return null;
        for (Element element: tags) {
            String[] words = element.text().split("\\P{L}+");
            for (String word : words) {
                if (word != null & !word.equals("")){
                    if (uniqueWords.containsKey(word)) {
                        uniqueWords.put(word, uniqueWords.get(word) + 1);
                    }
                    else {
                        uniqueWords.put(word, 1);
                    }
                }
            }
        }
        return uniqueWords;
    }
}
