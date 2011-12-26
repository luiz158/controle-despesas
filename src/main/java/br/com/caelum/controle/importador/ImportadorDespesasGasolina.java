package br.com.caelum.controle.importador;

import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Scanner;

import br.com.caelum.controle.modelo.Despesa;
import br.com.caelum.controle.modelo.Funcionario;
import br.com.caelum.controle.modelo.TipoDespesa;

public class ImportadorDespesasGasolina implements Importador {

	private final static SimpleDateFormat df = new SimpleDateFormat("ddMMyyyy");

	@Override
	public List<Despesa> importa(InputStream entrada) {
		Scanner sc = new Scanner(entrada);
		List<Despesa> despesas = new ArrayList<Despesa>();

		while (sc.hasNextLine()) {
			String linha = sc.nextLine();
			despesas.add(parseLineToDespesa(linha));
		}

		return despesas;

	}

	private Despesa parseLineToDespesa(String linha) {
		try {
			String[] dados = linha.split(",");

			TipoDespesa tipo = TipoDespesa.valueOf(dados[0]);

			double val = Double.parseDouble(dados[2]);

			Funcionario func = new Funcionario();
			func.setCpf(dados[3]);

			Calendar data = Calendar.getInstance();
			data.setTime(df.parse(dados[1]));
			
			return new Despesa(tipo, val / 100, func, data);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;

	}

}
