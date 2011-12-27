package br.com.caelum.controle.importador;

import java.io.InputStream;
import java.util.List;

import br.com.caelum.controle.modelo.Gasto;

public interface ImportadorBla {

	public List<Gasto> importa(InputStream entrada);

}