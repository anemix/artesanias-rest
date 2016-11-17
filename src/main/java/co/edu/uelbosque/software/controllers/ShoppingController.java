package co.edu.uelbosque.software.controllers;

import co.edu.uelbosque.software.entities.Product;
import co.edu.uelbosque.software.entities.ProductRequest;
import co.edu.uelbosque.software.entities.Shopping;
import co.edu.uelbosque.software.entities.ShoppingRequest;
import co.edu.uelbosque.software.repository.ProductRepository;
import co.edu.uelbosque.software.repository.ShoppingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/shopping")
public class ShoppingController {

    private ShoppingRepository shoppingRepository;

    @Autowired
    public ShoppingController(ShoppingRepository shoppingrepo) {
        this.shoppingRepository = shoppingrepo;
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Shopping> findAll(){
        return shoppingRepository.findAll();
    }

    @RequestMapping(method = RequestMethod.POST)
    public void addShopping(@RequestBody ShoppingRequest shoppingRequest){

        Shopping shopping = new Shopping();

        shopping.setDate_shopping(shoppingRequest.getDate_shopping());
        shopping.setProduct_id(shoppingRequest.getProduct_id());
        shopping.setQuantity(shoppingRequest.getQuantity());
        shopping.setTotal_price(shoppingRequest.getTotal_price());

        shoppingRepository.save(shopping);

    }
}
