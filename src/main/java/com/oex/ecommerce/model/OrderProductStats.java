package com.oex.ecommerce.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "order_product_stats")
public class OrderProductStats {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    // many orders can have many products
    // also defined productstockstats instead of product so that we can get to know the availability of the product without calling another repository
    @OneToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST}, fetch = FetchType.EAGER, targetEntity = ProductStockStats.class)
    private ProductStockStats productStockStats;
    private int productQuantityBrought;
    private LocalDateTime createdAt;
    private String createdBy;
    private LocalDateTime updatedAt;
    private String updatedBy;
    private LocalDateTime deletedAt;
    private String deletedBy;
}
