package com.bigbasket.payload;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderItemDto {
    private Long orderItemId;
    private ProductDto product;
    private Integer quantity;
    private double discount;
    private double orderedProductPrice;
}
