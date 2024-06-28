package ba.smoki.taifun.product;

import java.util.List;

class FoodProductFetcher implements ProductFetcher{
    //fetchProductBy("techno")
    @Override
    public List<String> fetchProductBy() {
        return List.of("Čevapi s lukom", "Suđuka", "Grah s kobasicom i suhim mesom");
    }
}
