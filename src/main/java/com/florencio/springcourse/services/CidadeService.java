package com.florencio.springcourse.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.florencio.springcourse.domain.Cidade;
import com.florencio.springcourse.domain.Estado;
import com.florencio.springcourse.repositories.CidadeRepository;

@Service
public class CidadeService {

	@Autowired
	private CidadeRepository repo;

	public List<Cidade> findEstado(Integer estadoId) {
		return repo.findCidades(estadoId);
	}

}
