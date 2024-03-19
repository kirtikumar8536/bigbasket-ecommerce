package com.bigbasket.entites;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.repository.Query;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "customer_order")
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
            cascade = {CascadeType.PERSIST, CascadeType.MERGE}
    )
    private List<OrderItem> orderItems = new ArrayList<>();
}
//do not use order as table name --The word "order" is a reserved keyword in most SQL databases, including MySQL. Using reserved keywords as table or column names can lead to conflicts and errors during DDL execution.
/*Hibernate: create table order (order_id bigint not null auto_increment, order_status varchar(255), email varchar(255), order_date date, total_amount double precision, primary key (order_id)) engine=InnoDB
2024-03-18 00:12:08.122  WARN 8648 --- [  restartedMain] o.h.t.s.i.ExceptionHandlerLoggedImpl     : GenerationTarget encountered exception accepting command : Error executing DDL "create table order (order_id bigint not null auto_increment, order_status varchar(255), email varchar(255), order_date date, total_amount double precision, primary key (order_id)) engine=InnoDB" via JDBC Statement

org.hibernate.tool.schema.spi.CommandAcceptanceException: Error executing DDL "create table order (order_id bigint not null auto_increment, order_status varchar(255), email varchar(255), order_date date, total_amount double precision, primary key (order_id)) engine=InnoDB" via JDBC Statement*/