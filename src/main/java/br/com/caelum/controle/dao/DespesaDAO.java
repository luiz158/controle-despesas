package br.com.caelum.controle.dao;

import java.util.List;

import br.com.caelum.controle.modelo.Gasto;


public interface DespesaDAO {
	/*
	 * Delete the methods you don't want to expose
	 */
	 
	void create(Gasto entity);
	
	Gasto update(Gasto entity);
	
	void destroy(Gasto entity);
	
	Gasto find(Long id);
	
	List<Gasto> findAll();

}
