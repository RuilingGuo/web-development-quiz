package com.thoughtworks.quiz.Service;

import com.thoughtworks.quiz.Dto.OrderDto;

import com.thoughtworks.quiz.Exception.BadRequestException;
import com.thoughtworks.quiz.Repository.OrderRepository;
import com.thoughtworks.quiz.pojo.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    OrderRepository orderRepository;

    public List<OrderDto> getOrderList() {
        return orderRepository.findAll();
    }

    @Transactional
    public void addOrder(Order order) {
        Optional<OrderDto> optionalOrderDto = orderRepository.findByProductId(order.getProductId());
        if(optionalOrderDto.isPresent()){
            OrderDto orderDto = optionalOrderDto.get();
            orderDto.add(order.getNum());
            orderRepository.save(orderDto);
            return;
        }
        orderRepository.save(new OrderDto(order.getProductId(),order.getNum()));
    }

    @Transactional
    public void deleteOrder(Integer orderId){
        Optional<OrderDto> optionalOrderDto = orderRepository.findById(orderId);
        if(optionalOrderDto.isPresent()){
            OrderDto orderDto = optionalOrderDto.get();
            orderRepository.delete(orderDto);
            return;
        }
        throw new BadRequestException("Order is not found");
    }

}
