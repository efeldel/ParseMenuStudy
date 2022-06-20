import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.util.ArrayList;

public class MenuCategory {
    private Document doc;
    private String categoryName;

    public MenuCategory(String name, Document doc) {
        this.categoryName = name;
        this.doc = doc;
    }

    public ArrayList<String> formArray(int operation) {
        Elements elems;
        ArrayList<String> arrList = new ArrayList<>();
        switch (operation) {
            case 1 -> {
                elems = doc.getElementsByAttributeValueStarting("class", "catalog-section-item-name-wrapper");
                for (Element el : elems) {
                    arrList.add(el.text());
                }
            }
            case 2 -> {
                elems = doc.getElementsByAttributeValueStarting("class", "catalog-section-item-price-discount");
                for (Element el : elems) {
                    arrList.add(el.text());
                }
            }
            case 3 -> {
                elems = doc.getElementsByAttributeValueStarting("class", "catalog-section-item-image-look").select("img");
                for (Element el : elems) {
                    arrList.add(el.attr("data-original"));
                }
            }
        }
        return arrList;
    }

    public void printItems() {
        ArrayList<String> menuItemNames = formArray(1);
        ArrayList<String> menuItemPrices = formArray(2);
        ArrayList<String> menuItemsImgUrls = formArray(3);
        System.out.println(categoryName);
        for (int i = 0, m = menuItemNames.size(); i < m; i++){
            System.out.println("\t" + menuItemNames.get(i) + " - " + menuItemPrices.get(i) + " - "
                    + "https://dominodomoy.ru" + menuItemsImgUrls.get(i));
        }
    }
}
