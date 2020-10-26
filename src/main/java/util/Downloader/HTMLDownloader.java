package util.Downloader;

import org.apache.log4j.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.util.Optional;

public class HTMLDownloader {

    private final static Logger LOGGER = Logger.getLogger(HTMLDownloader.class);
    public static Document getDocument(String url){
        Document document = null;
        try {
            document = Optional.of(Jsoup.connect(url).userAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.113 Safari/537.36").get()).orElseThrow(NullPointerException::new);

        } catch (IOException e) {
            LOGGER.error("Html loading problem", e);
        }

        return document;
    }
}
