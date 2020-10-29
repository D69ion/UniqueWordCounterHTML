import org.apache.log4j.Logger;
import util.Downloader.HTMLDownloader;
import util.Parser.HTMLParser;
import util.Validator.FilePathValidator;
import util.Validator.URLValidator;

import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    private final static Logger LOGGER = Logger.getLogger(Main.class);

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                System.out.println("Paste the link");
                String url = scanner.nextLine();

                if (URLValidator.isValid(url)) {
                    HTMLParser parser = new HTMLParser(HTMLDownloader.getDocumentFromURL(url));
                    HashMap<String, Integer> uniqueWords = parser.parseTags();
                    System.out.println("List of unique words:\r\n");
                    System.out.println(uniqueWords.toString());
                } else if(FilePathValidator.isValid(url)){
                    HTMLParser parser = new HTMLParser(HTMLDownloader.getDocumentFromFile(url));
                    HashMap<String, Integer> uniqueWords = parser.parseTags();
                    System.out.println("List of unique words:\r\n");
                    System.out.println(uniqueWords.toString());
                } else {
                    System.out.println("Invalid link or file path");
                }
            }
        } catch (NullPointerException e) {
            System.out.println("Failed to load html page");
            LOGGER.error("Failed to load html page", e);
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
        }

    }

}
