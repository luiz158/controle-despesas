package br.com.caelum.controle.dao;

import java.util.List;

import br.com.caelum.controle.modelo.Despesa;


public interface DespesaDAO {
	/*
	 * Delete the methods you don't want to expose
	 */
	 
	void create(Despesa entity);
	
	Despesa update(Despesa entity);
	
	void destroy(Despesa entity);
	
	Despesa find(Long id);
	
	List<Despesa> findAll();

}
