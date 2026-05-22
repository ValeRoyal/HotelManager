package com.acm.repository;

import com.acm.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsarioRepository extends JpaRepository<Usuario, Long> {
}
