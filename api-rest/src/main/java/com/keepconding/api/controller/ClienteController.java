package com.keepconding.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.keepconding.api.entity.Cliente;
import com.keepconding.api.service.ClienteService;


@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST})
@RequestMapping("/api")
public class ClienteController {

	@Autowired
	private ClienteService clienteService;
	
	@GetMapping("/clientes")
	public List<Cliente> index(){
		return clienteService.listarClientes();
	}
	
	@GetMapping("/clientes/{id}")
	public Cliente show(@PathVariable Long id) {
		return clienteService.clientePorId(id);
	}
	
	@GetMapping("/clientes/name/{name}")
	public Cliente showName(@PathVariable String name) {
		return clienteService.clientePorNombre(name);
	}
	@GetMapping("/clientes/search/name/{name}/lastname/{lastname}")
	public Cliente showNameLastName(@PathVariable String name,@PathVariable String lastname) {
		return clienteService.clientePorNomApell(name,lastname);
	}
	@GetMapping("/clientes/search/phone/{telefono}/email/{email}")
	public Cliente showPhoneEmail(@PathVariable String email,@PathVariable int telefono) {
		return clienteService.clientePorEmailTelef(email,telefono);
	}
	@PostMapping("/clientes")
	@ResponseStatus(HttpStatus.CREATED)
	public Cliente clienteSave(@RequestBody Cliente cliente) {
		return clienteService.guardarCliente(cliente);
	}
	
	@PutMapping("/clientes/update/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public Cliente clienteUpdate(@PathVariable Long id, @RequestBody Cliente cliente) {
		//recuperar el registro de cliente que quiere ser modificado
		Cliente clienteUpdateRequest = clienteService.clientePorId(id);
		//cargar los nuevos registros desde el modelo recibido, cliente
		clienteUpdateRequest.setNombre(cliente.getNombre());
		clienteUpdateRequest.setApellido(cliente.getApellido());
		clienteUpdateRequest.setEmail(cliente.getEmail());
		clienteUpdateRequest.setTelefono(cliente.getTelefono());
		clienteUpdateRequest.setCreatedAt(cliente.getCreatedAt());
		
		
		return clienteService.guardarCliente(clienteUpdateRequest);
	}
	
	@DeleteMapping("/clientes/{id}")
	@ResponseStatus(HttpStatus.OK)
	public void deleteCliente(@PathVariable Long id) {
		clienteService.borrarCliente(id);
	}
	
	
}
