package br.com.caelum.controle.dao;

import java.util.List;

import br.com.caelum.controle.modelo.Funcionario;


public interface FuncionarioDAO {
	/*
	 * Delete the methods you don't want to expose
	 */
	 
	void create(Funcionario entity);
	
	Funcionario update(Funcionario entity);
	
	void destroy(Funcionario entity);
	
	Funcionario find(Long id);
	
	List<Funcionario> findAll();

}
