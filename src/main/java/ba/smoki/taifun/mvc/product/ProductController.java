package ba.smoki.taifun.mvc.product;

import ba.smoki.taifun.entity.product.Product;
import ba.smoki.taifun.entity.product.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    //HTTP GET request http://localhost:8080/products
    @GetMapping("/products")
    public String getAllProducts(Model model) {
        List<Product> products = productRepository.findAll();
        model.addAttribute("proizvodi", products);
        return "product";//product.html
    }

    //HTTP GET request  http://localhost:8080/addProduct
    @GetMapping("/addProduct")
    public String addProduct(Model model) {
        Product product = new Product();
        model.addAttribute("product", product);
        return "add_product";
    }
    //HTTP POST request  http://localhost:8080/saveProduct
    @PostMapping("/saveProduct")
    public String saveProduct(@ModelAttribute("product") Product product){
        try {
            productRepository.save(product);
            return "redirect:/products"; // sintaksa za redirect view
        }catch (Exception e){
            return "redirect:/addProduct?error";
        }
    }
}
