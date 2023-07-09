package com.faizan.ProductCatalog;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/product")
public class ProductController {

    private final ProductRepository productRepository;

    public static record NewProductRequest(String name, String description, Integer price, Boolean availability) {}


    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping
    public List<Product> getProducts(){
        return productRepository.findAll();
    }

    @GetMapping("{pId}")
    public Optional<Product> getSpecificProduct(@PathVariable("pId") Integer id){
        return productRepository.findById(id);
    }

    @PostMapping
    public void addProducts(@RequestBody NewProductRequest request){
        Product product = new Product();
        product.setName(request.name);
        product.setDescription(request.description);
        product.setPrice(request.price);
        product.setAvailability(request.availability);
        productRepository.save(product);
}
    @DeleteMapping("{pId}")
    public void deleteProducts(@PathVariable("pId") Integer id){
        productRepository.deleteById(id);
    }


    @PutMapping("{pId}")
    public void updateProducts(@PathVariable("pId") Integer id, @RequestBody NewProductRequest request){
        Optional<Product> pid = productRepository.findById(id);
        Product product = pid.orElseThrow(() -> new IllegalArgumentException("Invalid product id"+ id));
        product.setName(request.name);
        product.setDescription(request.description);
        product.setPrice(request.price);
        product.setAvailability(request.availability);
        productRepository.save(product);


    }



}
