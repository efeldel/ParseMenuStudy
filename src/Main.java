import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class Main {
    static String pageUrl = "https://dominodomoy.ru/catalog/";

    public static void main(String[] args) throws IOException {
        List<String> catalog = new ArrayList<String>();
        Document doc = Jsoup.connect(pageUrl).get();
        Elements categories = doc.getElementsByAttributeValueStarting("href", "/catalog/");
        for (Element category : categories) {
            System.out.println(category.text());
        }
    }
}
