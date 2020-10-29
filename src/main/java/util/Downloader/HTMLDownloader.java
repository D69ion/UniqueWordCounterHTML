package util.Downloader;

import org.apache.log4j.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Optional;

public class HTMLDownloader {

    private final static Logger LOGGER = Logger.getLogger(HTMLDownloader.class);

    public static Document getDocumentFromURL(String url){
        Document document = null;
        try {
            document = Optional.of(Jsoup.connect(url).userAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.113 Safari/537.36").get()).orElseThrow(NullPointerException::new);
            File htmlFile = new File(HTMLDownloader.class.getProtectionDomain().getCodeSource().getLocation().toURI().getPath() + "/" + document.title() + ".html");//"C://" + document.title() + ".html");
            htmlFile.createNewFile();
            try(BufferedWriter writer =  new BufferedWriter(new FileWriter(htmlFile))){
                writer.write(document.outerHtml());
            }
        } catch (IOException | URISyntaxException e) {
            LOGGER.error("Html downloading problem", e);
        }
        return document;
    }

    public static Document getDocumentFromFile(String filePath){
        Document document = null;
        try {
            document = Optional.of(Jsoup.parse(new File(filePath),"UTF-8")).orElseThrow(NullPointerException::new);
        } catch (IOException e) {
            LOGGER.error("Html loading problem", e);
        }
        return document;
    }

}
