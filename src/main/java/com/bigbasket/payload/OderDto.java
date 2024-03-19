package com.bigbasket.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OderDto {
    private Long orderId;
    private String email;
    private List<OrderItemDto> orderItems = new ArrayList<>();
    private LocalDate orderDate;
   // private PaymentDTO payment;
    private Double totalAmount;
    private String orderStatus;
}
