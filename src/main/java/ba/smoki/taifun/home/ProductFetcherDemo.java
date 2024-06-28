package ba.smoki.taifun.home;

import ba.smoki.taifun.product.ProductFetcher;
import ba.smoki.taifun.product.ProductFetcherFabrika;
import ba.smoki.taifun.product.ProductFetcherFactory;

import java.util.List;

public class ProductFetcherDemo {

    public static void main(String[] args) {
        ProductFetcher productFetcher = ProductFetcherFabrika.get("TECHNO");
        List<String> products = productFetcher.fetchProductBy();
        for (String product : products) {
            System.out.println(product);
        }

        ProductFetcher anotherProductFetcher = ProductFetcherFactory.FOOD.getProductFetcher();
        anotherProductFetcher.fetchProductBy().forEach(System.out::println);
    }
}
