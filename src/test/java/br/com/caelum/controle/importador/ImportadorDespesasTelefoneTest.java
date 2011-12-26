package br.com.caelum.controle.importador;

import java.io.ByteArrayInputStream;
import java.io.UnsupportedEncodingException;
import java.util.List;

import junit.framework.Assert;

import org.junit.Test;

import br.com.caelum.controle.modelo.Despesa;
import br.com.caelum.controle.modelo.TipoDespesa;

public class ImportadorDespesasTelefoneTest {

	@Test
	public void deveImportarDespesaDeXML() throws UnsupportedEncodingException {

		String xml = "<list>" + 
						" <gasto>" + 
						"   <tipo>TELEFONE</tipo>" +
						"   <valor>100.0</valor>" +
						"     <data>" + 
						"       <time>447008300000</time>" + 
						"       <timezone>America/Sao_Paulo</timezone>" + 
						"     </data>" + 
						"   <funcionario>" +
						"     <nome>José da Silva</nome>" +
						"     <matricula>123</matricula>" + 
						"     <dataNascimento>" + 
						"       <time>447908400000</time>" + 
						"       <timezone>America/Sao_Paulo</timezone>" + 
						"     </dataNascimento>" + 
						"     <cpf>12312312344</cpf>" + 
						"   </funcionario>" + 
						" </gasto>" + 
					"</list>";

		Importador impotador = new ImportadorDespesasTelefone();
		
		List<Despesa> despesas = impotador.importa(new ByteArrayInputStream(xml.getBytes("UTF-8")));
		
		Assert.assertEquals(1, despesas.size());
		Assert.assertEquals(100.0, despesas.get(0).getValor(),0.00001);
		Assert.assertEquals(TipoDespesa.TELEFONE, despesas.get(0).getTipo());
		Assert.assertEquals("José da Silva", despesas.get(0).getFuncionario().getNome());
		Assert.assertEquals("123", despesas.get(0).getFuncionario().getMatricula());
		
	}

}
