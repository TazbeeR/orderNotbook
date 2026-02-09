package com.example.zeszyt02.entity;

import com.example.zeszyt02.entity.DTO.OrderItem;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "orders")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //TODO
    //Sprawdzić jaki obiekt tu przyjdzie

//    private List<OrderItem> listOfOrderItems;

    private boolean status;

    @CreationTimestamp
    @Column(updatable = false, nullable = false)
    private LocalDateTime creationDate;

    @UpdateTimestamp
    private LocalDateTime updateDate;

//    @OneToOne
//    @JoinColumn(name = "customer_id")
//    private Customers customer;
}
