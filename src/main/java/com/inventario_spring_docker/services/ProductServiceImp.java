package com.inventario_spring_docker.services;

import com.inventario_spring_docker.Exception.ProductNotFoundException;
import com.inventario_spring_docker.models.Product;
import com.inventario_spring_docker.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


@Service
public class ProductServiceImp {     //logic

    @Autowired
     private ProductRepository repository;

    public List<Product> getAllProductos(){
        List<Product> produ = new ArrayList<>();

        Iterator<Product> productIterator = repository.findAll().iterator();
        for (Iterator<Product> it = productIterator; it.hasNext(); ) {
            Product product = it.next();
            produ.add(product);
        }
        return produ;
    }


    public Product getProductId(Integer id){
      return  repository.findById(id)
              .orElseThrow(() -> new ProductNotFoundException("Producto no Encontrado"));
    }


    public void addProducto( Product product) {
        repository.save(product);
    }


    public void deleteProduct( Integer id) {

        repository.deleteById(id);
    }


    public void updateProduct(Integer id, Product upProduct) {
        upProduct.setId(id);
        repository.save(upProduct);
    }
////        Product productToUpdate = existingProduct.get();
//        productToUpdate.setName(upProduct.getName());
//        productToUpdate.setPrice(upProduct.getPrice());
//        productToUpdate.setStock(upProduct.getStock());
//        productToUpdate.setImage(upProduct.getImage());
//
//        return ResponseEntity.ok("Producto actualizado exitosamente");
//    }

    // 🔍 SEARCH MEJORADO

    public ResponseEntity<List<Product>> advancedSearch(String name, Long minPrice, Long maxPrice) {

       return null;
    }
}
