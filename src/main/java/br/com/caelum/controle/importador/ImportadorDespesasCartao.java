package br.com.caelum.controle.importador;

import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import java.util.Scanner;

import br.com.caelum.controle.modelo.Despesa;
import br.com.caelum.controle.modelo.Funcionario;
import br.com.caelum.controle.modelo.TipoDespesa;

public class ImportadorDespesasCartao implements Importador {

	private final static SimpleDateFormat df = new SimpleDateFormat("ddMMyyyy");

	@Override
	public List<Despesa> importa(InputStream entrada) {

		Scanner leitor = new Scanner(entrada);
		List<Despesa> gastos = new ArrayList<Despesa>();

		while (leitor.hasNextLine()) {

			String line = leitor.nextLine();
			gastos.add(parseLineToDespesa(line));
		}

		return gastos;

	}

	private Despesa parseLineToDespesa(String line) {

		try {
			String tp = line.substring(0, 6);
			String dt = line.substring(6, 14);
			String valor = line.substring(14, 23);
			String cpf = line.substring(23);

			TipoDespesa tipo = TipoDespesa.valueOf(tp);

			double val = Double.parseDouble(valor);

			Funcionario func = new Funcionario();
			func.setCpf(cpf);

			Calendar data = Calendar.getInstance();
			data.setTime(df.parse(dt));

			return new Despesa(tipo, val / 100, func, data);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

}
