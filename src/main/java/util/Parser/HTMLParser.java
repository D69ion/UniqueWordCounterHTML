package util.Parser;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.safety.Whitelist;
import org.jsoup.select.Elements;

import java.util.HashMap;

public class HTMLParser {

    private Document HTMLDoc;
    private HashMap<String, Integer> UniqueWords;

    public HTMLParser(Document document) {
        this.HTMLDoc = document;
        this.UniqueWords = new HashMap<>();
    }

    /*
    public HashMap<String, Integer> parseTags(){
        for (HTMLTags tag : HTMLTags.values()) {
            //TODO: текст вложенный в несколько тэгов, считается как принадлежащий каждому вложенному тэгу. Это причина подсчета одного и того же слова несколько раз
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
                //частично помогло
                element.remove();
            }
        }
        return UniqueWords;
    }
     */

    public HashMap<String, Integer> parseTags(){
        String htmlString = Jsoup.clean(this.HTMLDoc.outerHtml(), Whitelist.none());
        String[] words = htmlString.split("\\P{L}+");
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
        return this.UniqueWords;
    }
}
