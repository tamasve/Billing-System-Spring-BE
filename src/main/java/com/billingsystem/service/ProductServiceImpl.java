package com.billingsystem.service;

import com.billingsystem.entity.Product;
import com.billingsystem.entity.ProductDTO;
import com.billingsystem.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService{

    ProductRepository productRepository;
    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {this.productRepository = productRepository;}

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Optional<Product> findById(Long id) {
        return productRepository.findById(id);
    }

    @Override
    public List<ProductDTO> findAllWithCatName() {
        return productRepository.findAllWithCatName();
    }
}
