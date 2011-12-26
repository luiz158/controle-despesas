package br.com.caelum.controle.dao;

import javax.persistence.EntityManager;

import br.com.caelum.controle.modelo.Despesa;
import br.com.caelum.vraptor.ioc.Component;

@Component
public class DespesaDAOImpl
    extends DAO<Despesa, Long>
    implements DespesaDAO {

	DespesaDAOImpl(EntityManager entityManager) {
		super(entityManager);
	}
}
