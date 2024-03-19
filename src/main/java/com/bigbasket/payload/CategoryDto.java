package com.bigbasket.payload;

import lombok.*;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CategoryDto {
    private Long categoryId;
    private String categoryName;
//	private List<ProductDTO> products = new ArrayList<>();

}
