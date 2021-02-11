package br.com.cod3r.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.cod3r.springboot.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long>{

}
