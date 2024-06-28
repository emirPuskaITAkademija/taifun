package ba.smoki.taifun.product.mvc;

import ba.smoki.taifun.product.repository.ProductEntity;
import ba.smoki.taifun.product.repository.ProductRepository;
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
        List<ProductEntity> productEntities = productRepository.findAll();
        model.addAttribute("proizvodi", productEntities);
        return "product";//product.html
    }

    //HTTP GET request  http://localhost:8080/addProduct
    @GetMapping("/addProduct")
    public String addProduct(Model model) {
        ProductEntity productEntity = new ProductEntity();
        model.addAttribute("product", productEntity);
        return "add_product";
    }
    //HTTP POST request  http://localhost:8080/saveProduct
    @PostMapping("/saveProduct")
    public String saveProduct(@ModelAttribute("product") ProductEntity productEntity){
        try {
            productRepository.save(productEntity);
            return "redirect:/products"; // sintaksa za redirect view
        }catch (Exception e){
            return "redirect:/addProduct?error";
        }
    }
}
