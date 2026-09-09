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

    public void addLineItem(LineItem newItem) {
        for (LineItem item : items) {
            if (item.getProduct().getCode()
                    .equals(newItem.getProduct().getCode())) {

                item.setQuantity(
                        item.getQuantity() + newItem.getQuantity()
                );

                return;
            }
        }

        items.add(newItem);
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
    public double getTotal() {
        double total = 0;

        for (LineItem item : items) {
            total += item.getTotal();
        }

        return total;
    }
}
