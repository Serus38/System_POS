package com.milcolores.system_pos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.milcolores.system_pos.model.admin.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    
}
