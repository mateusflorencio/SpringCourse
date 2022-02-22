package com.florencio.springcourse.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.florencio.springcourse.domain.Estado;

@Repository
public interface EstadoRepository extends JpaRepository<Estado, Integer> {

}