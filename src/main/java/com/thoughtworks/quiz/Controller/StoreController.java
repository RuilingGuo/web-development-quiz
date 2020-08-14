package com.thoughtworks.quiz.Controller;

import com.thoughtworks.quiz.Dto.ProductDto;
import com.thoughtworks.quiz.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
public class StoreController {

    @Autowired
    ProductService productService;

    @GetMapping("/product/list")
    public ResponseEntity<List<ProductDto>> getProductList(){
        return ResponseEntity.status(HttpStatus.OK).body(productService.getProductList());
    }

}
