package com.thoughtworks.quiz.Dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Entity
@Table(name = "product_order")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderDto {
    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int productId;
    private int number;

    public OrderDto(int productId, int number) {
        this.productId = productId;
        this.number = number;
    }

    public void add(int num){
        this.number += num;
    }
}
