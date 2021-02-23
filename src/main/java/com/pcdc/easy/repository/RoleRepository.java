package com.pcdc.easy.repository;

import com.pcdc.easy.model.User.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role,Long> {

}
