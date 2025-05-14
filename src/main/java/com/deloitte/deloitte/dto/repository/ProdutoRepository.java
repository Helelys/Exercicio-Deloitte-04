package com.deloitte.deloitte.dto.repository;

import com.deloitte.deloitte.dto.model.entity.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}
