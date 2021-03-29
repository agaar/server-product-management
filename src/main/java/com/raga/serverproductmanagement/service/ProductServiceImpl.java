package com.raga.serverproductmanagement.service;

import com.raga.serverproductmanagement.model.Product;
import com.raga.serverproductmanagement.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional //support transaction management
public class ProductServiceImpl implements ProductService {

    @Autowired // injects the dependent beans into the associated references of a POJO class by matching the data-type
    private ProductRepository productRepository;

    @Override
    public Product saveProduct(final Product product){
        productRepository.save(product);
        return product;
    }

    @Override
    public Product updateProduct(final Product product){
        return productRepository.save(product);
    }

    @Override
    public void deleteProduct(final Long productId){
        productRepository.deleteById(productId);
    }

    @Override
    public Long numberOfProducts(){
        return productRepository.count();
    }

    @Override
    public List<Product> findAllProducts(){
        return productRepository.findAll();
    }

}
