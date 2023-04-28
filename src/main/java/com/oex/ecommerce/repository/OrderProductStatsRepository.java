package com.oex.ecommerce.repository;

import com.oex.ecommerce.model.OrderProductStats;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderProductStatsRepository  extends JpaRepository<OrderProductStats, Long> {
}
