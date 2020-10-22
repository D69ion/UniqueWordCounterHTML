package util.Downloader;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

public class HTMLDownloader {

    public static Document getDocument(String url){
        Document document = null;
        try {
            document = Jsoup.connect(url).get();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return document;
    }
}
