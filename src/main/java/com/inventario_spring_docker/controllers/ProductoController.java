package com.inventario_spring_docker.controllers;


import com.inventario_spring_docker.models.Product;
import com.inventario_spring_docker.services.ProductServiceImp;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductoController {

    @Autowired
   private ProductServiceImp productService;
    private Integer nextId = 1; // Contador para IDs automáticos



    @GetMapping
    public List<Product> getAllProductos(){
        return productService.getAllProductos();
    }

    @GetMapping("/{id}") //trae producto especifico
    public Product getProduct(@PathVariable Integer id){
        return productService.getProductId(id);
    }

    @PostMapping
    public void addProducto(@RequestBody @Valid Product product) {
        // Asignar ID automáticamente
        product.setId(nextId++);
        productService.addProducto(product);
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Integer id) {

        productService.deleteProduct(id);
    }

    @PutMapping("/{id}")
    public void updateProduct(@PathVariable Integer id,
                              @RequestBody Product upProduct) {
        productService.updateProduct(id, upProduct);
    }

    // 🔍 SEARCH
    @GetMapping("/search")
    public List<Product> searchProduct(@RequestParam(name = "name", required = false) String name){

        return productService.searchProduct(name).getBody();
    }

}