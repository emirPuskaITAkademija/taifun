package ba.smoki.taifun.product;

import java.util.List;
//TechnoProductFetcher fetcher = new TechnoProductFetcher()
//fetcher.fetchProductBy()
class TechnoProductFetcher implements ProductFetcher{
    //fetchProductBy("techno")
    @Override
    public List<String> fetchProductBy() {
        return List.of("IPhone12", "Samsung Galaxy S24", "Samsung Galax Tab 2");
    }
}
