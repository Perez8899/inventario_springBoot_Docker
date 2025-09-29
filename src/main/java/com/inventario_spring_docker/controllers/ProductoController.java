package com.inventario_spring_docker.controllers;


import com.inventario_spring_docker.models.Product;
import com.inventario_spring_docker.response.ApiResponse;
import com.inventario_spring_docker.response.MessageResponse;
import com.inventario_spring_docker.response.ProductResponse;
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

    //----------------------------------------------------------------------------------------------------------------------
    @GetMapping
    public ResponseEntity<List<Product>> getAllProductos(){
        List<Product> products= productService.getAllProductos();
        return ResponseEntity.ok(products);
    }
    //----------------------------------------------------------------------------------------------------------------------
    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Integer id) {
        Product product = productService.getProductId(id);
        return ResponseEntity.ok(product);
    }
    //----------------------------------------------------------------------------------------------------------------------
    @PostMapping
    public ResponseEntity<ProductResponse> addProducto(@RequestBody Product product) {

        ProductResponse response = productService.addProducto(product);
        return ResponseEntity.ok(response);
    }
    //----------------------------------------------------------------------------------------------------------------------
    @DeleteMapping("/{id}")
    public ResponseEntity<MessageResponse> deleteProduct(@PathVariable Integer id) {

        MessageResponse response = productService.deleteProduct(id);
        return ResponseEntity.ok(response);
    }
    //----------------------------------------------------------------------------------------------------------------------
    @PutMapping("/{id}")
    public ResponseEntity<ProductResponse> updateProduct(@PathVariable Integer id,
                                                         @RequestBody Product upProduct) {
        ProductResponse response = productService.updateProduct(id, upProduct);
        return ResponseEntity.ok(response);
    }
    //----------------------------------------------------------------------------------------------------------------------
    // 🔍 SEARCH
    @GetMapping("/search")
    public ResponseEntity<List<Product>> searchProductByPath(@RequestParam(name ="name", required = false) String name){

        return productService.searchProduct(name);
    }

}