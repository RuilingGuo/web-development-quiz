package com.thoughtworks.quiz.Controller;

import com.thoughtworks.quiz.Service.OrderService;
import com.thoughtworks.quiz.pojo.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
public class OrderController {
    @Autowired
    OrderService orderService;

    @GetMapping("/order")
    public ResponseEntity getOrder(){
        return  ResponseEntity.status(HttpStatus.OK).body(orderService.getOrderList());
    }

    @PostMapping("/order")
    public ResponseEntity addOrder(@RequestBody Order order){
        orderService.addOrder(order);
        return  ResponseEntity.status(HttpStatus.OK).body("成功添加");
    }

    @DeleteMapping("/order")
    public ResponseEntity deleteOrder(@RequestParam Integer orderId){
        orderService.deleteOrder(orderId);
        return  ResponseEntity.status(HttpStatus.OK).body("成功删除");
    }

}
