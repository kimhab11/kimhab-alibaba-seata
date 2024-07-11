package com.example.kimhabalibabaseataserver.quickstart.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "orders")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String userId;
    private String commodityCode;
    private int orderCount;
    private int money;
}
