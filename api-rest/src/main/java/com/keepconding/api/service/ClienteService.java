package com.keepconding.api.service;

import java.util.List;

import com.keepconding.api.entity.Cliente;

public interface ClienteService {

	//metodo para listar clientes
	public List<Cliente> listarClientes();
	
	//metodo para buscar un cliente por id
	public Cliente clientePorId(Long id);
	
	//metodo para guardar un cliente
	public Cliente guardarCliente(Cliente cliente);
	
	//metodo para eliminar cliente por id
	public void borrarCliente(Long id);
	
	public Cliente clientePorNombre(String nombre);
	
	//metodo de busqueda por nombre y apellido
	public Cliente clientePorNomApell(String nombre,String apellido);
	
	//meotod de busqueda por email y telefono
	public Cliente clientePorEmailTelef(String email,int telefono);
}
