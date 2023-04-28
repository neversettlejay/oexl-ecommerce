package com.oex.ecommerce.repository;

import com.oex.ecommerce.model.ProductStockStats;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface ProductStockStatsRepository extends JpaRepository<ProductStockStats, Long> {

    @Query("select pss from ProductStockStats pss where pss.product.productType.productType=?1")
    List<ProductStockStats> getAllProductByProductType(String productType);

    @Query("select pss from ProductStockStats pss")
    List<ProductStockStats> getAllProducts();
}
