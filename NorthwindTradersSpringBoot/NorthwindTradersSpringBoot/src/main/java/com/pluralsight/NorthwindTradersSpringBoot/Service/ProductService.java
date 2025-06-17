package com.pluralsight.NorthwindTradersSpringBoot.Service;


import com.pluralsight.NorthwindTradersSpringBoot.DAO.ProductDAO;
import com.pluralsight.NorthwindTradersSpringBoot.Models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductDAO productDAO;

    @Autowired
    public ProductService(ProductDAO productDAO) {
        this.productDAO = productDAO;
    }

    public List<Product> getAllProducts(){
        return productDAO.getAllProducts();
    }

}
