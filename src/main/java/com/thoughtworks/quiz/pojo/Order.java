package com.thoughtworks.quiz.pojo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import javax.persistence.Table;

@Component
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Order {

    private Integer productId;
    private Integer num;
}

