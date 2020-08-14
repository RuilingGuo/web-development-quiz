package com.thoughtworks.quiz.Repository;

import com.thoughtworks.quiz.Dto.OrderDto;
import com.thoughtworks.quiz.Dto.ProductDto;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OrderRepository extends CrudRepository<OrderDto,Integer> {
    @Override
    List<OrderDto> findAll();

    @Override
    void deleteById(Integer integer);


    Optional<OrderDto> findByProductId(Integer integer);

}
