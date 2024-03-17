package com.bigbasket.entites;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "order")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private Long orderId;

    private String email;

    @Column(name = "order_date")
    private LocalDate orderDate;

    @Column(name = "order_status")
    private String OrderStatus;

    @Column(name = "total_amount")
    private Double totalAmount;

    @OneToMany(mappedBy = "order",
              cascade = {CascadeType.PERSIST,CascadeType.MERGE}
            ,fetch = FetchType.EAGER)
    private List<OrderItem>orderItems=new ArrayList<>();
}
