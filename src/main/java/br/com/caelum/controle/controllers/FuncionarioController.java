package br.com.caelum.controle.controllers;

import java.util.List;

import br.com.caelum.controle.dao.FuncionarioDAO;
import br.com.caelum.controle.modelo.Funcionario;
import br.com.caelum.vraptor.Delete;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Put;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.Validator;

@Resource
public class FuncionarioController {

	private final Result result;
	private final FuncionarioDAO repository;
	private final Validator validator;
	
	FuncionarioController(Result result, FuncionarioDAO repository, Validator validator) {
		this.result = result;
		this.repository = repository;
		this.validator = validator;
	}
	
	@Get("/funcionarios")
	public List<Funcionario> index() {
		return repository.findAll();
	}
	
	@Post("/funcionarios")
	public void create(Funcionario funcionario) {
		validator.validate(funcionario);
		validator.onErrorUsePageOf(this).newFuncionario();
		repository.create(funcionario);
		result.redirectTo(this).index();
	}
	
	@Get("/funcionarios/new")
	public Funcionario newFuncionario() {
		return new Funcionario();
	}
	
	@Put("/funcionarios")
	public void update(Funcionario funcionario) {
		validator.validate(funcionario);
		validator.onErrorUsePageOf(this).edit(funcionario);
		repository.update(funcionario);
		result.redirectTo(this).index();
	}
	
	@Get("/funcionarios/{funcionario.id}/edit")
	public Funcionario edit(Funcionario funcionario) {
		return repository.find(funcionario.getId());
	}

	@Get("/funcionarios/{funcionario.id}")
	public Funcionario show(Funcionario funcionario) {
		return repository.find(funcionario.getId());
	}

	@Delete("/funcionarios/{funcionario.id}")
	public void destroy(Funcionario funcionario) {
		repository.destroy(repository.find(funcionario.getId()));
		result.redirectTo(this).index();  
	}
}