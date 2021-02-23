package com.pcdc.easy.repository;

import com.pcdc.easy.model.User.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
