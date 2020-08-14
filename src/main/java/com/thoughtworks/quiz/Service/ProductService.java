package com.thoughtworks.quiz.Service;

import com.thoughtworks.quiz.Dto.ProductDto;
import com.thoughtworks.quiz.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    public List<ProductDto> getProductList() {
        return productRepository.findAll();
    }

}
