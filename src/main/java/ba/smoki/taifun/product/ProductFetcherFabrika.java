package ba.smoki.taifun.product;

public class ProductFetcherFabrika {

    public static ProductFetcher get(String type) {
        switch (type) {
            case "TECHNO":
                return new TechnoProductFetcher();
            case "FOOD":
                return new FoodProductFetcher();
            default:
                throw new UnsupportedOperationException("Nije podržan tip " + type);
        }
    }
}
