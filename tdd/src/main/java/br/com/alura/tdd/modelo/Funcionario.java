package br.com.alura.tdd.modelo;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Funcionario {

	private String nome;
	private LocalDate dataAdmissao;
	private BigDecimal salario;

	public Funcionario(String nome, LocalDate dataAdmissao, BigDecimal salario) {
		this.nome = nome;
		this.dataAdmissao = dataAdmissao;
		this.salario = salario;
	}

	public String getNome() {
		return nome;
	}

	public LocalDate getDataAdmissao() {
		return dataAdmissao;
	}

	public BigDecimal getSalario() {
		return salario;
	}

	public void reajustarSalario(BigDecimal reajusteSalarial) {

		if (valorMenorOuIgualAZero(reajusteSalarial)) {
			throw new IllegalArgumentException();
		}

		this.salario = this.salario.add(reajusteSalarial);
	}

	public BigDecimal obterValorPercentualDoSalario(BigDecimal percentual) {

		if (valorMenorOuIgualAZero(percentual)) {
			throw new IllegalArgumentException();
		}

		return percentual.multiply(salario).setScale(2);
	}

	private boolean valorMenorOuIgualAZero(BigDecimal valor) {
		int compareTo = valor.compareTo(BigDecimal.ZERO);
		return compareTo <= 0 ? true : false;
	}

}
