package br.com.cod3r.springboot.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.cod3r.springboot.exception.ResourceNotFoundException;
import br.com.cod3r.springboot.model.Cliente;
import br.com.cod3r.springboot.repository.ClienteRepository;

@RestController
@RequestMapping("/api/v1/")
public class ClienteController {

	@Autowired
	ClienteRepository clienteRepository;

	
	@GetMapping("/clientes")
	public List<Cliente> getAllClientes() {
		return clienteRepository.findAll();
	}

	@PostMapping("/clientes")
	public Cliente saveCliente(@RequestBody Cliente cliente) {
		return clienteRepository.save(cliente);
	}

	@GetMapping("/clientes/{id}")
	public ResponseEntity<Cliente> getClienteById(@PathVariable Long id) {
		Cliente cliente = clienteRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Não exite o cliente com essa" + id));
		return ResponseEntity.ok(cliente);

	}

	@PutMapping("/clientes/{id}")
	public ResponseEntity<Cliente> updateCliente(@PathVariable Long id,@RequestBody Cliente clienteDetails) {
		Cliente cliente = clienteRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Não exite o cliente com essa" + id));
		
		cliente.setNome(clienteDetails.getNome());
		cliente.setCpf(clienteDetails.getCpf());
		cliente.setTelefone(clienteDetails.getTelefone());
		cliente.setEmail(clienteDetails.getEmail());
		
		Cliente updateCliente = clienteRepository.save(cliente);
		return ResponseEntity.ok(updateCliente);
	}
	
	@DeleteMapping("/clientes/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteCliente(@PathVariable Long id) {
		Cliente cliente = clienteRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Não existe cliente com esse id!" + id));
		
		clienteRepository.delete(cliente);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
}
