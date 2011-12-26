package br.com.caelum.controle.importador;

import java.io.InputStream;
import java.util.List;

import br.com.caelum.controle.modelo.Despesa;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

public class ImportadorDespesasTelefone implements Importador {

	private XStream stream = new XStream(new DomDriver());

	public ImportadorDespesasTelefone() {
		stream.alias("gasto", Despesa.class);
	}

	@Override
	public List<Despesa> importa(InputStream entrada) {

		List<Despesa> gastos = (List<Despesa>) stream.fromXML(entrada);
		return gastos;
	}

}
