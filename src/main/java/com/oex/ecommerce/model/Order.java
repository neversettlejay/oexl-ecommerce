package com.oex.ecommerce.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Collection;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "order")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    //one user can have multiple orders but one order cant be of multiple users
    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST}, targetEntity = User.class)
    private User user;

    // one order can have multiple products also one product in an order can have any number of quantity
    @OneToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST}, targetEntity = OrderProductStats.class)
    private Collection<OrderProductStats> orderProductStatsCollection;

    private LocalDateTime createdAt;
    private String createdBy;
    private LocalDateTime updatedAt;
    private String updatedBy;
    private LocalDateTime deletedAt;
    private String deletedBy;
}

