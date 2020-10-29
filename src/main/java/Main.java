import org.apache.log4j.Logger;
import util.Downloader.HTMLDownloader;
import util.Parser.HTMLParser;
import util.Validator.FilePathValidator;
import util.Validator.URLValidator;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    private final static Logger LOGGER = Logger.getLogger(Main.class);

    public static void main(String[] args) {
        while (true) {
            try(Scanner scanner = new Scanner(System.in)){
                while (true) {
                    System.out.println("Paste the link");
                    String url = scanner.nextLine();
                    if(url.equals("!quit")){
                        return;
                    }
                    if (URLValidator.isValid(url)) {
                        HTMLParser parser = new HTMLParser(HTMLDownloader.getDocumentFromURL(url));
                        getUniqueWords(parser);
                    } else if (FilePathValidator.isValid(url)) {
                        HTMLParser parser = new HTMLParser(HTMLDownloader.getDocumentFromFile(url));
                        getUniqueWords(parser);
                    } else {
                        System.out.println("Invalid link or file path");
                        LOGGER.warn("Invalid link: " + url);
                    }
                }
            } catch (NullPointerException e) {
                System.out.println("Failed to load html page");
                LOGGER.error("Failed to load html page", e);
            } catch (Exception e) {
                System.out.println(e.getMessage());
                LOGGER.error(e.getMessage(), e);
            }
        }
    }

    private static void getUniqueWords(HTMLParser parser){
        HashMap<String, Integer> uniqueWords = parser.parseTags();
        System.out.println("List of unique words:\r\n");
        for (Map.Entry<String, Integer> word: uniqueWords.entrySet()) {
            System.out.println(word.getKey() + " - " + word.getValue());
        }
    }

}
