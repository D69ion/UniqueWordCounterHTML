import util.Downloader.HTMLDownloader;
import util.Parser.HTMLParser;
import util.Parser.HTMLTags;
import util.Validator.URLValidator;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Main {
    public static void main(String[] args){
        try (Scanner scanner = new Scanner(System.in)){
            while(true){
                System.out.println("Paste the link");
                String url = scanner.nextLine();

                if(URLValidator.isValid(url)){
                    HashMap<String, Integer> uniqueWords = new HashMap<>();
                    HTMLParser parser = new HTMLParser(HTMLDownloader.getDocument(url));

                    for (HTMLTags tag: HTMLTags.values()) {
                        HashMap<String, Integer> temp = parser.parseTags(tag.getName());
                        if(temp == null)
                            continue;
                        for (Map.Entry<String, Integer> word: temp.entrySet()) {
                            if (uniqueWords.containsKey(word.getKey())) {
                                uniqueWords.put(word.getKey(), word.getValue() + uniqueWords.get(word.getKey()));
                            } else {
                                uniqueWords.put(word.getKey(), word.getValue());
                            }
                        }
                    }
                    System.out.println("List of unique words:\r\n");
                    for (Map.Entry<String, Integer> word: uniqueWords.entrySet()) {
                        System.out.println(word.getKey() + " - " + word.getValue() + "\r\n");
                    }
                }
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
