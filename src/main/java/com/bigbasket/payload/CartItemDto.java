package com.bigbasket.payload;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CartItemDto {
    private Long cartItemId;
    private CartDto cart;
    private ProductDto product;
    private Integer quantity;
    private double discount;
    private double productPrice;
}
