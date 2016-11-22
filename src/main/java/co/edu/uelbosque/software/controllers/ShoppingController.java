package co.edu.uelbosque.software.controllers;

import co.edu.uelbosque.software.entities.*;
import co.edu.uelbosque.software.repository.ProductRepository;
import co.edu.uelbosque.software.repository.ShoppingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;


//@CrossOrigin(origins = "http://localhost:3001")
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

    @RequestMapping(value = "/payu", method = RequestMethod.POST)
    public void responsePayu(@RequestHeader(value="Content-Type") String accept, @RequestBody MultiValueMap params){

        System.out.println(params);
        params.get("transaction_date");

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
