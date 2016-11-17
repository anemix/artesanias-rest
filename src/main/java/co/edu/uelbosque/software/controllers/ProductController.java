package co.edu.uelbosque.software.controllers;

import co.edu.uelbosque.software.entities.Product;
import co.edu.uelbosque.software.entities.ProductRequest;
import co.edu.uelbosque.software.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/products")
public class ProductController {

    private ProductRepository productrepo;

    @Autowired
    public ProductController(ProductRepository productrepo) {
        this.productrepo = productrepo;
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Product> findAll(){
        return productrepo.findAll();
    }

    @RequestMapping(method = RequestMethod.POST)
    public void addProduct(@RequestBody ProductRequest productRequest){
        Product product = new Product();
        product.setName(productRequest.getName());
        product.setDescription(productRequest.getDescription());
        product.setPrice(productRequest.getPrice());
        productrepo.save(product);
    }
    @RequestMapping(method = RequestMethod.GET, value = "/{productId}")
    public Product findById(@PathVariable Integer productId){
        return productrepo.findOne(productId);
    }
}
