package com.ym.service;

import java.util.List;

import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.ym.converter.NotaConverter;
import com.ym.entity.Nota;
import com.ym.model.NotaModel;
import com.ym.repository.NotaRepository;

@Service("NotaService")
public class NotaService {
	
	@Autowired
	@Qualifier("NotaRepository")
	private NotaRepository repo;
	
	
	@Autowired
	@Qualifier("NotaConverter")
	private NotaConverter converter;
	
	private static final Log logger = LogFactory.getLog(NotaService.class);
	
	public boolean AddNota(Nota nota) {
		logger.info("CREANDO NOTA");
		try {
			repo.save(nota);
			return true;
					
			
		}catch(Exception e){
			logger.error("ERROR CREANDO NOTA: " + e);
			return false;
		}
		
	}
	
	public boolean UpdateNota(Nota nota) {
		logger.info("ACTUALIZANDO NOTA");
			try {
				repo.save(nota);
				return true;
						
				
			}catch(Exception e){
				
				return false;
			}
			
		}
	
	public boolean DeleteNota(String nombre, long id) {
			logger.info("ELIMINANDO NOTA");
				try {
					Nota nota = repo.findByNombreAndId(nombre, id);
					repo.delete(nota);
					return true;
							
					
				}catch(Exception e){
					
					return false;
				}
				
			}
		
	public List<NotaModel> getAllNota() {
			logger.info("LISTANDO NOTA");
				return converter.convertirLista(repo.findAll());
			
		}
	
	public NotaModel getNombreTitulo(String nombre, String titulo) {
		
			return new NotaModel(repo.findByNombreAndTitulo(nombre, titulo));
		
	}
	
	public List<NotaModel> getTitulo(String titulo) {
		
				return converter.convertirLista(repo.findByTitulo(titulo));
			
		}
	
	public List<NotaModel> getAllNotaPage(Pageable pageable){
		
		return converter.convertirLista(repo.findAll(pageable).getContent());
		
	}
	

}
