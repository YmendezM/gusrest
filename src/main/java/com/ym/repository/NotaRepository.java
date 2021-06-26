package com.ym.repository;

import java.io.Serializable;
import java.util.List;
import com.ym.entity.Nota;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("NotaRepository")
public interface NotaRepository extends JpaRepository<Nota, Serializable> {

	public abstract Nota findByNombre(String nombre);
	
	public abstract List<Nota> findByTitulo(String titulo);
	
	public abstract Nota findByNombreAndTitulo(String nombre, String titulo);
	
	public abstract	Nota findByNombreAndId(String nombre, long id);
	
	
}
