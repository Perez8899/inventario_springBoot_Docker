package com.inventario_spring_docker.services;

import com.inventario_spring_docker.Exception.ProductNotFoundException;
import com.inventario_spring_docker.models.Product;
import com.inventario_spring_docker.repository.ProductRepository;
import com.inventario_spring_docker.response.MessageResponse;
import com.inventario_spring_docker.response.ProductResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ProductServiceImp {     //logic

    @Autowired
     private ProductRepository repository;

    //----------------------------------------------------------------------------------------------------------------------

    public List<Product> getAllProductos(){

        return (List<Product>) repository.findAll();
    }

    //----------------------------------------------------------------------------------------------------------------------
    public Product getProductId(Integer id){
      return  repository.findById(id)
              .orElseThrow(() -> new ProductNotFoundException("Producto no Encontrado"));
    }
    //----------------------------------------------------------------------------------------------------------------------
    public ProductResponse addProducto(Product product) {
        Product savedProduct = repository.save(product);
        return ProductResponse.success("Producto creado exitosamente", savedProduct);

    }
    //----------------------------------------------------------------------------------------------------------------------
    public MessageResponse deleteProduct(Integer id) {

        //Virificamos si existe
        Product product = repository.findById(id)
                        .orElseThrow(() -> new ProductNotFoundException("Producto no encontrado para Eliminar"));

        repository.deleteById(id);
        return MessageResponse.success("Producto Eliminado Exitosamente");
    }
    //----------------------------------------------------------------------------------------------------------------------
    public ProductResponse updateProduct(Integer id, Product upProduct) {
        //Virificamos si existe
        Product exixteinProduct = repository.findById(id)
                        .orElseThrow(() -> new ProductNotFoundException("Producto No encontrado para Actualizar"));

        upProduct.setId(id);
        Product updatedProduct = repository.save(upProduct);
        return ProductResponse.success("Producto Actualizado Exitosamente", updatedProduct);
    }
    //----------------------------------------------------------------------------------------------------------------------
    // 🔍 SEARCH
    public ResponseEntity<List<Product>> searchProduct(String name) {

       return null;
    }

}
