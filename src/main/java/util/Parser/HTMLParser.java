package util.Parser;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.HashMap;

public class HTMLParser {

    private Document HTMLDoc;

    public HTMLParser(Document document) {
        this.HTMLDoc = document;
    }

    public HashMap<String, Integer> parseTags(String tag){
        HashMap<String, Integer> uniqueWords = new HashMap<String, Integer>();
        Elements tags = HTMLDoc.select(tag);
        if(tags == null)
            return null;
        for (Element element: tags
             ) {
            String[] words = element.text().split("\\P{L}+");
            for (String word : words) {
                if (word != null & !word.equals("")){
                    if (uniqueWords.containsKey(word)) {
                        uniqueWords.put(word, uniqueWords.get(word) + 1);
                    } else {
                        uniqueWords.put(word, 1);
                    }
                }
            }
        }
        return uniqueWords;
    }
}
