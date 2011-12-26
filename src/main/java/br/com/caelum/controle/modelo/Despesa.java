package br.com.caelum.controle.modelo;

import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Despesa {

	@Id
	@GeneratedValue
	private Long id;

	private TipoDespesa tipo;

	private double valor;

	@ManyToOne
	private Funcionario funcionario;

	@Temporal(TemporalType.TIMESTAMP)
	private Calendar data;

	public Despesa(TipoDespesa tipo, double valor, Funcionario funcionario,
			Calendar data) {
		this.tipo = tipo;
		this.valor = valor;
		this.funcionario = funcionario;
		this.data = data;
	}
	
	public Despesa() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Calendar getData() {
		return data;
	}

	public void setData(Calendar data) {
		this.data = data;
	}

	public TipoDespesa getTipo() {
		return tipo;
	}

	public void setTipo(TipoDespesa tipo) {
		this.tipo = tipo;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

}
