package br.com.caelum.controle.importador;

import java.io.ByteArrayInputStream;
import java.io.UnsupportedEncodingException;
import java.util.List;

import junit.framework.Assert;

import org.junit.Test;

import br.com.caelum.controle.modelo.Despesa;
import br.com.caelum.controle.modelo.TipoDespesa;

public class ImportadorDespesasGasolinaTest {

	@Test
	public void deveImportarDespesasDeArquivoCSV() throws UnsupportedEncodingException {
		String conteudo = "GASOLINA,21122011,000010000,11111111111\r\n"
				+ "GASOLINA,21122011,000010100,22222222222\r\n"
				+ "GASOLINA,21122011,000003043,33333333333\r\n";

		Importador importador = new ImportadorDespesasGasolina();

		List<Despesa> list = importador.importa(new ByteArrayInputStream(
				conteudo.getBytes("UTF-8")));

		Assert.assertEquals(3, list.size());
		Assert.assertEquals(TipoDespesa.GASOLINA, list.get(0).getTipo());
		Assert.assertEquals(30.43, list.get(2).getValor(), 0.00001);
		Assert.assertEquals("22222222222", list.get(1).getFuncionario()
				.getCpf());
	}

}
