package com.thoughtworks.quiz.Repository;

import com.thoughtworks.quiz.Dto.OrderDto;
import com.thoughtworks.quiz.Dto.ProductDto;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public interface OrderRepository extends CrudRepository<OrderDto,Integer> {
    @Override
    List<OrderDto> findAll();

    @Override
    void deleteById(Integer integer);


    Optional<OrderDto> findByProductId(Integer integer);

    @Override
    void delete(OrderDto entity);

    @Override
    Optional<OrderDto> findById(Integer integer);

    @Override
    void deleteAll();

    @Transactional
    @Modifying
    @Query(value = "alter table product_order auto_increment = 1",nativeQuery = true)
    void initAutoIncrement();

}
