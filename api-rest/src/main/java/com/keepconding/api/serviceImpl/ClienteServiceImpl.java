package com.keepconding.api.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.keepconding.api.entity.Cliente;
import com.keepconding.api.repository.ClienteRepository;
import com.keepconding.api.service.ClienteService;

@Service
public class ClienteServiceImpl implements ClienteService{

	@Autowired
	private ClienteRepository repository;
	
	@Override
	@Transactional(readOnly = true)
	public List<Cliente> listarClientes() {
		return (List<Cliente>) repository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Cliente clientePorId(Long id) {
		return repository.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public Cliente guardarCliente(Cliente cliente) {
		return repository.save(cliente);
	}

	@Override
	@Transactional
	public void borrarCliente(Long id) {
		repository.deleteById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public Cliente clientePorNombre(String nombre) {
	
		return repository.findByNombre2(nombre);
	}

	@Override
	@Transactional(readOnly = true)
	public Cliente clientePorNomApell(String nombre, String apellido) {
		return repository.findByNombreAndApellido(nombre, apellido);
	}

	@Override
	@Transactional(readOnly = true)
	public Cliente clientePorEmailTelef(String email, int telefono) {
		return repository.findByEmailAndTelefono(email, telefono);
	}
	
	

}
