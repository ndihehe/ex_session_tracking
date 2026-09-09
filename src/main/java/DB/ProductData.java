package DB;

import java.util.ArrayList;
import java.util.List;

public class ProductData {

    private static final List<Product> products = new ArrayList<>();

    static {
        products.add(new Product(
                "86 (the band) - True Life Songs and Pictures",
                "pd01",
                14.95
        ));

        products.add(new Product(
                "Paddlefoot - The first CD",
                "pd02",
                12.95
        ));

        products.add(new Product(
                "Paddlefoot - The second CD",
                "pd03",
                14.95
        ));
    }

    public static List<Product> getProducts() {
        return products;
    }

    public static Product getProductByCode(String code) {
        for (Product product : products) {
            if (product.getCode().equals(code)) {
                return product;
            }
        }

        return null;
    }
}