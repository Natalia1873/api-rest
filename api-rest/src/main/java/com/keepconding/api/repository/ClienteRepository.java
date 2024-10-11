package com.keepconding.api.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.keepconding.api.entity.Cliente;
import java.util.List;


@Repository
public interface ClienteRepository extends CrudRepository<Cliente, Long>{
	
	Cliente findByNombre(String nombre);
	
	@Query("select n from Cliente n where n.nombre = ?1")
	Cliente findByNombre2(String nombre);
	
	//nombre y apellido
	Cliente findByNombreAndApellido(String nombre,String apellido);
	//email y telefono
	Cliente findByEmailAndTelefono(String email, int telefono);

}
