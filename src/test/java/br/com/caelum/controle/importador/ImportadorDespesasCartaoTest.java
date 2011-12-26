package br.com.caelum.controle.importador;

import java.io.ByteArrayInputStream;
import java.io.UnsupportedEncodingException;
import java.util.List;

import junit.framework.Assert;

import org.junit.Test;

import br.com.caelum.controle.modelo.Despesa;
import br.com.caelum.controle.modelo.TipoDespesa;

public class ImportadorDespesasCartaoTest {

	@Test
	public void deveImportarDespesasDeTXTPosicional() throws UnsupportedEncodingException {
		
		String conteudo = "CARTAO2112201100001000011111111111\r\n"+
						  "CARTAO2112201100001010022222222222\r\n" + 
						  "CARTAO2112201100000304333333333333\r\n";
		
		Importador importador = new ImportadorDespesasCartao();
		
		List<Despesa> list = importador.importa(new ByteArrayInputStream(conteudo.getBytes("UTF-8")));
		
		Assert.assertEquals(3, list.size());
		Assert.assertEquals(TipoDespesa.CARTAO, list.get(0).getTipo());
		Assert.assertEquals(30.43,list.get(2).getValor(),0.00001);
		Assert.assertEquals("22222222222", list.get(1).getFuncionario().getCpf());
		
	}

}
