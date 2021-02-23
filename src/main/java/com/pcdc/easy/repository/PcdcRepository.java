package com.pcdc.easy.repository;

import com.pcdc.easy.model.App.Pcdc;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PcdcRepository extends JpaRepository<Pcdc, Long> {
}
