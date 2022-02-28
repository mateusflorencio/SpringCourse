package com.florencio.springcourse.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.florencio.springcourse.domain.Cliente;
import com.florencio.springcourse.domain.Pedido;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Integer> {
		
		@Transactional (readOnly= true)
		Page<Pedido> findByCliente(Cliente cliente, Pageable pageRequest);
			
		

}