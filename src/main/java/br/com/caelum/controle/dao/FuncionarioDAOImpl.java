package br.com.caelum.controle.dao;

import javax.persistence.EntityManager;

import br.com.caelum.controle.modelo.Funcionario;
import br.com.caelum.vraptor.ioc.Component;

@Component
public class FuncionarioDAOImpl
    extends DAO<Funcionario, Long>
    implements FuncionarioDAO {

	FuncionarioDAOImpl(EntityManager entityManager) {
		super(entityManager);
	}
}
