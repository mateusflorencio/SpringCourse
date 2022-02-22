package com.florencio.springcourse;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.florencio.springcourse.domain.Categoria;
import com.florencio.springcourse.domain.Cidade;
import com.florencio.springcourse.domain.Cliente;
import com.florencio.springcourse.domain.Endereco;
import com.florencio.springcourse.domain.Estado;
import com.florencio.springcourse.domain.Produto;
import com.florencio.springcourse.domain.enums.TipoCliente;
import com.florencio.springcourse.repositories.CategoriaRepository;
import com.florencio.springcourse.repositories.CidadeRepository;
import com.florencio.springcourse.repositories.ClienteRepository;
import com.florencio.springcourse.repositories.EnderecoRepository;
import com.florencio.springcourse.repositories.EstadoRepository;
import com.florencio.springcourse.repositories.ProdutoRepository;

@SpringBootApplication
public class SpringCourseApplication implements CommandLineRunner {

	@Autowired
	private CategoriaRepository categoriaRepository;
	@Autowired
	private ProdutoRepository produtoRepository;
	@Autowired
	private EstadoRepository estadoRepository;
	@Autowired
	private CidadeRepository cidadeRepository;
	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired EnderecoRepository enderecoRepository;

	public static void main(String[] args) {
		SpringApplication.run(SpringCourseApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Categoria cat1 = new Categoria(null, "Informatica");
		Categoria cat2 = new Categoria(null, "Escritório");
		
		Produto p1= new Produto(null, "Computador", 2000.00);
		Produto p2= new Produto(null, "Impressora", 800.00);
		Produto p3= new Produto(null, "mouse", 80.00);
	
		cat1.getProdutos().addAll(Arrays.asList(p1,p2,p3));
		cat2.getProdutos().addAll(Arrays.asList(p2));
		
		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1,cat2));
		p3.getCategorias().addAll(Arrays.asList(cat1));
	
		categoriaRepository.saveAll(Arrays.asList(cat1, cat2));
		produtoRepository.saveAll(Arrays.asList(p1,p2,p3));
		
		Estado est1=new Estado (null, "Minas Gerais");
		Estado est2=new Estado (null, "São Paulo");
		
		Cidade c1 = new Cidade(null, "Uberlândia", est1);
		Cidade c2 = new Cidade(null, "São Pualo", est2);
		Cidade c3 = new Cidade(null, "Campinas", est2);

		
		est1.getCidades().addAll(Arrays.asList(c1));
		est2.getCidades().addAll(Arrays.asList(c2,c3));
		
		estadoRepository.saveAll(Arrays.asList(est1,est2));
		cidadeRepository.saveAll(Arrays.asList(c1,c2,c3));
		
		Cliente cli1=new Cliente(	null, "Maria silva", "maria@gmail.com", "3215489754", TipoCliente.PESSOAFISICA);
		cli1.getTelefones().addAll(Arrays.asList("11433512725", "11548455456"));
		
		Endereco e1=new Endereco(null, "Rua Flores" ,"300", "apto 300", "jardim", "38945000", cli1, c1);
		Endereco e2=new Endereco(null, "Rua marta" ,"545", "apto 7848", "Bernardo", "48744568", cli1, c2);
		
		cli1.getEnderecos().addAll(Arrays.asList(e1,e2));
		
		clienteRepository.saveAll(Arrays.asList(cli1));
		enderecoRepository.saveAll(Arrays.asList(e1,e2));
		
	
	}

}