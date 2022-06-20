import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.IOException;
import java.util.*;


public class Main {
    static String catalogUrl = "https://dominodomoy.ru/catalog/";
    static String pageUrl = "https://dominodomoy.ru";
    public static void main(String[] args) throws IOException {
        ArrayList<MenuCategory> menu = new ArrayList<>();
        Document doc = Jsoup.connect(catalogUrl).get();
        Elements categories = doc.getElementsByAttributeValueStarting("class", "catalog-section-list-item-title");
        for (Element category : categories) {
            menu.add(new MenuCategory(category.text(),Jsoup.connect(pageUrl+category.attr("href")).get()));
        }
        for (MenuCategory cat : menu) cat.printItems();
    }
}
