package com.pluralsight.NorthwindTradersSpringBoot;

import com.pluralsight.NorthwindTradersSpringBoot.DAO.ProductDAO;
import com.pluralsight.NorthwindTradersSpringBoot.DAO.SimpleProductDAO;
import com.pluralsight.NorthwindTradersSpringBoot.Models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.Scanner;

@SpringBootApplication
public class NorthwindTradersSpringBootApplication {
    private static ProductDAO productDAO;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
		SpringApplication.run(NorthwindTradersSpringBootApplication.class, args);
//        ApplicationContext context = SpringApplication.run(NorthwindTradersSpringBootApplication.class, args);
//        productDAO = context.getBean(SimpleProductDAO.class);
//        System.out.println("Welcome to the product spring app!");
//        while (true) {
//            System.out.println("Please select an option below");
//            System.out.println("1) List All Products");
//            System.out.println("2) Add Product");
//            System.out.println("3) Update Product");
//            System.out.println("4) Search by Product Id");
//            System.out.println("5) Delete Product");
//            System.out.println("0) Quit");
//            System.out.print("Selection: ");
//            int option = input.nextInt();
//            input.nextLine();
//
//            switch (option) {
//                case 1:
//                    productDAO.getAllProducts().stream().forEach(System.out::println);
//                    break;
//                case 2:
//                    System.out.print("Please enter the product id: ");
//                    int productId = input.nextInt();
//                    input.nextLine();
//                    System.out.print("Please enter the product name: ");
//                    String productName = input.nextLine();
//                    System.out.print("Please enter the product category: ");
//                    String productCategory = input.nextLine();
//                    System.out.print("Please enter the product price: ");
//                    double productPrice = input.nextDouble();
//                    input.nextLine();
//                    productDAO.addProduct(new Product(productId, productName, productCategory, productPrice));
//                    System.out.println("Product added");
//                    break;
//                case 3:
//                    System.out.print("Please enter the id of the product to update: ");
//                    int searchingProduct = input.nextInt();
//                    input.nextLine();
//                    System.out.print("Enter the new product name: ");
//                    String newProductName = input.nextLine();
//                    System.out.print("Enter the new product category: ");
//                    String newProductCategory = input.nextLine();
//                    System.out.print("Enter the new product price: ");
//                    double newProductPrice = input.nextDouble();
//                    input.nextLine();
//                    productDAO.updateProduct(searchingProduct, newProductName, newProductCategory, newProductPrice);
//                    System.out.println("Product updated");
//                    break;
//                case 4:
//                    System.out.print("Please enter the id of the product to search by: ");
//                    int productIdSearch = input.nextInt();
//                    input.nextLine();
//                    System.out.println(productDAO.getProductById(productIdSearch));
//                    break;
//                case 5:
//                    System.out.print("Please enter the id of the product to delete: ");
//                    int deleteIdSearch = input.nextInt();
//                    input.nextLine();
//                    productDAO.deleteProduct(deleteIdSearch);
//                    break;
//                case 0:
//                    System.exit(0);
//                default:
//                    System.out.println("Invalid input. Please try again.");
//            }
//        }
    }
}
