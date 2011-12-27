package br.com.caelum.controle.controllers;

import java.util.List;

import br.com.caelum.controle.dao.DespesaDAO;
import br.com.caelum.controle.modelo.Gasto;
import br.com.caelum.vraptor.Delete;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Put;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.Validator;

@Resource
public class DespesaController {

	private final Result result;
	private final DespesaDAO repository;
	private final Validator validator;
	
	DespesaController(Result result, DespesaDAO repository, Validator validator) {
		this.result = result;
		this.repository = repository;
		this.validator = validator;
	}
	
	@Get("/despesas")
	public List<Gasto> index() {
		return repository.findAll();
	}
	
	@Post("/despesas")
	public void create(Gasto despesa) {
		validator.validate(despesa);
		validator.onErrorUsePageOf(this).newDespesa();
		repository.create(despesa);
		result.redirectTo(this).index();
	}
	
	@Get("/despesas/new")
	public Gasto newDespesa() {
		return new Gasto();
	}
	
	@Put("/despesas")
	public void update(Gasto despesa) {
		validator.validate(despesa);
		validator.onErrorUsePageOf(this).edit(despesa);
		repository.update(despesa);
		result.redirectTo(this).index();
	}
	
	@Get("/despesas/{despesa.id}/edit")
	public Gasto edit(Gasto despesa) {
		return repository.find(despesa.getId());
	}

	@Get("/despesas/{despesa.id}")
	public Gasto show(Gasto despesa) {
		return repository.find(despesa.getId());
	}

	@Delete("/despesas/{despesa.id}")
	public void destroy(Gasto despesa) {
		repository.destroy(repository.find(despesa.getId()));
		result.redirectTo(this).index();  
	}
}