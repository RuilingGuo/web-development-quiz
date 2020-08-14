package com.thoughtworks.quiz.Repository;

import com.thoughtworks.quiz.Dto.ProductDto;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends CrudRepository<ProductDto,Integer> {

    @Override
    List<ProductDto> findAll();
}
