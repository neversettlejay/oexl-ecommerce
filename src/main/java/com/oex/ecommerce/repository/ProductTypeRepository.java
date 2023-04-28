package com.oex.ecommerce.repository;

import com.oex.ecommerce.model.Product;
import com.oex.ecommerce.model.ProductType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductTypeRepository  extends JpaRepository<ProductType, Long> {
    @Query(value = "SELECT pt FROM ProductType pt WHERE pt.productType = ?1 LIMIT 1")
    Optional<ProductType> findByProductType(String productTypeString);
}
