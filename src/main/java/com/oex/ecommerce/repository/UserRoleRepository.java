package com.oex.ecommerce.repository;

import com.oex.ecommerce.model.Product;
import com.oex.ecommerce.model.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRoleRepository  extends JpaRepository<UserRole, Long> {
}
