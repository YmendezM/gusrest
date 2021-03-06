package com.ym.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Pageable;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ym.entity.Nota;
import com.ym.model.NotaModel;
import com.ym.service.NotaService;

@RestController
@RequestMapping("/v1")
public class NotaController {
	
	 @Autowired
	 @Qualifier("NotaService")
	 NotaService servi;
	 
	 
	 @PostMapping("/nota")
	 public boolean addNota(@RequestBody @Validated Nota nota){
		return servi.AddNota(nota);
		
	}
	
	 @PutMapping("/nota")
	 public boolean UpdateNota(@RequestBody @Validated Nota nota){
		return servi.UpdateNota(nota);
		
	}
	 
	 
	 @DeleteMapping("/nota/{id}/{nombre}")
	 public boolean deleteNota(@PathVariable("id") long id, @PathVariable("nombre") String nombre){
		
		//Debe retornar acorde a como fue definido en el servicio
		return servi.DeleteNota(nombre, id);
		
	}
	 
	@GetMapping("/notas")
	public List<NotaModel> getAllNota(Pageable pageable){
		
		return servi.getAllNotaPage(pageable);
	}
	 
	 

}
