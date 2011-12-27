package br.com.caelum.controle.importador;

import java.io.ByteArrayInputStream;
import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.util.List;

import junit.framework.Assert;

import org.junit.Test;

import br.com.caelum.controle.modelo.Gasto;

public class ImportadorTest {

	@Test
	public void test() throws UnsupportedEncodingException, ParseException {
		String conteudo = "CARTAO01012011000010000123                jbjasbd jbjbbb22071983\r\n"
				+ "CARTAO01012011000010000123                jbjasbd jbjbbb22071983\r\n"
				+ "CARTAO01012011000010000123                jbjasbd jbjbbb22071983\r\n";

		Importador importador = new Importador();

		List<Gasto> list = importador.importa(new ByteArrayInputStream(
				conteudo.getBytes("UTF-8")));

		Assert.assertEquals(3, list.size());
		Assert.assertEquals("CARTAO", list.get(0).getTipo());
		Assert.assertEquals(100.0, list.get(2).getValor(), 0.00001);
		Assert.assertEquals("jbjasbd jbjbbb", list.get(1).getFuncionario().getNome());

	}

}
