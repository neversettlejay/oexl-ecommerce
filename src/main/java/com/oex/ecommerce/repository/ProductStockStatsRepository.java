package com.oex.ecommerce.repository;

import com.oex.ecommerce.model.ProductStockStats;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductStockStatsRepository  extends JpaRepository<ProductStockStats, Long> {
}
