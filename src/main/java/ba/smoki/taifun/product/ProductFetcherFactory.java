package ba.smoki.taifun.product;

import java.util.List;

public enum ProductFetcherFactory {
    FOOD(new FoodProductFetcher()),
    TECHNO(new TechnoProductFetcher());

    private ProductFetcher productFetcher;

    ProductFetcherFactory(ProductFetcher productFetcher){
        this.productFetcher = productFetcher;
    }

    public ProductFetcher getProductFetcher() {
        return productFetcher;
    }
}
