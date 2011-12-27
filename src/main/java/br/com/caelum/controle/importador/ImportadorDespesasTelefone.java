package br.com.caelum.controle.importador;

import java.io.InputStream;
import java.util.List;

import br.com.caelum.controle.modelo.Gasto;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

public class ImportadorDespesasTelefone implements ImportadorBla {

	private XStream stream = new XStream(new DomDriver());

	public ImportadorDespesasTelefone() {
		stream.alias("gasto", Gasto.class);
	}

	@Override
	public List<Gasto> importa(InputStream entrada) {

		List<Gasto> gastos = (List<Gasto>) stream.fromXML(entrada);
		return gastos;
	}

}
