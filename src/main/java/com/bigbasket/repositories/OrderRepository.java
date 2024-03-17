package com.bigbasket.repositories;

import com.bigbasket.entites.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
