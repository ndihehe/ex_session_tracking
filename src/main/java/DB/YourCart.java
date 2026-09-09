package DB;
import DB.Product;
import DB.LineItem;
import java.util.ArrayList;
import java.util.List;

public class YourCart{

    private List<LineItem> items;

    public YourCart() {
        items = new ArrayList<>();
    }
    public List<LineItem> getItems() {
        return items;
    }

    public void addLineItem(LineItem item) {
        items.add(item);
    }
    public void removeLineItem(String productCode) {

        for (int i = 0; i < items.size(); i++) {

            if (items.get(i).getProduct()
                    .getCode().equals(productCode)) {

                items.remove(i);
                break;
            }
        }
    }
    public void updateQuantity(String productCode, int quantity) {

        for (LineItem item : items) {

            if (item.getProduct()
                    .getCode()
                    .equals(productCode)) {

                item.setQuantity(quantity);
                return;
            }
        }
    }
}
