package com.anasdev.clientorder.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.time.Instant;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@ToString
@Entity
@Table(name = "ClientOrder")
public class Order {

    @Id
    @GeneratedValue
    private Long id;
    private long clientId;
    private double price;
    private Instant orderTime;
}
