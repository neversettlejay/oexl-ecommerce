package com.oex.ecommerce.service.implementation;

import com.oex.ecommerce.dto.ProductData;
import com.oex.ecommerce.enums.ProductType;
import com.oex.ecommerce.exception.customexceptions.ResourceNotFoundException;
import com.oex.ecommerce.model.Product;
import com.oex.ecommerce.model.ProductStockStats;
import com.oex.ecommerce.repository.ProductRepository;
import com.oex.ecommerce.repository.ProductStockStatsRepository;
import com.oex.ecommerce.repository.ProductTypeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService implements com.oex.ecommerce.service.definition.ProductService {
    private final ProductTypeRepository productTypeRepository;
    private final ProductRepository productRepository;
    private final ProductStockStatsRepository productStockStatsRepository;

    @Override
    @Transactional
    public String addProduct(ProductData productData) {

        com.oex.ecommerce.model.ProductType productType = productTypeRepository.findByProductType(productData.getProductType()).orElseThrow(() -> new ResourceNotFoundException("Product type of the type: '" + productData.getProductType() + "'  not found in the database"));

        Product toAddProduct = new Product(0, productData.getProductName(), productData.getProductDescription(), productType, LocalDateTime.now(), "default", null, null, null, null);

        productRepository.save(toAddProduct);

        ProductStockStats toAddProductStockStats = new ProductStockStats(0, toAddProduct, productData.getQuantity(), LocalDateTime.now(), "SecurityContextHolder.getContext().getAuthentication() " /* left to be implement*/, null, null, null, null);

        productStockStatsRepository.save(toAddProductStockStats);

        return "Product added successfully";
    }

    @Override
    public void reduceProduct(ProductData productData, int quantity) {

    }

    @Override
    public List<ProductData> listProductByProductType(String productType) {
        return productStockStatsRepository.getAllProductByProductType(productType).stream().map(productStockStats -> new ProductData(productStockStats.getProduct().getProductName(), productStockStats.getProduct().getProductDescription(), productStockStats.getProduct().getProductType().getProductType(), productStockStats.getProductQuantity())).toList();
    }

    @Override
    public List<ProductData> listAllProducts() {
        return productStockStatsRepository.getAllProducts().stream().map(productStockStats -> new ProductData(productStockStats.getProduct().getProductName(), productStockStats.getProduct().getProductDescription(), productStockStats.getProduct().getProductType().getProductType(), productStockStats.getProductQuantity())).toList();
    }
}
