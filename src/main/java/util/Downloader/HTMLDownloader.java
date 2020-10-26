package util.Downloader;

import org.apache.log4j.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

public class HTMLDownloader {

    private final static Logger LOGGER = Logger.getLogger(HTMLDownloader.class);
    public static Document getDocument(String url){
        Document document = null;
        try {
            document = Jsoup.connect(url).get();

        } catch (IOException e) {
            LOGGER.error("Html loading problem", e);
        }
        if(document == null){
            throw new NullPointerException();
        }
        return document;
    }
}
