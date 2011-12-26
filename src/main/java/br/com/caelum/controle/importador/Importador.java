package br.com.caelum.controle.importador;

import java.io.InputStream;
import java.util.List;

import br.com.caelum.controle.modelo.Despesa;

public interface Importador {

	public List<Despesa> importa(InputStream entrada);

}