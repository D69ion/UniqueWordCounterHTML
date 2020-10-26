import org.apache.log4j.Logger;
import util.Downloader.HTMLDownloader;
import util.Parser.HTMLParser;
import util.Validator.URLValidator;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    private final static Logger LOGGER = Logger.getLogger(Main.class);

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                System.out.println("Paste the link");
                String url = scanner.nextLine();

                if (URLValidator.isValid(url)) {
                    HTMLParser parser = new HTMLParser(HTMLDownloader.getDocument(url));
                    HashMap<String, Integer> uniqueWords = parser.parseTags();
                    System.out.println("List of unique words:\r\n");
                    System.out.println(uniqueWords.toString());
                    /*
                    for (Map.Entry<String, Integer> word : uniqueWords.entrySet()) {
                        System.out.println(word.getKey() + " - " + word.getValue() + "\r\n");
                    }
                    */
                } else {
                    System.out.println("Invalid link");
                }
            }
        } catch (NullPointerException e) {
            System.out.println("");
            LOGGER.error("Failed to load html page", e);
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
        }

    }
}
