package com.ht.scada.security.dao;

import com.ht.scada.security.entity.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRoleDao extends JpaRepository<UserRole, Integer> {
    UserRole findByName(String name);
}
