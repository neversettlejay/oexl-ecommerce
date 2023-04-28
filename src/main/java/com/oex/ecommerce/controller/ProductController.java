package com.oex.ecommerce.controller;


import com.oex.ecommerce.dto.GenericResponse;
import com.oex.ecommerce.dto.ProductData;
import com.oex.ecommerce.service.definition.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequiredArgsConstructor
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;
    @Operation(summary = "Add product details", description = "Add product with their product quantity here", tags = {"Product Controller"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Product added successfully"),
            @ApiResponse(responseCode = "401", description = "Unauthorized"),
            @ApiResponse(responseCode = "403", description = "Forbidden"),
            @ApiResponse(responseCode = "404", description = "Resource not found")
    })
    @PostMapping
    public ResponseEntity<GenericResponse> addProduct(@RequestParam(value = "product_name") String productName, @RequestParam(value = "product_description") String productDescription,@RequestParam(value = "product_type") String productType,@RequestParam(value = "product_quantity") int productQuantity) {
        return new ResponseEntity<>(new GenericResponse(true, "Classic View Projects returned successfully", productService.addProduct(new ProductData(productName,productDescription,productType,productQuantity)), HttpStatus.OK.value(), LocalDateTime.now()), HttpStatus.OK);
    }




}
