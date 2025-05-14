package com.deloitte.deloitte.dto.repository;

import com.deloitte.deloitte.dto.model.entity.Compras;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ComprasRepository extends JpaRepository<Compras, Long> {
}
