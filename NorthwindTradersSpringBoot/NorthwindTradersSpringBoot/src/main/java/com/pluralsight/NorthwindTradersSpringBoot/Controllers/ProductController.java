package com.pluralsight.NorthwindTradersSpringBoot.Controllers;


import com.pluralsight.NorthwindTradersSpringBoot.Models.Product;
import com.pluralsight.NorthwindTradersSpringBoot.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @RequestMapping(path = "/products", method = RequestMethod.GET)
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }


    @RequestMapping(path = "/products/{productId}", method = RequestMethod.GET)
    public Product getProductById(@PathVariable int productId) {
        return productService.getProductById(productId);
    }

    @RequestMapping(path = "/products", method = RequestMethod.POST)
    public void addCustomer(@RequestBody Product product) {
        productService.addProduct(product);
    }

    /*
    @RequestMapping(path = "/", method = RequestMethod.GET)
    public String index(@RequestParam(defaultValue = "World!") String name) {
        return "Hello " + name;
    }
     */
}

