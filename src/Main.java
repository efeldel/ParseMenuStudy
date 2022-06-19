import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.IOException;
import java.util.*;


public class Main {
    static String pageUrl = "https://dominodomoy.ru/catalog/";

    public static void main(String[] args) throws IOException {
        TreeMap<String,String> catalog = new TreeMap<>();
        Document doc = Jsoup.connect(pageUrl).get();
        Elements categories = doc.getElementsByAttributeValueStarting("class", "catalog-section-list-item-title intec-cl-text-hover");
        for (Element category : categories) {
            catalog.put(category.text(),category.attr("href"));
        }
        MenuCategory blin = new MenuCategory("Блины сладкие",Jsoup.connect("https://dominodomoy.ru/catalog/bliny_sladkie/").get());
//        ArrayList<Document> docs = new ArrayList<>();
//        for (String key : catalog.keySet()) {
//            docs.add(Jsoup.connect(pageUrl + catalog.get(key)).get());
//        }
        blin.printItems();
    }
}
