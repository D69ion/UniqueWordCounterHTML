package util.Parser;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.HashMap;

public class HTMLParser {

    private Document HTMLDoc;
    private HashMap<String, Integer> UniqueWords;

    public HTMLParser(Document document) {
        this.HTMLDoc = document;
        this.UniqueWords = new HashMap<>();
    }

    public HashMap<String, Integer> parseTags(){
        for (HTMLTags tag : HTMLTags.values()) {
            //TODO: несколько вложенных тэгов имеют такой же текст, как самый последний вложенный тэг. Это причина подсчета одного и того же слова несколько раз
            Elements tags = HTMLDoc.select(tag.getName());
            if(tags == null)
                continue;
            for (Element element: tags) {
                String[] words = element.text().split("\\P{L}+");
                for (String word : words) {
                    if (word != null && !word.equals("")){
                        if (UniqueWords.containsKey(word)) {
                            UniqueWords.put(word, UniqueWords.get(word) + 1);
                        }
                        else {
                            UniqueWords.put(word, 1);
                        }
                    }
                }
            }
        }
        return UniqueWords;
    }
}
