package com.oex.ecommerce.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductData {
    private String productName;
    private String productDescription;
    private String productType;
    private int quantity;
}
