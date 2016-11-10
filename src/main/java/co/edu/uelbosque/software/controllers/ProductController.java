package co.edu.uelbosque.software.controllers;

import co.edu.uelbosque.software.entities.Product;
import co.edu.uelbosque.software.repository.ProductRepository;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class ProductController {

    private ProductRepository productrepo;

    public ProductController(ProductRepository productrepo) {
        this.productrepo = productrepo;
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Product> findAll(){
        return productrepo.findAll();
    }

    @RequestMapping(method = RequestMethod.POST)
    public void addProduct(@RequestBody){

    }
}
