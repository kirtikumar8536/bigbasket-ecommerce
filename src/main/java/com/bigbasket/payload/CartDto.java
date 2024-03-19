package com.bigbasket.payload;

import java.util.ArrayList;
import java.util.List;

public class CartDto {
    private Long cartId;
    private Double totalPrice = 0.0;
    private List<ProductDto> products = new ArrayList<>();
}
