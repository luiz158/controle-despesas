package br.com.caelum.controle.modelo;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Principal {
	public static void main(String[] args) {
		Calendar dataNascimento = new GregorianCalendar(0, 11, 25);
		Funcionario funcionario = new Funcionario("sdfsdf", "DSfsdfsdf",
				dataNascimento);
		System.out.println(funcionario);

	}
}
