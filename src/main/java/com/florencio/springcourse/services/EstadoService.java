package com.florencio.springcourse.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.florencio.springcourse.domain.Estado;
import com.florencio.springcourse.repositories.EstadoRepository;


@Service
public class EstadoService {

	@Autowired
	private EstadoRepository repo;
	
	public List <Estado> findAll(){
		return repo.findAllByOrderByNome();
	}
}
